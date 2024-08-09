package za.ac.cput.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID d);
    List<T> getAll();
}
