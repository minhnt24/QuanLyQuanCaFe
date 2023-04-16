/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.QuanLyModel;
import Repository.QuanLyRepository;

import Repository.SanPhamRepository;
import Service.QuanLyService;
import ViewModels.QuanLy;
import java.util.List;

/**
 *
 * @author ACER
 */
public class QuanLyServiceImpl implements QuanLyService {

    private QuanLyRepository rps = new QuanLyRepository();

    @Override
    public List<QuanLy> getAll() {
        return rps.getAll();
    }

    @Override
    public String add(QuanLyModel ql) {
        boolean add = rps.add(ql);
        if (add) {
            return "add thành công";
        } else {
            return "add thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean add = rps.delete(ma);
        if (add) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public String update(QuanLyModel ql, String ma) {
        boolean add = rps.update(ql, ma);
        if (add) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

}
