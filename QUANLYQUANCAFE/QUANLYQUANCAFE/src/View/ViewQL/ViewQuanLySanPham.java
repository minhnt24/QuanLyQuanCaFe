/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View.ViewQL;

import DomainModels.SanPhamModel;
import DomainModels.ToppingModel;
import Service.DanhMucService;
import Service.impl.DanhMucServiceImpl;
import Service.impl.SanPhamServiceImpl;
import Service.impl.SizeServiceImpl;
import Service.impl.ToppingServiceImpl;
import ViewModels.DanhMuc;
import ViewModels.SanPham;
import ViewModels.Size;
import ViewModels.Topping;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewQuanLySanPham extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<DanhMuc> listDanhMuc = new ArrayList<>();
    private List<SanPham> listSanPham = new ArrayList<>();
    private List<Size> listSize = new ArrayList<>();
    private SanPhamServiceImpl spService = new SanPhamServiceImpl();
    private DanhMucService danhMucService = new DanhMucServiceImpl();
    private SizeServiceImpl impl = new SizeServiceImpl();
    private DefaultComboBoxModel dcm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxCB = new DefaultComboBoxModel();
    private List<Topping> listTopping = new ArrayList<>();
    private DefaultTableModel dtmTopping = new DefaultTableModel();
    private ToppingServiceImpl implTopping = new ToppingServiceImpl();

    /**
     * Creates new form ViewQuanLyBan
     */
    public ViewQuanLySanPham() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        jTable1.setModel(dtm);
        String[] header = {"Mã SP", "Tên SP", "Giá Bán", "Danh Mục", "Trạng Thái", "Mô tả", "Size"};
        dtm.setColumnIdentifiers(header);
        jTable2.setModel(dtmTopping);
        String[] header1 = {"ID", "Tên Topping", "Giá Bán", "Trạng Thái"};
        dtmTopping.setColumnIdentifiers(header1);
        listTopping = implTopping.getAll();
        showDataTopping(listTopping);
        listDanhMuc = danhMucService.getAll();
        listSanPham = spService.getAll();
        listSize = impl.getAll();
        showCBB(listDanhMuc);
        showCBBLoc(listDanhMuc);
        showData(listSanPham);
        showCBBSize(listSize);
    }

    private void showDataTopping(List<Topping> list) {
        dtmTopping.setRowCount(0);
        for (Topping tp : list) {
            dtmTopping.addRow(new Object[]{tp.getId(), tp.getTopping(), tp.getGia(), tp.getTrangThai()});
        }
    }

    private void fillDataTopping(int index) {
        Topping tp = listTopping.get(index);
        txtID.setText(tp.getId());
        txtTen.setText(tp.getTopping());
        txtGiaBan.setText(String.valueOf(tp.getGia()));
        String tt = tp.getTrangThai();
        if (tt.equalsIgnoreCase("Đang bán")) {
            rdoDangBAn.setSelected(true);
        } else {
            rdoNgungBan.setSelected(true);
        }
    }

    private void showData(List<SanPham> list) {
        dtm.setRowCount(0);
        for (SanPham sp : list) {
            dtm.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getGiaBan(), sp.getDanhMuc().getTenDanhMuc(), sp.getTrangThai(), sp.getMoTa(), sp.getSize().getSize()});
        }
    }

    private void showCBB(List<DanhMuc> list) {
        cbbDanhMuc.setModel(dcm);
        for (DanhMuc danhMuc : list) {
            dcm.addElement(danhMuc.getTenDanhMuc());
        }
    }

    private void showCBBSize(List<Size> list) {
        cbbSize.setModel(dcm2);
        for (Size Size : list) {
            dcm2.addElement(Size.getSize());
        }
    }

    private void showCBBLoc(List<DanhMuc> list) {
        cbbLocDanhMuc.setModel(dcm1);
        for (DanhMuc danhMuc : list) {
            dcm1.addElement(danhMuc.getTenDanhMuc());
        }
    }

    private void fillData(int index) {
        SanPham sp = listSanPham.get(index);
        txtMa.setText(sp.getMaSP());
        txtName.setText(sp.getTenSP());
        txtGia.setText(String.valueOf(sp.getGiaBan()));
        txtMota.setText(sp.getMoTa());
        cbbDanhMuc.setSelectedItem(sp.getDanhMuc().getTenDanhMuc());
        cbbSize.setSelectedItem(sp.getSize().getSize());
        String tt = sp.getTrangThai();
        if (tt.equalsIgnoreCase("Đang bán")) {
            rdoDangBan.setSelected(true);
        } else {
            rdoNgungBan.setSelected(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtMota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        bltDanhMuc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<>();
        bltSize = new javax.swing.JButton();
        rdoNgungBan = new javax.swing.JRadioButton();
        rdoDangBan = new javax.swing.JRadioButton();
        bltLamMoiDM = new javax.swing.JButton();
        bltLamMoiSize = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cbbLocDanhMuc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnXoas = new javax.swing.JButton();
        btCapNhat = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtSearchTopping = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        rdoDangBAn = new javax.swing.JRadioButton();
        rdoNgungBan1 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        btnThemTopping = new javax.swing.JButton();
        btnSuaTopping = new javax.swing.JButton();
        btnClearTopping = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(34, 33));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1073, 792));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        jLabel2.setText("Mã");

        jLabel3.setText("Tên");

        jLabel4.setText("Mô tả");

        jLabel5.setText("Danh Mục:");

        jLabel6.setText("Trạng thái");

        jLabel7.setText("Giá bán");

        cbbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bltDanhMuc.setBackground(new java.awt.Color(255, 255, 255));
        bltDanhMuc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bltDanhMuc.setForeground(new java.awt.Color(102, 255, 51));
        bltDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add_25px.png"))); // NOI18N
        bltDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltDanhMucActionPerformed(evt);
            }
        });

        jLabel9.setText("Size:");

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bltSize.setBackground(new java.awt.Color(255, 255, 255));
        bltSize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bltSize.setForeground(new java.awt.Color(102, 255, 0));
        bltSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add_25px.png"))); // NOI18N
        bltSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltSizeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNgungBan);
        rdoNgungBan.setText("Ngừng bán");

        buttonGroup1.add(rdoDangBan);
        rdoDangBan.setSelected(true);
        rdoDangBan.setText("Đang bán");

        bltLamMoiDM.setBackground(new java.awt.Color(255, 255, 255));
        bltLamMoiDM.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        bltLamMoiDM.setForeground(new java.awt.Color(102, 255, 51));
        bltLamMoiDM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sync_25px.png"))); // NOI18N
        bltLamMoiDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltLamMoiDMActionPerformed(evt);
            }
        });

        bltLamMoiSize.setBackground(new java.awt.Color(255, 255, 255));
        bltLamMoiSize.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        bltLamMoiSize.setForeground(new java.awt.Color(102, 255, 51));
        bltLamMoiSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sync_25px.png"))); // NOI18N
        bltLamMoiSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bltLamMoiSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoDangBan)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNgungBan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bltDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bltSize, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bltLamMoiDM, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bltLamMoiSize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(bltDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bltLamMoiDM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(bltSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bltLamMoiSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(rdoDangBan)
                    .addComponent(rdoNgungBan))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        cbbLocDanhMuc.setEditable(true);
        cbbLocDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLocDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbbLocDanhMucMouseEntered(evt);
            }
        });
        cbbLocDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocDanhMucActionPerformed(evt);
            }
        });
        cbbLocDanhMuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbLocDanhMucKeyReleased(evt);
            }
        });

        jLabel8.setText("Danh Mục");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLocDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));
        jPanel3.setPreferredSize(new java.awt.Dimension(814, 678));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnXoas.setBackground(new java.awt.Color(255, 255, 255));
        btnXoas.setText("Xoá");
        btnXoas.setToolTipText("");
        btnXoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoasActionPerformed(evt);
            }
        });

        btCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        btCapNhat.setText("Câp nhật");
        btCapNhat.setToolTipText("");
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(255, 255, 255));
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Làm mới");
        btnClear.setToolTipText("");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoas)
                .addGap(18, 18, 18)
                .addComponent(btThem)
                .addGap(18, 18, 18)
                .addComponent(btCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel6);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        txtSearchTopping.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchToppingKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtSearchTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearchTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Topping", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel10.setText("ID");

        jLabel11.setText("Tên Topping");

        jLabel12.setText("Giá tiền");

        jLabel13.setText("Trạng Thái");

        txtID.setEnabled(false);

        buttonGroup1.add(rdoDangBAn);
        rdoDangBAn.setText("Đang bán");

        buttonGroup1.add(rdoNgungBan1);
        rdoNgungBan1.setText(" Ngừng bán");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(48, 48, 48)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(rdoDangBAn)
                        .addGap(32, 32, 32)
                        .addComponent(rdoNgungBan1))
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel12))
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rdoDangBAn)
                    .addComponent(rdoNgungBan1))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThemTopping.setBackground(new java.awt.Color(255, 255, 255));
        btnThemTopping.setText("Thêm");
        btnThemTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemToppingActionPerformed(evt);
            }
        });

        btnSuaTopping.setBackground(new java.awt.Color(255, 255, 255));
        btnSuaTopping.setText("Sửa");
        btnSuaTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaToppingActionPerformed(evt);
            }
        });

        btnClearTopping.setBackground(new java.awt.Color(255, 255, 255));
        btnClearTopping.setText("Làm mới");
        btnClearTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearToppingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnClearTopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaTopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemTopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnThemTopping)
                .addGap(40, 40, 40)
                .addComponent(btnSuaTopping)
                .addGap(39, 39, 39)
                .addComponent(btnClearTopping)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Topping", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        try {
            String ma = txtMa.getText();
            String ten = txtName.getText();
            String gia = txtGia.getText();
            String moTa = txtMota.getText();
            String danhMuc = (String) cbbDanhMuc.getSelectedItem();
            boolean tt = rdoDangBan.isSelected();
            String status = "";
            if (tt) {
                status = "Đang bán";
            } else {
                status = "Ngừng bán";
            }
            String size = (String) cbbSize.getSelectedItem();
            Size sizeImpl = impl.getOne(cbbSize.getSelectedItem().toString());
            DanhMuc dm = danhMucService.getOne(cbbDanhMuc.getSelectedItem().toString());
            SanPhamModel sp = new SanPhamModel(ma, ten, Double.valueOf(gia), moTa, sizeImpl.getId(), dm.getId(), status);
            JOptionPane.showMessageDialog(this, spService.update(sp, ma));
            listDanhMuc = danhMucService.getAll();
            listSanPham = spService.getAll();
            showData(listSanPham);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được để trống !");
        }
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        List<SanPham> listSearch = spService.search(txtSearch.getText());
        showData(listSearch);

    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code hereString id = txtId.getText();
        try {
            String ma = txtMa.getText();
            String ten = txtName.getText();
            String gia = txtGia.getText();
            String moTa = txtMota.getText();
            String danhMuc = (String) cbbDanhMuc.getSelectedItem();
            boolean tt = rdoDangBan.isSelected();
            String status = "";
            if (tt) {
                status = "Đang bán";
            } else {
                status = "Ngừng bán";
            }
            String size = (String) cbbSize.getSelectedItem();
            Size sizeImpl = impl.getOne(cbbSize.getSelectedItem().toString());
            DanhMuc dm = danhMucService.getOne(cbbDanhMuc.getSelectedItem().toString());
            SanPhamModel sp = new SanPhamModel(ma, ten, Double.valueOf(gia), moTa, sizeImpl.getId(), dm.getId(), status);
            JOptionPane.showMessageDialog(this, spService.add(sp));
            listDanhMuc = danhMucService.getAll();
            listSanPham = spService.getAll();
            showData(listSanPham);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không được để trống !");
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btnXoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoasActionPerformed
        JOptionPane.showMessageDialog(this, spService.delete(txtMa.getText()));
        listDanhMuc = danhMucService.getAll();
        listSanPham = spService.getAll();
        showData(listSanPham);
    }//GEN-LAST:event_btnXoasActionPerformed

    private void cbbLocDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocDanhMucActionPerformed
        // TODO add your handling code here:
        List<SanPham> listSearchTenDanhMuc = spService.searchTenDanhMuc((String) cbbLocDanhMuc.getSelectedItem());
        showData(listSearchTenDanhMuc);
    }//GEN-LAST:event_cbbLocDanhMucActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtName.setText("");
        txtMota.setText("");
        txtGia.setText("");
        cbbDanhMuc.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        rdoDangBan.setSelected(true);
        rdoNgungBan.setSelected(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void bltDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltDanhMucActionPerformed
        ViewDanhMuc viewDM = new ViewDanhMuc();
        viewDM.setVisible(true);
    }//GEN-LAST:event_bltDanhMucActionPerformed

    private void bltSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltSizeActionPerformed
        ViewSize viewS = new ViewSize();
        viewS.setVisible(true);
    }//GEN-LAST:event_bltSizeActionPerformed

    private void bltLamMoiDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltLamMoiDMActionPerformed
        listDanhMuc = danhMucService.getAll();
        cbbDanhMuc.setModel(dcm);
        for (DanhMuc danhMuc : listDanhMuc) {
            dcm.removeAllElements();
        }
        for (DanhMuc danhMuc : listDanhMuc) {
            dcm.addElement(danhMuc.getTenDanhMuc());
        }
        showCBB(listDanhMuc);
    }//GEN-LAST:event_bltLamMoiDMActionPerformed

    private void bltLamMoiSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bltLamMoiSizeActionPerformed
        listSize = impl.getAll();
        cbbSize.setModel(dcm2);
        for (Size Size : listSize) {
            dcm2.removeAllElements();
        }
        for (Size Size : listSize) {
            dcm2.addElement(Size.getSize());
        }
    }//GEN-LAST:event_bltLamMoiSizeActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row = jTable2.getSelectedRow();
        fillDataTopping(row);
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtSearchToppingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchToppingKeyReleased
        // TODO add your handling code here:
        List<Topping> listSearch = implTopping.searchTen(txtSearchTopping.getText());
        showDataTopping(listSearch);
    }//GEN-LAST:event_txtSearchToppingKeyReleased

    private void btnThemToppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemToppingActionPerformed
        // TODO add your handling code here:
        String ten = txtTen.getText();
        String gia = txtGiaBan.getText();
        boolean trangThai = rdoDangBAn.isSelected();
        String status = "";
        if (trangThai) {
            status = "Đang bán";
        } else {
            status = "Ngừng bán";
        }
        ToppingModel tp = new ToppingModel(ten, Double.valueOf(gia), status);
        JOptionPane.showMessageDialog(this, implTopping.add(tp));
        listTopping = implTopping.getAll();
        showDataTopping(listTopping);
    }//GEN-LAST:event_btnThemToppingActionPerformed

    private void btnSuaToppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaToppingActionPerformed
        // TODO add your handling code here:
        String id = txtID.getText();
        String ten = txtTen.getText();
        String gia = txtGiaBan.getText();
        boolean trangThai = rdoDangBAn.isSelected();
        String status = "";
        if (trangThai) {
            status = "Đang bán";
        } else {
            status = "Ngừng bán";
        }
        ToppingModel tp = new ToppingModel(ten, Double.valueOf(gia), status);
        JOptionPane.showMessageDialog(this, implTopping.update(tp, id));
        listTopping = implTopping.getAll();
        showDataTopping(listTopping);
    }//GEN-LAST:event_btnSuaToppingActionPerformed

    private void btnClearToppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearToppingActionPerformed
        // TODO add your handling code here:
        txtID.setText("");
        txtTen.setText("");
        txtGiaBan.setText("");
        rdoDangBAn.setSelected(true);
    }//GEN-LAST:event_btnClearToppingActionPerformed

    private void cbbLocDanhMucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbLocDanhMucKeyReleased

    }//GEN-LAST:event_cbbLocDanhMucKeyReleased

    private void cbbLocDanhMucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLocDanhMucMouseEntered

        List<SanPham> listSearchTenDanhMuc = spService.searchTenDanhMuc((String) cbbLocDanhMuc.getSelectedItem());
        showData(listSearchTenDanhMuc);
    }//GEN-LAST:event_cbbLocDanhMucMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bltDanhMuc;
    private javax.swing.JButton bltLamMoiDM;
    private javax.swing.JButton bltLamMoiSize;
    private javax.swing.JButton bltSize;
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearTopping;
    private javax.swing.JButton btnSuaTopping;
    private javax.swing.JButton btnThemTopping;
    private javax.swing.JButton btnXoas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbLocDanhMuc;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JRadioButton rdoDangBAn;
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoNgungBan;
    private javax.swing.JRadioButton rdoNgungBan1;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchTopping;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
