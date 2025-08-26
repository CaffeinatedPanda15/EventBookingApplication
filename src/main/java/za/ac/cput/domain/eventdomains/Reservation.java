package za.ac.cput.domain.eventdomains;

import za.ac.cput.domain.endusers.Customer;

import java.time.LocalDateTime;

public class Reservation extends Customer {
    private String reservationId;
    private int customerID;
    private int ticketID;
    private LocalDateTime reservationDate;
    private String status;

    private Reservation(Customer.Builder builder) {
        super(builder);
    }

    public Reservation(Builder builder) {
        super(builder);
        this.reservationId = builder.reservationId;
        this.customerID = builder.customerID;
        this.ticketID = builder.ticketID;
        this.reservationDate = builder.reservationDate;
        this.status = builder.status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void confirmReservation() {
        this.status = "Confirmed";
    }

    public void cancelReservation() {
        this.status = "Canceled";
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", customerID=" + customerID +
                ", ticketID=" + ticketID +
                ", reservationDate=" + reservationDate +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder extends Customer.Builder {
        private String reservationId;
        private int customerID;
        private int ticketID;
        private LocalDateTime reservationDate;
        private String status;

        public Builder(String reservationId, int customerID, int ticketID, LocalDateTime reservationDate, String status) {
            this.reservationId = reservationId;
            this.customerID = customerID;
            this.ticketID = ticketID;
            this.reservationDate = reservationDate;
            this.status = status;
        }

        public Builder() {}

        public Builder setReservationId(String reservationId) {
            this.reservationId = reservationId;
            return this;
        }

        public Builder setCustomerID(int customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setTicketID(int ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setReservationDate(LocalDateTime reservationDate) {
            this.reservationDate = reservationDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Reservation reservation) {
            this.reservationId = reservation.reservationId;
            this.customerID = reservation.customerID;
            this.ticketID = reservation.ticketID;
            this.reservationDate = reservation.reservationDate;
            this.status = reservation.status;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }
}

