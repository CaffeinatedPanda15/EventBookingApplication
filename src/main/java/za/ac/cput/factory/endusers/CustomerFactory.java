package za.ac.cput.factory.endusers;

import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.domain.endusers.UserType;

public class CustomerFactory {

    public static Customer createCustomer(String userName, String fullName, String email,
                                          String password, UserType userType,
                                          String address, String contactNumber) {
        return new Customer.Builder()
                .setUserName(userName)
                .setFullname(fullName)
                .setEmailAddress(email)
                .setPassword(password)
                .setUserType(userType)
                .setAddress(address)
                .setContactNumber(contactNumber)
                .build();
    }
}
