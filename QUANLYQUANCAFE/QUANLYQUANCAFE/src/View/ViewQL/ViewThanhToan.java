/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import View.ViewNV.*;
import View.ViewQL.*;
import DomainModels.BanModel;
import DomainModels.HoaDonChiTietModel;
import DomainModels.HoaDonModel;
import DomainModels.KhuVucModel;
import DomainModels.KhuyenMaiModel;
import View.ViewNV.*;
import Service.impl.BanServiceImpl;
import Service.impl.DanhMucServiceImpl;
import Service.impl.HoaDonChiTietServiceIblm;
import Service.impl.HoaDonServiceIblm;
import Service.impl.KhuyenMaiServiceIblm;
import Service.impl.NhanVienServiceImpl;
import Service.impl.SanPhamServiceImpl;
import Service.impl.ToppingServiceImpl;
import ViewModels.Ban;
import ViewModels.DanhMuc;
import ViewModels.HoaDon;
import ViewModels.HoaDonChiTiet;
import ViewModels.KhuVuc;
import ViewModels.KhuyenMai;
import ViewModels.NhanVienViewModel;
import ViewModels.SanPham;
import ViewModels.Topping;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewThanhToan extends javax.swing.JInternalFrame implements Runnable, ThreadFactory {
//----------webcam---------------||

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private DefaultTableModel dtmBan = new DefaultTableModel();
    private DefaultTableModel dtmGioHang = new DefaultTableModel();
    private DefaultTableModel dtmSanPham = new DefaultTableModel();
    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultTableModel dtmCB = new DefaultTableModel();
    private DefaultComboBoxModel boxModelGG = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDM = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelTP = new DefaultComboBoxModel();
    private List<Ban> listBan = new ArrayList<>();
    private List<DanhMuc> listDM = new ArrayList<>();
    private List<Topping> listTP = new ArrayList<>();
    private List<NhanVienViewModel> listNV = new ArrayList<>();
    private List<KhuyenMai> listKhuyenMai = new ArrayList<>();
    private List<HoaDon> listHoaDon = new ArrayList<>();
    private List<SanPham> listSanPham = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private KhuyenMaiServiceIblm implKM = new KhuyenMaiServiceIblm();
    private BanServiceImpl implBan = new BanServiceImpl();
    private SanPhamServiceImpl implSP = new SanPhamServiceImpl();
    private HoaDonServiceIblm implHD = new HoaDonServiceIblm();
    private NhanVienServiceImpl implNV = new NhanVienServiceImpl();
    private HoaDonChiTietServiceIblm implHDCT = new HoaDonChiTietServiceIblm();
    private DefaultComboBoxModel boxKM = new DefaultComboBoxModel();
    private DanhMucServiceImpl implDM = new DanhMucServiceImpl();
    private ToppingServiceImpl implTP = new ToppingServiceImpl();
    private Color defaulColor = new Color(250, 250, 250);

    /**
     * Creates new form Menu1
     */
    public ViewThanhToan() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        
        String[] headersBan = {"Tên bàn", "Loại bàn", "Trạng thái"};
        tbBan.setModel(dtmBan);
        dtmBan.setColumnIdentifiers(headersBan);
        listBan = implBan.getAllTT();
        showDataBan(listBan);
        
        String[] headersHD = {"Mã HD", "Ngày lập", "Nhân viên", "Trạng thái"};
        tbHD.setModel(dtmHoaDon);
        dtmHoaDon.setColumnIdentifiers(headersHD);
        showDataHD(listHoaDon);
        
        tbSP.setModel(dtmSanPham);
        String[] headersSP = {"Mã SP", "Tên SP", "Giá Bán", "Danh Mục", "Trạng Thái", "Mô tả", "Size"};
        dtmSanPham.setColumnIdentifiers(headersSP);
        listSanPham = implSP.getAllTT();
        showDataSP(listSanPham);

//        String[] headersCB = {"ID", "Mã CB", "Tên CB", "Giá bán"};
//        tbHD1.setModel(dtmCB);
//        dtmCB.setColumnIdentifiers(headersCB);
//        listCB = implCB.get_all();
//        showDataCB(listCB);
        String[] headersGH = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Topping", "Tổng tiền"};
        tbGH.setModel(dtmGioHang);
        dtmGioHang.setColumnIdentifiers(headersGH);
//        listHDCT = implHDCT.getAll();
        showDataHDCT(listHDCT);
        
        listKhuyenMai = implKM.getAllKMTT();
        boxModelGG.addElement("Chọn");
        cbbGG.setModel(boxModelGG);
        for (KhuyenMai x : listKhuyenMai) {
            boxModelGG.addElement(x.getMaKM());
        }
        listDM = implDM.getAll();
        boxModelDM.addElement("All");
        cbbLocDanhMuc.setModel(boxModelDM);
        for (DanhMuc danhMuc : listDM) {
            boxModelDM.addElement(danhMuc.getTenDanhMuc());
        }
        
        listTP = implTP.getAll();
        cbbTopping.setModel(boxModelTP);
        for (Topping tp : listTP) {
            boxModelTP.addElement(tp.getTopping());
        }
    }

//    public String Fomat(double gia) {
//        Locale locale = new Locale("vi", "VN");
////        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
////        format.setRoundingMode(RoundingMode.HALF_UP);
//        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
//        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
//        decimalFormatSymbols.setGroupingSeparator(',');
//        decimalFormatSymbols.setCurrencySymbol("");
//        format.setDecimalFormatSymbols(decimalFormatSymbols);
//        return format.format(gia);
//    }
    private void showDataHDCT(List<HoaDonChiTiet> list) {
        dtmGioHang.setRowCount(0);
        for (HoaDonChiTiet x : list) {
            dtmGioHang.addRow(new Object[]{x.getIdSP().getMaSP(), x.getIdSP().getTenSP(), x.getSoLuong(), x.getIdSP().getGiaBan(), x.getIdTopping().getTopping(), x.getGiaTien()});
        }
    }
    
    private void showDataBan(List<Ban> list) {
        dtmBan.setRowCount(0);
        for (Ban x : list) {
            dtmBan.addRow(x.toRowDataTT());
        }
    }
    
    private void clear() {
        txtBan.setText("__");
        txtMa.setText("__");
        txtNgay.setText("__");
        txtNhanVien.setText("__");
        cbbGG.setSelectedIndex(0);
        txtTongTien.setText("0");
        txtTienGiam.setText("0");
        txtTienKhachTra.setText("");
        txtGiaTopping.setText("0");
        txtTienThua.setText("0");
    }
    
    private void showDataSP(List<SanPham> list) {
        dtmSanPham.setRowCount(0);
        for (SanPham sp : list) {
            dtmSanPham.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getGiaBan(), sp.getDanhMuc().getTenDanhMuc(), sp.getTrangThai(), sp.getMoTa(), sp.getSize().getSize()});
        }
    }
    
    private void showDataHD(List<HoaDon> list) {
        dtmHoaDon.setRowCount(0);
        for (HoaDon x : list) {
            dtmHoaDon.addRow(new Object[]{x.getMaHD(), x.getNgayLapHD(), x.getTenNV().getTenNV(), x.getTinhTrang()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puBan = new javax.swing.JPopupMenu();
        gopBan = new javax.swing.JMenuItem();
        tachBan = new javax.swing.JMenuItem();
        reset = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        updateSL = new javax.swing.JMenuItem();
        xoaSP = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        tachHD = new javax.swing.JMenuItem();
        gopHD = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        btMo = new javax.swing.JMenuItem();
        btDong = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbGH = new javax.swing.JTable();
        cbbTopping = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btDoi = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbSP = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtSearchTenSP = new javax.swing.JTextField();
        cbbLocDanhMuc = new javax.swing.JComboBox<>();
        PHoaDon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bltThanhToan = new javax.swing.JButton();
        btHuyDon = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbbGG = new javax.swing.JComboBox<>();
        txtTongTien = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbInHD = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPrint = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtTienGiam = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTenSP = new javax.swing.JLabel();
        txtSoL = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtGiaTopping = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtFake = new javax.swing.JTextField();

        gopBan.setText("Gộp bàn");
        gopBan.setToolTipText("");
        gopBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gopBanActionPerformed(evt);
            }
        });
        puBan.add(gopBan);

        tachBan.setText("Tách bàn");
        tachBan.setToolTipText("");
        tachBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachBanActionPerformed(evt);
            }
        });
        puBan.add(tachBan);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        puBan.add(reset);

        updateSL.setText("Update số lượng");
        updateSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSLActionPerformed(evt);
            }
        });
        jPopupMenu1.add(updateSL);

        xoaSP.setText("Xoá sản phẩm");
        xoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaSPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(xoaSP);

        tachHD.setText("Tách HD");
        tachHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachHDActionPerformed(evt);
            }
        });
        jPopupMenu2.add(tachHD);

        gopHD.setText("Gộp HD");
        gopHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gopHDActionPerformed(evt);
            }
        });
        jPopupMenu2.add(gopHD);

        btMo.setText("Mở");
        btMo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoActionPerformed(evt);
            }
        });
        jPopupMenu3.add(btMo);

        btDong.setText("Đóng");
        btDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDongActionPerformed(evt);
            }
        });
        jPopupMenu3.add(btDong);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tbGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbGH.setComponentPopupMenu(jPopupMenu1);
        tbGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbGH);

        cbbTopping.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Chọn topping");

        btDoi.setBackground(new java.awt.Color(255, 255, 255));
        btDoi.setText("Đổi");
        btDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbbTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDoi)
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btDoi))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tbSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSPMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbSP);

        jLabel12.setText("TÌM KIẾM SẢN PHẨM:");

        txtSearchTenSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTenSPKeyReleased(evt);
            }
        });

        cbbLocDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLocDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocDanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSearchTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        PHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin thanh toán")));
        PHoaDon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PHoaDonMouseMoved(evt);
            }
        });

        jLabel2.setText("Mã hoá đơn");

        txtMa.setText("__");

        jLabel3.setText("Bàn");

        txtBan.setText("__");

        jLabel5.setText("Nhân viên");

        txtNhanVien.setText("__");

        jLabel8.setText("Ngày");

        txtNgay.setText("__");

        jLabel4.setText("Tổng tiền");

        jLabel7.setText("Tiền khách trả");

        txtTienKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachTraKeyReleased(evt);
            }
        });

        jLabel6.setText("Tiền thừa");

        bltThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        bltThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bltThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pay-per-click (1).png"))); // NOI18N
        bltThanhToan.setText("Thanh toán");
        bltThanhToan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bltThanhToanMouseMoved(evt);
            }
        });
        bltThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltThanhToanActionPerformed(evt);
            }
        });

        btHuyDon.setBackground(new java.awt.Color(255, 255, 255));
        btHuyDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btHuyDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/remove (2).png"))); // NOI18N
        btHuyDon.setText("Huỷ đơn");
        btHuyDon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btHuyDonMouseMoved(evt);
            }
        });
        btHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyDonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add (1) (1) (1).png"))); // NOI18N
        jButton2.setText("Tạo hoá đơn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Mã giảm giá");
        jLabel11.setToolTipText("");

        cbbGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGGActionPerformed(evt);
            }
        });

        txtTongTien.setText("0");

        txtTienThua.setText("0");

        jLabel9.setText("VND");

        jLabel10.setText("VND");

        cbInHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbInHD.setText("In hóa đơn");

        txtPrint.setColumns(20);
        txtPrint.setRows(5);
        jScrollPane1.setViewportView(txtPrint);

        jLabel13.setText("Mức giảm:");

        txtTienGiam.setText("0");

        jLabel14.setText("VND");

        txtTenSP.setText("jLabel15");

        txtSoL.setText("jLabel15");

        txtDonGia.setText("jLabel15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSoL))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSP)
                            .addComponent(txtDonGia))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDonGia))
        );

        jLabel15.setText("Giá topping");

        txtGiaTopping.setText("0");

        jLabel16.setText("VND");

        javax.swing.GroupLayout PHoaDonLayout = new javax.swing.GroupLayout(PHoaDon);
        PHoaDon.setLayout(PHoaDonLayout);
        PHoaDonLayout.setHorizontalGroup(
            PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHoaDonLayout.createSequentialGroup()
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(PHoaDonLayout.createSequentialGroup()
                                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel13))
                                        .addGap(25, 25, 25)
                                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNgay)
                                            .addComponent(txtNhanVien)
                                            .addComponent(txtBan)
                                            .addComponent(txtMa)
                                            .addComponent(cbbGG, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11))
                                .addGap(15, 15, 15)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(PHoaDonLayout.createSequentialGroup()
                                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel10))
                                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PHoaDonLayout.createSequentialGroup()
                                        .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14))
                                    .addGroup(PHoaDonLayout.createSequentialGroup()
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(PHoaDonLayout.createSequentialGroup()
                                        .addComponent(txtGiaTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))))
                            .addGroup(PHoaDonLayout.createSequentialGroup()
                                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bltThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btHuyDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PHoaDonLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbInHD)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PHoaDonLayout.setVerticalGroup(
            PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHoaDonLayout.createSequentialGroup()
                .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBan))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNhanVien))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNgay))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbbGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTongTien)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTienGiam)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtGiaTopping)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTienThua)
                            .addComponent(jLabel10))
                        .addGap(19, 19, 19)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btHuyDon)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(PHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bltThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbInHD))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bàn"));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBan.setComponentPopupMenu(puBan);
        tbBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbBan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá đơn"));

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHD.setComponentPopupMenu(jPopupMenu2);
        tbHD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbHD);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setComponentPopupMenu(jPopupMenu3);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 170));
        jPanel5.add(txtFake, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 260, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1093, 769);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachTraKeyReleased
        try {
            for (KhuyenMai x : listKhuyenMai) {
                if (cbbGG.getSelectedItem() == x.getMaKM()) {
//                    txtTienGiam.setText(String.valueOf(x.getMucGiam()));
                    Double tienTP = Double.valueOf(txtGiaTopping.getText());
                    Double tienGiam = Double.valueOf(txtTienGiam.getText());
                    Double tien = Double.valueOf(txtTongTien.getText());
                    Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
                    Double tienThua = tienKhach - tien;
                    txtTienThua.setText(String.valueOf(tienThua));
                } else if (cbbGG.getSelectedItem() == "Chọn") {
                    Double tienTP = Double.valueOf(txtGiaTopping.getText());
                    Double tien = Double.valueOf(txtTongTien.getText());
                    Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
                    Double tienThua = tienKhach - tien;
                    txtTienThua.setText(String.valueOf(tienThua));
                }
            }
        } catch (Exception e) {
            txtTienThua.setText("0");
        }
    }//GEN-LAST:event_txtTienKhachTraKeyReleased

    private void tbSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSPMouseClicked
        try {
            int rowSP = tbSP.getSelectedRow();
            String maSP = tbSP.getValueAt(rowSP, 0).toString();
            SanPham sp = implSP.getOne(maSP);
            HoaDon idHD = implHD.getOne(txtMa.getText());
            String id = sp.getId();
            String tp = cbbTopping.getSelectedItem().toString();
            int slt = Integer.parseInt(JOptionPane.showInputDialog("Mời bạn nhập số lượng:"));
            if (slt <= 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập đúng định dạng");
                return;
            }
            for (int i = 0; i < tbGH.getRowCount(); i++) {
                String maSPGH = tbGH.getValueAt(i, 0).toString();
                Integer sl = Integer.valueOf(tbGH.getValueAt(i, 2).toString());
                if (maSP.equalsIgnoreCase(maSPGH)) {
                    HoaDonChiTietModel hdct = new HoaDonChiTietModel(slt + sl);
                    implHDCT.update(hdct, idHD.getID(), id);
                    listHDCT = implHDCT.getAllviewGH(idHD.getID());
                    showDataHDCT(listHDCT);
                }
            }
            if (txtMa.getText() == "__") {
                JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn");
            } else {
//                    int rowSP = tbSP.getSelectedRow();
//                    String maSP = tbSP.getValueAt(rowSP, 0).toString();
//                    SanPham sp = implSP.getOne(maSP);
//                    HoaDon idHD = implHD.getOne(txtMa.getText());
//                    String id = sp.getId();
//                    String tp = cbbTopping.getSelectedItem().toString();
                Topping idtp = implTP.getOne(tp);
                HoaDonChiTietModel hdct = new HoaDonChiTietModel(id, idHD.getID(), slt, "2dfc770d-1309-4186-8497-a1770d96a2b3");
                implHDCT.add(hdct);
                listHDCT = implHDCT.getAllviewGH(idHD.getID());
                showDataHDCT(listHDCT);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bỏ chọn sản phẩm");
        }
    }//GEN-LAST:event_tbSPMouseClicked

    private void tbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseClicked
        int row = tbHD.getSelectedRow();
        fillDataHD(row);
        String ma = tbHD.getValueAt(row, 0).toString();
        HoaDon hd = implHD.getOne(ma);
        listHDCT = implHDCT.getAllviewGH(hd.getID());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_tbHDMouseClicked

    private void tbGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGHMouseClicked
        int row = tbGH.getSelectedRow();
        fillDataGH(row);
        double tong = 0;
        double tienTP = 0;
        for (int i = 0; i < tbGH.getRowCount(); i++) {
            Double tien = Double.valueOf(tbGH.getValueAt(i, 5).toString());
            tong += tien;
            String tp = tbGH.getValueAt(i, 4).toString();
            Topping top = implTP.getOne(tp);
            tienTP += top.getGia();
        }
        double tongTien = tong;
        txtTongTien.setText(String.valueOf(tongTien));
        txtGiaTopping.setText(String.valueOf(tienTP));
    }//GEN-LAST:event_tbGHMouseClicked
    private void tbBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMouseClicked
        int row = tbBan.getSelectedRow();
        fillDataBan(row);
        String ten = tbBan.getValueAt(row, 0).toString();
        Ban b = implBan.getOne(ten);
        listHoaDon = implHD.getAllTTViewHD(b.getId());
        showDataHD(listHoaDon);
    }//GEN-LAST:event_tbBanMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtBan.getText() == "__") {
            JOptionPane.showMessageDialog(this, "Chưa chọn bàn");
        } else if (tbHD.getRowCount() >= 1) {
            JOptionPane.showMessageDialog(this, "Bàn đang có người sử dụng");
        } else {
            Ban b = implBan.getOne(txtBan.getText());
            Random r = new Random();
            int x = r.nextInt(100);
            long millis = System.currentTimeMillis();
            String name;
            HoaDonModel hd = new HoaDonModel(b.getId());
            implHD.add(hd, x + "");
            BanModel b2 = new BanModel("Đang sử dụng");
            implBan.updateTT(b2, b.getId());
            listBan = implBan.getAllTT();
            showDataBan(listBan);
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void gopBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gopBanActionPerformed
        Ban b = new Ban("", txtBan.getText());
        ViewNhanVien v2 = new ViewNhanVien();
        ViewTachBan v = new ViewTachBan(v2, true, b);
        v.setVisible(true);
    }//GEN-LAST:event_gopBanActionPerformed

    private void txtSearchTenSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTenSPKeyReleased
        if (txtSearchTenSP.getText().equalsIgnoreCase("")) {
            showDataSP(listSanPham);
        } else {
            List<SanPham> searchTenSP = implSP.search(txtSearchTenSP.getText());
            showDataSP(searchTenSP);
        }
    }//GEN-LAST:event_txtSearchTenSPKeyReleased

    private void bltThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltThanhToanActionPerformed
        if (cbInHD.isSelected() == true) {
            int row1 = tbGH.getSelectedRow();
            String maGH = tbGH.getValueAt(row1, 0).toString();
            HoaDonChiTiet hd1 = implHDCT.getOne(maGH);
            Double tien = Double.valueOf(txtTongTien.getText());
            Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
            Double tienThua = tienKhach - tien;
            if (tienThua >= 0) {
                if (tbHD.getRowCount() <= 1) {
                    txtPrint.append("\t\tHÓA ĐƠN THANH TOÁN \n\n"
                            + "\t\t   Mã Hóa Đơn:  " + txtMa.getText() + "\n"
                            + "+++--------------------------------------------------------------------------------------------------------+++\n"
                            + "\tBàn:\t\t\t" + txtBan.getText() + "\n"
                            + "\tNhân Viên:\t\t\t" + txtNhanVien.getText() + "\n"
                            + "\tNgày:\t\t\t" + txtNgay.getText() + "\n\n"
                            + "\tTên Mặt Hàng:" + "   Đơn Giá:   " + "\tSố Lượng:   " + "\tTopping:   "
                            + "\n_______________________________________________________________________________________________________________\n"
                    );
                    
                    DefaultTableModel mdpr = new DefaultTableModel();
                    mdpr = (DefaultTableModel) tbGH.getModel();
                    txtPrint.setText(txtPrint.getText());
                    for (int i = 0; i < mdpr.getRowCount(); i++) {
                        String tenSP = mdpr.getValueAt(i, 1).toString();
                        String soL = mdpr.getValueAt(i, 2).toString();
                        String donG = mdpr.getValueAt(i, 3).toString();
                        String tenTP = mdpr.getValueAt(i, 4).toString();
                        txtPrint.setText(txtPrint.getText() + "\t" + tenSP + "\t   " + donG + "\t" + soL + "\t" + tenTP + "\n");
                    }
                    txtPrint.setText(txtPrint.getText()
                            + "________________________________________________________________________________________________\n"
                            + "\tMã Giảm Giá:\t\t\t" + cbbGG.getSelectedItem().toString() + "\n"
                            + "\tMức Giảm:\t\t\t" + txtTienGiam.getText() + " " + "VND" + "\n"
                            + "\tGiá Topping:\t\t\t" + txtGiaTopping.getText() + " " + "VND" + "\n"
                            + "================================================================================\n"
                            + "\tTổng tiền:\t\t\t" + txtTongTien.getText() + " " + "VND" + "\n\n\n"
                            + "           +++++++=====CHÚC QUÝ KHÁCH 1 NGÀY TỐT LÀNH !=====+++++++");
                    try {
                        txtPrint.print();
                    } catch (PrinterException ex) {
                        Logger.getLogger(ViewThanhToan.class.getName()).log(Level.SEVERE, "In thất bại!", ex);
                        JOptionPane.showMessageDialog(this, "In thất bại !");
                    }
                    JOptionPane.showMessageDialog(this, "In thành công!");
                    
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    BanModel b2 = new BanModel("Trống");
                    implBan.updateTT(b2, b.getId());
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listBan = implBan.getAllTT();
                    showDataBan(listBan);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
                } else {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không đủ tiền");
            }
            
        } else {
            int row1 = tbGH.getSelectedRow();
            String maGH = tbGH.getValueAt(row1, 0).toString();
            HoaDonChiTiet hd1 = implHDCT.getOne(maGH);
            Double tien = Double.valueOf(txtTongTien.getText());
            Double tienKhach = Double.valueOf(txtTienKhachTra.getText());
            Double tienThua = tienKhach - tien;
            if (tienThua >= 0) {
                if (tbHD.getRowCount() <= 1) {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    BanModel b2 = new BanModel("Trống");
                    implBan.updateTT(b2, b.getId());
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listBan = implBan.getAllTT();
                    showDataBan(listBan);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
                } else {
                    String ma = txtMa.getText();
                    HoaDonModel hd = new HoaDonModel(ma, ma);
                    JOptionPane.showMessageDialog(this, implHD.update(hd, ma, "Đã thanh toán"));
//                    int row = tbBan.getSelectedRow();
//                    String ten = tbBan.getValueAt(row, 0).toString();
                    String ten = txtBan.getText();
                    Ban b = implBan.getOne(ten);
                    listHoaDon = implHD.getAllTTViewHD(b.getId());
                    showDataHD(listHoaDon);
                    listHDCT.clear();
                    showDataHDCT(listHDCT);
                    clear();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không đủ tiền");
            }
            
        }
    }//GEN-LAST:event_bltThanhToanActionPerformed

    private void cbbGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGGActionPerformed
        try {
            if (cbbGG.getSelectedItem().toString().equalsIgnoreCase("Chọn")) {
                txtTienGiam.setText("0");
                double tong = 0;
                double tienTP = 0;
                for (int i = 0; i < tbGH.getRowCount(); i++) {
                    Double tien = Double.valueOf(tbGH.getValueAt(i, 5).toString());
                    tong += tien;
                    String tp = tbGH.getValueAt(i, 4).toString();
                    Topping top = implTP.getOne(tp);
                    tienTP += top.getGia();
                }
                double tongTien = tong + tienTP;
                txtTongTien.setText(String.valueOf(tongTien));
                txtGiaTopping.setText(String.valueOf(tienTP));
            } else {
                for (KhuyenMai x : listKhuyenMai) {
                    if (cbbGG.getSelectedItem() == x.getMaKM()) {
                        if (txtTienGiam.getText().equalsIgnoreCase(String.valueOf(x.getMucGiam()))) {
                            JOptionPane.showMessageDialog(this, "Đã áp dụng mã");
                        } else {
                            txtTienGiam.setText(String.valueOf(x.getMucGiam()));
                            Double tienGiam = Double.valueOf(txtTienGiam.getText());
                            Double tongTien = Double.valueOf(txtTongTien.getText());
                            Double tien = tongTien - tienGiam;
                            txtTongTien.setText(String.valueOf(tien));
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
            txtTienGiam.setText("0");
        }
    }//GEN-LAST:event_cbbGGActionPerformed

    private void cbbLocDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocDanhMucActionPerformed
        if (cbbLocDanhMuc.getSelectedItem().toString().equalsIgnoreCase("All")) {
            listSanPham = implSP.getAllTT();
            showDataSP(listSanPham);
        } else {
            List<SanPham> listSearchTenDanhMuc = implSP.searchTenDanhMuc((String) cbbLocDanhMuc.getSelectedItem());
            showDataSP(listSearchTenDanhMuc);
        }
    }//GEN-LAST:event_cbbLocDanhMucActionPerformed

    private void btHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyDonActionPerformed
        
        if (tbHD.getRowCount() <= 1) {
            String ma = txtMa.getText();
            HoaDonModel hd = new HoaDonModel(ma, ma);
            implHD.update(hd, ma, "Huỷ");
            JOptionPane.showMessageDialog(this, "Huỷ thành công");
//            int row = tbBan.getSelectedRow();
//            String ten = tbBan.getValueAt(row, 0).toString();
            String ten = txtBan.getText();
            Ban b = implBan.getOne(ten);
            BanModel b2 = new BanModel("Trống");
            implBan.updateTT(b2, b.getId());
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
            listBan = implBan.getAllTT();
            showDataBan(listBan);
            listHDCT.clear();
            showDataHDCT(listHDCT);
            clear();
        } else {
            String ma = txtMa.getText();
            HoaDonModel hd = new HoaDonModel(ma, ma);
            implHD.update(hd, ma, "Huỷ");
            JOptionPane.showMessageDialog(this, "Huỷ thành công");
            int row = tbBan.getSelectedRow();
            String ten = txtBan.getText();
            Ban b = implBan.getOne(ten);
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
            listHDCT.clear();
            showDataHDCT(listHDCT);
            clear();
        }
    }//GEN-LAST:event_btHuyDonActionPerformed

    private void updateSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSLActionPerformed
        int rowSP = tbGH.getSelectedRow();
        String maSP = tbGH.getValueAt(rowSP, 0).toString();
        SanPham sp = implSP.getOne(maSP);
        HoaDon idHD = implHD.getOne(txtMa.getText());
        String id = sp.getId();
        int slt = Integer.parseInt(JOptionPane.showInputDialog("Mời bạn nhập số lượng:"));
        if (slt <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập đúng định dạng");
            return;
        }
        HoaDonChiTietModel hdct = new HoaDonChiTietModel(slt);
        implHDCT.update(hdct, idHD.getID(), id);
        listHDCT = implHDCT.getAllviewGH(idHD.getID());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_updateSLActionPerformed

    private void tachBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachBanActionPerformed
        try {
            if (tbHD.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(this, "Bàn không có người sử dụng");
            } else {
                int row = tbBan.getSelectedRow();
                if (txtBan.getText().equalsIgnoreCase("__")) {
                    JOptionPane.showMessageDialog(this, "Chưa chọn bàn");
                } else if (tbBan.getValueAt(row, 0).toString().contains(" - tách")) {
                    JOptionPane.showMessageDialog(this, "Không thể tách thêm");
                } else if (tbBan.getValueAt(row, 1).toString().equalsIgnoreCase("Nhỏ")) {
                    JOptionPane.showMessageDialog(this, "Không thể tách bàn nhỏ");
                } else {
                    String ten = txtBan.getText();
                    Ban idKV = implBan.getOne(ten);
                    BanModel ban = new BanModel(ten + " - tách", "Nhỏ", "Trống");
                    implBan.tachBan(ban);
                    listBan = implBan.getAllTT();
                    showDataBan(listBan);
                    Ban b = new Ban("", txtBan.getText());
                    ViewNhanVien v2 = new ViewNhanVien();
                    ViewTachBan v = new ViewTachBan(v2, true, b);
                    v.setVisible(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn bàn");
        }
    }//GEN-LAST:event_tachBanActionPerformed

    private void xoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaSPActionPerformed
        try {
            HoaDon idHD = implHD.getOne(txtMa.getText());
            int rowSP = tbGH.getSelectedRow();
            String maSP = tbGH.getValueAt(rowSP, 0).toString();
            SanPham sp = implSP.getOne(maSP);
            implHDCT.delete(idHD.getID(), sp.getId());
            listHDCT = implHDCT.getAllviewGH(idHD.getID());
            showDataHDCT(listHDCT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }
    }//GEN-LAST:event_xoaSPActionPerformed

    private void tachHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachHDActionPerformed
        try {
            Ban b = implBan.getOne(txtBan.getText());
            Random r = new Random();
            int x = r.nextInt(100);
            long millis = System.currentTimeMillis();
            String name;
            HoaDonModel hd = new HoaDonModel(b.getId());
            implHD.add(hd, x + "");
            BanModel b2 = new BanModel("Đang sử dụng");
            implBan.updateTT(b2, b.getId());
            listBan = implBan.getAllTT();
            showDataBan(listBan);
            listHoaDon = implHD.getAllTTViewHD(b.getId());
            showDataHD(listHoaDon);
            HoaDon h = new HoaDon(txtMa.getText());
            ViewNhanVien v1 = new ViewNhanVien();
            ViewTachHD v = new ViewTachHD(v1, true, h);
            v.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn");
        }
    }//GEN-LAST:event_tachHDActionPerformed

    private void gopHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gopHDActionPerformed
        int row = tbHD.getSelectedRow();
        HoaDon h = new HoaDon(txtMa.getText());
        ViewNhanVien v1 = new ViewNhanVien();
        ViewTachHD v = new ViewTachHD(v1, true, h);
        v.setVisible(true);
    }//GEN-LAST:event_gopHDActionPerformed

    private void btDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoiActionPerformed
        try {
            int rowSP = tbGH.getSelectedRow();
            String maSP = tbGH.getValueAt(rowSP, 0).toString();
            SanPham sp = implSP.getOne(maSP);
            String tp = cbbTopping.getSelectedItem().toString();
            Topping tp1 = implTP.getOne(tp);
            HoaDonChiTietModel hd = new HoaDonChiTietModel("", "", 0, tp1.getId());
            JOptionPane.showMessageDialog(this, implHDCT.updateTP(hd, sp.getId()));
            int row = tbHD.getSelectedRow();
            String ma = tbHD.getValueAt(row, 0).toString();
            HoaDon hd1 = implHD.getOne(ma);
            listHDCT = implHDCT.getAllviewGH(hd1.getID());
            showDataHDCT(listHDCT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm");
        }
    }//GEN-LAST:event_btDoiActionPerformed

    private void btDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDongActionPerformed
        webcam.close();
    }//GEN-LAST:event_btDongActionPerformed

    private void btMoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoActionPerformed
        
        initWebcam();
    }//GEN-LAST:event_btMoActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        listBan = implBan.getAllTT();
        showDataBan(listBan);
    }//GEN-LAST:event_resetActionPerformed

    private void btHuyDonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHuyDonMouseMoved
        btHuyDon.setBackground(Color.red);
    }//GEN-LAST:event_btHuyDonMouseMoved

    private void bltThanhToanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bltThanhToanMouseMoved
        bltThanhToan.setBackground(Color.green);
    }//GEN-LAST:event_bltThanhToanMouseMoved

    private void PHoaDonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PHoaDonMouseMoved
         btHuyDon.setBackground(defaulColor);
         bltThanhToan.setBackground(defaulColor);
    }//GEN-LAST:event_PHoaDonMouseMoved
    
    private void fillDataGH(int index) {
        HoaDonChiTiet hdct = listHDCT.get(index);
        SanPham sp = listSanPham.get(index);
        
        txtTongTien.setText(String.valueOf(hdct.getGiaTien()));
        txtTenSP.setText(sp.getTenSP());
        txtDonGia.setText(String.valueOf(sp.getGiaBan()));
        txtSoL.setText(String.valueOf(hdct.getSoLuong()));
        
    }
    
    private void fillDataBan(int index) {
        Ban b = listBan.get(index);
        txtBan.setText(b.getTenBan());
    }
    
    private void fillDataHD(int index) {
        HoaDon hd = listHoaDon.get(index);
        txtMa.setText(hd.getMaHD());
        txtNgay.setText(hd.getNgayLapHD());
        txtNhanVien.setText(hd.getTenNV().getTenNV());
    }
    
    private void initWebcam() {
        Dimension size = WebcamResolution.QQVGA.getSize();
        webcam = webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
       jPanel5.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 170));
        executor.execute(this);
    }
    
    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ViewThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmapew = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmapew);
            } catch (NotFoundException ex) {
                Logger.getLogger(ViewThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (result != null) {
                txtFake.setText(result.getText());
                MucGiam(result.getText());
            }
            
        } while (true);
        
    }
    
    private void MucGiam(String mucgiam) {
        if (txtFake.getText().equalsIgnoreCase("https://qrco.de/bdXusB")) {
            cbbGG.setSelectedItem("M1");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PHoaDon;
    private javax.swing.JButton bltThanhToan;
    private javax.swing.JButton btDoi;
    private javax.swing.JMenuItem btDong;
    private javax.swing.JButton btHuyDon;
    private javax.swing.JMenuItem btMo;
    private javax.swing.JCheckBox cbInHD;
    private javax.swing.JComboBox<String> cbbGG;
    private javax.swing.JComboBox<String> cbbLocDanhMuc;
    private javax.swing.JComboBox<String> cbbTopping;
    private javax.swing.JMenuItem gopBan;
    private javax.swing.JMenuItem gopHD;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu puBan;
    private javax.swing.JMenuItem reset;
    private javax.swing.JMenuItem tachBan;
    private javax.swing.JMenuItem tachHD;
    private javax.swing.JTable tbBan;
    private javax.swing.JTable tbGH;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tbSP;
    private javax.swing.JLabel txtBan;
    private javax.swing.JLabel txtDonGia;
    private javax.swing.JTextField txtFake;
    private javax.swing.JLabel txtGiaTopping;
    private javax.swing.JLabel txtMa;
    private javax.swing.JLabel txtNgay;
    private javax.swing.JLabel txtNhanVien;
    private javax.swing.JTextArea txtPrint;
    private javax.swing.JTextField txtSearchTenSP;
    private javax.swing.JLabel txtSoL;
    private javax.swing.JLabel txtTenSP;
    private javax.swing.JLabel txtTienGiam;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JMenuItem updateSL;
    private javax.swing.JMenuItem xoaSP;
    // End of variables declaration//GEN-END:variables

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
    
}
