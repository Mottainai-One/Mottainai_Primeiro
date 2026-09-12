package subscriptionPLanTest;

import org.mot.jdbc_Mottainai.dao.SubscriptionPLanDAO;
import org.mot.jdbc_Mottainai.model.Company;
import org.mot.jdbc_Mottainai.model.SubscriptionPlan;

import java.time.LocalDate;

public class MainUpdateSubscriptionPlan {
    public static void main(String[] args) {

        LocalDate data = LocalDate.parse("2026-02-02");
        Company company = new Company("12345678901234", "JBS Global", "prédio", "jbsGlobal@gmail.com", data, "SP","Irineu José Bordom", "São Paulo", "Vila Jaguaré", "97999999", "9999", "Empresa de Alimentos globais" );

        SubscriptionPLanDAO subscriptionPLanDAO = new SubscriptionPLanDAO();
        LocalDate data1 = LocalDate.parse("2020-02-01");
        SubscriptionPlan sp = new SubscriptionPlan(3, "Organizando", "Inativo",data1, 20000.99, 100,  company);

    }
}
