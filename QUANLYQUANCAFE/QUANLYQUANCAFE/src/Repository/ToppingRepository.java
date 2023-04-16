/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ToppingModel;
import Utilities.DBContext;
import ViewModels.Topping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ToppingRepository {

    public List<Topping> getAll() {
        String query = "SELECT * FROM Topping";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Topping> list = new ArrayList<>();
            while (rs.next()) {
                Topping tp = new Topping(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                list.add(tp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Topping> searchTen(String tenTopping) {
        String query = "SELECT [ID]\n"
                + "      ,[Topping]\n"
                + "      ,[GiaTien]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[Topping]\n"
                + "  WHERE Topping like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + tenTopping + "%");
            ResultSet rs = ps.executeQuery();
            List<Topping> list = new ArrayList<>();
            while (rs.next()) {
                Topping tp = new Topping(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                list.add(tp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Topping getOne(String topping) {
        String query = "SELECT * FROM Topping\n"
                + "where Topping like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, topping);
            ResultSet rs = ps.executeQuery();
            List<Topping> list = new ArrayList<>();
            while (rs.next()) {
                return new Topping(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(ToppingModel tp) {
        String query = "INSERT INTO [dbo].[Topping]\n"
                + "           ([Topping]\n"
                + "           ,[GiaTien]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tp.getTopping());
            ps.setObject(2, tp.getGiaTien());
            ps.setObject(3, tp.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ToppingModel tp, String ID) {
        String query = "UPDATE [dbo].[Topping]\n"
                + "   SET [Topping] = ?\n"
                + "      ,[GiaTien] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tp.getTopping());
            ps.setObject(2, tp.getGiaTien());
            ps.setObject(3, tp.getTrangThai());
            ps.setObject(4, ID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

//    public boolean delete(String ID) {
//        String query = "DELETE FROM [dbo].[Topping]\n"
//                + "      WHERE ID = ?";
//        int check = 0;
//        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
//            ps.setObject(1, ID);
//            check = ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return check > 0;
//    }
    public static void main(String[] args) {
//        List<Topping> show = new ToppingRepository().getAll();
//        for (Topping x : show) {
//            System.out.println(x);
//        }
        Topping tp = new ToppingRepository().getOne("123");
        System.out.println(tp);
    }
}
