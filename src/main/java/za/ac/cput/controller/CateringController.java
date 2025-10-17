package za.ac.cput.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.eventdomains.Catering;
import za.ac.cput.service.Iservice.ICateringService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/catering")
public class CateringController {

    private final ICateringService cateringService;

    public CateringController(ICateringService cateringService) {
        this.cateringService = cateringService;
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
