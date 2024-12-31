// Generated from cal.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class calParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VARIABLE=1, CONSTANT=2, RETURN=3, INT=4, BOOL=5, VOID=6, MAIN=7, IF=8, 
		ELSE=9, TRUE=10, FALSE=11, WHILE=12, BEGIN=13, END=14, IS=15, SK=16, COMMA=17, 
		DEFINE=18, ASSIGN=19, SEMI=20, LBR=21, RBR=22, PLUS=23, MINUS=24, NEG=25, 
		OR=26, AND=27, EQ=28, NEQ=29, LT=30, LTE=31, GT=32, GTE=33, ID=34, NUMBER=35, 
		LINE_COMMENT=36, MULTI_LINE_COMMENT=37, WS=38;
	public static final int
		RULE_program = 0, RULE_declList = 1, RULE_decl = 2, RULE_varDecl = 3, 
		RULE_constDecl = 4, RULE_functionList = 5, RULE_function = 6, RULE_type = 7, 
		RULE_parameterList = 8, RULE_nempParameterList = 9, RULE_main = 10, RULE_statementBlock = 11, 
		RULE_statement = 12, RULE_expr = 13, RULE_binaryArithOp = 14, RULE_frag = 15, 
		RULE_condition = 16, RULE_compOp = 17, RULE_argList = 18, RULE_nempArgList = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declList", "decl", "varDecl", "constDecl", "functionList", 
			"function", "type", "parameterList", "nempParameterList", "main", "statementBlock", 
			"statement", "expr", "binaryArithOp", "frag", "condition", "compOp", 
			"argList", "nempArgList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "','", "':'", "':='", "';'", "'('", "')'", 
			"'+'", "'-'", "'~'", "'|'", "'&'", "'='", "'!='", "'<'", "'<='", "'>'", 
			"'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VARIABLE", "CONSTANT", "RETURN", "INT", "BOOL", "VOID", "MAIN", 
			"IF", "ELSE", "TRUE", "FALSE", "WHILE", "BEGIN", "END", "IS", "SK", "COMMA", 
			"DEFINE", "ASSIGN", "SEMI", "LBR", "RBR", "PLUS", "MINUS", "NEG", "OR", 
			"AND", "EQ", "NEQ", "LT", "LTE", "GT", "GTE", "ID", "NUMBER", "LINE_COMMENT", 
			"MULTI_LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "cal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public FunctionListContext functionList() {
			return getRuleContext(FunctionListContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			declList();
			setState(41);
			functionList();
			setState(42);
			main();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclListContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(calParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(calParser.SEMI, i);
		}
		public List<DeclListContext> declList() {
			return getRuleContexts(DeclListContext.class);
		}
		public DeclListContext declList(int i) {
			return getRuleContext(DeclListContext.class,i);
		}
		public DeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclListContext declList() throws RecognitionException {
		DeclListContext _localctx = new DeclListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44);
					decl();
					setState(45);
					match(SEMI);
					setState(46);
					declList();
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				varDecl();
				}
				break;
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				constDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(calParser.VARIABLE, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode DEFINE() { return getToken(calParser.DEFINE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(VARIABLE);
			setState(58);
			match(ID);
			setState(59);
			match(DEFINE);
			setState(60);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(calParser.CONSTANT, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode DEFINE() { return getToken(calParser.DEFINE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(calParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(CONSTANT);
			setState(63);
			match(ID);
			setState(64);
			match(DEFINE);
			setState(65);
			type();
			setState(66);
			match(ASSIGN);
			setState(67);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionListContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<FunctionListContext> functionList() {
			return getRuleContexts(FunctionListContext.class);
		}
		public FunctionListContext functionList(int i) {
			return getRuleContext(FunctionListContext.class,i);
		}
		public FunctionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunctionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionListContext functionList() throws RecognitionException {
		FunctionListContext _localctx = new FunctionListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(69);
					function();
					setState(70);
					functionList();
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public List<TerminalNode> LBR() { return getTokens(calParser.LBR); }
		public TerminalNode LBR(int i) {
			return getToken(calParser.LBR, i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public List<TerminalNode> RBR() { return getTokens(calParser.RBR); }
		public TerminalNode RBR(int i) {
			return getToken(calParser.RBR, i);
		}
		public TerminalNode IS() { return getToken(calParser.IS, 0); }
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(calParser.BEGIN, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(calParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public TerminalNode END() { return getToken(calParser.END, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			type();
			setState(78);
			match(ID);
			setState(79);
			match(LBR);
			setState(80);
			parameterList();
			setState(81);
			match(RBR);
			setState(82);
			match(IS);
			setState(83);
			declList();
			setState(84);
			match(BEGIN);
			setState(85);
			statementBlock();
			setState(86);
			match(RETURN);
			setState(87);
			match(LBR);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 51558484992L) != 0)) {
				{
				{
				setState(88);
				expr();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(RBR);
			setState(95);
			match(SEMI);
			setState(96);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(calParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(calParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(calParser.VOID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<NempParameterListContext> nempParameterList() {
			return getRuleContexts(NempParameterListContext.class);
		}
		public NempParameterListContext nempParameterList(int i) {
			return getRuleContext(NempParameterListContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(100);
				nempParameterList();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NempParameterListContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode DEFINE() { return getToken(calParser.DEFINE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(calParser.COMMA, 0); }
		public NempParameterListContext nempParameterList() {
			return getRuleContext(NempParameterListContext.class,0);
		}
		public NempParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nempParameterList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNempParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NempParameterListContext nempParameterList() throws RecognitionException {
		NempParameterListContext _localctx = new NempParameterListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nempParameterList);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(ID);
				setState(107);
				match(DEFINE);
				setState(108);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(ID);
				setState(110);
				match(DEFINE);
				setState(111);
				type();
				setState(112);
				match(COMMA);
				setState(113);
				nempParameterList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(calParser.MAIN, 0); }
		public TerminalNode BEGIN() { return getToken(calParser.BEGIN, 0); }
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public TerminalNode END() { return getToken(calParser.END, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(MAIN);
			setState(118);
			match(BEGIN);
			setState(119);
			declList();
			setState(120);
			statementBlock();
			setState(121);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179947776L) != 0)) {
				{
				{
				setState(123);
				statement();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(calParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public TerminalNode BEGIN() { return getToken(calParser.BEGIN, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public TerminalNode END() { return getToken(calParser.END, 0); }
		public TerminalNode IF() { return getToken(calParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(calParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(calParser.WHILE, 0); }
		public TerminalNode SK() { return getToken(calParser.SK, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(ID);
				setState(130);
				match(ASSIGN);
				setState(131);
				expr();
				setState(132);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(ID);
				setState(135);
				match(LBR);
				setState(136);
				argList();
				setState(137);
				match(RBR);
				setState(138);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(BEGIN);
				setState(141);
				statementBlock();
				setState(142);
				match(END);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				match(IF);
				setState(145);
				condition(0);
				setState(146);
				match(BEGIN);
				setState(147);
				statementBlock();
				setState(148);
				match(END);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				match(ELSE);
				setState(151);
				match(BEGIN);
				setState(152);
				statementBlock();
				setState(153);
				match(END);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(155);
				match(WHILE);
				setState(156);
				condition(0);
				setState(157);
				match(BEGIN);
				setState(158);
				statementBlock();
				setState(159);
				match(END);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(161);
				match(SK);
				setState(162);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<FragContext> frag() {
			return getRuleContexts(FragContext.class);
		}
		public FragContext frag(int i) {
			return getRuleContext(FragContext.class,i);
		}
		public BinaryArithOpContext binaryArithOp() {
			return getRuleContext(BinaryArithOpContext.class,0);
		}
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				frag();
				setState(166);
				binaryArithOp();
				setState(167);
				frag();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(LBR);
				setState(170);
				expr();
				setState(171);
				match(RBR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				match(ID);
				setState(174);
				match(LBR);
				setState(175);
				argList();
				setState(176);
				match(RBR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				frag();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryArithOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(calParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(calParser.MINUS, 0); }
		public BinaryArithOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryArithOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBinaryArithOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryArithOpContext binaryArithOp() throws RecognitionException {
		BinaryArithOpContext _localctx = new BinaryArithOpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binaryArithOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FragContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode MINUS() { return getToken(calParser.MINUS, 0); }
		public TerminalNode NUMBER() { return getToken(calParser.NUMBER, 0); }
		public TerminalNode TRUE() { return getToken(calParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(calParser.FALSE, 0); }
		public FragContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frag; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFrag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragContext frag() throws RecognitionException {
		FragContext _localctx = new FragContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_frag);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(ID);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(MINUS);
				setState(185);
				match(ID);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				match(NUMBER);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(188);
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public Token op;
		public TerminalNode NEG() { return getToken(calParser.NEG, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public TerminalNode OR() { return getToken(calParser.OR, 0); }
		public TerminalNode AND() { return getToken(calParser.AND, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(192);
				match(NEG);
				setState(193);
				condition(4);
				}
				break;
			case 2:
				{
				setState(194);
				match(LBR);
				setState(195);
				condition(0);
				setState(196);
				match(RBR);
				}
				break;
			case 3:
				{
				setState(198);
				expr();
				setState(199);
				compOp();
				setState(200);
				expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(204);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(205);
					((ConditionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
						((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(206);
					condition(2);
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(calParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(calParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(calParser.LT, 0); }
		public TerminalNode LTE() { return getToken(calParser.LTE, 0); }
		public TerminalNode GT() { return getToken(calParser.GT, 0); }
		public TerminalNode GTE() { return getToken(calParser.GTE, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16911433728L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<NempArgListContext> nempArgList() {
			return getRuleContexts(NempArgListContext.class);
		}
		public NempArgListContext nempArgList(int i) {
			return getRuleContext(NempArgListContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(214);
				nempArgList();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NempArgListContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(calParser.COMMA, 0); }
		public NempArgListContext nempArgList() {
			return getRuleContext(NempArgListContext.class,0);
		}
		public NempArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nempArgList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNempArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NempArgListContext nempArgList() throws RecognitionException {
		NempArgListContext _localctx = new NempArgListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_nempArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(ID);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(221);
				match(COMMA);
				setState(222);
				nempArgList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u00e2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00011\b\u0001"+
		"\n\u0001\f\u00014\t\u0001\u0001\u0002\u0001\u0002\u0003\u00028\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005I\b\u0005\n\u0005\f\u0005"+
		"L\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006Z\b\u0006\n\u0006\f\u0006]\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0005"+
		"\bf\b\b\n\b\f\bi\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tt\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0005\u000b}\b\u000b\n\u000b\f\u000b\u0080\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a4"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00b4\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00be\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00cb\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00d0\b\u0010\n\u0010\f\u0010\u00d3\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0005\u0012\u00d8\b\u0012\n\u0012\f\u0012"+
		"\u00db\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00e0\b"+
		"\u0013\u0001\u0013\u0000\u0001 \u0014\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0004\u0001"+
		"\u0000\u0004\u0006\u0001\u0000\u0017\u0018\u0001\u0000\u001a\u001b\u0001"+
		"\u0000\u001c!\u00e6\u0000(\u0001\u0000\u0000\u0000\u00022\u0001\u0000"+
		"\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000"+
		"\b>\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fM\u0001\u0000"+
		"\u0000\u0000\u000eb\u0001\u0000\u0000\u0000\u0010g\u0001\u0000\u0000\u0000"+
		"\u0012s\u0001\u0000\u0000\u0000\u0014u\u0001\u0000\u0000\u0000\u0016~"+
		"\u0001\u0000\u0000\u0000\u0018\u00a3\u0001\u0000\u0000\u0000\u001a\u00b3"+
		"\u0001\u0000\u0000\u0000\u001c\u00b5\u0001\u0000\u0000\u0000\u001e\u00bd"+
		"\u0001\u0000\u0000\u0000 \u00ca\u0001\u0000\u0000\u0000\"\u00d4\u0001"+
		"\u0000\u0000\u0000$\u00d9\u0001\u0000\u0000\u0000&\u00dc\u0001\u0000\u0000"+
		"\u0000()\u0003\u0002\u0001\u0000)*\u0003\n\u0005\u0000*+\u0003\u0014\n"+
		"\u0000+\u0001\u0001\u0000\u0000\u0000,-\u0003\u0004\u0002\u0000-.\u0005"+
		"\u0014\u0000\u0000./\u0003\u0002\u0001\u0000/1\u0001\u0000\u0000\u0000"+
		"0,\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u00003\u0003\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u000058\u0003\u0006\u0003\u000068\u0003\b\u0004\u000075\u0001"+
		"\u0000\u0000\u000076\u0001\u0000\u0000\u00008\u0005\u0001\u0000\u0000"+
		"\u00009:\u0005\u0001\u0000\u0000:;\u0005\"\u0000\u0000;<\u0005\u0012\u0000"+
		"\u0000<=\u0003\u000e\u0007\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005"+
		"\u0002\u0000\u0000?@\u0005\"\u0000\u0000@A\u0005\u0012\u0000\u0000AB\u0003"+
		"\u000e\u0007\u0000BC\u0005\u0013\u0000\u0000CD\u0003\u001a\r\u0000D\t"+
		"\u0001\u0000\u0000\u0000EF\u0003\f\u0006\u0000FG\u0003\n\u0005\u0000G"+
		"I\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u000b\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MN\u0003\u000e\u0007\u0000"+
		"NO\u0005\"\u0000\u0000OP\u0005\u0015\u0000\u0000PQ\u0003\u0010\b\u0000"+
		"QR\u0005\u0016\u0000\u0000RS\u0005\u000f\u0000\u0000ST\u0003\u0002\u0001"+
		"\u0000TU\u0005\r\u0000\u0000UV\u0003\u0016\u000b\u0000VW\u0005\u0003\u0000"+
		"\u0000W[\u0005\u0015\u0000\u0000XZ\u0003\u001a\r\u0000YX\u0001\u0000\u0000"+
		"\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005"+
		"\u0016\u0000\u0000_`\u0005\u0014\u0000\u0000`a\u0005\u000e\u0000\u0000"+
		"a\r\u0001\u0000\u0000\u0000bc\u0007\u0000\u0000\u0000c\u000f\u0001\u0000"+
		"\u0000\u0000df\u0003\u0012\t\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0011"+
		"\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0005\"\u0000\u0000"+
		"kl\u0005\u0012\u0000\u0000lt\u0003\u000e\u0007\u0000mn\u0005\"\u0000\u0000"+
		"no\u0005\u0012\u0000\u0000op\u0003\u000e\u0007\u0000pq\u0005\u0011\u0000"+
		"\u0000qr\u0003\u0012\t\u0000rt\u0001\u0000\u0000\u0000sj\u0001\u0000\u0000"+
		"\u0000sm\u0001\u0000\u0000\u0000t\u0013\u0001\u0000\u0000\u0000uv\u0005"+
		"\u0007\u0000\u0000vw\u0005\r\u0000\u0000wx\u0003\u0002\u0001\u0000xy\u0003"+
		"\u0016\u000b\u0000yz\u0005\u000e\u0000\u0000z\u0015\u0001\u0000\u0000"+
		"\u0000{}\u0003\u0018\f\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0017\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0005\"\u0000\u0000\u0082\u0083\u0005\u0013\u0000\u0000\u0083\u0084"+
		"\u0003\u001a\r\u0000\u0084\u0085\u0005\u0014\u0000\u0000\u0085\u00a4\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005\"\u0000\u0000\u0087\u0088\u0005\u0015"+
		"\u0000\u0000\u0088\u0089\u0003$\u0012\u0000\u0089\u008a\u0005\u0016\u0000"+
		"\u0000\u008a\u008b\u0005\u0014\u0000\u0000\u008b\u00a4\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0005\r\u0000\u0000\u008d\u008e\u0003\u0016\u000b\u0000"+
		"\u008e\u008f\u0005\u000e\u0000\u0000\u008f\u00a4\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0005\b\u0000\u0000\u0091\u0092\u0003 \u0010\u0000\u0092"+
		"\u0093\u0005\r\u0000\u0000\u0093\u0094\u0003\u0016\u000b\u0000\u0094\u0095"+
		"\u0005\u000e\u0000\u0000\u0095\u00a4\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0005\t\u0000\u0000\u0097\u0098\u0005\r\u0000\u0000\u0098\u0099\u0003"+
		"\u0016\u000b\u0000\u0099\u009a\u0005\u000e\u0000\u0000\u009a\u00a4\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005\f\u0000\u0000\u009c\u009d\u0003 "+
		"\u0010\u0000\u009d\u009e\u0005\r\u0000\u0000\u009e\u009f\u0003\u0016\u000b"+
		"\u0000\u009f\u00a0\u0005\u000e\u0000\u0000\u00a0\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005\u0010\u0000\u0000\u00a2\u00a4\u0005\u0014\u0000"+
		"\u0000\u00a3\u0081\u0001\u0000\u0000\u0000\u00a3\u0086\u0001\u0000\u0000"+
		"\u0000\u00a3\u008c\u0001\u0000\u0000\u0000\u00a3\u0090\u0001\u0000\u0000"+
		"\u0000\u00a3\u0096\u0001\u0000\u0000\u0000\u00a3\u009b\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u0019\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0003\u001e\u000f\u0000\u00a6\u00a7\u0003\u001c\u000e"+
		"\u0000\u00a7\u00a8\u0003\u001e\u000f\u0000\u00a8\u00b4\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005\u0015\u0000\u0000\u00aa\u00ab\u0003\u001a\r\u0000"+
		"\u00ab\u00ac\u0005\u0016\u0000\u0000\u00ac\u00b4\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0005\"\u0000\u0000\u00ae\u00af\u0005\u0015\u0000\u0000\u00af"+
		"\u00b0\u0003$\u0012\u0000\u00b0\u00b1\u0005\u0016\u0000\u0000\u00b1\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b4\u0003\u001e\u000f\u0000\u00b3\u00a5"+
		"\u0001\u0000\u0000\u0000\u00b3\u00a9\u0001\u0000\u0000\u0000\u00b3\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u001b"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0007\u0001\u0000\u0000\u00b6\u001d"+
		"\u0001\u0000\u0000\u0000\u00b7\u00be\u0005\"\u0000\u0000\u00b8\u00b9\u0005"+
		"\u0018\u0000\u0000\u00b9\u00be\u0005\"\u0000\u0000\u00ba\u00be\u0005#"+
		"\u0000\u0000\u00bb\u00be\u0005\n\u0000\u0000\u00bc\u00be\u0005\u000b\u0000"+
		"\u0000\u00bd\u00b7\u0001\u0000\u0000\u0000\u00bd\u00b8\u0001\u0000\u0000"+
		"\u0000\u00bd\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u001f\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0006\u0010\uffff\uffff\u0000\u00c0\u00c1\u0005\u0019"+
		"\u0000\u0000\u00c1\u00cb\u0003 \u0010\u0004\u00c2\u00c3\u0005\u0015\u0000"+
		"\u0000\u00c3\u00c4\u0003 \u0010\u0000\u00c4\u00c5\u0005\u0016\u0000\u0000"+
		"\u00c5\u00cb\u0001\u0000\u0000\u0000\u00c6\u00c7\u0003\u001a\r\u0000\u00c7"+
		"\u00c8\u0003\"\u0011\u0000\u00c8\u00c9\u0003\u001a\r\u0000\u00c9\u00cb"+
		"\u0001\u0000\u0000\u0000\u00ca\u00bf\u0001\u0000\u0000\u0000\u00ca\u00c2"+
		"\u0001\u0000\u0000\u0000\u00ca\u00c6\u0001\u0000\u0000\u0000\u00cb\u00d1"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\n\u0001\u0000\u0000\u00cd\u00ce\u0007"+
		"\u0002\u0000\u0000\u00ce\u00d0\u0003 \u0010\u0002\u00cf\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2!\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d5\u0007\u0003\u0000"+
		"\u0000\u00d5#\u0001\u0000\u0000\u0000\u00d6\u00d8\u0003&\u0013\u0000\u00d7"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"%\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00df"+
		"\u0005\"\u0000\u0000\u00dd\u00de\u0005\u0011\u0000\u0000\u00de\u00e0\u0003"+
		"&\u0013\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e0\'\u0001\u0000\u0000\u0000\u000e27J[gs~\u00a3\u00b3"+
		"\u00bd\u00ca\u00d1\u00d9\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}