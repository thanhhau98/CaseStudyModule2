package models;

public class Villa extends Services {
    private String standardRoom;
    private String convenient;
    private double areaPool ;
    private int numberFloor;

    public Villa (){

    }

    public Villa(String id, String nameService, double areaUsed, double rentCosts, int maxPeople, String rentalType, String standardRoom, String convenient, double areaPool, int numberFloor) {
        super(id, nameService, areaUsed, rentCosts, maxPeople, rentalType);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.areaPool = areaPool;
        this.numberFloor = numberFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", convenient='" + convenient + '\'' +
                ", areaPool=" + areaPool +
                ", numberFloor=" + numberFloor +
                '}'+super.toString();
    }
}
