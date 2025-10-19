package za.ac.cput.service.endusers;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.eventdomains.Catering;
import za.ac.cput.domain.eventdomains.CateringDTO;
import za.ac.cput.repository.eventrepositories.ICateringRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CateringService {

    private final ICateringRepository cateringRepository;

    public CateringService(ICateringRepository cateringRepository) {
        this.cateringRepository = cateringRepository;
    }

    // Convert entity to DTO
    private CateringDTO toDTO(Catering c) {
        return new CateringDTO(
                c.getCateringId(),
                c.getCateringName(),
                c.getCateringType(),
                c.getCateringDescription(),
                c.getCateringPrice(),
                c.getCateringContact(),
                c.getCateringImage()
        );
    }

    // Convert DTO to entity (for create)
    private Catering toEntity(CateringDTO dto) {
        return new Catering.Builder()
                .setCateringName(dto.getCateringName())
                .setCateringType(dto.getCateringType())
                .setCateringDescription(dto.getCateringDescription())
                .setCateringPrice(dto.getCateringPrice())
                .setCateringContact(dto.getCateringContact())
                .setCateringImage(dto.getCateringImage())
                .build();
    }

    // Create new catering
    public CateringDTO createCater(CateringDTO dto) {
        Catering c = toEntity(dto);
        c = cateringRepository.save(c);
        return toDTO(c);
    }

    // Read single catering
    public CateringDTO readCatering(long id) {
        Optional<Catering> optional = cateringRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    // Update all fields including image
    public CateringDTO updateCatering(long id, CateringDTO dto) {
        Optional<Catering> optional = cateringRepository.findById(id);
        if (optional.isPresent()) {
            Catering existing = optional.get();

            // Update all fields using builder
            Catering updated = new Catering.Builder()
                    .copy(existing)
                    .setCateringName(dto.getCateringName() != null ? dto.getCateringName() : existing.getCateringName())
                    .setCateringType(dto.getCateringType() != null ? dto.getCateringType() : existing.getCateringType())
                    .setCateringDescription(dto.getCateringDescription() != null ? dto.getCateringDescription() : existing.getCateringDescription())
                    .setCateringPrice(dto.getCateringPrice() != 0 ? dto.getCateringPrice() : existing.getCateringPrice())
                    .setCateringContact(dto.getCateringContact() != null ? dto.getCateringContact() : existing.getCateringContact())
                    .setCateringImage(dto.getCateringImage() != null ? dto.getCateringImage() : existing.getCateringImage())
                    .build();

            cateringRepository.save(updated);
            return toDTO(updated);
        }
        return null;
    }

    // Delete catering
    public boolean delete(long id) {
        if (cateringRepository.existsById(id)) {
            cateringRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Get all caterings
    public List<Catering> getAll() {
        return cateringRepository.findAll();
    }
}
