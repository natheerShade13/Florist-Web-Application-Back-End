package za.ac.cput.service;

import org.springframework.stereotype.Service;

public interface IService <T, ID>{
    T create (T t);
    T read (ID id);
    T update (T t);
    void delete(ID id);
}