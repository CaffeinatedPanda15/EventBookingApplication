package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.UserType;

public class AdminFactory {
    public static Admin createAdmin(String userName, String fullname, String emailAddress, String password, UserType userType, String address, String contactNumber) {
        if (userName == null || fullname == null || emailAddress == null || password == null || address == null || contactNumber == null) {
            return null;
        }
        return new Admin.Builder()
                .setUserName(userName)
                .setFullname(fullname)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .setUserType(userType)
                .setAddress(address)
                .setContactNumber(contactNumber)
                .build();
    }
}//end of class
