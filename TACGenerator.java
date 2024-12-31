import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TACGenerator {

    private List<String> instructions;
    private SymbolTable symbolTable;

    public TACGenerator(SymbolTable symbolTable) {
        instructions = new ArrayList<>();
        this.symbolTable = symbolTable;
    }

    public void addInstruction(String instruction, String scopePath) {
        if (scopePath!= null) {
            int counter = symbolTable.getCurrentScopePath().split(">").length - 1;
            if (scopePath.contains("while") || scopePath.contains("if")) {
                counter--;
            }

            // System.out.println(scopePath + " " + counter);

            String tabs = "\t".repeat(counter);
            instructions.add(tabs + instruction);
        } else {
            instructions.add(instruction);
        }
    }

    public void generateArithmetic(String op, String name, String left, String right, String scopePath) {
        addInstruction(name + " = " + left + " " + op + " " + right, scopePath);
    }

    public void generateAssignment(String left, String right, String scopePath) {
        addInstruction(left + " = " + right, scopePath);
    }

    public void generateReturn(String value, String scopePath) {
        addInstruction("return " + value, scopePath);
    }

    public void generateIfGoto(String condition, String label, String scopePath) {
        String id = System.currentTimeMillis() + "" ;
        String if_name = "ifz_"; // + System.currentTimeMillis();
        String temp =  "stmt_" + id + " = " + "(" + condition +")";
        
        int counter = symbolTable.getCurrentScopePath().split(">").length - 2;
        String tabs = "\t".repeat(counter);

        addInstruction(temp + "\n" + tabs + if_name + id + " goto true_stmt" + id + "\n" + tabs + "true_stmt_" + id + ":", scopePath);

    }

    public void generateGoto(String label, String scopePath) {
        addInstruction("goto " + label, scopePath);
    }

    public void generateCall(String functionName, List<String> parameters, String returnValue, String scopePath) {
        if (parameters != null) {
            int paramIndex = 1;
            for (String param : parameters) {
                addInstruction("param " + param, scopePath);
                paramIndex++;
            }
            addInstruction("call " + functionName + ", " + parameters.size(), scopePath);
        } else if (functionName == "main"){
            addInstruction("\n" + functionName + ":", scopePath);
        }


        if (returnValue != null) {
            generateReturn(returnValue, scopePath);
        }
    }

    public void generateReturnTAC(String value, String scopePath) {
        if (value != null) {
            addInstruction("return " + value, scopePath);
        } else {
            addInstruction("return", scopePath);
        }
    }

    // public void generateFunctionEndTAC(String functionName, String scopePath) {
    //     addInstruction("end " + functionName, scopePath);
    // }

    public void enterFunctionScope(String functionName, List<Value> parameters) {
        symbolTable.enterScope(functionName);

        for (Value param : parameters) {
            symbolTable.declareVariable(param.getName(), param, false, null);
        }
    }

    public void leaveFunctionScope() {
        symbolTable.leaveScope();
    }

    public void generateLibraryCall(String libraryFunction, String scopePath) {
        if (libraryFunction.equals("_exit")) {
            addInstruction("_exit", scopePath);
        } else if (libraryFunction.equals("_read")) {
            addInstruction("_read", scopePath);
        } else if (libraryFunction.equals("_print")) {
            addInstruction("_print t0", scopePath);
        } else if (libraryFunction.equals("_println")) {
            addInstruction("_println t0", scopePath);
        }
    }

    public void generateWhileLoop(String condition, String bodyInstructions, String scopePath) {
        String startLabel = newLabel("while_start");
        String endLabel = newLabel("whileend");

        addInstruction(startLabel + ":", scopePath);
        generateIfGoto(condition, endLabel, scopePath);
        addInstructionsFromBody(bodyInstructions, scopePath);
        generateGoto(startLabel, scopePath);
        addInstruction(endLabel + ":", scopePath);
    }

    private void addInstructionsFromBody(String bodyInstructions, String scopePath) {
        String[] instructionsArray = bodyInstructions.split("\n");
        for (String instr : instructionsArray) {
            addInstruction(instr.trim(), scopePath);
        }
    }

    private String newLabel(String prefix) {
        return prefix + "_" + instructions.size();
    }

    public void writeToFile(String fileName) throws IOException {
        File outputFile = new File("outputs/" + fileName + ".tac");
        outputFile.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String instruction : instructions) {
                writer.write(instruction + "\n");
            }
        }
    }

    public void printTAC() {
        for (String instruction : instructions) {
            System.out.println(instruction);
        }
    }

    public List<String> getInstructions() {
        return instructions;
    }
}
