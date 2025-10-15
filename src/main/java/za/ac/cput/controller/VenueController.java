package za.ac.cput.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.eventdomains.Venue;
import za.ac.cput.service.IVenueService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/venue")
public class VenueController {

    private final IVenueService venueService;

    public VenueController(IVenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping("/create")
    public Venue create (@RequestBody Venue venue) {
        return venueService.create(venue);
    }

    @GetMapping("/read/{id}")
    public Venue read (@PathVariable int id) {
        return venueService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Venue> update (@RequestBody Map<String, String> payload) {
        try {
            Venue venue;
            byte[] imageBytes = null;
            if (payload.containsKey("venueImage") && payload.get("venueImage") != null && !payload.get("venueImage").isEmpty()) {
                imageBytes = Base64.getDecoder().decode(payload.get("venueImage"));
            }

            if (payload.containsKey("venueId") && !payload.get("venueId").isEmpty()) {
                int venueId = Integer.parseInt(payload.get("venueId"));
                Venue existingVenue = venueService.read(venueId);
                if (existingVenue == null) return ResponseEntity.notFound().build();

                venue = new Venue.Builder()
                        .copy(existingVenue)
                        .setVenueName(payload.get("venueName"))
                        .setVenueDescription(payload.get("venueDescription"))
                        .setVenueAddress(payload.get("venueAddress"))
                        .setVenueCapacity(Integer.parseInt(payload.get("venueCapacity")))
                        .setVenuePrice(Double.parseDouble(payload.get("venuePrice")))
                        .setVenueImage(imageBytes != null ? imageBytes : existingVenue.getVenueImage())
                        .build();

                venue = venueService.update(venue);
            } else {

                venue = new Venue.Builder()
                        .setVenueName(payload.get("venueName"))
                        .setVenueDescription(payload.get("venueDescription"))
                        .setVenueAddress(payload.get("venueAddress"))
                        .setVenueCapacity(Integer.parseInt(payload.get("venueCapacity")))
                        .setVenuePrice(Double.parseDouble(payload.get("venuePrice")))
                        .setVenueImage(imageBytes)
                        .build();

                venue = venueService.create(venue);
            }

            return ResponseEntity.ok(venue);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable int id) {
        return venueService.delete(id);
    }

    @GetMapping("/all")
    public List<Venue> getAll() {
        return venueService.getAll();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Venue venue = venueService.read(id);
        if (venue == null || venue.getVenueImage() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg") // adjust if PNG
                .body(venue.getVenueImage());
    }
}//end of class
