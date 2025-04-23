package com.example.test.mapper;

import com.example.test.dto.KhoaDto;
import com.example.test.entity.Khoa;

public class KhoaMapper {
    public static KhoaDto mapToKhoaDto(Khoa khoa) {
        return new KhoaDto(
                khoa.getId(),
                khoa.getTrangThai(),
                khoa.getNgayTao(),
                khoa.getNgaySua(),
                khoa.getMaKhoa(),
                khoa.getTenKhoa()
        );
    }

    public static Khoa mapToKhoa(KhoaDto khoaDto) {
        return new Khoa(
                khoaDto.getId(),
                khoaDto.getTrangThai(),
                khoaDto.getNgayTao(),
                khoaDto.getNgaySua(),
                khoaDto.getMaKhoa(),
                khoaDto.getTenKhoa()
        );
    }
}
