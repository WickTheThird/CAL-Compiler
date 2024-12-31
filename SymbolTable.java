import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private Map<String, Map<String, SymbolInfo>> scopeMap;
    private String currentScopePath;

    public SymbolTable() {
        scopeMap = new HashMap<>();
        currentScopePath = "GLOBAL";
        scopeMap.put(currentScopePath, new HashMap<>());
    }

    public SymbolInfo lookupFunction(String identifier) {
        Map<String, SymbolInfo> currentScope = scopeMap.get(currentScopePath);

        if (currentScope != null && currentScope.containsKey(identifier)) {
            return currentScope.get(identifier);
        }

        for (Map.Entry<String, Map<String, SymbolInfo>> entry : scopeMap.entrySet()) {
            currentScope = entry.getValue();

            if (currentScope != null && currentScope.containsKey(identifier)) {
                return currentScope.get(identifier);
            }
        }

        return null;

        // throw new IllegalArgumentException("Function '" + identifier + "' is not declared.");
    }


    public void enterScope(String scopeName) {
        currentScopePath = currentScopePath + ">" + scopeName;

        if (!scopeMap.containsKey(currentScopePath)) {
            scopeMap.put(currentScopePath, new HashMap<>());
        }
    }

    public void leaveScope() {
        if (currentScopePath.equals("GLOBAL")) {
            throw new IllegalStateException("Cannot leave the global scope.");
        }

        int lastSeparator = currentScopePath.lastIndexOf(">");
        currentScopePath = (lastSeparator == -1) ? "GLOBAL" : currentScopePath.substring(0, lastSeparator);
    }

    public void declareVariable(String identifier, Value value, boolean isConstant, List<Value> parameter) {
        Map<String, SymbolInfo> currentScope = scopeMap.get(currentScopePath);

        if (currentScope.containsKey(identifier)) {
            throw new IllegalArgumentException("Variable '" + identifier + "' is already declared in the current scope.");
        }

        value.setName(identifier);

        if (parameter == null) {
            currentScope.put(identifier, new SymbolInfo(identifier, value, isConstant));
        } else {
            currentScope.put(identifier, new SymbolInfo(identifier, value, parameter));
        }
    }

    public SymbolInfo lookupVariable(String identifier) {
        String searchPath = currentScopePath;

        // printScopeMap();

        while (searchPath != null) {
            Map<String, SymbolInfo> currentScope = scopeMap.get(searchPath);

            if (currentScope != null && currentScope.containsKey(identifier)) {
                return currentScope.get(identifier);
            }

            int lastSeparator = searchPath.lastIndexOf(">");
            searchPath = (lastSeparator == -1) ? null : searchPath.substring(0, lastSeparator);
        }
        return null;
        // throw new IllegalArgumentException("Variable '" + identifier + "' is not declared.");
    }

    public void updateVariable(String identifier, Value newValue) {
        String searchPath = currentScopePath;

        while (searchPath != null) {
            Map<String, SymbolInfo> currentScope = scopeMap.get(searchPath);

            if (currentScope != null && currentScope.containsKey(identifier)) {
                SymbolInfo symbolInfo = currentScope.get(identifier);
                symbolInfo.setValue(newValue);
                return;
            }

            int lastSeparator = searchPath.lastIndexOf(">");
            searchPath = (lastSeparator == -1) ? null : searchPath.substring(0, lastSeparator);
        }

        throw new IllegalArgumentException("Variable '" + identifier + "' is not declared.");
    }

    public void printScopeMap() {
        // System.out.println("Scope Map:");
        // for (Map.Entry<String, Map<String, SymbolInfo>> entry : scopeMap.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue().keySet());
        // }

        // System.out.println("Scope Map:");
        for (Map.Entry<String, Map<String, SymbolInfo>> scopeEntry : scopeMap.entrySet()) {
            String scopeName = scopeEntry.getKey();
            Map<String, SymbolInfo> variables = scopeEntry.getValue();

            System.out.println("Scope: " + scopeName);
            
            if (variables.isEmpty()) {
                System.out.println("  No variables declared.");
            } else {
                for (Map.Entry<String, SymbolInfo> varEntry : variables.entrySet()) {
                    String variableName = varEntry.getKey();
                    SymbolInfo symbolInfo = varEntry.getValue();
                    
                    System.out.println("  Variable: " + variableName + 
                                    " | Value: " + symbolInfo.getValue() + 
                                    " | Constant: " + symbolInfo.isConstant());
                }
            }
            System.out.println();
        }
    }

    public String getCurrentScope() {
        int temp = getCurrentScopePath().split(">").length;

        return currentScopePath.split(">")[temp - 1];
    }

    public String getCurrentScopePath() {
        return currentScopePath;
    }
}
