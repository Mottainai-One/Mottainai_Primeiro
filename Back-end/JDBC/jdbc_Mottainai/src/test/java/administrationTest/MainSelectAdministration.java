package administrationTest;

import org.mot.jdbc_Mottainai.dao.AdministrationDAO;
import org.mot.jdbc_Mottainai.model.Administration;

import java.util.List;

public class MainSelectAdministration {
    public static void main(String[] args) {

        AdministrationDAO administrationDAO = new AdministrationDAO();
        List<Administration> administrations = administrationDAO.list();

        for(Administration adm : administrations){
            System.out.println(adm);
        }
    }
}
