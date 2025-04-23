package com.example.test.mapper;

import com.example.test.dto.NganhCoSoDto;
import com.example.test.entity.KhoaCoSo;
import com.example.test.entity.Nganh;
import com.example.test.entity.NganhCoSo;

public class NganhCoSoMapper {
    public static NganhCoSoDto mapToCoSoDto(NganhCoSo nganhCoSo){
        return new NganhCoSoDto(
                nganhCoSo.getId(),
                nganhCoSo.getTrangThai(),
                nganhCoSo.getNgayTao(),
                nganhCoSo.getNgaySua(),
                nganhCoSo.getKhoaCoSo().getId(),
                nganhCoSo.getNganh().getTenNganh()
        );
    }

    public static NganhCoSo mapToCoSo(NganhCoSoDto nganhCoSoDto){

        KhoaCoSo khoaCoSo = new KhoaCoSo();
        khoaCoSo.setId(nganhCoSoDto.getId());

        Nganh nganh = new Nganh();
        nganh.setTenNganh(nganhCoSoDto.getTenNganh());

        NganhCoSo nganhCoSo = new NganhCoSo();
        nganhCoSo.setId(nganhCoSoDto.getId());
        nganhCoSo.setTrangThai(nganhCoSoDto.getTrangThai());
        nganhCoSo.setNgayTao(nganhCoSoDto.getNgayTao());
        nganhCoSo.setNgaySua(nganhCoSoDto.getNgaySua());
        nganhCoSo.setKhoaCoSo(khoaCoSo);
        nganhCoSo.setNganh(nganh);

        return nganhCoSo;
    }
}
