package za.ac.cput.service;

import za.ac.cput.domain.eventdomains.Catering;

import java.util.List;

public interface ICateringService {

    Catering create(Catering catering);

    Catering read(int cateringId);

    Catering update(Catering catering);

    boolean delete(int cateringId);

    List<Catering> getAll();

    Catering updateCateringImage(int cateringId, byte[] cateringImage);

}
