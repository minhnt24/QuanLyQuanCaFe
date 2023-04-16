/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import DomainModels.ChucVu;
import Repository.ChucVuRepository;
import Service.ChucVuService;
import java.util.List;

/**
 *
 * @author hdo48
 */
public class ChucVuServiceImpl implements ChucVuService{
private ChucVuRepository chucVuRepository= new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public String add(ChucVu chucVu) {
       boolean add=chucVuRepository.add(chucVu);
       if(add){
           return "ADD THÀNH CÔNG";
       }else{
           return "ADD THẤT BẠI";
       }
    }

   

    @Override
    public String update(ChucVu chucVu, String id) {
        boolean UPDATE=chucVuRepository.update(chucVu, id);
        if(UPDATE){
            return "UPDATE THÀNH CÔNG";
        }else{
            return "UPDATE THẤT BẠI";
        }
    }
    
}
