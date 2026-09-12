package storeTest;

import org.mot.jdbc_Mottainai.dao.StoreDAO;
import org.mot.jdbc_Mottainai.model.Store;

import java.util.List;

public class MainSelectStore {
    public static void main(String[] args) {

        StoreDAO storeDAO = new StoreDAO();
        List<Store> stores = storeDAO.list();

        for (Store store : stores){
            System.out.println(store);
        }
    }
}
