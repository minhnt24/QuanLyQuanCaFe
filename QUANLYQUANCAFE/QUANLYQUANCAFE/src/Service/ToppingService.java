/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ToppingModel;
import ViewModels.Topping;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ToppingService {

    List<Topping> getAll();

    String add(ToppingModel tp);

//    String delete(String id);
    String update(ToppingModel tp, String id);

    Topping getOne(String topping);
    
    List<Topping> searchTen(String tenTopping);
}
