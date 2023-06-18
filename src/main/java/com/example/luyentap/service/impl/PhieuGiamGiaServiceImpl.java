package com.example.luyentap.service.impl;

import com.example.luyentap.entity.PhieuGiamGia;
import com.example.luyentap.repository.PhieuGiamGiaRepository;
import com.example.luyentap.service.PhieuGiamGiaSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaSercive {
    @Autowired
    private PhieuGiamGiaRepository phieuGiamGiaRepository;
    @Override
    public List<PhieuGiamGia> getAll() {
        return phieuGiamGiaRepository.findAll();
    }

    @Override
    public void add(PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaRepository.save(phieuGiamGia);
    }

    @Override
    public void delete(PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaRepository.delete(phieuGiamGia);
    }

    @Override
    public Optional<PhieuGiamGia> getOne(String maPhieu) {
        return phieuGiamGiaRepository.findById(maPhieu);
    }

    @Override
    public Page<PhieuGiamGia> phanTrang(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return phieuGiamGiaRepository.findAll(pageable);
    }

//    @Override
//    public Page<PhieuGiamGia> search(Date ngayBatDau, Date ngayKetThuc, Pageable pageable) {
//        return phieuGiamGiaRepository.search(ngayBatDau,ngayKetThuc,pageable);
//    }
}
