package com.global.book.repository;

import com.global.book.Base.BaseRepository;
import com.global.book.entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutherRepo extends BaseRepository<Auther, Long> {

}
