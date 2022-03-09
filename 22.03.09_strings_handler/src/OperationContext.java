import operations.IStringOperation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * loads and provides all operations by their names
 */
public class OperationContext {

    Map<String, IStringOperation> operationsSource = new TreeMap<>();

    /**
     * The method creates instances for all the operation by their name and places them into operationsSource
     * @param operationsPaths the path to operations
     */
    public void loadOperations(List<String> operationsPaths){
        for(String s : operationsPaths){
            try {
                Class<?> classFromString = Class.forName(s);
                IStringOperation operation = (IStringOperation) classFromString.getConstructor().newInstance();
                operationsSource.put(operation.getName(), operation);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public IStringOperation getOperation(String name){
        return operationsSource.get(name);
    }

}
