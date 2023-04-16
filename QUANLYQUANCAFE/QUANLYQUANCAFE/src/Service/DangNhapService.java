package Service;

import DomainModels.TaiKhoanModel;

public interface DangNhapService {

    TaiKhoanModel dangNhap(String username, String pass);
}
