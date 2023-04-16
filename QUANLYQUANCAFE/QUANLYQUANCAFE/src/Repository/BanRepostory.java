package Repository;

import DomainModels.BanModel;
import DomainModels.Ban_HoaDonModel;
import DomainModels.KhuVucModel;
import DomainModels.SanPhamModel;
import Utilities.DBContext;
import ViewModels.Ban;
import ViewModels.KhuVuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BanRepostory {

    public List<Ban> getAll() {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV,TinhTrang\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv, rs.getString(6));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Ban getOne(String ten) {
        String query = "SELECT [ID]\n"
                + "  FROM [dbo].[Ban]\n"
                + "  Where [TenBan] like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Ban(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public BanModel checkTrung(String ma) {
        String query = "select MaBan from Ban where MaBan like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new BanModel(rs.getString(1), "");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> getAllTT() {
        String query = "Select TenBan,Loaiban,TinhTrang\n"
                + "From Ban \n";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> banTach() {
        String query = "Select TenBan,Loaiban,TinhTrang\n"
                + "From Ban\n"
                + "where TenBan like  N'% - tách' \n";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> Search(String ma) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV,TinhTrang\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where TenBan like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv, rs.getString(6));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> SearchKV(String TenKV) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV,TinhTrang\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where TenKV like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + TenKV + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv, rs.getString(6));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> SearchTen(String ten) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV,TinhTrang\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where TenBan like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv, rs.getString(6));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Ban> SearchLoaiBan(String loai) {
        String query = "Select MaBan,TenBan,Mota, Loaiban, TenKV,TinhTrang\n"
                + "From Ban \n"
                + "inner join KhuVuc on Ban.IDKV = KhuVuc.ID\n"
                + "where Loaiban like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + loai + "%");
            ResultSet rs = ps.executeQuery();
            List<Ban> list = new ArrayList<>();
            while (rs.next()) {
                KhuVuc kv = new KhuVuc(rs.getString(5));
                Ban ban = new Ban(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), kv, rs.getString(6));
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(BanModel ban) {
        String query = "INSERT INTO [dbo].[Ban]\n"
                + "           ([MaBan]\n"
                + "           ,[TenBan]\n"
                + "           ,[Mota]\n"
                + "           ,[Loaiban]\n"
                + "           ,[IDKV],[TinhTrang])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ban.getMaBan());
            ps.setObject(2, ban.getTenBan());
            ps.setObject(3, ban.getMoTa());
            ps.setObject(4, ban.getLoaiBan());
            ps.setObject(5, ban.getIDKV());
            ps.setObject(6, ban.getTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean tachBan(BanModel ban) {
        String query = "INSERT INTO [dbo].[Ban]\n"
                + "           ([MaBan]\n"
                + "           ,[TenBan]\n"
                + "           ,[Mota]\n"
                + "           ,[Loaiban]\n"
                + "           ,[IDKV],[TinhTrang])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ban.getMaBan());
            ps.setObject(2, ban.getTenBan());
            ps.setObject(3, ban.getMoTa());
            ps.setObject(4, ban.getLoaiBan());
            ps.setObject(5, ban.getIDKV());
            ps.setObject(6, ban.getTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean gopBan(String ten) {
        String query = "DELETE FROM [dbo].[Ban]\n"
                + "      WHERE TenBan = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ten);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[Ban]\n"
                + "      WHERE MaBan = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(BanModel ban, String ma) {
        String query = "UPDATE [dbo].[Ban]\n"
                + "   SET [MaBan] = ?\n"
                + "      ,[TenBan] = ?\n"
                + "      ,[Mota] = ?\n"
                + "      ,[Loaiban] = ?\n"
                + "      ,[IDKV] = ?\n"
                + ",[TinhTrang] = ?"
                + " WHERE MaBan like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ban.getMaBan());
            ps.setObject(2, ban.getTenBan());
            ps.setObject(3, ban.getMoTa());
            ps.setObject(4, ban.getLoaiBan());
            ps.setObject(5, ban.getIDKV());
            ps.setObject(6, ban.getTinhTrang());
            ps.setObject(7, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateTT(BanModel ban, String id) {
        String query = "UPDATE [dbo].[Ban]\n"
                + "   SET [TinhTrang] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ban.getTinhTrang());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<Ban> list = new BanRepostory().getAllTT();
//        for (Ban x : list) {
//            System.out.println(x.toString());
//        }
//        BanModel b = new BanRepostory().checkTrung("B1");
//        System.out.println(b);
        KhuVucModel kv = new KhuVucModel("Tâng 5");
        BanModel b = new BanModel("B5", "Bàn 5", "Tốt", "Lớn", "440fa864-3d5b-4b29-9c30-780fd44e60ff", kv, "Trống");
        boolean add = new BanRepostory().update(b, "B5");
        System.out.println(add);
    }
}
