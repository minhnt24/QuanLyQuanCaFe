/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.BanModel;
import Repository.BanRepostory;
import Service.BanService;
import ViewModels.Ban;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanServiceImpl implements BanService {

    private BanRepostory rp = new BanRepostory();

    @Override
    public List<Ban> getAll() {
        return rp.getAll();
    }

    @Override
    public Ban getOne(String id) {
        return rp.getOne(id);
    }

    @Override
    public String add(BanModel ban) {
        if (ban.getTenBan().isEmpty() || ban.getMoTa().isEmpty() || ban.getMaBan().isEmpty()) {
            return "Không được để trống";
        }
        BanModel b = rp.checkTrung(ban.getMaBan());
        if (b != null) {
            return "Trùng mã";
        }
        boolean add = rp.add(ban);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(BanModel ban, String ma) {
        if (ban.getTenBan().isEmpty() || ban.getMoTa().isEmpty() || ban.getMaBan().isEmpty()) {
            return "Không được để trống";
        }
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
    public List<Ban> Search(String ma) {
        return rp.Search(ma);
    }

    @Override
    public List<Ban> SearchKV(String TenKV) {
        return rp.SearchKV(TenKV);
    }

    @Override
    public List<Ban> SearchTen(String ten) {
        return rp.SearchTen(ten);
    }

    @Override
    public List<Ban> SearchLoaiBan(String loai) {
        return rp.SearchLoaiBan(loai);
    }

    @Override
    public List<Ban> getAllTT() {
        return rp.getAllTT();
    }

    @Override
    public String updateTT(BanModel ban, String ma) {
        boolean update = rp.updateTT(ban, ma);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String gopBan(String ten) {
        boolean gopBan = rp.gopBan(ten);
        if (gopBan) {
            return "Gộp bàn thành công";
        } else {
            return "Gộp bàn thất bại";
        }
    }

    @Override
    public String tachBan(BanModel ban) {
        boolean tachBan = rp.tachBan(ban);
        if (tachBan) {
            return "Tách bàn thành công";
        } else {
            return "Tách bàn thất bại";
        }
    }

    @Override
    public List<Ban> banTach() {
        return rp.banTach();
    }

}
