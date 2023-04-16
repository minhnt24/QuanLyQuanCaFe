/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDonModel;
import Utilities.DBContext;
import ViewModels.Ban;
import ViewModels.HoaDon;
import ViewModels.HoaDonChiTiet;
import ViewModels.KhuyenMai;
import ViewModels.NhanVienViewModel;
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
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        String query = "SELECT MaHD, TenBan , TenNV , NgayLapHD , PhuongThucThanhToan , TenSP,Giaban,HDCT.Soluong ,TP.Topping,(SP.Giaban*Soluong) + TP.GiaTien  As ThanhTien,HD.TinhTrang\n"
                + "              FROM  Ban B JOIN HoaDon HD ON B.ID = HD.IDBan JOIN HoaDonChiTiet HDCT ON HD.ID = HDCT.IDHD JOIN\n"
                + "             SanPham SP ON HDCT.IDSP = SP.ID JOIN NhanVien NV ON HD.IDNV = NV.ID JOIN Topping TP ON HDCT.IDTopping = TP.ID\n"
                + "			 WHERE HD.TinhTrang LIKE N'Đã thanh toán' or HD.TinhTrang LIKE N'Huỷ'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                Ban ban = new Ban(rs.getString(2), "", "");
                NhanVienViewModel tenNV = new NhanVienViewModel(rs.getString(3));
                SanPham sp = new SanPham(rs.getString(6), rs.getDouble(7));
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(8));
                Topping tp = new Topping(rs.getString(9));
                HoaDon hd = new HoaDon(rs.getString(1), ban, tenNV, rs.getString(4), rs.getString(5), sp, tp, hdct, rs.getDouble(10), rs.getString(11));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllHD(String ma) {
        String query = "SELECT MaHD, TenBan , TenNV , NgayLapHD , PhuongThucThanhToan , TenSP,Giaban,HDCT.Soluong ,TP.Topping,(SP.Giaban*Soluong) + TP.GiaTien As ThanhTien,HD.TinhTrang\n"
                + "FROM  Ban B \n"
                + "inner JOIN HoaDon HD ON B.ID = HD.IDBan\n"
                + "inner JOIN HoaDonChiTiet HDCT ON HD.ID = HDCT.IDHD\n"
                + "inner JOIN SanPham SP ON HDCT.IDSP = SP.ID \n"
                + "inner JOIN NhanVien NV ON HD.IDNV = NV.ID \n"
                + "inner JOIN Topping TP ON HDCT.IDTopping = TP.ID\n"
                + "WHERE MaHD = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                Ban ban = new Ban(rs.getString(2), "", "");
                NhanVienViewModel tenNV = new NhanVienViewModel(rs.getString(3));
                SanPham sp = new SanPham(rs.getString(6), rs.getDouble(7));
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(8));
                Topping tp = new Topping(rs.getString(9));
                HoaDon hd = new HoaDon(rs.getString(1), ban, tenNV, rs.getString(4), rs.getString(5), sp, hdct, tp, rs.getDouble(10), rs.getString(11));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getListHD() {
        String query = "Select MaHD,NgayLapHD,TenSP,Soluong,(Giaban*Soluong)  + TP.GiaTien  As ThanhTien,TinhTrang from HoaDon\n"
                + "                inner join HoaDonChiTiet\n"
                + "                on HoaDon.ID = HoaDonChiTiet.IDHD\n"
                + "                inner join SanPham ON HoaDonChiTiet.IDSP = SanPham.ID\n"
                + "                inner join Topping TP ON HoaDonChiTiet.IDTopping = TP.ID\n"
                + "				where TinhTrang like N'Đã thanh toán'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(4));
                SanPham sp = new SanPham(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), sp, hdct, rs.getDouble(5), rs.getString(6));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> searchTheoTT(String tt) {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "WHERE TinhTrang LIKE ? ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, tt);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> searchTheoDate(String date1, String date2) {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "                from HoaDon \n"
                + "                inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "                WHERE NOT TinhTrang LIKE N'Chờ' and  \n"
                + "                NgayLapHD BETWEEN ? AND ? ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, date1);
            ps.setString(2, date2);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> searchTheoDate1(String date1, String date2) {
        String query = "Select MaHD,NgayLapHD,TenSP,Soluong,(Giaban*Soluong)  + TP.GiaTien  As ThanhTien,TinhTrang from HoaDon\n"
                + "                inner join HoaDonChiTiet\n"
                + "                on HoaDon.ID = HoaDonChiTiet.IDHD\n"
                + "                inner join SanPham ON HoaDonChiTiet.IDSP = SanPham.ID\n"
                + "                inner join Topping TP ON HoaDonChiTiet.IDTopping = TP.ID\n"
                + "		   where TinhTrang like N'Đã thanh toán' and"
                + "                NgayLapHD BETWEEN ? AND ? ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, date1);
            ps.setString(2, date2);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(4));
                SanPham sp = new SanPham(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), sp, hdct, rs.getDouble(5), rs.getString(6));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> searchTheoMaHD(String maHD) {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "                from HoaDon \n"
                + "                inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "                WHERE MaHD LIKE ? AND NOT TinhTrang LIKE N'Chờ'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, "%" + maHD + "%");
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public HoaDon getOne(String ma) {
        String query = "Select HoaDon.ID, MaHD,NgayLapHD,TenNV, TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV where MaHD like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(4));
                return new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), nv, rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllTT() {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllViewHD() {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "WHERE TinhTrang LIKE N'Đã thanh toán' or TinhTrang LIKE N'Huỷ'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllSearchTheoDate(String date1, String date2) {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "from HoaDon \n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "WHERE TinhTrang LIKE N'Đã thanh toán' or TinhTrang LIKE N'Hủy'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllHDCho() {
        String query = "Select MaHD,NgayLapHD,TenNV,TinhTrang\n"
                + "from HoaDon\n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "WHERE TinhTrang like N'Chờ'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getAllTTViewHD(String id) {
        String query = "Select MaHD,NgayLapHD,TenNV, hoadon.TinhTrang\n"
                + "from HoaDon\n"
                + "inner join NhanVien on NhanVien.ID = HoaDon.IDNV\n"
                + "inner join Ban on HoaDon.IDBan = Ban.ID\n"
                + "Where IDBan like ? and hoadon.TinhTrang like N'Chờ'";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), nv, rs.getString(4));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> search(String date) {
        String query = "Select MaHD,NgayLapHD,TenSP,Soluong,(Giaban*Soluong)  + TP.GiaTien  As ThanhTien from HoaDon\n"
                + "                inner join HoaDonChiTiet\n"
                + "               on HoaDon.ID = HoaDonChiTiet.IDHD\n"
                + "               inner join SanPham ON HoaDonChiTiet.IDSP = SanPham.ID\n"
                + "               inner join Topping TP ON HoaDonChiTiet.IDTopping = TP.ID\n"
                + "                WHERE MaHD like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + date + "%");
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(4));
                SanPham sp = new SanPham(rs.getString(3));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), sp, hdct, rs.getDouble(5));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonModel hd, String ma) {
        String query = "INSERT INTO [dbo].[HoaDon]([MaHD],[NgayLapHD],[IDNV],[IDBan],[TinhTrang])\n"
                + "VALUES('HD'+?,GETDATE(),'5dc424c8-d86a-4aa9-9b6a-399678fd5ae5',?,N'Chờ')";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ps.setObject(2, hd.getIDBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HoaDonModel hd, String ma, String tinhTrang) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [MaHD] = ?\n"
                + "      ,[TinhTrang] = ?\n"
                + " WHERE MaHD = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, tinhTrang);
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSL(HoaDonModel hd, String ma, String tinhTrang) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [MaHD] = ?\n"
                + "      ,[TinhTrang] = ?\n"
                + " WHERE MaHD = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, tinhTrang);
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateID(String id, String maHD) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [IDBan] = ?\n"
                + " WHERE MaHD like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ps.setObject(2, maHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ID) {
        String query = "DELETE FROM [dbo].[HoaDon]\n"
                + "      WHERE  MaHD=?";
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
//        List<HoaDon> rp = new HoaDonRepository().getAllTT();
//        for (HoaDon hoaDon : rp) {
//            System.out.println(hoaDon.toString());
//        }
//        HoaDonModel hd = new HoaDonModel("HD1", "1");
//        boolean add = new HoaDonRepository().updateID("15d13f6e-71b8-44be-8560-213d2f84002a", "HD31");
//        System.out.println(add);
//        boolean hd = new HoaDonRepository().delete("HD40");
//        System.out.println(hd);
        List<HoaDon> getall = new Repository.HoaDonRepository().getAll();
        for (HoaDon x : getall) {
            System.out.println(x.toString());
        }
    }
}
