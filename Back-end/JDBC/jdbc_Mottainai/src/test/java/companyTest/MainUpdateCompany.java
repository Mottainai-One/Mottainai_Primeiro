package companyTest;

import org.mot.jdbc_Mottainai.dao.CompanyDAO;
import org.mot.jdbc_Mottainai.model.Company;

import java.time.LocalDate;

public class MainUpdateCompany {
    public static void main(String[] args) {

        LocalDate data = LocalDate.parse("2026-09-01");
        Company company = new Company("12345678901234", "JBS Brasil", "Prédio", "jbsBrasil@gmail.com", data, "PE", "Casuza", "Recife", "Jardim Rosinha", "12365487", "8888", "Empresa Nacional de Alimentos");
        CompanyDAO companyDAO = new CompanyDAO();

        companyDAO.update(company);
    }
}
