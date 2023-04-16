/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.NhanVienModel;
import ViewModels.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author hdo48
 */
public interface NhanVienService {

    List<NhanVienViewModel> getAll();

    String add(NhanVienModel nhanVien);

    String delete(String id);

    String update(NhanVienModel nhanVien, String id);

    List<NhanVienViewModel> getTimkiem(String ma);
    
    List<NhanVienViewModel> locchucvu(String ten);

}
