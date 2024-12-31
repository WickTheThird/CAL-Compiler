grammar cal;

program: declList functionList main;

declList: (decl SEMI declList)*;

decl: varDecl | constDecl;

varDecl: VARIABLE ID DEFINE type;

constDecl: CONSTANT ID DEFINE type ASSIGN expr;

functionList: (function functionList)*;

function: type ID LBR parameterList RBR IS
		  declList
          BEGIN
          statementBlock
          RETURN LBR (expr)* RBR SEMI
          END
		;

type: INT | BOOL | VOID;

parameterList: (nempParameterList)*;

nempParameterList: ID DEFINE type
                  | ID DEFINE type COMMA nempParameterList
			   ;

main: MAIN
     BEGIN
     declList
     statementBlock
     END
     ;

statementBlock: statement*;

statement: ID ASSIGN expr SEMI
          | ID LBR argList RBR SEMI
          | BEGIN statementBlock END
		  | IF condition BEGIN statementBlock END
		  | ELSE BEGIN statementBlock END
          | WHILE condition BEGIN statementBlock END
          | SK SEMI
		;

expr: frag binaryArithOp frag
     | LBR expr RBR
     | ID LBR argList RBR
     | frag
	;

binaryArithOp: PLUS | MINUS;

frag: ID
     | MINUS ID
     | NUMBER
     | TRUE
     | FALSE
	;

condition: NEG condition
          | LBR condition RBR
          | expr compOp expr
          | condition op=(OR | AND) condition
		;

compOp: EQ | NEQ | LT | LTE | GT | GTE;

argList: nempArgList*;

nempArgList: ID (COMMA nempArgList)?;

fragment A:  'a' | 'A';
fragment B:  'b' | 'B';
fragment C:  'c' | 'C';
fragment D:  'd' | 'D';
fragment E:  'e' | 'E';
fragment F:  'f' | 'F';
fragment G:  'g' | 'G';
fragment H:  'h' | 'H';
fragment I:  'i' | 'I';
fragment J:  'j' | 'J';
fragment K:  'k' | 'K';
fragment L:  'l' | 'L';
fragment M:  'm' | 'M';
fragment N:  'n' | 'N';
fragment O:  'o' | 'O';
fragment P:  'p' | 'P';
fragment Q:  'q' | 'Q';
fragment R:  'r' | 'R';
fragment S:  's' | 'S';
fragment T:  't' | 'T';
fragment U:  'u' | 'U';
fragment V:  'v' | 'V';
fragment W:  'w' | 'W';
fragment X:  'x' | 'X';
fragment Y:  'y' | 'Y';
fragment Z:  'z' | 'Z';

VARIABLE: V A R I A B L E;
CONSTANT: C O N S T A N T;
RETURN: R E T U R N ;
INT: I N T ;
BOOL: B O O L;
VOID: V O I D;
MAIN: M A I N;
IF: I F;
ELSE: E L S E;
TRUE: T R U E;
FALSE: F A L S E;
WHILE: W H I L E;
BEGIN: B E G I N;
END: E N D;
IS: I S;
SK: S K I P;

COMMA: ',';
DEFINE: ':';
ASSIGN: ':=';
SEMI: ';';
LBR: '(';
RBR: ')';
PLUS: '+';
MINUS: '-';
NEG: '~';
OR: '|';
AND: '&';
EQ: '=';
NEQ: '!=';
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';

ID: [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER: ('-'?[1-9]([0-9]*)?)
       | ([1-9]([0-9]*)?)
	  | '0'
	  ;


LINE_COMMENT: '//' ~[\r\n]* -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;
