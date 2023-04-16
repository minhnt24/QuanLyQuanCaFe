/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.DanhMucModel;
import Utilities.DBContext;
import ViewModels.DanhMuc;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class DanhMucRepository {

    public List<DanhMuc> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[TenDM]\n"
                + "  FROM [dbo].[DanhMuc]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<DanhMuc> list = new ArrayList<>();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc(rs.getString(1), rs.getString(2));
                list.add(dm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(DanhMucModel dm) {
        String query = "INSERT INTO [dbo].[DanhMuc]\n"
                + "           ([TenDM])\n"
                + "     VALUES\n"
                + "           (?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, dm.getTenDM());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(DanhMucModel dm, String id) {
        String query = "UPDATE [dbo].[DanhMuc]\n"
                + "   SET [TenDM] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, dm.getTenDM());
            ps.setString(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public DanhMuc getOne(String ten) {
        String query = "SELECT [ID]\n"
                + "      ,[TenDM]\n"
                + "  FROM [dbo].[DanhMuc]\n"
                + "  WHERE TenDM like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new DanhMuc(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean delete(String ID) {
        String query = "DELETE FROM [dbo].[DanhMuc]\n"
                + "      WHERE ID =?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<DanhMuc> list = new DanhMucRepository().getAll();
        for (DanhMuc x : list) {
            System.out.println(x);
        }
    }
}
