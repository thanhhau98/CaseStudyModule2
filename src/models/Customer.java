package models;

public class Customer {
    private String name;
    private String date;
    private String gender;
    private int passport;
    private int number;
    private String email;
    private String type;
    private String address;
    private Services services;

    public Customer(String name, String date, String gender, int passport, int number, String email, String type, String address, Services services) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.passport = passport;
        this.number = number;
        this.email = email;
        this.type = type;
        this.address = address;
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", passport=" + passport +
                ", number=" + number +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", services=" + services +
                '}';
    }
}
