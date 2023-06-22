package com.example.luyentap.controller;

import com.example.luyentap.entity.PhieuGiamGia;
import com.example.luyentap.service.KhachHangService;
import com.example.luyentap.service.PhieuGiamGiaSercive;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/phieu-giam-gia")
public class PhieuGiamGiaController {
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private PhieuGiamGiaSercive phieuGiamGiaSercive;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0" ,value = "page")int page){
        model.addAttribute("listKH",khachHangService.getAll());
        model.addAttribute("list",phieuGiamGiaSercive.phanTrang(page,2));
        return "index";
    }

    @GetMapping("/viewUpdate/{maPhieu}")
    public String viewUpdate(@PathVariable("maPhieu") String maPhieu,Model model){
        Optional<PhieuGiamGia> phieuGiamGia = phieuGiamGiaSercive.getOne(maPhieu);
        model.addAttribute("phieuGiamGia",phieuGiamGia);
        model.addAttribute("action","/phieu-giam-gia/update/" +phieuGiamGia.get().getMaPhieu());
        model.addAttribute("listKH",khachHangService.getAll());
        return "update";
    }


    @PostMapping("/update/{maPhieu}")
    public String upadte( Model model, @Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("listKH",khachHangService.getAll());
            return "update";
        }else {
            httpSession.setAttribute("confim","Cập nhật thanh công");
            phieuGiamGiaSercive.add(phieuGiamGia);
            System.out.println("linhddtr");
            return "redirect:/phieu-giam-gia/hien-thi";
        }
    }
    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        PhieuGiamGia phieuGiamGia = new PhieuGiamGia();
        model.addAttribute("phieuGiamGia",phieuGiamGia);
        model.addAttribute("action","/phieu-giam-gia/add");
        model.addAttribute("listKH",khachHangService.getAll());
        return "update";
    }
    @PostMapping("/add")
    public String add(
            Model model,
            @Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("listKH",khachHangService.getAll());
            return "update";
        }else if (phieuGiamGia.getNgayBatDau().after(phieuGiamGia.getNgayKetThuc())) {
            model.addAttribute("mes","Ngay băt đầu phải nhỏ hơn ngày keets thúc");
            return "update";
        }else {
            httpSession.setAttribute("confim","Thêm thanh công");
            phieuGiamGiaSercive.add(phieuGiamGia);
            return "redirect:/phieu-giam-gia/hien-thi";
        }
    }

    @GetMapping("/delete/{maPhieu}")
    public String delete(@PathVariable("maPhieu") PhieuGiamGia phieuGiamGia){
//        Optional<PhieuGiamGia> phieuGiamGia = phieuGiamGiaSercive.getOne(ma);
        httpSession.setAttribute("confim","Xóa thanh công");
        phieuGiamGiaSercive.delete(phieuGiamGia);
        return "redirect:/phieu-giam-gia/hien-thi";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam(defaultValue = "", required = false) Date ngayBatDau,
//                         @RequestParam(defaultValue = "", required = false) Date ngayKetThuc,
//                         Model model){
//        Pageable pageable = PageRequest.of(0, 2);
//        model.addAttribute("listKH",khachHangService.getAll());
//        model.addAttribute("list",phieuGiamGiaSercive.search(ngayBatDau,ngayKetThuc,pageable));
//        return "index";
//    }
}
