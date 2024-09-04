package za.ac.cput.service;

import java.util.List;

/**
 * IService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

public interface IService<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    List<T> findAll();
}
