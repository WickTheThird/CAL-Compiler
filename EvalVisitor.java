import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.*;


public class EvalVisitor extends calBaseVisitor<Value> {
    Map<String, Value> memory = new HashMap<>();
    TACGenerator tacGenerator;

    private SymbolTable symbolTable;
    private calParser.ProgramContext programContext;

    public EvalVisitor(SymbolTable initScope) {
        this.symbolTable = initScope;
        tacGenerator = new TACGenerator(symbolTable);
    }

    // Title Main
    @Override
    public Value visitProgram(calParser.ProgramContext ctx) {
        this.programContext = ctx;
        visit(ctx.declList());
        visit(ctx.main());
        visit(ctx.functionList());
        return null;
    }
    @Override
    public Value visitMain(calParser.MainContext ctx) {
        tacGenerator.addInstruction("main: " ,symbolTable.getCurrentScope());
        symbolTable.enterScope("main");

        visit(ctx.declList());

        if (ctx.statementBlock() != null) {
            visit(ctx.statementBlock());
        }

        for (calParser.StatementContext statement : ctx.statementBlock().statement()) {
            if (statement.ID() != null && statement.argList() != null) {
                
                if (statement.argList() != null) {
                    extractArguments(statement.argList());
                }

                processFunctions(this.programContext);
            }
        }

        tacGenerator.addInstruction("call _exit, 0", symbolTable.getCurrentScopePath());

        symbolTable.leaveScope();
        return null;
    }

    private List<Value> extractArguments(calParser.ArgListContext argListCtx) {

        List<Value> args = new ArrayList<>();

        for (calParser.NempArgListContext exprCtx : argListCtx.nempArgList()) {
            Value argValue = visit(exprCtx);
            args.add(argValue);
        }

        return args;
    }

    public void processFunctions(calParser.ProgramContext programContext) {
        visit(programContext.functionList());
    }


    // Title DECL
    @Override
    public Value visitDeclList(calParser.DeclListContext ctx) {

        if (ctx.decl() != null && !ctx.decl().isEmpty()) {
            for (calParser.DeclContext declCtx : ctx.decl()) {
                visit(declCtx);
            }
        }

        if (ctx.declList() != null) {
            for (calParser.DeclListContext nestedDeclList : ctx.declList()) {
                visit(nestedDeclList);
            }
        }

        return null;
    }

    @Override
    public Value visitVarDecl(calParser.VarDeclContext ctx) {
        String varName = ctx.ID().getText();
        String varType = ctx.type().getText();
        
        try {
            symbolTable.lookupVariable(varName);
            throw new IllegalArgumentException("Variable '" + varName + "' is already declared in this scope.");
        } catch (IllegalArgumentException e) {
            Value val = new Value(varName, varType, null, 0);
            symbolTable.declareVariable(varName, val, false, null);
        }

        return null;
    }


    @Override
    public Value visitConstDecl(calParser.ConstDeclContext ctx) {
        String constName = ctx.ID().getText();
        String constType = ctx.type().getText();
        Value constValue = visit(ctx.expr());

        try {
            symbolTable.lookupVariable(constName);
            throw new IllegalArgumentException("Constant '" + constName + "' is already declared in this scope.");
        } catch (IllegalArgumentException e) {
            symbolTable.declareVariable(constName, constValue, true, null);
            
            if (constType.equals("int")) {
                tacGenerator.addInstruction(constName + " = " + constValue.getValue(), symbolTable.getCurrentScopePath());
            } else if (constType.equals("bool")) {
                String boolValue = (constValue.getValue().equals("true")) ? "true" : "false";
                tacGenerator.addInstruction(constName + " = " + boolValue, symbolTable.getCurrentScopePath());
            }

        }


        return null;
    }

    // Title STATEMENT

    @Override
    public Value visitStatementBlock(calParser.StatementBlockContext ctx) {

        for (calParser.StatementContext stmtCtx : ctx.statement()) {
            visit(stmtCtx);
        }

        return null;
    }

    @Override
    public Value visitStatement(calParser.StatementContext ctx) {

        if (ctx.ASSIGN() != null) {
            visitAssignmentStatement(ctx);
        }

        if (ctx.IF() != null) {
            visitIfStatement(ctx);
        }

        if (ctx.ELSE() != null) {
            visitElseStatement(ctx);
        }

        if (ctx.WHILE() != null) {
            visitWhileStatement(ctx);
        }

        if (ctx.BEGIN() != null) {
            visitBeginEndStatement(ctx);
        }



        return null;
    }


    public Value visitAssignmentStatement(calParser.StatementContext ctx) {
        String varName = ctx.ID().getText();
        Value rightHandSideValue = visit(ctx.expr());

        SymbolInfo symbolInfo = symbolTable.lookupVariable(varName);

        if (symbolInfo == null) {
            throw new IllegalArgumentException("Variable '" + varName + "' is not declared.");
        }

        Value currentValue = symbolInfo.getValue();

        // System.out.println(varName + " 1= " + currentValue + "\n");
        // System.out.println(varName + " 2= " + rightHandSideValue.getValue() + "\n");
        // System.out.println(varName + " 3= " + rightHandSideValue.getReturnType() + "\n");
        // System.out.println(rightHandSideValue.getValue() instanceof Integer);

        if (currentValue.getType() != null && currentValue.getType().equals("int")) {
            Object value;
            // System.err.println(rightHandSideValue.getValue()==null);
            if (rightHandSideValue.getValue() != null) {
                value = rightHandSideValue.getValue();
            } else {
                value = currentValue.getValue();
            }


            int newValue;

            if (value instanceof Integer) {
                newValue = (Integer) value;
            } else if (value instanceof String) {
                try {
                    newValue = Integer.parseInt((String) value);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("String value cannot be converted to an integer: " + value, e);
                }
            } else if (value instanceof Number) {
                newValue = ((Number) value).intValue();
            } else {
                throw new IllegalArgumentException("Unsupported type for assignment: " + value);
            }

            symbolTable.updateVariable(varName, new Value("int", newValue));

            // System.out.println(symbolTable.getCurrentScope().contains("while"));

            if (symbolTable.getCurrentScope().contains("while") == false && symbolTable.getCurrentScope().contains("if") == false) {
                tacGenerator.generateAssignment(varName, String.valueOf(newValue), symbolTable.getCurrentScopePath());
            }

        } else if (currentValue.getType() != null &&
                (currentValue.getType().equals("boolean") || currentValue.getType().equals("bool"))) {

            Object value = rightHandSideValue.getValue().toString().strip();
            boolean newValue = Boolean.parseBoolean((String) value);
            symbolTable.updateVariable(varName, new Value("boolean", newValue));

            if (symbolTable.getCurrentScope().contains("while") && symbolTable.getCurrentScope().contains("if")) {
                tacGenerator.generateAssignment(varName, String.valueOf(newValue), symbolTable.getCurrentScopePath());
            }

        } else {
            throw new IllegalArgumentException("Invalid type for assignment to variable '" + varName + "'.");
        }

        return null;
    }

    public Value visitIfStatement(calParser.StatementContext ctx) {
        Value conditionValue = visit(ctx.condition());

        if (conditionValue.getValue() instanceof Boolean) {
            boolean condition = (boolean) conditionValue.getValue();

            String scopeName = "ifz_" + System.currentTimeMillis();
            symbolTable.enterScope(scopeName);

            // System.out.println("Entering scope: " + symbolTable.getCurrentScopePath());

            String conditionLabel = ctx.condition().getText();
            tacGenerator.generateIfGoto(conditionLabel, conditionLabel, symbolTable.getCurrentScopePath());

            if (condition) {
                visit(ctx.statementBlock());
            }

            symbolTable.leaveScope();

        } else {
            throw new IllegalArgumentException("Condition must evaluate to a boolean.");
        }

        return null;
    }

    public Value visitElseStatement(calParser.StatementContext ctx) {
        if (ctx.ELSE() == null) {
            throw new IllegalArgumentException("If statement does not have an else clause.");
        }

        String scopeName = "else" + System.currentTimeMillis();
        symbolTable.enterScope(scopeName);

        String elseLabel = ctx.getParent().getText();
        tacGenerator.generateIfGoto("true", elseLabel, symbolTable.getCurrentScopePath());

        visit(ctx.statementBlock());
        symbolTable.leaveScope();

        return null;
    }


    public Value visitWhileStatement(calParser.StatementContext ctx) {
        Value conditionValue = visit(ctx.condition());

        if (conditionValue == null) {
            throw new IllegalArgumentException("Condition evaluation returned null.");
        }

        if (conditionValue.getValue() instanceof Boolean) {
            boolean condition = (boolean) conditionValue.getValue();


            String start = "label while_start_" + System.currentTimeMillis();

            String scopeName = start;
            symbolTable.enterScope(scopeName);


            tacGenerator.addInstruction(scopeName + "\n", symbolTable.getCurrentScopePath());
            // System.out.println("Entering while loop scope: " + symbolTable.getCurrentScopePath());

            while (condition) {
                visit(ctx.statementBlock());

                conditionValue = visit(ctx.condition());
                if (conditionValue == null) {
                    throw new IllegalArgumentException("Condition evaluation returned null after statement block.");
                }

                if (conditionValue.getValue() instanceof Boolean) {
                    condition = (boolean) conditionValue.getValue();
                } else {
                    throw new IllegalArgumentException("Condition must evaluate to a boolean.");
                }
            }

            for (calParser.StatementContext stmtCtx : ctx.statementBlock().statement()) {}

            symbolTable.leaveScope();

        } else {
            throw new IllegalArgumentException("Condition must evaluate to a boolean.");
        }

        return null;
    }

    public Value visitSkipStatement(calParser.StatementContext ctx) {
        return null;
    }

    private Value visitBeginEndStatement(calParser.StatementContext ctx) {

        String scopeName = "block_" + System.currentTimeMillis();

        symbolTable.enterScope(scopeName);
        // System.out.println("Entering block scope: " + symbolTable.getCurrentScopePath());

        for (calParser.StatementContext stmtCtx : ctx.statementBlock().statement()) {
            visit(stmtCtx);
        }


        if (symbolTable.getCurrentScope().contains("while") || symbolTable.getCurrentScope().contains("if")) {
            tacGenerator.addInstruction("fi", symbolTable.getCurrentScopePath());
        }
        symbolTable.leaveScope();

        return null;
    }


    // Title EXPR
    @Override
    public Value visitExpr(calParser.ExprContext ctx) {
        if (ctx.binaryArithOp() != null) {
            Value left = visit(ctx.frag(0));
            Value right = visit(ctx.frag(1));
            String operator = ctx.binaryArithOp().getText();

            // System.out.println("reeeesssss" + left.getName());
            // System.out.println("reeeesssss" + right.getName());
            // System.out.println();

            if (left.getType().equals("int") && right.getType().equals("int")) {
                int leftValue = (int) left.getValue();
                int rightValue = (int) right.getValue();

                if (operator.equals("+")) {

                    // tacGenerator.generateArithmetic(operator,String.valueOf(leftValue + rightValue),  String.valueOf(leftValue), String.valueOf(rightValue));
                    return new Value("int", String.valueOf(leftValue + rightValue));
                } else if (operator.equals("-")) {
                    // tacGenerator.generateArithmetic(operator, , String.valueOf(leftValue), String.valueOf(rightValue));
                    return new Value("int", String.valueOf(leftValue - rightValue));
                }
            } else {
                throw new IllegalArgumentException("Binary operation can only be performed on integers.");
            }
        }

        else if (ctx.LBR() != null && ctx.RBR() != null && ctx.expr() != null) {
            return visit(ctx.expr());
        }

        else if (ctx.ID() != null) {
            String functionName = ctx.ID().getText();
            List<Value> args = new ArrayList<>();

            if (ctx.argList() != null) {
                for (ParseTree child : ctx.argList().children) {
                    if (child instanceof calParser.NempArgListContext) {
                        calParser.NempArgListContext argCtx = (calParser.NempArgListContext) child;
                        collectArgumentsFromNempArgList(argCtx, args);
                    }
                }
            }

            SymbolInfo functionInfo = symbolTable.lookupFunction(functionName);
            if (functionInfo == null) {
                symbolTable.leaveScope();
                calParser.FunctionListContext functionListCtx = this.programContext.functionList();
                for (calParser.FunctionContext funcCtx : functionListCtx.function()) {
                    String declaredFunctionName = funcCtx.ID().getText();
                    if (declaredFunctionName.equals(functionName)) {
                        symbolTable.enterScope(functionName);
                        String returnType = funcCtx.type().getText().toLowerCase();
                        
                        Value paramListValue = funcCtx.parameterList() != null
                            ? visit(funcCtx.parameterList())
                            : new Value("parameterList", null, new ArrayList<>());
                        List<Value> parameters = paramListValue.getParameters();

                        Value functionValue = new Value(functionName, returnType, parameters);
                        symbolTable.declareVariable(functionName, functionValue, false, parameters);

                        // System.out.println("Declared Function: " + functionName + ", Parameters: " + parameters + ", Return Type: " + returnType);
                        break;
                    }
                }
                symbolTable.leaveScope();
                symbolTable.enterScope("main");

            }

            tacGenerator.generateCall(functionName,
            args.stream().map(arg -> arg.getValue().toString()).collect(Collectors.toList()),
            null, symbolTable.getCurrentScopePath());

            return callFunction(functionName, args, this.programContext);
        }



        else if (ctx.frag(0) != null) {
            return visit(ctx.frag(0));
        }

        throw new IllegalArgumentException("Invalid expression.");
    }

    private void collectArgumentsFromNempArgList(calParser.NempArgListContext nempArgListCtx, List<Value> args) {
        if (nempArgListCtx == null) return;

        String argName = nempArgListCtx.ID().getText();

        Value argValue = symbolTable.lookupVariable(argName).getValue();
        if (argValue == null) {
            throw new IllegalArgumentException("Undefined argument: " + argName);
        }

        args.add(argValue);

        if (nempArgListCtx.nempArgList() != null) {
            collectArgumentsFromNempArgList(nempArgListCtx.nempArgList(), args);
        }
    }

    //TITLE FUNCTION
    @Override
    public Value visitFunctionList(calParser.FunctionListContext ctx) {


        if (ctx.function() != null && !ctx.function().isEmpty()) {
            for (calParser.FunctionContext funcCtx : ctx.function()) {
                visit(funcCtx);
            }
        }

        if (ctx.functionList() != null && !ctx.functionList().isEmpty()) {
            for (calParser.FunctionListContext nextFunctionListCtx : ctx.functionList()) {
                visit(nextFunctionListCtx);
            }
        }

        return null;
    }


    @Override
    public Value visitFunction(calParser.FunctionContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = ctx.type().getText().toLowerCase();

        Value paramListValue = ctx.parameterList() != null ? visit(ctx.parameterList()) : new Value("parameterList", null, new ArrayList<>());
        List<Value> parameters = paramListValue.getParameters();

        Value functionValue = new Value(functionName, returnType, parameters);
        symbolTable.declareVariable(functionName, functionValue, false, parameters);

        symbolTable.enterScope(functionName);

        // System.out.println("Function: " + functionName + ", Parameters: " + parameters + ", Return Type: " + returnType);

        
        for (Value param : parameters) {
            SymbolInfo existingSymbol = symbolTable.lookupVariable(param.getName());

            if (existingSymbol == null) {
                symbolTable.declareVariable(param.getName(), param, false, null);
                // System.out.println("Declared parameter: " + param.getName() + " of type: " + param.getType());
            }
        }


        tacGenerator.addInstruction("\n" + functionName + ":", null);


        if (ctx.declList() != null) {
            visit(ctx.declList());
        }
        if (ctx.statementBlock() != null) {
            visit(ctx.statementBlock());
        }

        if (ctx.expr() != null && !ctx.expr().isEmpty()) {
            for (calParser.ExprContext exprCtx : ctx.expr()) {
                Value returnValue = visit(exprCtx);

                // System.err.println(returnValue.getType().equals(returnType));
                // System.err.println(returnType);

                if (returnValue != null && returnValue.getType().equals(returnType)) {
                    tacGenerator.generateReturnTAC(returnValue.getValue().toString().toLowerCase(), symbolTable.getCurrentScopePath());
                    functionValue.setValue(returnValue.getValue());
                } else {
                    throw new IllegalArgumentException("Return type mismatch for function '" + functionName + "'. Expected " + returnType + " but got " + returnValue.getType() + ".");
                }
            }
        } else if (returnType.equals("void")) {
            tacGenerator.generateReturnTAC(null, symbolTable.getCurrentScopePath());
            functionValue.setValue(null);
        } else {
            throw new IllegalArgumentException("Invalid return type");
        }

        // tacGenerator.generateFunctionEndTAC(functionName, symbolTable.getCurrentScopePath());
        symbolTable.leaveScope();

        return null;
    }

    public Value callFunction(String functionName, List<Value> args, calParser.ProgramContext programCtx) {
        SymbolInfo functionInfo = symbolTable.lookupFunction(functionName);

        symbolTable.enterScope(functionName);
        List<Value> expectedParams = functionInfo.getParameters();

        if (expectedParams != null && args != null) {
            if (expectedParams.isEmpty() && !args.isEmpty()) {
                throw new IllegalArgumentException("Function '" + functionName + "' expects no arguments, but got " + args.size() + ".");
            } else if (!expectedParams.isEmpty() && args.size() != expectedParams.size()) {
                throw new IllegalArgumentException("Function '" + functionName + "' expects " + expectedParams.size() + " arguments, but got " + args.size() + ".");
            }

            for (int i = 0; i < args.size(); i++) {
                Value paramValue = args.get(i);
                Value expectedParam = expectedParams.get(i);

                if (!paramValue.getType().equals(expectedParam.getType())) {
                    throw new IllegalArgumentException("Argument type mismatch for parameter '" + expectedParam.getName() + "' in function '" + functionName + "'. Expected " + expectedParam.getType() + " but got " + paramValue.getType() + ".");
                }

                symbolTable.declareVariable(expectedParam.getName(), paramValue, false, null);
            }
        } else {
            if (expectedParams != null && expectedParams.isEmpty() && args != null && args.isEmpty()) {
            } else if (args != null && !args.isEmpty()) {
                throw new IllegalArgumentException("Function '" + functionName + "' expects no arguments, but got " + args.size() + ".");
            }
        }

        List<String> argumentStrings = new ArrayList<>();
        for (Value arg : args) {
            argumentStrings.add(arg.getValue().toString());
        }
        tacGenerator.generateCall(functionName, argumentStrings, null, symbolTable.getCurrentScopePath());

        if (functionInfo.getReturnValue() != null) {
            return functionInfo.getReturnValue();
        }

        symbolTable.leaveScope();

        return null;
    }

    //TITLE: CONDITIONS
    @Override
    public Value visitCondition(calParser.ConditionContext ctx) {
        if (ctx.NEG() != null) {
            Value conditionValue = visit(ctx.condition(0));
            
            if (conditionValue.getValue() instanceof Boolean) {
                boolean result = !(Boolean) conditionValue.getValue();
                
                // String tempVar = "temp" + System.nanoTime();
                // tacGenerator.generateAssignment(tempVar, String.valueOf(result));

                return new Value("boolean", result);
            } else {
                throw new IllegalArgumentException("Negation can only be applied to boolean conditions.");
            }
        }

        if (ctx.LBR() != null && ctx.RBR() != null) {
            return visit(ctx.condition(0));
        }

        if (ctx.compOp() != null) {
            Value left = visit(ctx.expr(0));
            Value right = visit(ctx.expr(1));

            // System.out.println("dddd" + left.getValue());
            // System.out.println("dddd" + right.getValue());

            if ((left.getValue() instanceof Integer && right.getValue() instanceof Integer)) {
                int leftValue = (Integer) left.getValue();
                int rightValue = (Integer) right.getValue();

                boolean result = false;
                String comparisonOp = ctx.compOp().getText();

                switch (comparisonOp) {
                    case "<":
                        result = leftValue < rightValue;
                        break;
                    case "<=":
                        result = leftValue <= rightValue;
                        break;
                    case ">":
                        result = leftValue > rightValue;
                        break;
                    case ">=":
                        result = leftValue >= rightValue;
                        break;
                    case "=":
                        result = leftValue == rightValue;
                        break;
                    case "!=":
                        result = leftValue != rightValue;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported comparison operator: " + comparisonOp);
                }

                // String tempVar = tacGenerator.newTemp();
                // tacGenerator.generateAssignment(tempVar, result ? "1" : "0");

                return new Value("boolean", result);
            } else if ((left.getValue() instanceof Boolean && right.getValue() instanceof Boolean)) {
                boolean leftValue = (Boolean) left.getValue();
                boolean rightValue = (Boolean) right.getValue();

                boolean result = false;
                String comparisonOp = ctx.compOp().getText();

                switch (comparisonOp) {
                    case "=":
                        result = leftValue == rightValue;
                        break;
                    case "!=":
                        result = leftValue != rightValue;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported comparison operator for booleans: " + comparisonOp);
                }

                return new Value("boolean", result);
            } else {
                throw new IllegalArgumentException("Comparison requires operands of the same type, either both integers or both booleans.");
            }
        }

        if (ctx.op != null) {
            Value leftCondition = visit(ctx.condition(0));
            Value rightCondition = visit(ctx.condition(1));

            if (leftCondition.getValue() instanceof Boolean && rightCondition.getValue() instanceof Boolean) {
                boolean left = (Boolean) leftCondition.getValue();
                boolean right = (Boolean) rightCondition.getValue();
                boolean result = false;

                if (ctx.AND() != null) {
                    // String tempVar = tacGenerator.newTemp();
                    result = left && right;
                    // tacGenerator.generateAssignment(tempVar, result ? "1" : "0");
                } else if (ctx.OR() != null) {
                    // String tempVar = tacGenerator.newTemp();
                    result = left || right;
                    // tacGenerator.generateAssignment(tempVar, result ? "1" : "0");
                } else {
                    throw new IllegalArgumentException("Unsupported logical operator: " + ctx.op);
                }

                return new Value("boolean", result);
            } else {
                throw new IllegalArgumentException("Logical operations require boolean operands.");
            }
        }

        throw new IllegalArgumentException("Invalid condition.");
    }



    // TITLE: ArgList
    @Override
    public Value visitArgList(calParser.ArgListContext ctx) {
        List<Value> args = new ArrayList<>();
        if (ctx.nempArgList() != null) {
            for (calParser.NempArgListContext nempArgCtx : ctx.nempArgList()) {
                Value argValue = visit(nempArgCtx);
                args.add(argValue);
            }
        }

        return new Value("argList", args);
    }


    @SuppressWarnings("unchecked")
    @Override
    public Value visitNempArgList(calParser.NempArgListContext ctx) {
        List<Value> args = new ArrayList<>();

        if (ctx.ID() != null) {
            String argName = ctx.ID().getText();
            
            try {
                Value argValue = symbolTable.lookupVariable(argName).getValue();
                args.add(argValue);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Argument '" + argName + "' not found in the current scope.", e);
            }
        }

        if (ctx.nempArgList() != null) {
            Value nextArgs = visit(ctx.nempArgList());
            
            if (nextArgs.getValue() instanceof List<?>) {
                args.addAll((List<Value>) nextArgs.getValue());
            } else {
                throw new IllegalArgumentException("Unexpected argument list structure.");
            }
        }

        return new Value("argList", args);
    }



    //Title BiaryArithOp
    @Override
    public Value visitBinaryArithOp(calParser.BinaryArithOpContext ctx) {
        Value left = visit(ctx.getChild(0));
        Value right = visit(ctx.getChild(2));

        String operator = ctx.getChild(1).getText();

        if (left.getType().equals("int") && right.getType().equals("int")) {
            int leftValue = (int) left.getValue();
            int rightValue = (int) right.getValue();

            switch (operator) {
                case "+":
                    tacGenerator.generateArithmetic("+", String.valueOf(leftValue + rightValue), String.valueOf(leftValue), String.valueOf(rightValue), symbolTable.getCurrentScopePath());
                    return new Value( "int", String.valueOf(leftValue + rightValue));
                case "-":
                    tacGenerator.generateArithmetic("-",String.valueOf(leftValue - rightValue),  String.valueOf(leftValue), String.valueOf(rightValue), symbolTable.getCurrentScopePath());
                    return new Value( "int", String.valueOf(leftValue - rightValue));
                default:
                    throw new IllegalArgumentException("Unsupported binary operator: " + operator);
            }
        } else {
            throw new IllegalArgumentException("Binary arithmetic operations require integer operands.");
        }
    }


    //Title BinaryCompOp
    @Override
    public Value visitCompOp(calParser.CompOpContext ctx) {
        Value left = visit(ctx.getChild(0));
        Value right = visit(ctx.getChild(2));
        String operator = ctx.getChild(1).getText();

        if (left.getType().equals("int") && right.getType().equals("int")) {
            int leftValue = (int) left.getValue();
            int rightValue = (int) right.getValue();
            boolean result = false;

            switch (operator) {
                case "=":
                    result = leftValue == rightValue;
                    break;
                case "!=":
                    result = leftValue != rightValue;
                    break;
                case "<":
                    result = leftValue < rightValue;
                    break;
                case "<=":
                    result = leftValue <= rightValue;
                    break;
                case ">":
                    result = leftValue > rightValue;
                    break;
                case ">=":
                    result = leftValue >= rightValue;
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported comparison operator: " + operator);
            }

            tacGenerator.generateArithmetic(operator,String.valueOf(result), String.valueOf(leftValue), String.valueOf(rightValue), symbolTable.getCurrentScopePath());

            return new Value("boolean", result);
        } else {
            throw new IllegalArgumentException("Comparison requires integer operands.");
        }
    }


    // Title Frag Context
    @Override
    public Value visitFrag(calParser.FragContext ctx) {

        if (ctx.NUMBER() != null) {
            // String tempVar = "temp" + System.nanoTime();
            String number = ctx.NUMBER().getText();
            // tacGenerator.generateAssignment(tempVar, number);

            return new Value("int", Integer.parseInt(number));
        } else if (ctx.ID() != null) {

            return symbolTable.lookupVariable(ctx.ID().getText()).getValue();
        }
        else if (ctx.TRUE() != null) {
            // String tempVar = "temp" + System.nanoTime();
            // tacGenerator.generateAssignment(tempVar, "true");

            return new Value("boolean", true);
        } else if (ctx.FALSE() != null) {
            // String tempVar = "temp" + System.nanoTime();
            // tacGenerator.generateAssignment(tempVar, "false");

            return new Value("boolean", false);
        } else if (ctx.MINUS() != null) {
            Value value = symbolTable.lookupVariable(ctx.ID().getText()).getValue();

            if (value.getType().equals("int")) {
                // String tempVar = "temp" + System.nanoTime();
                // tacGenerator.generateAssignment(tempVar, "-" + (value.getValue()).toString());

                int negatedValue = -(int) value.getValue();
                return new Value("int", negatedValue);
            }

            throw new IllegalStateException("Negative operations can only apply to integers.");
        }

        throw new IllegalStateException("Invalid Fragment: Unable to handle this fragment type.");
    }


    // Title NempParameterListContext
    @Override
    public Value visitNempParameterList(calParser.NempParameterListContext ctx) {
        List<Value> params = new ArrayList<>();

        String paramName = ctx.ID().getText();
        String paramType = ctx.type().getText();

        params.add(new Value(paramName, paramType, null, 0));

        if (ctx.nempParameterList() != null) {
            Value moreParams = visit(ctx.nempParameterList());
            if (moreParams != null && moreParams.getParameters() != null) {
                params.addAll(moreParams.getParameters());
            }
        }

        return new Value("nempParameterList", null, params);
    }



    @Override
    public Value visitParameterList(calParser.ParameterListContext ctx) {
        List<Value> allParams = new ArrayList<>();

        for (calParser.NempParameterListContext nempParamCtx : ctx.nempParameterList()) {
            Value paramValue = visit(nempParamCtx);
            if (paramValue != null && paramValue.getParameters() != null) {
                allParams.addAll(paramValue.getParameters());
            }
        }

        return new Value("parameterList", null, allParams);
    }



    // TITLE TypeContext
    @Override
    public Value visitType(calParser.TypeContext ctx) {
        String typeText = ctx.getText().toLowerCase();
        
        switch (typeText) {
            case "int":
                break;
            case "bool":
                break;
            case "void":
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + typeText);
        }
        return new Value("type", typeText.toLowerCase());
    }

}