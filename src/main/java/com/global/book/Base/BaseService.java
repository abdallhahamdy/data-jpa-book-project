package com.global.book.Base;

import com.global.book.error.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService <T extends BaseEntity<ID>, ID extends Number> {

    @Autowired
    private BaseRepository<T, ID> baseRepository;

    public T findById(ID id) {

        Optional<T> entity = baseRepository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RecordNotFoundException("This Record with id:- " + id + " not found");
        }
    }

    public T getById(ID id) {
        return baseRepository.getById(id);
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public T insert(T entity) {
//        if (entity.getId() != null) {
//            throw new RuntimeException();
//        }
        return baseRepository.save(entity);
    }

    public List<T> insertAll(List<T> entities) {
        return baseRepository.saveAll(entities);
    }

    public T update(T entity) {
        return baseRepository.save(entity);
    }

    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }
}
