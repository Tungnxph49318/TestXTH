package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDto {
    private Long id;
    private Integer trangThai;
    private Long ngayTao;
    private Long ngaySua;
    private String tkFe;
    private String tkFpt;
    private String tenNhanVien;
    private String maNhanVien;
}
