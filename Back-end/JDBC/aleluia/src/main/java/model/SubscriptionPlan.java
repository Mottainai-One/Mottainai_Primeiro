package model;

public class SubscriptionPlan {
    //ATRIBUTOS
    private int id;
    private String description;
    private String status;
    private String registrationDate;
    private double price;
    private int storeLimit;
    private Company company;
    //CONSTRUTOR
    public SubscriptionPlan(String registrationDate, double price, int storeLimit, Company company) {
        this.registrationDate = registrationDate;
        this.price = price;
        this.storeLimit = storeLimit;
        this.company = company;
    }
    //SOBRECARGA
    public SubscriptionPlan(int id, String description, String status, String registrationDate, double price, int storeLimit, Company company) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.registrationDate = registrationDate;
        this.price = price;
        this.storeLimit = storeLimit;
        this.company = company;
    }
    //GETTERS
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public double getPrice() {
        return price;
    }

    public int getStoreLimit() {
        return storeLimit;
    }

    public Company getCompany() {
        return company;
    }
    //SETTERS
    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStoreLimit(int storeLimit) {
        this.storeLimit = storeLimit;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

