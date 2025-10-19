package za.ac.cput.service.Iservice;

import java.util.List;

public interface iService<T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);

    List<T> getAll();
}