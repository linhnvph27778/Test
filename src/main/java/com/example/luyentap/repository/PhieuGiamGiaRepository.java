package com.example.luyentap.repository;

import com.example.luyentap.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia,String> {
//    PhieuGiamGia findByMaPhieu(String maPhieu);

//    @Query("select p from PhieuGiamGia p where  p.ngayBatDau BETWEEN: ngayBatDau AND: ngayKetThuc")
//    Page<PhieuGiamGia> search(@Param("ngayBatDau") Date ngayBatDau , @Param("ngayKetThuc")Date ngayKetThuc, Pageable pageable);
}
