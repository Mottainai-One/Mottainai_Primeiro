package administrationTest;

import org.mot.jdbc_Mottainai.dao.AdministrationDAO;
import org.mot.jdbc_Mottainai.model.Administration;

public class MainInsertAdministration {
    public static void main(String[] args) {

        AdministrationDAO administrationDAO = new AdministrationDAO();
        Administration adm = new Administration("quadros@gmail.com", "Cy1324$");
        administrationDAO.insert(adm);
    }
}
