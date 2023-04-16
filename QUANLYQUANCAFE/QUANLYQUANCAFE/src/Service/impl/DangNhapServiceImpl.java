/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.TaiKhoanModel;
import Repository.DangNhapRepostory;
import Service.DangNhapService;

/**
 *
 * @author Admin
 */
public class DangNhapServiceImpl implements DangNhapService {

    private DangNhapRepostory rp = new DangNhapRepostory();

    @Override
    public TaiKhoanModel dangNhap(String username, String pass) {
        return rp.dangNhap(username, pass);
    }

}
