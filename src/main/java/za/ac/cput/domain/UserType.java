package za.ac.cput.domain;

public enum UserType {
    ADMIN,
    CUSTOMER;

    @Override
    public String toString() {
        return name();
    }
}
