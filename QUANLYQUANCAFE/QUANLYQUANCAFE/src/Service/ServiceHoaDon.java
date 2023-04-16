/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.HoaDonChiTietModel;
import DomainModels.HoaDonModel;
import ViewModels.HoaDon;
import java.util.List;

/**
 *
 * @author vietv
 */
public interface ServiceHoaDon {

    List<ViewModels.HoaDon> getAll();

    List<ViewModels.HoaDon> searchTheoTT(String tt);

    List<ViewModels.HoaDon> searchTheoMaHD(String maHD);

    List<ViewModels.HoaDon> searchTheoDate(String date1, String date2);

    List<ViewModels.HoaDon> searchTheoDate1(String date1, String date2);

    List<ViewModels.HoaDon> getAllTT();

    List<ViewModels.HoaDon> getAllViewHD();

    List<ViewModels.HoaDon> getListHD();

    List<ViewModels.HoaDon> getAllTTViewHD(String id);

    List<ViewModels.HoaDon> getAllHD(String ma);

    List<ViewModels.HoaDon> search(String datehd);

    HoaDon getOne(String ma);

    String add(HoaDonModel hd, String ma);

    String update(HoaDonModel hd, String maHD, String tinhTrang);

    String updateID(String id, String maHD);

    String delete(String maHD);

    List<HoaDon> getAllHDCho();

}
