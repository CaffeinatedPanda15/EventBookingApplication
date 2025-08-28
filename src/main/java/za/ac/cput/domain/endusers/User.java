package za.ac.cput.domain.endusers;

public abstract class User {

    private String userName;
    private String fullname;
    private String emailAddress;
    private String password;
    private UserType userType;
    private String address;
    private String contactNumber;

    // Constructor receives Builder
    protected User(Builder builder) {
        this.userName = builder.userName;
        this.fullname = builder.fullname;
        this.emailAddress = builder.emailAddress;
        this.password = builder.password;
        this.userType = builder.userType;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
    }

    // ------------------- Getters -------------------
    public String getUserName() { return userName; }
    public String getFullname() { return fullname; }
    public String getEmailAddress() { return emailAddress; }
    public String getPassword() { return password; }
    public UserType getUserType() { return userType; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", fullname='" + fullname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", userType=" + userType +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    // ------------------- Builder -------------------
    public abstract static class Builder {
        private String userName;
        private String fullname;
        private String emailAddress;
        private String password;
        private UserType userType;
        private String address;
        private String contactNumber;

        // Setters return Builder for chaining
        public Builder setUserName(String userName) { this.userName = userName; return this; }
        public Builder setFullname(String fullname) { this.fullname = fullname; return this; }
        public Builder setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; return this; }
        public Builder setPassword(String password) { this.password = password; return this; }
        public Builder setUserType(UserType userType) { this.userType = userType; return this; }
        public Builder setAddress(String address) { this.address = address; return this; }
        public Builder setContactNumber(String contactNumber) { this.contactNumber = contactNumber; return this; }

        // Must be implemented by subclasses to create the actual object
        public abstract User build();
    }
}


