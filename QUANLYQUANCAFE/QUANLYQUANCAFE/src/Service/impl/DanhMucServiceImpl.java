/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.DanhMucModel;
import Repository.DanhMucRepository;
import Service.DanhMucService;
import ViewModels.DanhMuc;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DanhMucServiceImpl implements DanhMucService {

    private DanhMucRepository rps = new DanhMucRepository();

    @Override
    public List<DanhMuc> getAll() {
        return rps.getAll();
    }

    @Override
    public DanhMuc getOne(String ma) {
        return rps.getOne(ma);
    }

    @Override
    public String add(DanhMucModel dm) {
        if (dm.getTenDM().isEmpty()) {
            return "Không được để trống!";
        }
        boolean add = rps.add(dm);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(DanhMucModel dm, String ID) {
        boolean update = rps.update(dm, ID);
        if (update) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

    @Override
    public String delete(String ID) {
        boolean xoa = rps.delete(ID);
        if (xoa) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

}
