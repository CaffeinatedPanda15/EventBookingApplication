package za.ac.cput.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.eventdomains.Catering;
import za.ac.cput.domain.eventdomains.CateringDTO;
import za.ac.cput.domain.eventdomains.EventDTO;
import za.ac.cput.repository.eventrepositories.ICateringRepository;
import za.ac.cput.service.ICateringService;
import za.ac.cput.service.endusers.CateringService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/catering")
public class CateringController {

    private final CateringService cateringService;

    public CateringController(ICateringService cateringService) {
        this.cateringService = cateringService;
    }


    @PostMapping
    public ResponseEntity<CateringDTO> createEvent(@RequestBody CateringDTO dto) {
        CateringDTO created = cateringService.createCater(dto);
        if (created != null) {
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CateringDTO> getEvent(@PathVariable int id) {
        CateringDTO cater = cateringService.readCaters(id);
        if (cater != null) {
            return new ResponseEntity<>(cater, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CateringDTO> updateEvent(@PathVariable int id, @RequestBody CateringDTO dto) {
        CateringDTO updated = cateringService.updateCater(id, dto);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable int id) {
        boolean deleted = cateringService.deleteCater(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/create")
    public Catering create(@RequestBody Catering catering) {
        return cateringService.create(catering);
    }

    @GetMapping("/read/{id}")
    public Catering read(@PathVariable int id) {
        return cateringService.read(id);
    }

    @PutMapping("/update")
    public Catering update(@RequestBody Catering catering) {
        return cateringService.update(catering);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return cateringService.delete(id);
    }

    @GetMapping("/all")
    public List<Catering> getAll() {
        return cateringService.getAll();
    }

    @PostMapping(value = "/{id}/uploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Catering uploadImage(@PathVariable int id,
                                @RequestParam("image") MultipartFile image) throws IOException {
        return cateringService.updateCateringImage(id, image.getBytes());
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Catering catering = cateringService.read(id);
        if (catering == null || catering.getCateringImage() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg") // change to "image/png" if needed
                .body(catering.getCateringImage());
    }
}//end of class
