/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhanVienModel;
import Utilities.DBContext;
import ViewModels.NhanVienViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdo48
 */
public class NhanVienRepository {

    public List<NhanVienViewModel> getAll() {
        String query = "SELECT dbo.NhanVien.ID, dbo.NhanVien.MaNV, dbo.NhanVien.TenNV, dbo.NhanVien.NgaySinh, dbo.NhanVien.SDT, dbo.ChucVu.TenCV, dbo.NhanVien.TrangThai, dbo.NhanVien.GioiTinh, dbo.NhanVien.Diachi\n"
                + "FROM   dbo.NhanVien INNER JOIN\n"
                + "             dbo.ChucVu ON dbo.NhanVien.IDCV = dbo.ChucVu.ID";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<NhanVienViewModel> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nhanVienViewModel = new NhanVienViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9));

                list.add(nhanVienViewModel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NhanVienModel nhanVien) {
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([MaNV]\n"
                + "           ,[TenNV]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[SDT]\n"
                + "           ,[IDCV]\n"
                + "           ,[TrangThai]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[Diachi])\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nhanVien.getMaNV());
            ps.setObject(2, nhanVien.getTenNV());
            ps.setObject(3, nhanVien.getNgaySinh());
            ps.setObject(4, nhanVien.getSDT());
            ps.setObject(5, nhanVien.getIdCV());
            ps.setObject(6, nhanVien.isTrangThai());
            ps.setObject(7, nhanVien.isGioiTinh());
            ps.setObject(8, nhanVien.getDiaChi());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[NhanVien]\n"
                + "      WHERE ID=?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(NhanVienModel nhanVien, String id) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [MaNV] = ?\n"
                + "      ,[TenNV] =?\n"
                + "      ,[NgaySinh] =?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[IDCV] = ?\n"
                + "      ,[TrangThai] =? \n"
                + "      ,[GioiTinh] =?\n"
                + "      ,[Diachi] = ?\n"
                + " WHERE ID=?";
        int check = 0;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nhanVien.getMaNV());
            ps.setObject(2, nhanVien.getTenNV());
            ps.setObject(3, nhanVien.getNgaySinh());
            ps.setObject(4, nhanVien.getSDT());
            ps.setObject(5, nhanVien.getIdCV());
            ps.setObject(6, nhanVien.isTrangThai());
            ps.setObject(7, nhanVien.isGioiTinh());
            ps.setObject(8, nhanVien.getDiaChi());
            ps.setObject(9, id);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<NhanVienViewModel> timkiem(String ma) {
        String sql = "SELECT dbo.NhanVien.ID, dbo.NhanVien.MaNV, dbo.NhanVien.TenNV, dbo.NhanVien.NgaySinh, dbo.NhanVien.SDT, dbo.ChucVu.TenCV, dbo.NhanVien.TrangThai, dbo.NhanVien.GioiTinh, dbo.NhanVien.Diachi\n"
                + "FROM   dbo.NhanVien INNER JOIN\n"
                + "             dbo.ChucVu ON dbo.NhanVien.IDCV = dbo.ChucVu.ID\n"
                + "			 where MaNV=?";
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();

            List<NhanVienViewModel> LISTs = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nhanVienViewModel = new NhanVienViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9));

                LISTs.add(nhanVienViewModel);
            }
            return LISTs;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public List<NhanVienViewModel> locchucvu(String ten) {
        String sql = "SELECT dbo.NhanVien.ID, dbo.NhanVien.MaNV, dbo.NhanVien.TenNV, dbo.NhanVien.NgaySinh, dbo.NhanVien.SDT, dbo.ChucVu.TenCV, dbo.NhanVien.TrangThai, dbo.NhanVien.GioiTinh, dbo.NhanVien.Diachi\n"
                + "FROM   dbo.NhanVien INNER JOIN\n"
                + "             dbo.ChucVu ON dbo.NhanVien.IDCV = dbo.ChucVu.ID\n"
                + "			 where ChucVu.TenCV=?";
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();

            List<NhanVienViewModel> LISTloc = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nhanVienViewModel = new NhanVienViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9));

                LISTloc.add(nhanVienViewModel);
            }
            return LISTloc;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public NhanVienModel checkTrung(String manv) {
        String query = "select MaNV from NhanVien where MaNV=?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, manv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienModel sp = new NhanVienModel(rs.getString(1));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().update(new NhanVienModel("E79BE21E-2BCE-4D20-9C70-1882E94A3EE5", "manv6", "hu", "01-11-2003", "0345571727", "F7724F02-E050-487B-901C-678E11B29A64", true, true, "ha noi"), "E79BE21E-2BCE-4D20-9C70-1882E94A3EE5"));
    }

}
