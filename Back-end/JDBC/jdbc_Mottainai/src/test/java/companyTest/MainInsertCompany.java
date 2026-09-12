package companyTest;

import org.mot.jdbc_Mottainai.dao.CompanyDAO;
import org.mot.jdbc_Mottainai.model.Company;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainInsertCompany {
    public static void main(String[] args) {

        CompanyDAO companyDAO = new CompanyDAO();
        LocalDate data = LocalDate.parse("2026-02-02");
        Company company = new Company("12345678901234", "JBS Global", "prédio", "jbsGlobal@gmail.com", data, "SP","Irineu José Bordom", "São Paulo", "Vila Jaguaré", "97999999", "9999", "Empresa Internacional de Alimentos" );

       companyDAO.insert(company);
    }
}
