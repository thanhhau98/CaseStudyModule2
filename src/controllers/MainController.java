package controllers;

import commons.FileUtil;
import commons.RegularExpression;
import models.House;
import models.Room;
import models.Services;
import models.Villa;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public final String VILLA_PATH = "D:\\CodeGym\\FuramaResort\\src\\data\\Villa.csv";
    public final String HOUSE_PATH = "D:\\CodeGym\\FuramaResort\\src\\data\\House.csv";
    public final String ROOM_PATH = "D:\\CodeGym\\FuramaResort\\src\\data\\Room.csv";
    private final String NAME_REGEX = "^[A-Z][a-z]*$";
    private final String VILLA_REGEX = "^SVVL-\\d{4}$";
    private final String HOUSE_REGEX = "^SVHO-\\d{4}$";
    private final String ROOM_REGEX = "^SVRO-\\d{4}$";
    private final String AREA_REGEX = "^[3-9]\\d+$";
    private final String RENT_REGEX = "^[1-9]\\d+$";
    private final String PEOPLE_REGEX = "^[0-1]\\d?$";
    private final String SERVICES_REGEX = "^massage|karaoke|food|drink|car$";
    private final String TYPE_REGEX = "^year|month|day|hour$";
    private final String STANDARD_REGEX = "^diamond|gold|silver|member$";

    Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("1.\tAdd New Services\n" +
                "2.\tShow Services\n" +
                "3.\tAdd New Customer\n" +
                "4.\tShow Information of Customer\n" +
                "5.\tAdd New Booking\n" +
                "6.\tShow Information of Employee\n" +
                "0.\tExit\n");
        System.out.println("Enter number:");
        int number;
        do {
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    addNewService();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    showInformationOfCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter number again :");
            }

        } while (true);
    }

    private void addNewService() {
        System.out.println("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        System.out.println("Enter number:");
        int number;
        do {
            number = scanner.nextInt();
            scanner.skip("\\R");
            switch (number) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter number again :");
            }
            addNewService();
        } while (true);
    }

    public void addNewVilla() {
        String id;
        String serviceName;
        double areaUsed;
        double rentCosts;
        int maxPeople;
        String rentalType;
        String standardRoom;
        String convenient;
        double areaPool;
        int numberFloor;
        String temp;
        do {
            System.out.println("Enter id");
            id = scanner.nextLine();
        } while (RegularExpression.validate(id, VILLA_REGEX));

        do {
            System.out.println("Enter service name");
            serviceName = scanner.nextLine();

        } while (RegularExpression.validate(serviceName, NAME_REGEX));

        do {
            System.out.println("Enter area used :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), AREA_REGEX));
        areaUsed = Double.parseDouble(temp);


        do {
            System.out.println("Enter rent costs :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), RENT_REGEX));
        rentCosts = Double.parseDouble(temp);


        do {
            System.out.println("Enter max people :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), PEOPLE_REGEX));
        maxPeople = Integer.parseInt(temp);

        do {
            System.out.println("Enter rental type :");
            rentalType = scanner.nextLine();
        } while (RegularExpression.validate(rentalType, TYPE_REGEX));
        do {
            System.out.println("Enter standard room :");
            standardRoom = scanner.nextLine();
        } while (RegularExpression.validate(standardRoom, STANDARD_REGEX));
        do {
            System.out.println("Enter convenient :");
            convenient = scanner.nextLine();
        } while (RegularExpression.validate(convenient, NAME_REGEX));

        do {
            System.out.println("Enter area pool :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), AREA_REGEX));
        areaPool = Double.parseDouble(temp);

        do {
            System.out.println("Enter number floor :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), RENT_REGEX));
        numberFloor = Integer.parseInt(temp);


        Services newVilla = new Villa(id, serviceName, areaUsed, rentCosts, maxPeople, rentalType, standardRoom, convenient, areaPool, numberFloor);
        FileUtil.writeCSV(VILLA_PATH, newVilla, true);

    }

    private void addNewHouse() {
        String id;
        String serviceName;
        double areaUsed;
        double rentCosts;
        int maxPeople;
        String rentalType;
        String standardRoom;
        String convenient;
        int numberFloor;
        String temp;
        do {
            System.out.println("Enter id");
            id = scanner.nextLine();
        } while (RegularExpression.validate(id, VILLA_REGEX));

        do {
            System.out.println("Enter service name");
            serviceName = scanner.nextLine();

        } while (RegularExpression.validate(serviceName, NAME_REGEX));

        do {
            System.out.println("Enter area used :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), AREA_REGEX));
        areaUsed = Double.parseDouble(temp);


        do {
            System.out.println("Enter rent costs :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), RENT_REGEX));
        rentCosts = Double.parseDouble(temp);


        do {
            System.out.println("Enter max people :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), PEOPLE_REGEX));
        maxPeople = Integer.parseInt(temp);

        do {
            System.out.println("Enter rental type :");
            rentalType = scanner.nextLine();
        } while (RegularExpression.validate(rentalType, TYPE_REGEX));
        do {
            System.out.println("Enter standard room :");
            standardRoom = scanner.nextLine();
        } while (RegularExpression.validate(standardRoom, STANDARD_REGEX));
        do {
            System.out.println("Enter convenient :");
            convenient = scanner.nextLine();
        } while (RegularExpression.validate(convenient, NAME_REGEX));

        do {
            System.out.println("Enter number floor :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), RENT_REGEX));
        numberFloor = Integer.parseInt(temp);

        Services newHouse = new House(id, serviceName, areaUsed, rentCosts, maxPeople, rentalType, standardRoom, convenient, numberFloor);
        FileUtil.writeCSV(HOUSE_PATH, newHouse, true);
    }

    private void addNewRoom() {
        String id;
        String serviceName;
        double areaUsed;
        double rentCosts;
        int maxPeople;
        String rentalType;
        String freeServices;
        String temp;
        do {
            System.out.println("Enter id");
            id = scanner.nextLine();
        } while (RegularExpression.validate(id, VILLA_REGEX));

        do {
            System.out.println("Enter service name");
            serviceName = scanner.nextLine();

        } while (RegularExpression.validate(serviceName, NAME_REGEX));

        do {
            System.out.println("Enter area used :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), AREA_REGEX));
        areaUsed = Double.parseDouble(temp);


        do {
            System.out.println("Enter rent costs :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), RENT_REGEX));
        rentCosts = Double.parseDouble(temp);


        do {
            System.out.println("Enter max people :");
            temp = scanner.nextLine();
        } while (RegularExpression.validate(String.valueOf(temp), PEOPLE_REGEX));
        maxPeople = Integer.parseInt(temp);

        do {
            System.out.println("Enter rental type :");
            rentalType = scanner.nextLine();
        } while (RegularExpression.validate(rentalType, TYPE_REGEX));

        do {
            System.out.println("Enter free service ");
            freeServices = scanner.nextLine();

        } while (RegularExpression.validate(freeServices, NAME_REGEX));


        Services newRoom = new Room(id, serviceName, areaUsed, rentCosts, maxPeople, rentalType, freeServices);
        FileUtil.writeCSV(ROOM_PATH, newRoom, true);
    }

    private void showServices() {
        System.out.println("1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Room Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "0.\tExit\n");
        System.out.println("Enter number:");
        int number;
        do {
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    showAllVilla();
                    break;
                case 2:
                    showAllHouse();
                    break;
                case 3:
                    showAllRoom();
                    break;
                case 4:
                    showAllNameVillaNotDuplicate();
                    break;
                case 5:
                    showAllNameHouseNotDuplicate();
                    break;
                case 6:
                    showAllNameRoomNotDuplicate();
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter number again :");
            }

        } while (true);
    }

    private void showAllVilla() {
        List<Services> villaList;
        villaList = FileUtil.readCSV(VILLA_PATH);
        for (Services services : villaList) {
            System.out.println(services.toString());
        }
    }

    private void showAllHouse() {
        List<Services> houseList;
        houseList = FileUtil.readCSV(HOUSE_PATH);
        for (Services services : houseList) {
            System.out.println(services.toString());
        }
    }

    private void showAllRoom() {
        List<Services> roomList;
        roomList = FileUtil.readCSV(ROOM_PATH);
        for (Services services : roomList) {
            System.out.println(services.toString());
        }


    }

    private void showAllNameVillaNotDuplicate() {
    }


    private void showAllNameHouseNotDuplicate() {
    }

    private void showAllNameRoomNotDuplicate() {
    }


    private void addNewCustomer() {

    }

    private void showInformationOfCustomer() {
    }

    private void addNewBooking() {
    }

    private void showInformationOfEmployee() {
    }
}
