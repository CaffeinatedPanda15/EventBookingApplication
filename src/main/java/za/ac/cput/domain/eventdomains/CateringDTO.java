package za.ac.cput.domain.eventdomains;

import java.io.Serializable;
import java.util.Objects;

/**
 * CateringDTO
 * Data Transfer Object for Catering Entity
 * Used to safely transfer data between frontend (Swing/UI) and backend.
 *
 * @author
 * @since 2025
 */
public class CateringDTO implements Serializable {

    private Long cateringId;
    private String cateringName;
    private String cateringType;
    private String cateringDescription;
    private double cateringPrice;
    private String cateringContact;
    private byte[] cateringImage; // Stores the image bytes

    // --- Default Constructor ---
    public CateringDTO() {}

    // --- Full Constructor ---
    public CateringDTO(Long cateringId, String cateringName, String cateringType,
                       String cateringDescription, double cateringPrice,
                       String cateringContact, byte[] cateringImage) {
        this.cateringId = cateringId;
        this.cateringName = cateringName;
        this.cateringType = cateringType;
        this.cateringDescription = cateringDescription;
        this.cateringPrice = cateringPrice;
        this.cateringContact = cateringContact;
        this.cateringImage = cateringImage;
    }

    // --- Getters & Setters ---
    public Long getCateringId() {
        return cateringId;
    }

    public void setCateringId(Long cateringId) {
        this.cateringId = cateringId;
    }

    public String getCateringName() {
        return cateringName;
    }

    public void setCateringName(String cateringName) {
        this.cateringName = cateringName;
    }

    public String getCateringType() {
        return cateringType;
    }

    public void setCateringType(String cateringType) {
        this.cateringType = cateringType;
    }

    public String getCateringDescription() {
        return cateringDescription;
    }

    public void setCateringDescription(String cateringDescription) {
        this.cateringDescription = cateringDescription;
    }

    public double getCateringPrice() {
        return cateringPrice;
    }

    public void setCateringPrice(double cateringPrice) {
        this.cateringPrice = cateringPrice;
    }

    public String getCateringContact() {
        return cateringContact;
    }

    public void setCateringContact(String cateringContact) {
        this.cateringContact = cateringContact;
    }

    public byte[] getCateringImage() {
        return cateringImage;
    }

    public void setCateringImage(byte[] cateringImage) {
        this.cateringImage = cateringImage;
    }

    // --- toString() for debugging/logging ---
    @Override
    public String toString() {
        return "CateringDTO{" +
                "cateringId=" + cateringId +
                ", cateringName='" + cateringName + '\'' +
                ", cateringType='" + cateringType + '\'' +
                ", cateringDescription='" + cateringDescription + '\'' +
                ", cateringPrice=" + cateringPrice +
                ", cateringContact='" + cateringContact + '\'' +
                ", cateringImage=" + (cateringImage != null ? "[image bytes present]" : "null") +
                '}';
    }

    // --- Equals & HashCode (important for collections and testing) ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CateringDTO)) return false;
        CateringDTO that = (CateringDTO) o;
        return Double.compare(that.cateringPrice, cateringPrice) == 0 &&
                Objects.equals(cateringId, that.cateringId) &&
                Objects.equals(cateringName, that.cateringName) &&
                Objects.equals(cateringType, that.cateringType) &&
                Objects.equals(cateringDescription, that.cateringDescription) &&
                Objects.equals(cateringContact, that.cateringContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cateringId, cateringName, cateringType, cateringDescription, cateringPrice, cateringContact);
    }
}

