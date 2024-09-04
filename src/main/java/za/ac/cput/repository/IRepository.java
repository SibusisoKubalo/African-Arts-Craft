package za.ac.cput.repository;

/**
 * IRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

public interface IRepository<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);
}
