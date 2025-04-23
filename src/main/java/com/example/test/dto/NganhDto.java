package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NganhDto {
    private Long id;
    private Integer trangThai;
    private Long ngayTao;
    private Long ngaySua;
    private String tenNganh;
    private String maNganh;
}
