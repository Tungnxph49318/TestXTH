package com.example.test.repository;

import com.example.test.entity.CoSo;
import com.example.test.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoSoRepository extends JpaRepository<CoSo, Long> {
}
