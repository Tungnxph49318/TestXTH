package com.example.test.service;

import com.example.test.dto.NhanVienDto;
import com.example.test.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {
    List<NhanVienDto> getAllNhanVien();

    NhanVienDto getOne(Long id);

    NhanVienDto createNhanVien(NhanVienDto nhanVienDto);

    NhanVienDto updateNhanVien(Long id, NhanVienDto nhanVienDto);

    void deleteNhanVien(Long id);

    Page<NhanVienDto> getNhanVienPage(int page, int size);

    NhanVienDto updateNhanVienByTrangThai(Long id, NhanVienDto nhanVienDto);
}
