package subscriptionPLanTest;

import org.mot.jdbc_Mottainai.dao.SubscriptionPLanDAO;

public class MainDeleteSubscriptionPlan {
    public static void main(String[] args) {

        SubscriptionPLanDAO subscriptionPLanDAO = new SubscriptionPLanDAO();
        subscriptionPLanDAO.delete(3);
    }
}
