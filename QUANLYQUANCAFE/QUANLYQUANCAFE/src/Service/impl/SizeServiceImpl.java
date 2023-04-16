/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.SizeModel;
import ViewModels.Size;
import Repository.SizeRepostory;
import Service.SizeService;
import java.util.List;

/**
 *
 * @author ADMIN5
 */
public class SizeServiceImpl implements SizeService {

    private SizeRepostory rp = new SizeRepostory();

    @Override
    public List<Size> getAll() {
        return rp.getAll();
    }

    @Override
    public String add(SizeModel s) {
        if (s.getSize().isEmpty()) {
            return "Không được để trống!";
        }
        boolean add = rp.add(s);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(SizeModel s, String ID) {
        boolean update = rp.update(s, ID);
        if (update) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

    @Override
    public Size getOne(String size) {
        return rp.getOne(size);
    }

    @Override
    public String delete(String ID) {
        boolean xoa = rp.delete(ID);
        if (xoa) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

}
