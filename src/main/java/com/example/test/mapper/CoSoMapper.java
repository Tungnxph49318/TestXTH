package com.example.test.mapper;

import com.example.test.dto.CoSoDto;
import com.example.test.entity.CoSo;

public class CoSoMapper {
    public static CoSoDto mapToCoSoDto(CoSo coSo) {
        return new CoSoDto(
                coSo.getId(),
                coSo.getTrangThai(),
                coSo.getNgayTao(),
                coSo.getNgaySua(),
                coSo.getMaCoSo(),
                coSo.getTenCoSo()
        );
    }

    public static CoSo mapToCoSo(CoSoDto coSoDto) {
        return new CoSo(
                coSoDto.getId(),
                coSoDto.getTrangThai(),
                coSoDto.getNgayTao(),
                coSoDto.getNgaySua(),
                coSoDto.getMaCoSo(),
                coSoDto.getTenCoSo()
        );
    }
}
