package za.ac.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.eventdomains.CateringDTO;
import za.ac.cput.domain.eventdomains.Catering;
import za.ac.cput.service.endusers.CateringService;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/catering")
public class CateringController {

    private final CateringService cateringService;

    public CateringController(CateringService cateringService) {
        this.cateringService = cateringService;
    }

    @PostMapping
    public ResponseEntity<CateringDTO> createCaterer(@RequestBody CateringDTO dto) {
        CateringDTO created = cateringService.createCater(dto);
        if (created != null) {
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CateringDTO> getCatering(@PathVariable long id) {
        CateringDTO cater = cateringService.readCatering(id);
        if (cater != null) {
            return new ResponseEntity<>(cater, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CateringDTO> updateCatering(@PathVariable long id, @RequestBody CateringDTO dto) {
        // Decode image if present
        if (dto.getCateringImage() != null) {
            dto.setCateringImage(dto.getCateringImage()); // already a byte[] from GUI Base64 decode
        }

        CateringDTO updated = cateringService.updateCatering(id, dto);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatering(@PathVariable long id) {
        boolean deleted = cateringService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Catering>> getAll() {
        List<Catering> list = cateringService.getAll();
        if (list != null) return ResponseEntity.ok(list);
        return ResponseEntity.noContent().build();
    }
}
