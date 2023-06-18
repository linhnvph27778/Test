package com.example.luyentap.service.impl;

import com.example.luyentap.entity.KhachHang;
import com.example.luyentap.repository.KhachHangRepository;
import com.example.luyentap.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }
}
