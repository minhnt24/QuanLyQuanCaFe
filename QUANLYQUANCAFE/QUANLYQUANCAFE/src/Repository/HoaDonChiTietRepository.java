/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDonChiTietModel;
import Utilities.DBContext;
import ViewModels.HoaDonChiTiet;
import ViewModels.SanPham;
import ViewModels.Topping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietRepository {

    public List<HoaDonChiTiet> getAll() {
        String query = "select MaSP,TenSP,Giaban,Soluong,Topping, (Soluong * Giaban) + Topping.GiaTien as Tongtien\n"
                + "from HoaDonChiTiet\n"
                + "inner join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "inner join Topping on Topping.ID = HoaDonChiTiet.IDTopping";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                Topping tp = new Topping(rs.getString(5));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3));
                HoaDonChiTiet hdct = new HoaDonChiTiet(sp, rs.getInt(4), tp, rs.getDouble(6));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonChiTiet> getAllviewGH(String id) {
        String query = "select MaSP,TenSP,Giaban,Soluong,Topping, (Soluong * Giaban) + Topping.GiaTien as Tongtien\n"
                + "from HoaDonChiTiet\n"
                + "inner join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "inner join Topping on Topping.ID = HoaDonChiTiet.IDTopping\n"
                + "where IDHD like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                Topping tp = new Topping(rs.getString(5));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3));
                HoaDonChiTiet hdct = new HoaDonChiTiet(sp, rs.getInt(4), tp, rs.getDouble(6));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDonChiTiet getOne(String ma) {
        String query = "select MaSP,TenSP,Giaban,Soluong,Topping, (Soluong * Giaban) + Topping.GiaTien as Tongtien\n"
                + "from HoaDonChiTiet\n"
                + "inner join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "inner join Topping on Topping.ID = HoaDonChiTiet.IDTopping\n"
                + "where MaSP like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Topping tp = new Topping(rs.getString(5));
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3));
                return new HoaDonChiTiet(sp, rs.getInt(4), tp, rs.getDouble(6));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonChiTietModel hd) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IDSP]\n"
                + "           ,[IDHD]\n"
                + "           ,[Soluong]\n"
                + "           ,[IDTopping])\n"
                + "     VALUES(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIDSP());
            ps.setObject(2, hd.getIDHD());
            ps.setObject(3, hd.getSoLuong());
            ps.setObject(4, hd.getTopping());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonChiTietModel hd, String idHD, String idSP) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [Soluong] = ?\n"
                + " WHERE IDHD like ? and IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getSoLuong());
            ps.setObject(2, idHD);
            ps.setObject(3, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateTP(HoaDonChiTietModel hd, String idSP) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [IDTopping] = ?\n"
                + " WHERE IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getTopping());
            ps.setObject(2, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateIDHD(String idHD, int soLuong, String idTopping, String idSP) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "SET [IDHD] = ?,[Soluong] = ?,IDTopping = ?\n"
                + "WHERE IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, soLuong);
            ps.setObject(3, idTopping);
            ps.setObject(4, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean gopHD(String idHD, String idSP) {
        String query = "UPDATE [dbo].[HoaDonChiTiet]\n"
                + "   SET [IDHD] = ?\n"
                + " WHERE IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

//    public HoaDonChiTietModel checkTrung(String idSp) {
//        String query = "SELECT idSP FROM SANPHAM WHERE idSp = ?";
//        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
//            ps.setObject(1, idSp);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                HoaDonChiTietModel sp = new HoaDonChiTietModel(rs.getString(1));
//                return sp;
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
    public boolean delete(String idHD, String idSP) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
                + "      WHERE IDHD like ? and IDSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<HoaDonChiTiet> list = new HoaDonChiTietRepository().getAllviewGH("b3e3cd4c-395d-411b-bd18-b088ab4769fa");
//        for (HoaDonChiTiet x : list) {
//            System.out.println(x.toString());
//        }
//        HoaDonChiTiet hd = new HoaDonChiTietRepository().getOne("SP1");
//        System.out.println(hd);
        HoaDonChiTietModel hd = new HoaDonChiTietModel("", "", 0, "b001ea99-ed1f-42b5-83f7-fcad487cdd40");
        boolean add = new HoaDonChiTietRepository().updateIDHD("dddae10e-2162-4eb7-9ce5-ad1adae81473", 3, "96b4e2de-ceb5-4683-be33-1b54382c317c", "ceeb3f9d-b646-4310-8780-53d502fc7065");
        System.out.println(add);
    }
}
