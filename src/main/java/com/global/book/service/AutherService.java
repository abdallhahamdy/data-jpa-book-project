package com.global.book.service;

import com.global.book.Base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.error.DuplicateRecordException;
import com.global.book.repository.AutherRepo;
import com.global.book.repository.AutherSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutherService extends BaseService<Auther, Long> {

    @Autowired
    private AutherRepo autherRepo;

    @Override
    public Auther insert(Auther entity) {

        if (!entity.getEmail().isEmpty() && entity.getEmail() != null) {
            Optional<Auther> auther = findByEmail(entity.getEmail());

            if (auther.isPresent()) {
                throw new DuplicateRecordException("This email already found with another auther ");
            }
        }

        return super.insert(entity);
    }
    @Override
    public Auther update(Auther entity) {

        Auther auther = findById(entity.getId());

        auther.setName(entity.getName());

        return super.update(entity);
    }

    public List<Auther> findByAutherSpec(AutherSearch search) {

        AutherSpec spec = new AutherSpec(search);

        return autherRepo.findAll(spec);

    }

    public Optional<Auther> findByEmail(String email) {

        return autherRepo.findByEmail(email);
    }


}
