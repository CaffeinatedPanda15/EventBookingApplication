//PHIHLELLO jUNAID MAROGA
//STUDENT :219354359
//Group ; kN13
package za.ac.cput.domain;

public class Customer {
    private String address;
    private int contactNumber;

    private Customer(){

    }
    public Customer(Builder builder){
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
    }
    public String getAddress(){
        return address;
    }
    public int getContactNumber (){
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
    public static class Builder {
        private String address;
        private int contactNumber;

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setContactNumber(int contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }
        public Builder copy(Customer customer){
            this.address= customer.address;
            this.contactNumber =customer.contactNumber;
            return this;
        }

        public Customer build (){
            return new Customer (this);
        }
    }
}
