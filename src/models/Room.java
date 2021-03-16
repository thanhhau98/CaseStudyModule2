package models;

public class Room extends Services {
    private String freeService;

    public Room(String id, String nameService, double areaUsed, double rentCosts, int maxPeople, String rentalType, String freeService) {
        super(id, nameService, areaUsed, rentCosts, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return  super.getId() + "," +
                super.getNameService()+ "," +
                super.getAreaUsed()+ "," +
                super.getRentCosts() + ","+
                super.getMaxPeople() +","+
                super.getRentalType() + "," +
                freeService;
    }
}
