package models;

public class House extends Services {
    private String standardRoom;
    private String convenient;
    private int numberFloor;

    public House(){

    }

    public House(String id, String nameService, double areaUsed, double rentCosts, int maxPeople, String rentalType, String standardRoom, String convenient, int numberFloor) {
        super(id, nameService, areaUsed, rentCosts, maxPeople, rentalType);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
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
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", convenient='" + convenient + '\'' +
                ", numberFloor=" + numberFloor +
                '}'+super.toString();
    }
}
