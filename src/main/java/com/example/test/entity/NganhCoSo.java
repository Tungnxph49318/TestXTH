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
@Table(name = "nganh_co_so")
public class NganhCoSo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private Long ngayTao;

    @Column(name = "ngay_sua")
    private Long ngaySua;

    @ManyToOne
    @JoinColumn(name = "id_khoa_co_so", referencedColumnName = "id")
    private KhoaCoSo khoaCoSo;

    @ManyToOne
    @JoinColumn(name = "id_nganh", referencedColumnName = "id")
    private Nganh nganh;
}
