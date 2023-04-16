/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhuVucModel;
import ViewModels.KhuVuc;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface KhuVucService {

    List<KhuVuc> getAll();

    KhuVuc getOne(String ma);

    List<KhuVuc> Search(String ma);

    List<KhuVuc> SearchTT(String tt);

    String add(KhuVucModel ban);

    String update(KhuVucModel ban, String ma);

    String delete(String ma);
}
