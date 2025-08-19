package za.ac.cput.domain;

public class Customer extends User {
    public static Object UserType;
    private String address;
    private String contactNumber;

    private Customer() {

    }

    public Customer(Builder build) {
        super.setUserName(build.userName);
        super.setFullname(build.fullname);
        super.setEmailAddress(build.emailAddress);
        super.setPassword(build.password);
        super.setUserType(build.userType);
        this.address = build.address;
        this.contactNumber = build.contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String userName;
        private String fullname;
        private String emailAddress;
        private String password;
        private UserType userType;
        private String address;
        private String contactNumber;

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

        public Builder copy(Customer admin) {
            this.userName = admin.getUserName();
            this.fullname = admin.getFullname();
            this.emailAddress = admin.getEmailAddress();
            this.password = admin.getPassword();
            this.userType = admin.getUserType();
            this.address = admin.getAddress();
            this.contactNumber = admin.getContactNumber();
            return this;
        }


    }//end of builder class
}//end of class
