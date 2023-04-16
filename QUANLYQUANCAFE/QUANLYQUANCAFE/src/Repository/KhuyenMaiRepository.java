/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuyenMaiModel;
import Utilities.DBContext;
import ViewModels.KhuyenMai;
import ViewModels.SanPham;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vietv
 */
public class KhuyenMaiRepository {

    public List<KhuyenMai> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaKM]\n"
                + "      ,[TenKM]\n"
                + "      ,[HinhThucGG]\n"
                + "      ,[MucGiam]\n"
                + "      ,[TGBatDau]\n"
                + "      ,[TGKetThuc]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Mota]\n"
                + "  FROM [dbo].[KhuyenMai]";
        List<KhuyenMai> listKM = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listKM.add(km);
            }
            return listKM;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhuyenMai> getAllKMTT() {
        String query = "SELECT [ID]\n"
                + "      ,[MaKM]\n"
                + "      ,[TenKM]\n"
                + "      ,[HinhThucGG]\n"
                + "      ,[MucGiam]\n"
                + "      ,[TGBatDau]\n"
                + "      ,[TGKetThuc]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Mota]\n"
                + "  FROM [QuanLyQuanCafe].[dbo].[KhuyenMai]\n"
                + "  WHERE [TrangThai] LIKE N'Đang kích hoạt'";
        List<KhuyenMai> listKM = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listKM.add(km);
            }
            return listKM;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhuyenMai getOne(String ten) {
        String query = "SELECT [ID]\n"
                + "      ,[MaKM]\n"
                + "      ,[TenKM]\n"
                + "      ,[HinhThucGG]\n"
                + "      ,[MucGiam]\n"
                + "      ,[TGBatDau]\n"
                + "      ,[TGKetThuc]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Mota]\n"
                + "  FROM [dbo].[KhuyenMai]"
                + "Where TenKM like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPham> searchSP_KMTheoTen(String tenSP) {
        String query = "SELECT [MaSP]\n"
                + "      ,[TenSP]\n"
                + "  FROM [dbo].[SanPham]"
                + "WHERE TenSP like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + tenSP + "%");
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<KhuyenMai> searchMaKM(String maKM) {
        String query = "SELECT [ID]\n"
                + "      ,[MaKM]\n"
                + "      ,[TenKM]\n"
                + "      ,[HinhThucGG]\n"
                + "      ,[MucGiam]\n"
                + "      ,[TGBatDau]\n"
                + "      ,[TGKetThuc]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Mota]\n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  WHERE MaKM LIKE ?";
        List<KhuyenMai> listKM = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, "%" + maKM + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listKM.add(km);
            }
            return listKM;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhuyenMai> searchTheoHinhThucGG(String htgg) {
        String query = "SELECT [ID]\n"
                + "      ,[MaKM]\n"
                + "      ,[TenKM]\n"
                + "      ,[HinhThucGG]\n"
                + "      ,[MucGiam]\n"
                + "      ,[TGBatDau]\n"
                + "      ,[TGKetThuc]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Mota]\n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  WHERE HinhThucGG = ?";
        List<KhuyenMai> listKM = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, htgg);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listKM.add(km);
            }
            return listKM;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhuyenMai> searchTheoTrangThai(String tt) {
        String query = "SELECT [ID]\n"
                + "      ,[MaKM]\n"
                + "      ,[TenKM]\n"
                + "      ,[HinhThucGG]\n"
                + "      ,[MucGiam]\n"
                + "      ,[TGBatDau]\n"
                + "      ,[TGKetThuc]\n"
                + "      ,[TrangThai]\n"
                + "      ,[Mota]\n"
                + "  FROM [dbo].[KhuyenMai]\n"
                + "  WHERE TrangThai = ?";
        List<KhuyenMai> listKM = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                listKM.add(km);
            }
            return listKM;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(KhuyenMaiModel km) {
        int check = 0;
        String query = "INSERT INTO [dbo].[KhuyenMai]\n"
                + "           ([MaKM]\n"
                + "           ,[TenKM]\n"
                + "           ,[HinhThucGG]\n"
                + "           ,[MucGiam]\n"
                + "           ,[TGBatDau]\n"
                + "           ,[TGKetThuc]\n"
                + "           ,[TrangThai]\n"
                + "           ,[Mota])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, km.getMaKM());
            ps.setObject(2, km.getTenKM());
            ps.setObject(3, km.getHinhThucGG());
            ps.setObject(4, km.getMucGiam());
            ps.setObject(5, km.getTgBatDau());
            ps.setObject(6, km.getTgKetThuc());
            ps.setObject(7, km.getTrangThai());
            ps.setObject(8, km.getMoTa());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(KhuyenMaiModel km, String IDKM) {
        int check = 0;
        String query = "UPDATE [dbo].[KhuyenMai]\n"
                + "   SET [MaKM] = ?\n"
                + "      ,[TenKM] = ?\n"
                + "      ,[HinhThucGG] = ?\n"
                + "      ,[MucGiam] = ?\n"
                + "      ,[TGBatDau] = ?\n"
                + "      ,[TGKetThuc] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[Mota] = ?\n"
                + " WHERE ID = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, km.getMaKM());
            ps.setObject(2, km.getTenKM());
            ps.setObject(3, km.getHinhThucGG());
            ps.setObject(4, km.getMucGiam());
            ps.setObject(5, km.getTgBatDau());
            ps.setObject(6, km.getTgKetThuc());
            ps.setObject(7, km.getTrangThai());
            ps.setObject(8, km.getMoTa());
            ps.setObject(9, IDKM);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public KhuyenMaiModel checkTrung(String maKM) {
        String query = "SELECT MaKM FROM KhuyenMai WHERE MaKM = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMaiModel km = new KhuyenMaiModel(rs.getString(1));
                return km;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean xoa(String IDKM) {
        int check = 0;
        String query = "DELETE FROM [dbo].[KhuyenMai]\n"
                + "      WHERE ID = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, IDKM);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<KhuyenMai> show = new KhuyenMaiRepository().getAll();
        for (KhuyenMai x : show) {
            System.out.println(x);
        }
        KhuyenMai km = new KhuyenMaiRepository().getOne("King");
        System.out.println(km);
//        KhuyenMaiModel km = new KhuyenMaiModel("KM01", "Giam 10 k", "Giảm theo số tiền", "10000", "10/10/2022", "11/11/2022", "Đang kích hoạt", "null");
//        boolean add = new KhuyenMaiRepository().update(km, "KM02");
//        System.out.println(add);
    }
}
