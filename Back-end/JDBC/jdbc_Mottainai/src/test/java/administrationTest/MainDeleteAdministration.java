package administrationTest;

import org.mot.jdbc_Mottainai.dao.AdministrationDAO;

public class MainDeleteAdministration {
    public static void main(String[] args) {

        AdministrationDAO administrationDAO = new AdministrationDAO();
        administrationDAO.delete(7);
    }
}
