package companyTest;

import org.mot.jdbc_Mottainai.dao.CompanyDAO;

public class MainDeleteCompany {
    public static void main(String[] args) {

        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.delete("12345678901234");
    }
}
