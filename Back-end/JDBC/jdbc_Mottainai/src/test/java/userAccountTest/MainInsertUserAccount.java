package userAccountTest;

import org.mot.jdbc_Mottainai.dao.EmployeeDAO;
import org.mot.jdbc_Mottainai.dao.UserAccountDAO;
import org.mot.jdbc_Mottainai.model.Company;
import org.mot.jdbc_Mottainai.model.Employee;
import org.mot.jdbc_Mottainai.model.Store;
import org.mot.jdbc_Mottainai.model.UserAccount;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainInsertUserAccount {
    public static void main(String[] args) {


        UserAccountDAO userAccountDAO = new UserAccountDAO();
        LocalDateTime hora = LocalDateTime.parse("2026-09-01T18:24:00");
        LocalDate data03 = LocalDate.parse("2026-02-02");

        LocalDate data00 = LocalDate.parse("1990-02-02");
        LocalDate dt = LocalDate.parse("2010-10-02");
        LocalDate dt1 = LocalDate.parse("2010-10-02");

        Company company = new Company("12345678901234", "McDonald", "Empresa de alimentos", "mc@gmail.com",dt1, "SP", "José Irineu", "São Paulo", "Jagurá","12345678" ,"12345678", "alimentos" );
        Store store = new Store(3, "jbs@gmail.com","Loja JBS","Administração", "978119845","Ativo", "123", "Joé Ordom", "São Paulo", "raguaja","12345678", "SP", "alimentos gostosos",  company);
        Employee employee = new Employee("13263893893", "Patrick", "Jane", data00,dt, store);


        UserAccount userAccount = new UserAccount(3, "Zaia", "interServlet@gmail.com", "12345678901", data03, hora, "Ativo", "Gerente", employee);

        userAccountDAO.insert(userAccount);
    }
}
