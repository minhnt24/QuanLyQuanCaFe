package Repository;

import DomainModels.TaiKhoanModel;
import Utilities.DBContext;
import ViewModels.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DangNhapRepostory {

    public TaiKhoanModel dangNhap(String username, String pass){
        String query = "SELECT [Username]\n"
                + "      ,[Password]\n"
                + "      ,[Role]\n"
                + "  FROM [dbo].[Tai_khoan]\n"
                + "  where Username like ? and Password like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, username);
            ps.setObject(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoanModel(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args){
        TaiKhoanModel tk =  new DangNhapRepostory().dangNhap("nhanvien","123");
        System.out.println(tk);
    }
}
