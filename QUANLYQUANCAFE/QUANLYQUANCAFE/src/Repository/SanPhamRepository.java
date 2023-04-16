/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPhamModel;
import java.util.List;
import ViewModels.SanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Utilities.DBContext;
import ViewModels.DanhMuc;
import ViewModels.Size;

/**
 *
 * @author ACER
 */
public class SanPhamRepository {

    public List<SanPham> getAll() {
        String query = "SELECT MaSP, TenSP, Giaban, MoTa, DanhMuc.TenDM, TrangThai, Size FROM SanPham\n"
                + "INNER JOIN DanhMuc ON SanPham.IDDM = DanhMuc.ID\n"
                + "inner join Size on SanPham.IDSize = Size.ID";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), new DanhMuc(rs.getString(5)), rs.getString(6), new Size(rs.getString(7)));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> getAllTT() {
        String query = "SELECT MaSP, TenSP, Giaban, MoTa, DanhMuc.TenDM, TrangThai, Size FROM SanPham\n"
                + "INNER JOIN DanhMuc ON SanPham.IDDM = DanhMuc.ID\n"
                + "inner join Size on SanPham.IDSize = Size.ID\n"
                + "Where TrangThai like N'Đang bán'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), new DanhMuc(rs.getString(5)), rs.getString(6), new Size(rs.getString(7)));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> getAllKM() {
        String query = "SELECT MaSP, TenSP FROM SanPham";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
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

    public SanPham getOne(String ten) {
        String query = "SELECT SanPham.ID, MaSP, TenSP, Giaban, MoTa, DanhMuc.TenDM, TrangThai, Size FROM SanPham\n"
                + "INNER JOIN DanhMuc ON SanPham.IDDM = DanhMuc.ID\n"
                + "inner join Size on SanPham.IDSize = Size.ID\n"
                + "WHERE MaSP like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), new DanhMuc(rs.getString(6)), rs.getString(7), new Size(rs.getString(8)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> search(String ten) {
        String query = "SELECT MaSP, TenSP, Giaban, MoTa, DanhMuc.TenDM, TrangThai, Size FROM SanPham\n"
                + "INNER JOIN DanhMuc ON SanPham.IDDM = DanhMuc.ID\n"
                + "inner join Size on SanPham.IDSize = Size.ID\n"
                + "WHERE TenSP like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), new DanhMuc(rs.getString(5)), rs.getString(6), new Size(rs.getString(7)));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPham> searchTenDanhMuc(String tenDanhMuc) {
        String query = "SELECT MaSP, TenSP, Giaban, MoTa, DanhMuc.TenDM, TrangThai, Size FROM SanPham\n"
                + "INNER JOIN DanhMuc ON SanPham.IDDM = DanhMuc.ID\n"
                + "inner join Size on SanPham.IDSize = Size.ID\n"
                + "WHERE DanhMuc.TenDM like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + tenDanhMuc + "%");
            ResultSet rs = ps.executeQuery();
            List<SanPham> list = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), new DanhMuc(rs.getString(5)), rs.getString(6), new Size(rs.getString(7)));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(SanPhamModel sp) {
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([MaSP]\n"
                + "           ,[TenSP]\n"
                + "           ,[Giaban]\n"
                + "           ,[MoTa]\n"
                + "           ,[Anh]\n"
                + "           ,[IDSize]\n"
                + "           ,[IDDM]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getMoTa());
            ps.setObject(5, sp.getAnh());
            ps.setObject(6, sp.getIdSize());
            ps.setObject(7, sp.getIdDM());
            ps.setObject(8, sp.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[SanPham]\n"
                + "      WHERE MaSP = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPhamModel sp, String ma) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "   SET [MaSP] = ?\n"
                + "      ,[TenSP] =?\n"
                + "      ,[Giaban] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[Anh] = ?\n"
                + "      ,[IDSize] = ?\n"
                + "      ,[IDDM] =?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE MaSP = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaBan());
            ps.setObject(4, sp.getMoTa());
            ps.setObject(5, sp.getAnh());
            ps.setObject(6, sp.getIdSize());
            ps.setObject(7, sp.getIdDM());
            ps.setObject(8, sp.getTrangThai());
            ps.setObject(9, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addID(SanPhamModel sp, String ma) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "   SET [IDKM] = ?\n"
                + " WHERE MaSP like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getIdKM());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public SanPhamModel checkTrung(String maSp) {
        String query = "SELECT MASP FROM SANPHAM WHERE MASP = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maSp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel sp = new SanPhamModel(rs.getString(1));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepository().getAll();
        for (SanPham x : list) {
            System.out.println(x.toString());
        }
//        SanPhamModel sp = new SanPhamModel("SP05", "TranChau", 1110, "Ngon", "653342b5-baab-4e2f-84b5-774c27b80d63", "41cc728e-36a8-4362-8839-61d1c3c39395", "Đang bán");
//        boolean add = new SanPhamRepository().add(sp);
//        System.out.println(add);
//        SanPhamModel sp = new SanPhamModel("ae539fd9-0cd8-4818-addd-87cce30342d9");
//        SanPham add = new SanPhamRepository().getOne("SP1");
//        System.out.println(add);
//        List<SanPham> list = new SanPhamRepository().search("Kem");
//        for (SanPham x : list) {
//            System.out.println(x);
//        }
//        List<SanPham> list = new SanPhamRepository().searchTenDanhMuc("Topping");
//        for (SanPham x : list) {
//            System.out.println(x);
//        }
    }
}
