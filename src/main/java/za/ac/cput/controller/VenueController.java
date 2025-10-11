package za.ac.cput.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.eventdomains.Venue;
import za.ac.cput.service.IVenueService;

import java.io.IOException;
import java.util.List;

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
    public Venue update (@RequestBody Venue venue) {
        return venueService.update(venue);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable int id) {
        return venueService.delete(id);
    }

    @GetMapping("/all")
    public List<Venue> getAll() {
        return venueService.getAll();
    }

    @PostMapping(value = "/{id}/uploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Venue uploadImage(@PathVariable int id,
                             @RequestParam("image") MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        return venueService.updateVenueImage(id, imageBytes);
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
