package com.example.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "can_bo")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private Long ngayTao;

    @Column(name = "ngay_sua")
    private Long ngaySua;

    @Column(name = "tai_khoan_fe")
    private String tkFe;

    @Column(name = "tai_khoan_fpt")
    private String tkFpt;

    @Column(name = "ten")
    private String tenNhanVien;

    @Column(name = "ma_can_bo")
    private String maNhanVien;

}
