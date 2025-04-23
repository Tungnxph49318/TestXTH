package com.example.test.repository;

import com.example.test.entity.KhoaCoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaCoSoRepository extends JpaRepository<KhoaCoSo, Long> {
}
