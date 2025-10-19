package za.ac.cput.domain.eventdomains;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "catering")
public class Catering implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catering_id", nullable = false, updatable = false)
    private Long cateringId;

    @Column(name = "catering_name", nullable = false)
    private String cateringName;

    @Column(name = "catering_type")
    private String cateringType;

    @Column(name = "catering_description", length = 1000)
    private String cateringDescription;

    @Column(name = "catering_price")
    private double cateringPrice;

    @Column(name = "catering_contact")
    private String cateringContact;

    @Column(name = "catering_image")
    private byte[] cateringImage;

    // 🔹 Default constructor required by JPA
    protected Catering() {}

    // 🔹 Private constructor for Builder
    private Catering(Builder builder) {
        this.cateringId = builder.cateringId;
        this.cateringName = builder.cateringName;
        this.cateringType = builder.cateringType;
        this.cateringDescription = builder.cateringDescription;
        this.cateringPrice = builder.cateringPrice;
        this.cateringContact = builder.cateringContact;
        this.cateringImage = builder.cateringImage;
    }


    public Long getCateringId() {
        return cateringId;
    }

    public String getCateringName() {
        return cateringName;
    }

    public String getCateringType() {
        return cateringType;
    }

    public String getCateringDescription() {
        return cateringDescription;
    }

    public double getCateringPrice() {
        return cateringPrice;
    }

    public String getCateringContact() {
        return cateringContact;
    }

    public byte[] getCateringImage() {
        return cateringImage;
    }

    // 🔹 Builder Pattern
    public static class Builder {
        private Long cateringId;
        private String cateringName;
        private String cateringType;
        private String cateringDescription;
        private double cateringPrice;
        private String cateringContact;
        private byte[] cateringImage;

        public Builder setCateringId(Long cateringId) {
            this.cateringId = cateringId;
            return this;
        }

        public Builder setCateringName(String cateringName) {
            this.cateringName = cateringName;
            return this;
        }

        public Builder setCateringType(String cateringType) {
            this.cateringType = cateringType;
            return this;
        }

        public Builder setCateringDescription(String cateringDescription) {
            this.cateringDescription = cateringDescription;
            return this;
        }

        public Builder setCateringPrice(double cateringPrice) {
            this.cateringPrice = cateringPrice;
            return this;
        }

        public Builder setCateringContact(String cateringContact) {
            this.cateringContact = cateringContact;
            return this;
        }

        public Builder setCateringImage(byte[] cateringImage) {
            this.cateringImage = cateringImage;
            return this;
        }

        public Builder copy(Catering catering) {
            this.cateringId = catering.cateringId;
            this.cateringName = catering.cateringName;
            this.cateringType = catering.cateringType;
            this.cateringDescription = catering.cateringDescription;
            this.cateringPrice = catering.cateringPrice;
            this.cateringContact = catering.cateringContact;
            this.cateringImage = catering.cateringImage;
            return this;
        }

        public Catering build() {
            return new Catering(this);
        }
    }


    @Override
    public String toString() {
        return "Catering{" +
                "cateringId=" + cateringId +
                ", cateringName='" + cateringName + '\'' +
                ", cateringType='" + cateringType + '\'' +
                ", cateringDescription='" + cateringDescription + '\'' +
                ", cateringPrice=" + cateringPrice +
                ", cateringContact='" + cateringContact + '\'' +
                ", cateringImage='" + cateringImage + '\'' +
                '}';
    }
}
