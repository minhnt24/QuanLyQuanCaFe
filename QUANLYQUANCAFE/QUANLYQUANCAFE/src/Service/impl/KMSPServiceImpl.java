/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.SP_KM;
import Repository.SP_KMRepostory;
import Service.SPKMService;

/**
 *
 * @author Admin
 */
public class KMSPServiceImpl implements SPKMService {

    private SP_KMRepostory rp = new SP_KMRepostory();

    @Override
    public String add(SP_KM sp) {
        boolean add = rp.add(sp);
        if (add) {
            return "Áp dụng mã giảm giá cho sản phẩm thành công!";
        } else {
            return "Áp dụng mã giảm giá cho sản phẩm thất bại!";
        }
    }

}
