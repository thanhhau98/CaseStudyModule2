package models;

import commons.FileUtil;
import java.util.List;

public class CustomerManager {
    public static final String CUSTOMER_PATH = "D:\\CodeGym\\FuramaResort\\src\\data\\Customer.csv";
    private List<Customer>customerList;

    public CustomerManager(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addNewCustomer(Customer customer){
        FileUtil.writeCSV(CUSTOMER_PATH,customer,true);
    }

    public void showInformationCustomers(){

    }


    @Override
    public String toString() {
        return "CustomerManager{" +
                "customerList=" + customerList +
                '}';
    }
}
