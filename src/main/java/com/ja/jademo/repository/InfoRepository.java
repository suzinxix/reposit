package com.ja.jademo.repository;

import com.ja.jademo.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info, Long> {
    List<Info> findByRegion(String region);
//
}

