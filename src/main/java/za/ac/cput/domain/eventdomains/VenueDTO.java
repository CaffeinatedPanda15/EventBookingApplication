package za.ac.cput.domain.eventdomains;

import jakarta.persistence.Lob;

public class VenueDTO {
    private int venueId;
    private String venueName;
    private String venueDescription;
    private String venueAddress;
    private int venueCapacity;
    private double venuePrice;
    @Lob
    private byte[] venueImage;

    public VenueDTO() {}

    public VenueDTO(int venueId, String venueName, String venueAddress, String venueDescription,
                    int venueCapacity,double venuePrice, byte[] venueImage) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueDescription = venueDescription;
        this.venueCapacity = venueCapacity;
        this.venuePrice = venuePrice;
        this.venueImage = venueImage;
        this.venueAddress = venueName;
    }


    // Getters and Setters
    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueDescription() {
        return venueDescription;
    }

    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    public double getVenuePrice() {
        return venuePrice;
    }

    public void setVenuePrice(double venuePrice) {
        this.venuePrice = venuePrice;
    }


    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public byte[] getVenueImage() {
        return venueImage;
    }

    public void setVenueImage(byte[] venueImage) {
        this.venueImage = venueImage;
    }



}
