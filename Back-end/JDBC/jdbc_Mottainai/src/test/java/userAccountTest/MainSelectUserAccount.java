package userAccountTest;

import org.mot.jdbc_Mottainai.dao.UserAccountDAO;
import org.mot.jdbc_Mottainai.model.UserAccount;

import java.util.List;

public class MainSelectUserAccount {
    public static void main(String[] args) {

        UserAccountDAO accountDAO = new UserAccountDAO();
        List<UserAccount> userAccounts = accountDAO.list();

        for (UserAccount ua: userAccounts){
            System.out.println(ua);
        }
    }
}
