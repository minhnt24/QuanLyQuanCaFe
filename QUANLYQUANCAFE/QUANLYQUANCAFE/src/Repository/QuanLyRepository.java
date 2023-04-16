/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.QuanLyModel;
import Utilities.DBContext;
import ViewModels.QuanLy;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyRepository {

    public List<QuanLy> getAll() {
        String query = "SELECT [MaQL]\n"
                + "      ,[TenQL]\n"
                + "      ,[SDT]\n"
                + "      ,[DiaChi]\n"
                + "  FROM [dbo].[QuanLy]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<QuanLy> list = new ArrayList<>();
            while (rs.next()) {
                QuanLy ql = new QuanLy(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ql);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(QuanLyModel ql) {
        String query = "INSERT INTO [dbo].[QuanLy]\n"
                + "           ([MaQL]\n"
                + "           ,[TenQL]\n"
                + "           ,[SDT]\n"
                + "           ,[DiaChi])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ql.getMaQL());
            ps.setObject(2, ql.getTenQL());
            ps.setObject(3, ql.getSDT());
            ps.setObject(4, ql.getDiaChi());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[QuanLy]\n"
                + "      WHERE MaQL = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(QuanLyModel ql, String ma) {
        String query = "UPDATE [dbo].[QuanLy]\n"
                + "   SET \n"
                + "      [MaQL] = ?\n"
                + "      ,[TenQL] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + " WHERE MaQL = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ql.getMaQL());
            ps.setObject(2, ql.getTenQL());
            ps.setObject(3, ql.getSDT());
            ps.setObject(4, ql.getDiaChi());
            ps.setObject(5, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<SanPham> list = new SanPhamRepostory().getAll();
//        for (SanPham x : list) {
//            System.out.println(x.toString());
//        }
        QuanLyModel ql = new QuanLyModel("", "Ql123123", "Minhghhhhhhhh", "0123", "BN");
        boolean add = new QuanLyRepository().update(ql, "Ql123123");
        System.out.println(add);
    }
}
