/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ACER
 */
public class DanhMucModel {

    private String id;
    private String tenDM;
   

    public DanhMucModel() {
    }

    public DanhMucModel(String id, String tenDM) {
        this.id = id;
        this.tenDM = tenDM;
    }

       

    public DanhMucModel(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

}
