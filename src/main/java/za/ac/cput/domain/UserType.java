package za.ac.cput.domain;

public enum UserType {
    ADMIN,
    CUSTOMER, userType;

    @Override
    public String toString() {
        return name();
    }
}
