/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuVucModel;
import Utilities.DBContext;
import ViewModels.KhuVuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhuVucRepostory {

    public List<KhuVuc> getAll() {
        String query = "SELECT [ID],[MaKV],[TenKV],[TrangThai]FROM [dbo].[KhuVuc]\n"
                + "order by TenKV";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<KhuVuc> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc ban = new KhuVuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ban);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<KhuVuc> Search(String ten) {
        String query = "SELECT [ID],[MaKV],[TenKV],[TrangThai]FROM [dbo].[KhuVuc]\n"
                + "Where TenKV like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            List<KhuVuc> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc ban = new KhuVuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ban);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<KhuVuc> SearchTT(String TrangThai) {
        String query = "SELECT [ID],[MaKV],[TenKV],[TrangThai]FROM [dbo].[KhuVuc]\n"
                + "Where TrangThai like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + TrangThai + "%");
            ResultSet rs = ps.executeQuery();
            List<KhuVuc> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc ban = new KhuVuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(ban);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public KhuVuc getOne(String ma) {
        String query = "SELECT [ID]\n"
                + "      ,[MaKV]\n"
                + "      ,[TenKV]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhuVuc]"
                + "Where TenKV like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhuVuc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhuVucModel kv) {
        String query = "INSERT INTO [dbo].[KhuVuc]\n"
                + "           ([MaKV]\n"
                + "           ,[TenKV]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kv.getMaKV());
            ps.setObject(2, kv.getTenKV());
            ps.setObject(3, kv.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[KhuVuc]\n"
                + "      WHERE MaKV = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KhuVucModel kv, String ma) {
        String query = "UPDATE [dbo].[KhuVuc]\n"
                + "   SET [MaKV] = ?\n"
                + "      ,[TenKV] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE MaKV like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kv.getMaKV());
            ps.setObject(2, kv.getTenKV());
            ps.setObject(3, kv.getTrangThai());
            ps.setObject(4, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {

//        List<KhuVuc> one = new KhuVucRepostory().Search("Tầng 1");
//        for (KhuVuc khuVuc : one) {
//            System.out.println(khuVuc.toString());
//        }

        KhuVucModel ban = new KhuVucModel("kv1", "k", "trong");
        boolean add = new KhuVucRepostory().add(ban);
        System.out.println(add);
    }
}
