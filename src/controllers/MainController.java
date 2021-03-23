package controllers;

import commons.*;
import exceptions.*;
import models.*;
import java.util.*;

public class MainController {

    private final String EMPLOYEE ="employee" ;
    private final String BOOKING = "booking" ;
    private final Scanner scanner = new Scanner(System.in);
    private final String VILLA = "villa";
    private final String HOUSE = "house";
    private final String ROOM = "room";
    private final String CUSTOMER = "customer";
    private boolean isExit;
    private boolean isBackToMenu;

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }

    public void displayMainMenu() {
        int choose;
        do {
            System.out.println("1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tShow queue of customer\n" +
                    "0.\tExit\n");
            System.out.println("Enter number (1-6):");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(CUSTOMER);
                    break;
                case 4:
                    showInformationOfCustomer(CUSTOMER);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 0:
                    isExit = true;
                    break;
                case 7:
                    showQueueOfCustomer();
                    break;
                default:
                    displayMainMenu();

            }

            if (isExit) {
                break;
            }

        } while (choose >= 0 && choose <= 6);
    }

    private void showQueueOfCustomer() {
        Queue<Customer> queueCustomer = new LinkedList<>();
        List<Customer> customerList =readAllCustomer(CUSTOMER);

        showInformationOfCustomer(CUSTOMER);

        queueCustomer.add(customerList.get(1));
        queueCustomer.add(customerList.get(2));
        queueCustomer.add(customerList.get(3));

        Customer customer ;

        System.out.println("--------------------------------");
        System.out.println("List customner buy ticket: ");
        while (!queueCustomer.isEmpty()){
            customer =queueCustomer.poll();
            customer.showInfor();
        }
    }

    private Map<String,Employee> readAllEmployee(String fileName){
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesEmployee = FileUtils.readFile();
        Map<String,Employee> mapOfEmployee = new HashMap<>();
        String[] arrayPropertiesEmployee ;
        Employee employee ;

        for (String properties : propertiesEmployee){
            arrayPropertiesEmployee = properties.split(StringUtils.COMMA);
            employee= new Employee();
            employee.setEmployeeId(arrayPropertiesEmployee[0]);
            employee.setEmployeeName(arrayPropertiesEmployee[1]);
            employee.setEmployeeDateOfBirth(arrayPropertiesEmployee[2]);
            employee.setEmployeeAddress(arrayPropertiesEmployee[3]);

            mapOfEmployee.put(employee.getEmployeeId(),employee);
        }
        return mapOfEmployee;
    }
    private void showInformationOfEmployee() {
        Map<String,Employee> mapOfEmployee = readAllEmployee(EMPLOYEE);

        System.out.println("--------------------------------");
        System.out.println("List Employee: ");

        for (Map.Entry<String,Employee> employeeEntry :mapOfEmployee.entrySet()){
            System.out.println(employeeEntry.getKey()+" "+ employeeEntry.getValue().toString());
        }
    }

    private void addNewBooking() {
        List<Customer> customerList = readAllCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Please choose customer to booking: ");
        int iCustomer = scanner.nextInt();

        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");

        System.out.println("Please choose type of service: ");
        int iTypeOfService = scanner.nextInt();

        List<Services> ListOfService = null;

        switch (iTypeOfService){
            case 1:
                ListOfService = readAllService(VILLA);
                showAllService(VILLA);
                break;
            case 2:
                ListOfService = readAllService(HOUSE);
                showAllService(HOUSE);

                break;
            case 3:
                ListOfService = readAllService(ROOM);
                showAllService(ROOM);

                break;
        }

        System.out.println("Please choose service to booking: ");
        int iService = scanner.nextInt();

        Customer customer = customerList.get(iCustomer-1);
        customer.setServices(ListOfService.get(iService-1));

        FileUtils.setFullPathFile(BOOKING);
        FileUtils.writeFile(new String[]{customer.toString()});

        System.out.println("Booking is done!");
    }

    private void showInformationOfCustomer(String fileName) {

        System.out.println("--------------------------- ");
        System.out.println("List customer ");
         List<Customer> customerList=readAllCustomer(fileName);

         Customer customer ;
        for (int i=0;i < customerList.size(); i++) {
            customer =customerList.get(i);
            System.out.println((i+1)+". ");
            customer.showInfor();
        }

    }

    private List<Customer> readAllCustomer(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesCustomer = FileUtils.readFile();
        List<Customer> listOfCustomer = new ArrayList<>();
        String[] arrPropertyCustomer ;
        Customer customer ;

        for (String properties : propertiesCustomer) {
            arrPropertyCustomer = properties.split(StringUtils.COMMA);
            customer = new Customer();
            customer.setFullName(arrPropertyCustomer[0]);
            customer.setDateOfBirth(arrPropertyCustomer[1]);
            customer.setGender(arrPropertyCustomer[2]);
            customer.setIdCard(arrPropertyCustomer[3]);
            customer.setPhoneNumber(arrPropertyCustomer[4]);
            customer.setEmail(arrPropertyCustomer[5]);
            customer.setTypeOfCustomer(arrPropertyCustomer[6]);
            customer.setAddress(arrPropertyCustomer[7]);
            listOfCustomer.add(customer);
        }
        Collections.sort(listOfCustomer);
        return listOfCustomer;
    }

    private void addNewCustomer(String filename) {
        scanner.nextLine();

        boolean flag;
        String fullName;
        do {
            flag = true;
            System.out.println(" Please input full name :");
            fullName = scanner.nextLine();

            try {
                Validators.isValidFullName(fullName);
            } catch (NameException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        String dateOfBirth;
        do {
            flag = true;
            System.out.println(" Please input date of birth :");
            dateOfBirth = scanner.nextLine();
            try {
                Validators.isValidBirthDay(dateOfBirth);
            } catch (BirthDayException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        while (!flag);

        String gender;
        do {
            flag = true;
            System.out.println(" Please input gender :");
            gender = scanner.nextLine();
            try {
                Validators.isValidGender(gender);
            } catch (GenderException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        while (!flag);
        gender = ConvertUtils.normalizeStr(gender);

        String idCard;
        do {
            flag = true;
            System.out.println(" Please input idCard :");
            idCard = scanner.nextLine();
            try {
                Validators.isValidIdCard(String.valueOf(idCard));
            } catch (IdCardException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        while (!flag);

        System.out.println(" Please input phoneNumber :");
        String phoneNumber = scanner.nextLine();

        String email;
        do {
            flag = true;
            System.out.println(" Please input email :");
            email = scanner.nextLine();
            try {
                Validators.isValidEmail(email);
            } catch (EmailException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        while (!flag);

        scanner.nextLine();
        System.out.println(" Please input type of customer :");
        String typeOfCustomer = scanner.nextLine();

        System.out.println(" Please input address :");
        String address = scanner.nextLine();

        FileUtils.setFullPathFile(filename);
        FileUtils.writeFile(new String[]{fullName, dateOfBirth, gender, String.valueOf(idCard), String.valueOf(phoneNumber), email, typeOfCustomer, address});
    }

    private void addNewServices() {
        int choose;

        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "0.\tExit\n");
            System.out.println("Please choose service to add :");

            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addNewService(VILLA);
                    isBackToMenu = false;
                    break;
                case 2:
                    addNewService(HOUSE);
                    isBackToMenu = false;

                    break;
                case 3:
                    addNewService(ROOM);
                    isBackToMenu = false;
                    break;
                case 4:
                    isBackToMenu = true;
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    addNewServices();
            }

            if (isExit || isBackToMenu) {
                return;
            }

        } while (choose >= 0 && choose <= 4);
    }

    private void addNewService(String fileName) {

        scanner.nextLine();
        String id;
        do {
            System.out.println("Please input services id:");
            id = scanner.nextLine();

        } while (!Validators.isValidRegex(id, Validators.SERVICE_ID_REGEX));

        String nameService;
        do {
            System.out.println("Please input services name:");
            nameService = scanner.nextLine();
        } while (!Validators.isValidRegex(nameService, Validators.SERVICE_NAME_REGEX));

        double areaUsed;
        do {
            System.out.println("Please input area used:");
            areaUsed = scanner.nextDouble();
        } while (!Validators.isMoreThan(areaUsed, 30));

        double rentCost;
        do {
            System.out.println("Please input rent cost:");
            rentCost = scanner.nextDouble();
        } while (!Validators.isMoreThan(rentCost, 0));

        int maxPeople;
        do {
            System.out.println("Please input max people:");
            maxPeople = scanner.nextInt();
        } while (!Validators.isMoreThan(maxPeople, 0, 20));

        scanner.nextLine();


        System.out.println("Please input rental type:");
        String rentalType = scanner.nextLine();

        FileUtils.setFullPathFile(fileName);

        switch (fileName) {
            case VILLA: {

                String standardRoom;
                do {
                    System.out.println("Please input standard room:");
                    standardRoom = scanner.nextLine();
                } while (!Validators.isValidRegex(standardRoom, Validators.SERVICE_NAME_REGEX));

                String convenient;
                do {
                    System.out.println("Please input convinient:");
                    convenient = scanner.nextLine();
                } while (!Validators.isValidRegex(convenient, Validators.SERVICE_NAME_REGEX));

                double areaPool;
                do {
                    System.out.println("Please input area pool:");
                    areaPool = scanner.nextDouble();
                } while (!Validators.isMoreThan(areaPool, 30));

                double numberFloor;
                do {
                    System.out.println("Please input number floor:");
                    numberFloor = scanner.nextInt();
                } while (!Validators.isMoreThan(numberFloor, 0));

                FileUtils.writeFile(new String[]{id, nameService, String.valueOf(areaUsed), String.valueOf(rentCost), String.valueOf(maxPeople), rentalType,
                        standardRoom, convenient, String.valueOf(areaPool), String.valueOf(numberFloor)});

                break;
            }
            case HOUSE: {

                String standardRoom;
                do {
                    System.out.println("Please input standar room:");
                    standardRoom = scanner.nextLine();
                } while (!Validators.isValidRegex(standardRoom, Validators.SERVICE_NAME_REGEX));

                String convenient;
                do {
                    System.out.println("Please input convinient:");
                    convenient = scanner.nextLine();
                } while (!Validators.isValidRegex(convenient, Validators.SERVICE_NAME_REGEX));

                double numberFloor;
                do {
                    System.out.println("Please input number floor:");
                    numberFloor = scanner.nextInt();
                } while (!Validators.isMoreThan(numberFloor, 0));

                FileUtils.writeFile(new String[]{id, nameService, String.valueOf(areaUsed), String.valueOf(rentCost), String.valueOf(maxPeople), rentalType,
                        standardRoom, convenient, String.valueOf(numberFloor)});
                break;
            }
            case ROOM:
                String extraServiceName;
                do {
                    System.out.println("Please input extra service name:");
                    extraServiceName = scanner.nextLine();
                } while (!Validators.isValidExtraServiceName(extraServiceName));

                System.out.println("Please input unit:");
                String unit = scanner.nextLine();

                System.out.println("Please input money:");
                double money = scanner.nextDouble();

                FileUtils.writeFile(new String[]{id, nameService, String.valueOf(areaUsed), String.valueOf(rentCost), String.valueOf(maxPeople), rentalType,
                        extraServiceName, unit, String.valueOf(money)});

                break;
        }
    }


    private void showServices() {
        int choose;

        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Room Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "0.\tExit\n");
            System.out.println("Please choose service to show :");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    showAllService(VILLA);
                    isBackToMenu = false;

                    break;
                case 2:
                    showAllService(HOUSE);
                    isBackToMenu = false;

                    break;
                case 3:
                    showAllService(ROOM);
                    isBackToMenu = false;

                    break;
                case 4:
                    showAllNameServiceNotDuplicate(VILLA);
                    isBackToMenu = true;

                    break;
                case 5:
                    showAllNameServiceNotDuplicate(HOUSE);
                    isBackToMenu = true;

                    break;
                case 6:
                    showAllNameServiceNotDuplicate(ROOM);
                    isBackToMenu = true;

                    break;
                case 7:
                    isBackToMenu = true;
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    showServices();
            }

            if (isBackToMenu || isExit) {
                return;
            }

        } while (choose >= 0 && choose <= 7);
    }

    private void showAllNameServiceNotDuplicate(String fileName) {
        Set<String> setOfService = new TreeSet<>();
        System.out.println("--------------------------------------");
        System.out.println("List services not duplicate name :");
        for (Services services : readAllService(fileName)) {
            setOfService.add(services.getNameService());
        }
    }

    private void showAllService(String fileName) {
        System.out.println("--------------------------------------");
        System.out.println("List services:");
         List<Services> servicesList =readAllService(fileName);
         Services services ;
        for (int i=0;i< servicesList.size();i++ ) {
            services = servicesList.get(i);
            System.out.println((i+1)+". ");
            services.showInfor();
        }
    }


    public List<Services> readAllService(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesService = FileUtils.readFile();
        List<Services> listOfService = new ArrayList<>();
        Services services = null;
        ExtraService extraService;
        String[] propertiesElement;

        for (String properties : propertiesService) {
            propertiesElement = properties.split(StringUtils.COMMA);
            switch (fileName) {
                case VILLA:
                    services = new Villa();

                    ((Villa) services).setStandardRoom(propertiesElement[6]);
                    ((Villa) services).setConvenient(propertiesElement[7]);
                    ((Villa) services).setAreaPool(Double.parseDouble(propertiesElement[8]));
                    ((Villa) services).setNumberFloor(Integer.parseInt(propertiesElement[9]));

                    break;
                case HOUSE:
                    services = new House();

                    ((House) services).setStandardRoom(propertiesElement[6]);
                    ((House) services).setConvenient(propertiesElement[7]);
                    ((House) services).setNumberFloor(Integer.parseInt(propertiesElement[8]));
                    break;
                case ROOM:
                    extraService = new ExtraService(propertiesElement[6], propertiesElement[7], Double.parseDouble(propertiesElement[8]));
                    services = new Room();

                    ((Room) services).setExtraService(extraService);
                    break;
            }

            services.setId(propertiesElement[0]);
            services.setNameService(propertiesElement[1]);
            services.setAreaUsed(Double.parseDouble(propertiesElement[2]));
            services.setRentCosts(Double.parseDouble(propertiesElement[3]));
            services.setMaxPeople(Integer.parseInt(propertiesElement[4]));
            services.setRentalType(propertiesElement[5]);

            listOfService.add(services);
        }
        return listOfService;
    }
}
