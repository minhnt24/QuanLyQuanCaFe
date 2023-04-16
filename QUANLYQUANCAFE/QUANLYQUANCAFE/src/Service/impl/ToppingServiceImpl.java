/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.ToppingModel;
import Repository.ToppingRepository;
import Service.ToppingService;
import ViewModels.Topping;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ToppingServiceImpl implements ToppingService {

    private ToppingRepository rps = new ToppingRepository();

    @Override
    public List<Topping> getAll() {
        return rps.getAll();
    }

    @Override
    public String add(ToppingModel tp) {
        if (tp.getTopping().isEmpty()) {
            return "Không được để trống";
        }
        boolean add = rps.add(tp);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

//    @Override
//    public String delete(String id) {
//        boolean delete = rps.delete(id);
//        if (delete) {
//            return "Xóa thành công!";
//        } else {
//            return "Xóa thất bại!";
//        }
//    }
    @Override
    public String update(ToppingModel tp, String id) {
        boolean update = rps.update(tp, id);
        if (update) {
            return "Sửa thành công!";
        } else {
            return "Sủa thất bại!";
        }
    }

    @Override
    public Topping getOne(String topping) {
        return rps.getOne(topping);
    }

    @Override
    public List<Topping> searchTen(String tenTopping) {
        return rps.searchTen(tenTopping);
    }

}
