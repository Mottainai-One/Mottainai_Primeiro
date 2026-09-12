package employeeTest;

import org.mot.jdbc_Mottainai.dao.EmployeeDAO;
import org.mot.jdbc_Mottainai.model.Company;
import org.mot.jdbc_Mottainai.model.Employee;
import org.mot.jdbc_Mottainai.model.Store;

import java.time.LocalDate;

public class MainUpdateEmployee {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        LocalDate data = LocalDate.parse("1980-02-02");
        LocalDate dt = LocalDate.parse("2020-10-02");
        LocalDate dt1 = LocalDate.parse("2010-10-02");

        Company company = new Company("12345678901234", "McDonald", "Empresa de FastFood", "mcdonald@gmail.com",dt1, "SP", "José Irineu", "São Paulo", "Jagurá","12345678" ,"12345678", "Empresa de FastFood" );
        Store store = new Store(3, "jbs@gmail.com","Loja JBS","Administração", "978119845","Ativo", "123", "Joé Ordom", "São Paulo", "Guarujá","12345678", "SP", "Empresa de Alimentos",  company);
        Employee employee = new Employee("13263893893", "Bob", "Jordam", data,dt, store);

        employeeDAO.update(employee);
    }
}
