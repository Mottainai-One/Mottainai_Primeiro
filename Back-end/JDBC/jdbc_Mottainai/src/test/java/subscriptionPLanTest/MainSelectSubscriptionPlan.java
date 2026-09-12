package subscriptionPLanTest;

import org.mot.jdbc_Mottainai.dao.SubscriptionPLanDAO;
import org.mot.jdbc_Mottainai.model.SubscriptionPlan;

import java.util.ArrayList;
import java.util.List;

public class MainSelectSubscriptionPlan {
    public static void main(String[] args) {

        SubscriptionPLanDAO spDAO = new SubscriptionPLanDAO();
        List<SubscriptionPlan> subscriptionPlans = spDAO.list();

        for (SubscriptionPlan sp : subscriptionPlans){
            System.out.println(sp);
        }
    }
}
