/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author hdo48
 */
public interface ChucVuService {

    List<ChucVu> getAll();

    String add(ChucVu chucVu);

    String update(ChucVu chucVu, String id);
}
