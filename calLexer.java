// Generated from cal.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class calLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "VARIABLE", 
			"CONSTANT", "RETURN", "INT", "BOOL", "VOID", "MAIN", "IF", "ELSE", "TRUE", 
			"FALSE", "WHILE", "BEGIN", "END", "IS", "SK", "COMMA", "DEFINE", "ASSIGN", 
			"SEMI", "LBR", "RBR", "PLUS", "MINUS", "NEG", "OR", "AND", "EQ", "NEQ", 
			"LT", "LTE", "GT", "GTE", "ID", "NUMBER", "LINE_COMMENT", "MULTI_LINE_COMMENT", 
			"WS"
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


	public calLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "cal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000&\u0171\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 "+
		"\u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001+\u0001+\u0001"+
		",\u0001,\u0001,\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u00010\u0001"+
		"0\u00011\u00011\u00012\u00012\u00013\u00013\u00014\u00014\u00015\u0001"+
		"5\u00016\u00016\u00016\u00017\u00017\u00018\u00018\u00018\u00019\u0001"+
		"9\u0001:\u0001:\u0001:\u0001;\u0001;\u0005;\u0135\b;\n;\f;\u0138\t;\u0001"+
		"<\u0003<\u013b\b<\u0001<\u0001<\u0005<\u013f\b<\n<\f<\u0142\t<\u0003<"+
		"\u0144\b<\u0001<\u0001<\u0005<\u0148\b<\n<\f<\u014b\t<\u0003<\u014d\b"+
		"<\u0001<\u0003<\u0150\b<\u0001=\u0001=\u0001=\u0001=\u0005=\u0156\b=\n"+
		"=\f=\u0159\t=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0005>\u0161\b"+
		">\n>\f>\u0164\t>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001?\u0004?\u016c"+
		"\b?\u000b?\f?\u016d\u0001?\u0001?\u0001\u0162\u0000@\u0001\u0000\u0003"+
		"\u0000\u0005\u0000\u0007\u0000\t\u0000\u000b\u0000\r\u0000\u000f\u0000"+
		"\u0011\u0000\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000"+
		"\u001d\u0000\u001f\u0000!\u0000#\u0000%\u0000\'\u0000)\u0000+\u0000-\u0000"+
		"/\u00001\u00003\u00005\u00017\u00029\u0003;\u0004=\u0005?\u0006A\u0007"+
		"C\bE\tG\nI\u000bK\fM\rO\u000eQ\u000fS\u0010U\u0011W\u0012Y\u0013[\u0014"+
		"]\u0015_\u0016a\u0017c\u0018e\u0019g\u001ai\u001bk\u001cm\u001do\u001e"+
		"q\u001fs u!w\"y#{$}%\u007f&\u0001\u0000 \u0002\u0000AAaa\u0002\u0000B"+
		"Bbb\u0002\u0000CCcc\u0002\u0000DDdd\u0002\u0000EEee\u0002\u0000FFff\u0002"+
		"\u0000GGgg\u0002\u0000HHhh\u0002\u0000IIii\u0002\u0000JJjj\u0002\u0000"+
		"KKkk\u0002\u0000LLll\u0002\u0000MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002"+
		"\u0000PPpp\u0002\u0000QQqq\u0002\u0000RRrr\u0002\u0000SSss\u0002\u0000"+
		"TTtt\u0002\u0000UUuu\u0002\u0000VVvv\u0002\u0000WWww\u0002\u0000XXxx\u0002"+
		"\u0000YYyy\u0002\u0000ZZzz\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001"+
		"\u000019\u0001\u000009\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u0161"+
		"\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009"+
		"\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000"+
		"\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000"+
		"\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G"+
		"\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000"+
		"\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000"+
		"\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U"+
		"\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000"+
		"\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000"+
		"\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c"+
		"\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000"+
		"\u0000\u0000\u0000i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000"+
		"\u0000m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000\u0000q"+
		"\u0001\u0000\u0000\u0000\u0000s\u0001\u0000\u0000\u0000\u0000u\u0001\u0000"+
		"\u0000\u0000\u0000w\u0001\u0000\u0000\u0000\u0000y\u0001\u0000\u0000\u0000"+
		"\u0000{\u0001\u0000\u0000\u0000\u0000}\u0001\u0000\u0000\u0000\u0000\u007f"+
		"\u0001\u0000\u0000\u0000\u0001\u0081\u0001\u0000\u0000\u0000\u0003\u0083"+
		"\u0001\u0000\u0000\u0000\u0005\u0085\u0001\u0000\u0000\u0000\u0007\u0087"+
		"\u0001\u0000\u0000\u0000\t\u0089\u0001\u0000\u0000\u0000\u000b\u008b\u0001"+
		"\u0000\u0000\u0000\r\u008d\u0001\u0000\u0000\u0000\u000f\u008f\u0001\u0000"+
		"\u0000\u0000\u0011\u0091\u0001\u0000\u0000\u0000\u0013\u0093\u0001\u0000"+
		"\u0000\u0000\u0015\u0095\u0001\u0000\u0000\u0000\u0017\u0097\u0001\u0000"+
		"\u0000\u0000\u0019\u0099\u0001\u0000\u0000\u0000\u001b\u009b\u0001\u0000"+
		"\u0000\u0000\u001d\u009d\u0001\u0000\u0000\u0000\u001f\u009f\u0001\u0000"+
		"\u0000\u0000!\u00a1\u0001\u0000\u0000\u0000#\u00a3\u0001\u0000\u0000\u0000"+
		"%\u00a5\u0001\u0000\u0000\u0000\'\u00a7\u0001\u0000\u0000\u0000)\u00a9"+
		"\u0001\u0000\u0000\u0000+\u00ab\u0001\u0000\u0000\u0000-\u00ad\u0001\u0000"+
		"\u0000\u0000/\u00af\u0001\u0000\u0000\u00001\u00b1\u0001\u0000\u0000\u0000"+
		"3\u00b3\u0001\u0000\u0000\u00005\u00b5\u0001\u0000\u0000\u00007\u00be"+
		"\u0001\u0000\u0000\u00009\u00c7\u0001\u0000\u0000\u0000;\u00ce\u0001\u0000"+
		"\u0000\u0000=\u00d2\u0001\u0000\u0000\u0000?\u00d7\u0001\u0000\u0000\u0000"+
		"A\u00dc\u0001\u0000\u0000\u0000C\u00e1\u0001\u0000\u0000\u0000E\u00e4"+
		"\u0001\u0000\u0000\u0000G\u00e9\u0001\u0000\u0000\u0000I\u00ee\u0001\u0000"+
		"\u0000\u0000K\u00f4\u0001\u0000\u0000\u0000M\u00fa\u0001\u0000\u0000\u0000"+
		"O\u0100\u0001\u0000\u0000\u0000Q\u0104\u0001\u0000\u0000\u0000S\u0107"+
		"\u0001\u0000\u0000\u0000U\u010c\u0001\u0000\u0000\u0000W\u010e\u0001\u0000"+
		"\u0000\u0000Y\u0110\u0001\u0000\u0000\u0000[\u0113\u0001\u0000\u0000\u0000"+
		"]\u0115\u0001\u0000\u0000\u0000_\u0117\u0001\u0000\u0000\u0000a\u0119"+
		"\u0001\u0000\u0000\u0000c\u011b\u0001\u0000\u0000\u0000e\u011d\u0001\u0000"+
		"\u0000\u0000g\u011f\u0001\u0000\u0000\u0000i\u0121\u0001\u0000\u0000\u0000"+
		"k\u0123\u0001\u0000\u0000\u0000m\u0125\u0001\u0000\u0000\u0000o\u0128"+
		"\u0001\u0000\u0000\u0000q\u012a\u0001\u0000\u0000\u0000s\u012d\u0001\u0000"+
		"\u0000\u0000u\u012f\u0001\u0000\u0000\u0000w\u0132\u0001\u0000\u0000\u0000"+
		"y\u014f\u0001\u0000\u0000\u0000{\u0151\u0001\u0000\u0000\u0000}\u015c"+
		"\u0001\u0000\u0000\u0000\u007f\u016b\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0007\u0000\u0000\u0000\u0082\u0002\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0007\u0001\u0000\u0000\u0084\u0004\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0007\u0002\u0000\u0000\u0086\u0006\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0007\u0003\u0000\u0000\u0088\b\u0001\u0000\u0000\u0000\u0089\u008a\u0007"+
		"\u0004\u0000\u0000\u008a\n\u0001\u0000\u0000\u0000\u008b\u008c\u0007\u0005"+
		"\u0000\u0000\u008c\f\u0001\u0000\u0000\u0000\u008d\u008e\u0007\u0006\u0000"+
		"\u0000\u008e\u000e\u0001\u0000\u0000\u0000\u008f\u0090\u0007\u0007\u0000"+
		"\u0000\u0090\u0010\u0001\u0000\u0000\u0000\u0091\u0092\u0007\b\u0000\u0000"+
		"\u0092\u0012\u0001\u0000\u0000\u0000\u0093\u0094\u0007\t\u0000\u0000\u0094"+
		"\u0014\u0001\u0000\u0000\u0000\u0095\u0096\u0007\n\u0000\u0000\u0096\u0016"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0007\u000b\u0000\u0000\u0098\u0018"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0007\f\u0000\u0000\u009a\u001a\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0007\r\u0000\u0000\u009c\u001c\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0007\u000e\u0000\u0000\u009e\u001e\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0007\u000f\u0000\u0000\u00a0 \u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0007\u0010\u0000\u0000\u00a2\"\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0007\u0011\u0000\u0000\u00a4$\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0007\u0012\u0000\u0000\u00a6&\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0007\u0013\u0000\u0000\u00a8(\u0001\u0000\u0000\u0000\u00a9\u00aa\u0007"+
		"\u0014\u0000\u0000\u00aa*\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007\u0015"+
		"\u0000\u0000\u00ac,\u0001\u0000\u0000\u0000\u00ad\u00ae\u0007\u0016\u0000"+
		"\u0000\u00ae.\u0001\u0000\u0000\u0000\u00af\u00b0\u0007\u0017\u0000\u0000"+
		"\u00b00\u0001\u0000\u0000\u0000\u00b1\u00b2\u0007\u0018\u0000\u0000\u00b2"+
		"2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0007\u0019\u0000\u0000\u00b44\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b6\u0003+\u0015\u0000\u00b6\u00b7\u0003\u0001"+
		"\u0000\u0000\u00b7\u00b8\u0003#\u0011\u0000\u00b8\u00b9\u0003\u0011\b"+
		"\u0000\u00b9\u00ba\u0003\u0001\u0000\u0000\u00ba\u00bb\u0003\u0003\u0001"+
		"\u0000\u00bb\u00bc\u0003\u0017\u000b\u0000\u00bc\u00bd\u0003\t\u0004\u0000"+
		"\u00bd6\u0001\u0000\u0000\u0000\u00be\u00bf\u0003\u0005\u0002\u0000\u00bf"+
		"\u00c0\u0003\u001d\u000e\u0000\u00c0\u00c1\u0003\u001b\r\u0000\u00c1\u00c2"+
		"\u0003%\u0012\u0000\u00c2\u00c3\u0003\'\u0013\u0000\u00c3\u00c4\u0003"+
		"\u0001\u0000\u0000\u00c4\u00c5\u0003\u001b\r\u0000\u00c5\u00c6\u0003\'"+
		"\u0013\u0000\u00c68\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003#\u0011\u0000"+
		"\u00c8\u00c9\u0003\t\u0004\u0000\u00c9\u00ca\u0003\'\u0013\u0000\u00ca"+
		"\u00cb\u0003)\u0014\u0000\u00cb\u00cc\u0003#\u0011\u0000\u00cc\u00cd\u0003"+
		"\u001b\r\u0000\u00cd:\u0001\u0000\u0000\u0000\u00ce\u00cf\u0003\u0011"+
		"\b\u0000\u00cf\u00d0\u0003\u001b\r\u0000\u00d0\u00d1\u0003\'\u0013\u0000"+
		"\u00d1<\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003\u0003\u0001\u0000\u00d3"+
		"\u00d4\u0003\u001d\u000e\u0000\u00d4\u00d5\u0003\u001d\u000e\u0000\u00d5"+
		"\u00d6\u0003\u0017\u000b\u0000\u00d6>\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0003+\u0015\u0000\u00d8\u00d9\u0003\u001d\u000e\u0000\u00d9\u00da\u0003"+
		"\u0011\b\u0000\u00da\u00db\u0003\u0007\u0003\u0000\u00db@\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0003\u0019\f\u0000\u00dd\u00de\u0003\u0001\u0000"+
		"\u0000\u00de\u00df\u0003\u0011\b\u0000\u00df\u00e0\u0003\u001b\r\u0000"+
		"\u00e0B\u0001\u0000\u0000\u0000\u00e1\u00e2\u0003\u0011\b\u0000\u00e2"+
		"\u00e3\u0003\u000b\u0005\u0000\u00e3D\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0003\t\u0004\u0000\u00e5\u00e6\u0003\u0017\u000b\u0000\u00e6\u00e7\u0003"+
		"%\u0012\u0000\u00e7\u00e8\u0003\t\u0004\u0000\u00e8F\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0003\'\u0013\u0000\u00ea\u00eb\u0003#\u0011\u0000"+
		"\u00eb\u00ec\u0003)\u0014\u0000\u00ec\u00ed\u0003\t\u0004\u0000\u00ed"+
		"H\u0001\u0000\u0000\u0000\u00ee\u00ef\u0003\u000b\u0005\u0000\u00ef\u00f0"+
		"\u0003\u0001\u0000\u0000\u00f0\u00f1\u0003\u0017\u000b\u0000\u00f1\u00f2"+
		"\u0003%\u0012\u0000\u00f2\u00f3\u0003\t\u0004\u0000\u00f3J\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0003-\u0016\u0000\u00f5\u00f6\u0003\u000f\u0007"+
		"\u0000\u00f6\u00f7\u0003\u0011\b\u0000\u00f7\u00f8\u0003\u0017\u000b\u0000"+
		"\u00f8\u00f9\u0003\t\u0004\u0000\u00f9L\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0003\u0003\u0001\u0000\u00fb\u00fc\u0003\t\u0004\u0000\u00fc\u00fd"+
		"\u0003\r\u0006\u0000\u00fd\u00fe\u0003\u0011\b\u0000\u00fe\u00ff\u0003"+
		"\u001b\r\u0000\u00ffN\u0001\u0000\u0000\u0000\u0100\u0101\u0003\t\u0004"+
		"\u0000\u0101\u0102\u0003\u001b\r\u0000\u0102\u0103\u0003\u0007\u0003\u0000"+
		"\u0103P\u0001\u0000\u0000\u0000\u0104\u0105\u0003\u0011\b\u0000\u0105"+
		"\u0106\u0003%\u0012\u0000\u0106R\u0001\u0000\u0000\u0000\u0107\u0108\u0003"+
		"%\u0012\u0000\u0108\u0109\u0003\u0015\n\u0000\u0109\u010a\u0003\u0011"+
		"\b\u0000\u010a\u010b\u0003\u001f\u000f\u0000\u010bT\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0005,\u0000\u0000\u010dV\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0005:\u0000\u0000\u010fX\u0001\u0000\u0000\u0000\u0110\u0111\u0005"+
		":\u0000\u0000\u0111\u0112\u0005=\u0000\u0000\u0112Z\u0001\u0000\u0000"+
		"\u0000\u0113\u0114\u0005;\u0000\u0000\u0114\\\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0005(\u0000\u0000\u0116^\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0005)\u0000\u0000\u0118`\u0001\u0000\u0000\u0000\u0119\u011a\u0005+"+
		"\u0000\u0000\u011ab\u0001\u0000\u0000\u0000\u011b\u011c\u0005-\u0000\u0000"+
		"\u011cd\u0001\u0000\u0000\u0000\u011d\u011e\u0005~\u0000\u0000\u011ef"+
		"\u0001\u0000\u0000\u0000\u011f\u0120\u0005|\u0000\u0000\u0120h\u0001\u0000"+
		"\u0000\u0000\u0121\u0122\u0005&\u0000\u0000\u0122j\u0001\u0000\u0000\u0000"+
		"\u0123\u0124\u0005=\u0000\u0000\u0124l\u0001\u0000\u0000\u0000\u0125\u0126"+
		"\u0005!\u0000\u0000\u0126\u0127\u0005=\u0000\u0000\u0127n\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0005<\u0000\u0000\u0129p\u0001\u0000\u0000\u0000"+
		"\u012a\u012b\u0005<\u0000\u0000\u012b\u012c\u0005=\u0000\u0000\u012cr"+
		"\u0001\u0000\u0000\u0000\u012d\u012e\u0005>\u0000\u0000\u012et\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0005>\u0000\u0000\u0130\u0131\u0005=\u0000\u0000"+
		"\u0131v\u0001\u0000\u0000\u0000\u0132\u0136\u0007\u001a\u0000\u0000\u0133"+
		"\u0135\u0007\u001b\u0000\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135"+
		"\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0001\u0000\u0000\u0000\u0137x\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0139\u013b\u0005-\u0000\u0000\u013a\u0139\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0001"+
		"\u0000\u0000\u0000\u013c\u0143\u0007\u001c\u0000\u0000\u013d\u013f\u0007"+
		"\u001d\u0000\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013f\u0142\u0001"+
		"\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001"+
		"\u0000\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000\u0142\u0140\u0001"+
		"\u0000\u0000\u0000\u0143\u0140\u0001\u0000\u0000\u0000\u0143\u0144\u0001"+
		"\u0000\u0000\u0000\u0144\u0150\u0001\u0000\u0000\u0000\u0145\u014c\u0007"+
		"\u001c\u0000\u0000\u0146\u0148\u0007\u001d\u0000\u0000\u0147\u0146\u0001"+
		"\u0000\u0000\u0000\u0148\u014b\u0001\u0000\u0000\u0000\u0149\u0147\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014d\u0001"+
		"\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014c\u0149\u0001"+
		"\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u0150\u0001"+
		"\u0000\u0000\u0000\u014e\u0150\u00050\u0000\u0000\u014f\u013a\u0001\u0000"+
		"\u0000\u0000\u014f\u0145\u0001\u0000\u0000\u0000\u014f\u014e\u0001\u0000"+
		"\u0000\u0000\u0150z\u0001\u0000\u0000\u0000\u0151\u0152\u0005/\u0000\u0000"+
		"\u0152\u0153\u0005/\u0000\u0000\u0153\u0157\u0001\u0000\u0000\u0000\u0154"+
		"\u0156\b\u001e\u0000\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0156\u0159"+
		"\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157\u0158"+
		"\u0001\u0000\u0000\u0000\u0158\u015a\u0001\u0000\u0000\u0000\u0159\u0157"+
		"\u0001\u0000\u0000\u0000\u015a\u015b\u0006=\u0000\u0000\u015b|\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0005/\u0000\u0000\u015d\u015e\u0005*\u0000\u0000"+
		"\u015e\u0162\u0001\u0000\u0000\u0000\u015f\u0161\t\u0000\u0000\u0000\u0160"+
		"\u015f\u0001\u0000\u0000\u0000\u0161\u0164\u0001\u0000\u0000\u0000\u0162"+
		"\u0163\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0163"+
		"\u0165\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0005*\u0000\u0000\u0166\u0167\u0005/\u0000\u0000\u0167\u0168\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0006>\u0000\u0000\u0169~\u0001\u0000\u0000"+
		"\u0000\u016a\u016c\u0007\u001f\u0000\u0000\u016b\u016a\u0001\u0000\u0000"+
		"\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000"+
		"\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000"+
		"\u0000\u016f\u0170\u0006?\u0000\u0000\u0170\u0080\u0001\u0000\u0000\u0000"+
		"\u000b\u0000\u0136\u013a\u0140\u0143\u0149\u014c\u014f\u0157\u0162\u016d"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}