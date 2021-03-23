package models;

import commons.FileUtils;
import commons.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FileCabinet {
     public static Scanner scanner = new Scanner(System.in);
    private static final String EMPLOYEE = "employee";

    public static List<Employee> readAllCustomer(String fileName){
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesEmployee = FileUtils.readFile();
        List<Employee> listOfEmployee  = new ArrayList<>();
        String[] arrPropertyEmployee  ;
        Employee employee ;

        for (String properties : propertiesEmployee) {
            arrPropertyEmployee  = properties.split(StringUtils.COMMA);
            employee  = new Employee();
            employee.setEmployeeId(arrPropertyEmployee[0]);
            employee.setEmployeeName(arrPropertyEmployee[1]);
            employee.setEmployeeDateOfBirth(arrPropertyEmployee[2]);
            employee.setEmployeeAddress(arrPropertyEmployee[3]);
            listOfEmployee.add(employee);
        }
        return listOfEmployee;
    }

    public static void searchEmployee(String fileName){
        FileUtils.setFullPathFile(fileName);
        List<Employee> employeeList = readAllCustomer(EMPLOYEE);
        Stack<Employee> employeeStack =new Stack<>();
        for (Employee employee:employeeList) {
            employeeStack.push(employee);
        }

        System.out.println("Please input employee id: ");
        String employeeId = scanner.nextLine();
        while (!employeeStack.isEmpty()){
            Employee employeeTemp = employeeStack.pop();
            if (employeeTemp.getEmployeeId().equals(employeeId)){
                System.out.println(employeeTemp);
            }
        }
    }

    public static void main(String[] args) {
        FileCabinet.searchEmployee(EMPLOYEE);
    }
}
