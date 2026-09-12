package companyTest;

import org.mot.jdbc_Mottainai.dao.CompanyDAO;
import org.mot.jdbc_Mottainai.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MainSelectCompany {
    public static void main(String[] args) {

        CompanyDAO companyDAO = new CompanyDAO();
        List<Company> companies = companyDAO.list();

        for (Company company : companies){
            System.out.println(company);
        }
    }
}
