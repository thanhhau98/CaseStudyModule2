package models;

public class Room extends Services {
    private ExtraService extraService;

    public Room(){}

    public Room(String id, String nameService, double areaUsed, double rentCosts, int maxPeople, String rentalType, ExtraService extraService) {
        super(id, nameService, areaUsed, rentCosts, maxPeople, rentalType);
        this.extraService = extraService;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Room{" +
                "extraService=" + extraService +
                '}'+super.toString();
    }
}
