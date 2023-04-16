/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.QuanLyModel;
import ViewModels.QuanLy;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface QuanLyService {

    List<QuanLy> getAll();

    String add(QuanLyModel sp);

    String delete(String ma);

    String update(QuanLyModel ql, String ma);
}
