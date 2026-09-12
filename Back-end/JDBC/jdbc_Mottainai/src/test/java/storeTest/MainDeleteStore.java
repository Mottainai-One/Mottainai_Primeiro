package storeTest;

import org.mot.jdbc_Mottainai.dao.StoreDAO;

public class MainDeleteStore {
    public static void main(String[] args) {

        StoreDAO storeDAO = new StoreDAO();
        storeDAO.delete(3);
    }
}
