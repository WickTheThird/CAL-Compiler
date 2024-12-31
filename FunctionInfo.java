import java.util.List;

public class FunctionInfo {
    private String returnType;
    private List<Value> parameters;
    private Value returnValue; 

    public FunctionInfo(String returnType, List<Value> parameters) {
        this.returnType = returnType;
        this.parameters = parameters;
        this.returnValue = null;
    }

    public String getReturnType() {
        return returnType;
    }

    public List<Value> getParameters() {
        return parameters;
    }

    public void setReturnValue(Value returnValue) {
        this.returnValue = returnValue;
    }

    public Value getReturnValue() {
        return returnValue;
    }
}
