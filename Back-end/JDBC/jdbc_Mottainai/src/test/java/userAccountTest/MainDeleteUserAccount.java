package userAccountTest;

import org.mot.jdbc_Mottainai.dao.EmployeeDAO;

public class MainDeleteUserAccount {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.delete("13263893893");
    }
}
