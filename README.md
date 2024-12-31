This is a brief overview of how i implemented the Semantic Analysis and Intermediate representation to he lexical and syntax analyser we previously implemented in Assignment1.

First step in the implementation was generating the Parse Tree. For this i utilised the built in Parse Tree class to parse the program and then use EvalVisitor to evaluate the grammar tree.

Given that there are several repetitive commands, I have create a makefile that compiles my cal.java and runs tests against the program. There are a total of 5 tests, you can run them individually or all of them at once.

Next I have created the evalVisitor class that will be overriting and evaluating the grammar tree. Inside the calParser, there are a number of contexts, a total of 20 from my grammar that were to be implemented.

ArgListContext
BinaryArithOpContext
CompOpContext
ConditionContext
ConstDeclContext
DeclContext
DeclListContext
ExprContext
FragContext
FunctionContext
FunctionListContext
MainContext
NempArgListContext
NempParameterListContext
ParameterListContext
ProgramContext
StatementBlockContext
StatementContext
TypeContext
VarDeclContext

Before continuing with the implementation, I saw that I needed a way to keep track of all the types, values and declarations, so for this I have created 2 classes caled Value and SymbolInfo that work together to provide context for each variable and declaration. Each Value and Symbol needed a scope and to handle this scope I have written the SymbolTable.

There were many ways to handle the table. I decided to go through the Map route. I kept 2 things, a Scope Map and a Scope Path. One is a Map and the other is a string. This will ensure that traversing the table will be easy and also ensure unique locations for each variable and declaration that needs to be local, while ensuring a hierarcy for those that are global. 
The most utilised methods are the lookupFuntion, lookupVariable, enterScope, leaveScope and declareVariables. Each acts as its named.

The Value and SymbolInfo also is able to store handle functions, keeping a list of parameters, values declared, its own return value type and its scope is its own name.

When implementing all of this together, I followed the structure and rules from the grammar. As best as I could, obviously I made some modifications by the end of this assignment, but I will mention them below, along with the weaknesses of my approach.

I decided the SymbolTable to be constructed at the same time as the program is visiting the tree and dynamically alocating scopes as it visits each "branch".

This meant that proper handling of scope will be very important.

Thus, scopes are handled in the following:

- Program: its initialised with the global scope;
- Main: its scope is functional;
- Local: this is local to the function its being held in;

Thus, this is mainly handled by the VisitMain, VisitFunction and CallFunction.
Since there are expressions and statements inside function bodies, expressions and statements do also look for variables or functions that are declared outside of its scope in order to handle references.

Each function has parameters. Each parameter is of type Value stored in the Value of the function. This is important because if we know the parameters that will be passed and their respective values, we can associate them directly with the function's parameters and since those values are witin a scope, they then will be defined in the scope of the function.

Parameters are also cross-checked to see if there is the corresponding number of parameters agains the given ones. There is also an error for this if so.

Parameters for each function is gathered from the ArgList and nempArgList respectively.

This is also handled by the visitExpr which will check for functions that are called in the scope of the current function. This is because the declarations of both variables and constants contain expression. Var decl is a little bit different as its assignment depends on the statement.

Thus this will handle if the values are declared within the scope of the function before its used and ensures that its only declared once within that scope. Our SymbolTable also checks for this as well as the individual drivers.

The statement block handles many different things, such as:
- If and Else statements;
- While statements;
- Begin and End Blocks;
- Assignment Statements;

The assignment statement is quite important. First we look for the variable in the current scope, then we check if the variable's type matches the its assignment while also making sure that it fit's the grammar's description. This will also ensure that we can update each variable given that its reasigned a value.
The reassignment statement can be used only by variables and not constants. Their assignment procedure differs, constants being able to be assigned a value on the same line while variables need to be declared and then assigned. This choice was made due to the grammar delared in assignment 1 and to clearly differentiate between variables and constants.

For each value we also keep track if the value is a constant or not, making sure we can limit operations made depending on intention.

Begin and End blocks only enable bettter scope management and also the ability to  call individual statements as we are passing to it the statement block context.

If statements and while statements work as expected. They perform needed arythmetic and even compute the result that is then assigned to the variable using the assignment statement. They also update return values if needs be. They also perform checks and make sure that the values that perform the computation are comparable and can be utilised within the condition slot.

Further on, I have implemented computation of statements. If you perform a computation such as k = k - 1, k will be updated within the SymbolTable with its new value. This also ensures correct return values and types which are checked with the variable we assign.

Thus the symbol table builds the final result of the program at the same time.

Now comes the issues with my implementation.

I have attempted to generate an IR, but I didn't have enough time to complete it.
You can see the .tac files I am generating after each run.

While you can clearly see the results, from correct assignments to corresponding return types, its syntax isnt fully TACi compatible as its missing proper labling management and rule implementations for TACi.

You can see the attempted implementation for this in the class TACGenerator.

TACGenerator takes advantage of the symbol table to produce the attempted correct output. It leverages scoping to ensure proper indentation and ordering of variables since each holds a different scope path at the time they were declared.

I found myself using the addInstruction method most throughout the program and eventually created methods around the addInstruction method to ease implementation.

Though not complete it still shows the program's result.

As I went further in the project, I found myself that I have forgotten to relate the argLists from the function to their respective calls within other functions.

This messed a few things up. So what I decided to do, in order not to chenge the method's functionality, I call main first and declare all of the variables with their respective types and then go through the list of functions that exit and declare them coming back to the main program in case functions were declared within it. This is not a great approach as in my opinion it should have taken care of functions first.
Another reason for why this was done is that we compute tha variables as we go through the program, meaning that when we compute the functions first, they will have undefined values for passed parameters giving out errors messages for incomatable computations.
For this I decided to go with thhis approach in order to solve parameters first and then pass them through and associate them with the corresponding functions.

Even if we utilise a function call in another function other than main, it should compute as functionList will eventually be visited and its variables within its blocs will be computed on visit.

I havent implemented a warning to state which functions are called and not, but i have a functionCall that is called only when we call functions within blocks. So I do not have a implementation to check if every function is called. Same goes for variables.

Each visitor has its own checks both in the method and from its callers like SymbolTable, Value and TACGenerator.

Thus this is my implementation.
Note again that I have a fiew tests inside the test directory and the outouts for eachr un are inside the output directory.
Thank you very much.
