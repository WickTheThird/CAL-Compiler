import java.util.List;

public class SymbolInfo {
    private Value value;
    private boolean isConstant;
    private List<Value> parameters;
    private Value returnValue;
    private String name;

    public SymbolInfo(String name, Value value, boolean isConstant) {
        this.value = value;
        this.isConstant = isConstant;
        this.parameters = null;
        this.returnValue = null;
        this.name = name;
    }

    public SymbolInfo(String name, Value returnValue, List<Value> parameters) {
        this.value = returnValue;
        this.isConstant = false;
        this.parameters = parameters;
        this.returnValue = returnValue;
        this.name = name;
    }

    public Value getValue() {
        return value;
    }

    public String getName() {
        return value.getName();
    }

    public String getType() {
        return value.getType();
    }

    public boolean isConstant() {
        return isConstant;
    }

    public void setValue(Value value) {
        if (isConstant) {
            throw new IllegalArgumentException("Cannot modify a constant variable.");
        }
        this.value = value;
    }

    public List<Value> getParameters() {
        return parameters;
    }

    public Value getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Value returnValue) {
        this.returnValue = returnValue;
    }

    public void setParameters(List<Value> parameters) {
        this.parameters = parameters;
    }
}
