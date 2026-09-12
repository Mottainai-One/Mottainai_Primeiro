package storeTest;

import org.mot.jdbc_Mottainai.dao.StoreDAO;
import org.mot.jdbc_Mottainai.model.Company;
import org.mot.jdbc_Mottainai.model.Store;

import java.time.LocalDate;

public class MainInsertStore {
    public static void main(String[] args) {

        LocalDate data = LocalDate.parse("2026-02-02");
        Company company = new Company("12345678901234", "JBS Global", "prédio", "jbsGlobal@gmail.com", data, "SP","Irineu José Bordom", "São Paulo", "Vila Jaguaré", "97999999", "9999", "Empresa de Alimentos globais" );

        Store store = new Store(3, "jbs@gmail.com","Loja JBS","Administração", "11978119845","Ativo", "123", "Joé Ordom", "São Paulo", "Guaruja","12345678", "SP", "alimentos gostosos",  company);
        StoreDAO storeDAO = new StoreDAO();

        storeDAO.insert(store);
    }
}
