package za.ac.cput.domain.endusers;

public class Customer extends User {

    private Customer(Builder builder) {
        super(builder);
    }

    public static class Builder extends User.Builder {
        @Override
        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userName='" + getUserName() + '\'' +
                ", fullname='" + getFullname() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", userType=" + getUserType() +
                ", address='" + getAddress() + '\'' +
                ", contactNumber='" + getContactNumber() + '\'' +
                '}';
    }
}

