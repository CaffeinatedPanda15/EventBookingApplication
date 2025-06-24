package za.ac.cput;

import za.ac.cput.domain.Customer;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer.Builder()
                .setAddress("maroga")
                .setContactNumber(2)
                        .build();



        System.out.println(c1.toString());
    }
}