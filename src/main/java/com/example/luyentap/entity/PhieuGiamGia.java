package com.example.luyentap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "PhieuGiamGia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PhieuGiamGia {
    @Id
    @Column(name = "MaPhieu")
    @NotNull(message = "Khong duoc bo trong")
    private String maPhieu;

    @Column(name ="TenPhieu")
    @NotBlank( message = "Khong duoc bo trong")
    private String tenPhieu;

    @Column(name = "GiaTriGiam")
    @NotNull(message = "Khong dc bo trong")
    private double giaTriGiam;

    @Column(name = "NgayKetThuc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Khong duoc bo trong")
    private Date ngayKetThuc;

    @Column(name = "NgayBatDau")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Khong duoc bo trong")
    private Date ngayBatDau;

    @Column(name = "trangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "NguoiSoHuu")
    private KhachHang khachHang;
}
