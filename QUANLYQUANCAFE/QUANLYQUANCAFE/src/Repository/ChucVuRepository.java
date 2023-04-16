/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChucVu;

import Utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdo48
 */
public class ChucVuRepository {

    public List<ChucVu> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaCV]\n"
                + "      ,[TenCV]\n"
                + "  FROM [dbo].[ChucVu]";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ChucVu> list = new ArrayList<>();
            while (rs.next()) {
                ChucVu chucVu = new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(chucVu);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(ChucVu chucVu) {
        String query = "INSERT INTO [dbo].[ChucVu]\n"
                + "           (\n"
                + "           [MaCV]\n"
                + "           ,[TenCV])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chucVu.getMacv());
            ps.setObject(2, chucVu.getTenCV());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChucVu chucVu, String id) {
        String query = "UPDATE [dbo].[ChucVu]\n"
                + "   SET \n"
                + "      [MaCV] =?\n"
                + "      ,[TenCV] =? \n"
                + " WHERE ID=?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chucVu.getMacv());
            ps.setObject(2, chucVu.getTenCV());
            ps.setObject(3, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

   
   
}
