package za.ac.cput.service.endusers;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.eventdomains.Catering;
import za.ac.cput.repository.eventrepositories.ICateringRepository;
import za.ac.cput.service.ICateringService;

import java.util.List;
import java.util.Optional;

@Service
public class CateringService implements ICateringService {

    private final ICateringRepository cateringRepository;

    public CateringService(ICateringRepository cateringRepository) {
        this.cateringRepository = cateringRepository;
    }

    @Override
    public Catering create(Catering catering) {
        return cateringRepository.save(catering);
    }

    @Override
    public Catering read(int cateringId) {
        Optional<Catering> catering = cateringRepository.findById(cateringId);
        return catering.orElse(null);
    }

    @Override
    public Catering update(Catering catering) {
        if (cateringRepository.existsById(catering.getCateringId())) {
            return cateringRepository.save(catering);
        }
        return null;
    }

    @Override
    public boolean delete(int cateringId) {
        if (cateringRepository.existsById(cateringId)) {
            cateringRepository.deleteById(cateringId);
            return true;
        }
        return false;
    }

    @Override
    public List<Catering> getAll() {
        return cateringRepository.findAll();
    }

    @Override
    public Catering updateCateringImage(int cateringId, byte[] cateringImage) {
        Optional<Catering> cateringOptional = cateringRepository.findById(cateringId);
        if (cateringOptional.isPresent()) {
            Catering updated = new Catering.Builder()
                    .copy(cateringOptional.get())
                    .setCateringImage(cateringImage)
                    .build();
            return cateringRepository.save(updated);
        }
        return null;
    }
}//end of class
