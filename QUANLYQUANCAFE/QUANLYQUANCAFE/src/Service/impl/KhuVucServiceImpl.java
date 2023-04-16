/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.KhuVucModel;
import Repository.KhuVucRepostory;
import Service.KhuVucService;
import ViewModels.KhuVuc;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhuVucServiceImpl implements KhuVucService {

    private KhuVucRepostory rp = new KhuVucRepostory();

    @Override
    public List<KhuVuc> getAll() {
        return rp.getAll();
    }

    @Override
    public KhuVuc getOne(String ma) {
        return rp.getOne(ma);
    }

    @Override
    public String add(KhuVucModel ban) {
        boolean add = rp.add(ban);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(KhuVucModel ban, String ma) {
        boolean update = rp.update(ban, ma);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = rp.delete(ma);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public List<KhuVuc> Search(String ma) {
        return rp.Search(ma);
    }

    @Override
    public List<KhuVuc> SearchTT(String tt) {
        return rp.SearchTT(tt);
    }

}
