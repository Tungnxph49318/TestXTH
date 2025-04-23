package com.example.test.mapper;

import com.example.test.dto.KhoaCoSoDto;
import com.example.test.entity.CoSo;
import com.example.test.entity.Khoa;
import com.example.test.entity.KhoaCoSo;
import com.example.test.entity.NhanVien;

public class KhoaCoSoMapper {
    public static KhoaCoSoDto mapToKhoaCoSoDto(KhoaCoSo khoaCoSo){
        return new KhoaCoSoDto(
                khoaCoSo.getId(),
                khoaCoSo.getTrangThai(),
                khoaCoSo.getNgayTao(),
                khoaCoSo.getNgaySua(),
                khoaCoSo.getKhoa().getTenKhoa(),
                khoaCoSo.getCoSo().getTenCoSo(),
                khoaCoSo.getNhanVien().getTenNhanVien()
        );
    }

    public static KhoaCoSo mapToKhoaCoSo(KhoaCoSoDto khoaCoSoDto){

        Khoa khoa = new Khoa();
        khoa.setTenKhoa(khoaCoSoDto.getTenKhoa());

        CoSo coSo = new CoSo();
        coSo.setTenCoSo(khoaCoSoDto.getTenCoSo());

        NhanVien nhanVien = new NhanVien();
        nhanVien.setTenNhanVien(khoaCoSoDto.getTenNhanVien());

        KhoaCoSo khoaCoSo = new KhoaCoSo();
        khoaCoSo.setId(khoaCoSoDto.getId());
        khoaCoSo.setTrangThai(khoaCoSoDto.getTrangThai());
        khoaCoSo.setNgayTao(khoaCoSoDto.getNgayTao());
        khoaCoSo.setNgaySua(khoaCoSoDto.getNgaySua());
        khoaCoSo.setKhoa(khoa);
        khoaCoSo.setCoSo(coSo);
        khoaCoSo.setNhanVien(nhanVien);

        return khoaCoSo;
    }
}
