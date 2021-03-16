package models;

public abstract class Services {
    private String id;
    private String nameService;
    private double areaUsed;
    private double rentCosts;
    private int maxPeople;
    private String rentalType;

    public Services(String id, String nameService, double areaUsed, double rentCosts, int maxPeople, String rentalType) {
        this.id = id;
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.rentCosts = rentCosts;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRentCosts() {
        return rentCosts;
    }

    public void setRentCosts(double rentCosts) {
        this.rentCosts = rentCosts;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return  id + "," +
                nameService + "," +
                areaUsed + ","+
                rentCosts + ","+
                maxPeople+ "," +
                rentalType;

    }
}
