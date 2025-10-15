package za.ac.cput.service.endusers;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.eventdomains.Catering;
import za.ac.cput.domain.eventdomains.CateringDTO;
import za.ac.cput.domain.eventdomains.Event;
import za.ac.cput.domain.eventdomains.EventDTO;
import za.ac.cput.repository.eventrepositories.ICateringRepository;
import za.ac.cput.service.ICateringService;

import java.util.List;
import java.util.Optional;

@Service
public class CateringService{

    private final ICateringRepository CateringRepo;

    public CateringService(ICateringRepository CateringRepo) {
        this.CateringRepo = CateringRepo;
    }

    private CateringDTO toDTO(Catering catering) {
        return new CateringDTO(
                catering.getCateringId(),
                catering.getCateringName(),
                catering.getCateringType(),
                catering.getCateringDescription(),
                catering.getCateringPrice(),
                catering.getCateringContact(),
                catering.getCateringImage()
        );
    }

    // Convert DTO → Entity
    private Catering toEntity(CateringDTO dto) {
        Catering.Builder builder = new Catering.Builder();

        if (dto.getCateringId() != 0) {
            builder.setCateringId(dto.getCateringId());
        }

        builder.setCateringName(dto.getCateringName())
                .setCateringType(dto.getCateringType())
                .setCateringDescription(dto.getCateringDescription())
                .setCateringPrice(dto.getCateringPrice())
                .setCateringContact(dto.getCateringContact())
                .setCateringImage(dto.getCateringImage());

        return builder.build();
    }

    public CateringDTO createEvent(CateringDTO dto) {
        Catering catering = toEntity(dto);
        catering = CateringRepo.save(catering);
        return toDTO(catering);
    }

    public CateringDTO readEvent(int id) {
        Optional<Catering> optionalCatering = CateringRepo.findById(id);
        if (optionalCatering.isPresent()) {
            return toDTO(optionalCatering.get());
        }
        return null;
    }

    public CateringDTO updateCatering(int id, CateringDTO dto) {
        Optional<Catering> optionalCatering = CateringRepo.findById(id);
        if (optionalCatering.isPresent()) {
            Catering existing = optionalCatering.get();

            // Update only provided fields
            if (dto.getCateringName() != null)
                existing = new Catering.Builder().copy(existing)
                        .setCateringName(dto.getCateringName()).build();
            if (dto.getCateringType() != null)
                existing = new Catering.Builder().copy(existing).setCateringType
                        (dto.getCateringType()).build();
            if (dto.getCateringDescription() != null)
                existing = new Catering.Builder().copy(existing)
                        .setCateringDescription(dto.getCateringDescription()).build();
            if (dto.getCateringPrice() != 0)
                existing = new Catering.Builder().copy(existing)
                        .setCateringPrice(dto.getCateringPrice()).build();
            if (dto.getCateringContact() != null)
                existing = new Catering.Builder().copy(existing).
                        setCateringContact(dto.getCateringContact()).build();
            if (dto.getCateringImage() != null)
                existing = new Catering.Builder().copy(existing)
                        .setCateringImage(dto.getCateringImage()).build();


            Catering updated = CateringRepo.save(existing);
            return toDTO(updated);
        }
        return null;
    }


    //    @Override
//    public Catering create(Catering catering) {
//        return cateringRepository.save(catering);
//    }
//
//    @Override
//    public Catering read(int cateringId) {
//        Optional<Catering> catering = cateringRepository.findById(cateringId);
//        return catering.orElse(null);
//    }
//
//    @Override
//    public Catering update(Catering catering) {
//        if (cateringRepository.existsById(catering.getCateringId())) {
//            return cateringRepository.save(catering);
//        }
//        return null;
//    }
//
//    @Override
    public boolean delete(int cateringId) {
        if (CateringRepo.existsById(cateringId)) {
            CateringRepo.deleteById(cateringId);
            return true;
        }
        return false;
    }

//    @Override
    public List<Catering> getAll() {
        return CateringRepo.findAll();
    }

//    @Override
    public Catering updateCateringImage(int cateringId, byte[] cateringImage) {
        Optional<Catering> cateringOptional = CateringRepo.findById(cateringId);
        if (cateringOptional.isPresent()) {
            Catering updated = new Catering.Builder()
                    .copy(cateringOptional.get())
                    .setCateringImage(cateringImage)
                    .build();
            return CateringRepo.save(updated);
        }
        return null;
    }
}//end of class
