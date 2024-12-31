import java.util.ArrayList;
import java.util.List;

public class Value {
    private String name;
    private Object value;
    private String type;
    private boolean isConstant = false;
    private List<Value> parameters;
    private String returnType;

    public Value(String type, Object value) {
        this.type = type;
        this.value = value;
        this.parameters = new ArrayList<>();
        this.returnType = null;
    }

    public Value(String name, String type, Object value, int checker) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.parameters = new ArrayList<>();
        this.returnType = null;
    }

    public Value(String type, Object value, boolean isConstant) {
        this.value = value;
        this.type = type.toLowerCase();
        this.isConstant = isConstant;
        this.parameters = new ArrayList<>();
        this.returnType = null;
    }

    public Value(String name, String returnType, List<Value> parameters) {
        this.name = name;
        this.value = null;
        this.type = "function";
        this.parameters = parameters;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Value> getParameters() {
        return parameters;
    }

    public String getReturnType() {
        return returnType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public int asInt() {
        if (!"int".equals(type)) {
            throw new RuntimeException("Value is not an integer: " + value);
        }
        return (int) value;
    }

    public boolean asBoolean() {
        if (!"boolean".equals(type)) {
            throw new RuntimeException("Value is not a boolean: " + value);
        }
        return (boolean) value;
    }

    public String asString() {
        if (!"string".equals(type)) {
            throw new RuntimeException("Value is not a string: " + value);
        }
        return (String) value;
    }

    public boolean isNull() {
        return value == null;
    }


    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Value other = (Value) obj;
        return this.type.equals(other.type) && this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode() + type.hashCode();
    }
}
