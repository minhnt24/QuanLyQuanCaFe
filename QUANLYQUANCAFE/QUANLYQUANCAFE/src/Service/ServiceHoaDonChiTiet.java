/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.HoaDonChiTietModel;
import ViewModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceHoaDonChiTiet {

    List<ViewModels.HoaDonChiTiet> getAll();

    List<ViewModels.HoaDonChiTiet> getAllviewGH(String id);

    HoaDonChiTiet getOne(String ma);

    String add(HoaDonChiTietModel hd);

    String update(HoaDonChiTietModel hd, String idHD, String idSP);

    String delete(String idHD, String idSP);

    String gopHD(String idHD, String idSP);

    String updateIDHD(String idHD, int soLuong, String idTopping, String idSP);

    String updateTP(HoaDonChiTietModel hd, String idSP);

//    HoaDonChiTietModel checkTrung(String idSp);
}
