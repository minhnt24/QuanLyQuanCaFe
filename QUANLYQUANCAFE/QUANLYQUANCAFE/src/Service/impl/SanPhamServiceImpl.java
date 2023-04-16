/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.SanPhamModel;
import java.util.List;
import Repository.SanPhamRepository;
import Service.SanPhamService;
import ViewModels.SanPham;

/**
 *
 * @author ACER
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository rps = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return rps.getAll();
    }

    @Override

    public String add(SanPhamModel sp) {
        if (sp.getMaSP().isEmpty() || sp.getTenSP().isEmpty() || sp.getMoTa().isEmpty() || String.valueOf(sp.getGiaBan()).isEmpty()) {
            return "Không được để trống";
        }
        if (sp.getTenSP().matches("[a-z A-Z]+") == false) {
            return "Tên phải là chữ";
        }
        SanPhamModel ma = rps.checkTrung(sp.getMaSP());
        if (ma != null) {
            return "Mã SP đã tồn tại!";
        }
        boolean add = rps.add(sp);
        if (add) {
            return "Đã thêm thành công";
        } else {
            return "Đã thêm thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean add = rps.delete(ma);
        if (add) {
            return "Đã xóa thành công";
        } else {
            return "Đã xóa thất bại";
        }
    }

    @Override
    public String update(SanPhamModel sp, String ma) {
        if (sp.getMaSP().isEmpty() || sp.getTenSP().isEmpty() || sp.getMoTa().isEmpty() || String.valueOf(sp.getGiaBan()).isEmpty()) {
            return "Không được để trống";
        }
        
        boolean add = rps.update(sp, ma);
        if (add) {
            return "Đã sửa thành công";
        } else {
            return "Đã sửa thất bại";
        }
    }

    @Override
    public List<SanPham> search(String tenSP) {
        return rps.search(tenSP);
    }

    @Override
    public List<SanPham> searchTenDanhMuc(String tenDanhMuc) {
        return rps.searchTenDanhMuc(tenDanhMuc);
    }

    @Override
    public List<SanPham> getAllKM() {
        return rps.getAllKM();
    }

    @Override
    public String addID(SanPhamModel sp, String ma) {
        boolean add = rps.addID(sp, ma);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public SanPham getOne(String ma) {
        return rps.getOne(ma);
    }

    @Override
    public List<SanPham> getAllTT() {
        return rps.getAllTT();
    }

}
