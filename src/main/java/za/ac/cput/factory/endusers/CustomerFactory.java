package za.ac.cput.factory.endusers;

import za.ac.cput.domain.endusers.Customer;
import za.ac.cput.domain.endusers.UserType;

public class CustomerFactory {

    public static Customer createCustomer(
            String userName,
            String fullname,
            String emailAddress,
            String password,
            UserType userType,
            String address,
            String contactNumber
    ) {
        // Validate required fields
        if (userName == null || fullname == null || emailAddress == null || password == null || address == null || contactNumber == null) {
            return null;
        }

        // Build the Customer using the Builder
        return (Customer) new Customer.Builder()
                .setUserName(userName)
                .setFullname(fullname)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .setUserType(userType)  // use the method argument
                .setAddress(address)
                .setContactNumber(contactNumber)
                .build();
    }
}


