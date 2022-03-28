import java.util.List;

public class Department {

    String name;
    String code;
    List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }
}
