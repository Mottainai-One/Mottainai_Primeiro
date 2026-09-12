package administrationTest;

import org.mot.jdbc_Mottainai.dao.AdministrationDAO;
import org.mot.jdbc_Mottainai.model.Administration;

public class MainUpdateAdministration {
    public static void main(String[] args) {

        AdministrationDAO administrationDAO = new AdministrationDAO();
        Administration adm = new Administration(7,"srNInguem@gmail.com", "roubeiOquadros");// nao esqeça do id na hora dde passar o objeto
        administrationDAO.update(adm);
    }
}
