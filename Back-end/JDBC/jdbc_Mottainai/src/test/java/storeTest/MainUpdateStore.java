package storeTest;

import org.mot.jdbc_Mottainai.dao.StoreDAO;
import org.mot.jdbc_Mottainai.model.Company;
import org.mot.jdbc_Mottainai.model.Store;

import java.time.LocalDate;

public class MainUpdateStore {
    public static void main(String[] args) {

        StoreDAO storeDAO = new StoreDAO();

        LocalDate data = LocalDate.parse("2026-02-02");
        Company company = new Company("12345678901234", "JBS Global", "prédio", "jbsGlobal@gmail.com", data, "SP","Irineu José Bordom", "São Paulo", "Vila Jaguaré", "97999999", "9999", "Empresa de Alimentos globais" );

        Store store = new Store(3, "jbsGlobal@gmail.com","Loja JBS glovas","Administração de alimentos", "11978119845","Inativo", "123", "Joé Ordom Irineu", "São Paulo/SP", "raguaja Lapa","12345678", "SP", "alimentos muito gostosos",  company);

        storeDAO.update(store);
    }
}
