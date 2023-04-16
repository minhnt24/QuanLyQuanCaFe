package Repository;

import DomainModels.SP_KM;
import Utilities.DBContext;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SP_KMRepostory {

    public boolean add(SP_KM ql) {
        String query = "INSERT INTO [dbo].[KhuyenMai_SanPham]\n"
                + "           ([IDSP]\n"
                + "           ,[IDKM])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ql.getIdSP());
            ps.setObject(2, ql.getIdKM());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        SP_KM s = new SP_KM("6a0c96e8-fe13-4e56-80b8-1a294978cc7b", "cdd453d1-a64b-4189-81a6-3b55a1f68430");
        boolean add = new SP_KMRepostory().add(s);
        System.out.println(add);
    }
}
