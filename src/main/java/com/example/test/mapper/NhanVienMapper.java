package com.example.test.mapper;

import com.example.test.dto.NhanVienDto;
import com.example.test.entity.NhanVien;

public class NhanVienMapper {
    public static NhanVienDto mapToNhanVienDto(NhanVien nhanVien) {
        return new NhanVienDto(
                nhanVien.getId(),
                nhanVien.getTrangThai(),
                nhanVien.getNgayTao(),
                nhanVien.getNgaySua(),
                nhanVien.getTkFe(),
                nhanVien.getTkFpt(),
                nhanVien.getTenNhanVien(),
                nhanVien.getMaNhanVien()
        );
    }

    public static NhanVien mapToNhanVien(NhanVienDto nhanVienDto) {
        return new NhanVien(
                nhanVienDto.getId(),
                nhanVienDto.getTrangThai(),
                nhanVienDto.getNgayTao(),
                nhanVienDto.getNgaySua(),
                nhanVienDto.getTkFe(),
                nhanVienDto.getTkFpt(),
                nhanVienDto.getTenNhanVien(),
                nhanVienDto.getMaNhanVien()
        );
    }
}
