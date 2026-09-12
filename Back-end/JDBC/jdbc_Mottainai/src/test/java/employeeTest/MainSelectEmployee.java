package employeeTest;

import org.mot.jdbc_Mottainai.dao.EmployeeDAO;
import org.mot.jdbc_Mottainai.model.Employee;

import java.util.List;

public class MainSelectEmployee {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.list();

        for(Employee employee : employees){
            System.out.println(employee);
        }
    }
}
