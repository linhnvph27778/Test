package com.example.luyentap.service;

import com.example.luyentap.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PhieuGiamGiaSercive {
    List<PhieuGiamGia> getAll();

    void add(PhieuGiamGia phieuGiamGia);

    void delete(PhieuGiamGia phieuGiamGia);

    Optional<PhieuGiamGia> getOne(String maPhieu);

    Page<PhieuGiamGia> phanTrang(int pageNo,int size);

//    Page<PhieuGiamGia> search(Date ngayBatDau,Date ngayKetThuc, Pageable pageable);
}
