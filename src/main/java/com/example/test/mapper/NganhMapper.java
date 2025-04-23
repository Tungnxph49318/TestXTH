package com.example.test.mapper;

import com.example.test.dto.NganhDto;
import com.example.test.entity.Nganh;

public class NganhMapper {
    public static NganhDto mapToNganhDto(Nganh nganh){
        return new NganhDto(
                nganh.getId(),
                nganh.getTrangThai(),
                nganh.getNgayTao(),
                nganh.getNgaySua(),
                nganh.getMaNganh(),
                nganh.getTenNganh()
        );
    }

    public static Nganh mapToNganh(NganhDto nganhDto){
        return new Nganh(
                nganhDto.getId(),
                nganhDto.getTrangThai(),
                nganhDto.getNgayTao(),
                nganhDto.getNgaySua(),
                nganhDto.getMaNganh(),
                nganhDto.getTenNganh()
        );
    }
}
