/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.HoaDonModel;
import Repository.HoaDonRepository;
import Service.ServiceHoaDon;
import java.util.List;
import ViewModels.HoaDon;

/**
 *
 * @author vietv
 */
public class HoaDonServiceIblm implements ServiceHoaDon {

    private HoaDonRepository rps = new HoaDonRepository();

//    @Override
//    public List<HoaDon> getAll() {
//        return rps.getAll();
//    }
    @Override
    public String delete(String maHD) {
        boolean delete = rps.delete(maHD);
        if (delete) {
            return "Gộp thành công";
        } else {
            return "Gộp thất bại";
        }
    }

    @Override
    public List<HoaDon> getAllTT() {
        return rps.getAllTT();
    }

    @Override
    public List<HoaDon> getListHD() {
        return rps.getListHD();
    }

    @Override
    public List<HoaDon> search(String datehd) {
        return rps.search(datehd);
    }

    @Override
    public HoaDon getOne(String ma) {
        return rps.getOne(ma);
    }

    @Override
    public String add(HoaDonModel hd, String id) {
        boolean add = rps.add(hd, id);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(HoaDonModel hd, String maHD, String tinhTrang) {
        boolean update = rps.update(hd, maHD, tinhTrang);
        if (update) {
            return "Thanh toán thành công";
        } else {
            return "Thanh toán thất bại";
        }
    }

    @Override
    public List<HoaDon> getAllTTViewHD(String id) {
        return rps.getAllTTViewHD(id);
    }

    @Override
    public String updateID(String id, String maHD) {
        boolean update = rps.updateID(id, maHD);
        if (update) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public List<HoaDon> getAll() {
        return rps.getAll();
    }

    @Override
    public List<HoaDon> searchTheoTT(String tt) {
        return rps.searchTheoTT(tt);
    }

    @Override
    public List<HoaDon> searchTheoMaHD(String maHD) {
        return rps.searchTheoMaHD(maHD);
    }

    @Override
    public List<HoaDon> getAllHD(String ma) {
        return rps.getAllHD(ma);
    }

    @Override
    public List<HoaDon> getAllHDCho() {
        return rps.getAllHDCho();
    }

    @Override
    public List<HoaDon> getAllViewHD() {
        return rps.getAllViewHD();
    }

    @Override
    public List<HoaDon> searchTheoDate(String date1, String date2) {
        return rps.searchTheoDate(date1, date2);
    }

    @Override
    public List<HoaDon> searchTheoDate1(String date1, String date2) {
        return rps.searchTheoDate1(date1, date2);
    }

}
