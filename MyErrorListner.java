import org.antlr.v4.runtime.*;

public class MyErrorListner extends BaseErrorListener {

    private final String fileName;
    private Boolean status;

    public MyErrorListner(String fileName) {
        this.fileName = fileName;
        this.status = true;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        this.status = false;
        System.err.println(fileName + " has not parsed!\n\n");
        System.err.println("Syntax Error at line " + line + ", column " + charPositionInLine);
        System.err.println("Message: " + msg);
        System.err.println("Offending symbol: " + offendingSymbol);

        if (e != null) {
            System.err.println("Exception details: " + e.getMessage());
        }

        System.err.println();
    }

    public Boolean getStatus() {
        return this.status;
    }

}
