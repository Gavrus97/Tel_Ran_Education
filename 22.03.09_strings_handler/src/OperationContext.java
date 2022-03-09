import operations.IStringOperation;

import java.util.List;
import java.util.Map;

/**
 * loads and provides all operations by their names
 */
public class OperationContext {

    Map<String, IStringOperation> operationsSource;

    /**
     * The method creates instances for all the operation by their name and places them
     * @param operationsPaths the path to operations
     */
    public void loadOperations(List<String> operationsPaths){
        // TODO implement
    }

    public IStringOperation getOperation(String name){
        return operationsSource.get(name);
    }

}
