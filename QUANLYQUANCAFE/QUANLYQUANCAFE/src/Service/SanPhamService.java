/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.SanPhamModel;
import ViewModels.SanPham;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface SanPhamService {

    List<ViewModels.SanPham> getAll();

    List<ViewModels.SanPham> getAllTT();

    List<ViewModels.SanPham> getAllKM();

    ViewModels.SanPham getOne(String ma);

    String add(SanPhamModel sp);

    String addID(SanPhamModel sp, String ma);

    String delete(String ma);

    String update(SanPhamModel sp, String ma);

    List<ViewModels.SanPham> search(String tenSP);

    List<SanPham> searchTenDanhMuc(String tenDanhMuc);

}
