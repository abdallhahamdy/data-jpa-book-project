package com.global.book.service;

import com.global.book.Base.BaseService;
import com.global.book.entity.Auther;
import org.springframework.stereotype.Service;

@Service
public class AutherService extends BaseService<Auther, Long> {

    @Override
    public Auther update(Auther entity) {

        Auther auther = findById(entity.getId());

        auther.setName(entity.getName());

        return super.update(entity);
    }
}
