USE [QuanLyQuanCafe]
GO
/****** Object:  Table [dbo].[Ban]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
	[ID] [uniqueidentifier] NOT NULL,
	[MaBan] [nvarchar](50) NULL,
	[TenBan] [nvarchar](50) NULL,
	[Mota] [nvarchar](50) NULL,
	[Loaiban] [nvarchar](50) NULL,
	[IDKV] [uniqueidentifier] NULL,
	[TinhTrang] [nvarchar](50) NULL,
 CONSTRAINT [PK_Ban] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[ID] [uniqueidentifier] NOT NULL,
	[MaCV] [nvarchar](50) NULL,
	[TenCV] [nvarchar](50) NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[ID] [uniqueidentifier] NOT NULL,
	[TenDM] [nvarchar](50) NULL,
 CONSTRAINT [PK_DanhMuc] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [uniqueidentifier] NOT NULL,
	[MaHD] [nvarchar](50) NULL,
	[NgayLapHD] [date] NULL,
	[ThanhTien] [decimal](20, 0) NULL,
	[PhuongThucThanhToan] [nvarchar](50) NULL,
	[IDNV] [uniqueidentifier] NULL,
	[IDBan] [uniqueidentifier] NULL,
	[TinhTrang] [nvarchar](50) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[IDSP] [uniqueidentifier] NOT NULL,
	[IDHD] [uniqueidentifier] NOT NULL,
	[Soluong] [int] NULL,
	[Giatien] [decimal](20, 0) NULL,
	[Ghichu] [nvarchar](50) NULL,
	[IDTopping] [uniqueidentifier] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[IDSP] ASC,
	[IDHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuVuc]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuVuc](
	[ID] [uniqueidentifier] NOT NULL,
	[MaKV] [nvarchar](50) NULL,
	[TenKV] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhuVuc] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[ID] [uniqueidentifier] NOT NULL,
	[MaKM] [nvarchar](50) NULL,
	[TenKM] [nvarchar](50) NULL,
	[HinhThucGG] [nvarchar](50) NULL,
	[MucGiam] [decimal](20, 0) NULL,
	[TGBatDau] [date] NULL,
	[TGKetThuc] [date] NULL,
	[TrangThai] [nvarchar](50) NULL,
	[Mota] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai_SanPham]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai_SanPham](
	[IDSP] [uniqueidentifier] NOT NULL,
	[IDKM] [uniqueidentifier] NOT NULL,
 CONSTRAINT [PK_KhuyenMai_SanPham] PRIMARY KEY CLUSTERED 
(
	[IDSP] ASC,
	[IDKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ID] [uniqueidentifier] NOT NULL,
	[MaNV] [nvarchar](50) NULL,
	[TenNV] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[SDT] [nvarchar](13) NULL,
	[IDCV] [uniqueidentifier] NULL,
	[TrangThai] [bit] NULL,
	[GioiTinh] [bit] NULL,
	[Diachi] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID] [uniqueidentifier] NOT NULL,
	[MaSP] [nvarchar](50) NULL,
	[TenSP] [nvarchar](50) NULL,
	[Giaban] [decimal](20, 0) NULL,
	[MoTa] [nvarchar](50) NULL,
	[Anh] [nvarchar](50) NULL,
	[IDSize] [uniqueidentifier] NULL,
	[IDDM] [uniqueidentifier] NULL,
	[TrangThai] [nvarchar](50) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[ID] [uniqueidentifier] NOT NULL,
	[Size] [nvarchar](50) NULL,
 CONSTRAINT [PK_Size] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tai_khoan]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tai_khoan](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NULL,
	[Role] [nvarchar](50) NULL,
 CONSTRAINT [PK_Tai_khoan] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Topping]    Script Date: 12/15/2022 5:16:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Topping](
	[ID] [uniqueidentifier] NOT NULL,
	[Topping] [nvarchar](50) NULL,
	[GiaTien] [decimal](20, 0) NULL,
	[TrangThai] [nvarchar](50) NULL,
 CONSTRAINT [PK_Topping] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ban] ([ID], [MaBan], [TenBan], [Mota], [Loaiban], [IDKV], [TinhTrang]) VALUES (N'd3239f31-94e3-41fd-b180-5c969e324853', N'B4', N'Bàn 4', N'Tốt', N'Lớn', N'2a0369ea-f5b8-4e9f-87a8-065ab1ed2eb4', N'Trống')
INSERT [dbo].[Ban] ([ID], [MaBan], [TenBan], [Mota], [Loaiban], [IDKV], [TinhTrang]) VALUES (N'9f23f735-2783-4dfd-ac62-bb9b9397466c', N'B3', N'Bàn 3', N'Tốt', N'Lớn', N'440fa864-3d5b-4b29-9c30-780fd44e60ff', N'Đang sử dụng')
GO
INSERT [dbo].[ChucVu] ([ID], [MaCV], [TenCV]) VALUES (N'682f38aa-5ee3-44aa-a1e8-2e2ed27d19c1', N'CV3', N'Pha chế')
INSERT [dbo].[ChucVu] ([ID], [MaCV], [TenCV]) VALUES (N'c75a4af1-aa17-40f6-9252-949a512138e4', N'CV2', N'Bồi bàn')
INSERT [dbo].[ChucVu] ([ID], [MaCV], [TenCV]) VALUES (N'f82843f4-f6a9-4df1-9b0c-b78d02fcc44d', N'CV1', N'Order')
GO
INSERT [dbo].[DanhMuc] ([ID], [TenDM]) VALUES (N'd7464601-31ef-4e64-b972-3036b5b75123', N'Cà phê')
INSERT [dbo].[DanhMuc] ([ID], [TenDM]) VALUES (N'ce87025d-ea33-4c85-b754-6d3bd92f0049', N'Đồ ăn vặt')
INSERT [dbo].[DanhMuc] ([ID], [TenDM]) VALUES (N'b635c72c-141f-4bd0-9674-85d19d88fd18', N'Trà - Nước hoa quả')
INSERT [dbo].[DanhMuc] ([ID], [TenDM]) VALUES (N'6dfcd28e-6c98-40a1-9097-bd79f4371f36', N'Sinh tố')
GO
INSERT [dbo].[HoaDon] ([ID], [MaHD], [NgayLapHD], [ThanhTien], [PhuongThucThanhToan], [IDNV], [IDBan], [TinhTrang]) VALUES (N'b98afe52-468d-47c1-8930-1325cf64d2eb', N'HD90', CAST(N'2022-12-15' AS Date), NULL, NULL, N'5dc424c8-d86a-4aa9-9b6a-399678fd5ae5', N'9f23f735-2783-4dfd-ac62-bb9b9397466c', N'Chờ')
INSERT [dbo].[HoaDon] ([ID], [MaHD], [NgayLapHD], [ThanhTien], [PhuongThucThanhToan], [IDNV], [IDBan], [TinhTrang]) VALUES (N'4dfce2be-40fd-4725-b17c-691cc12e3744', N'HD80', CAST(N'2022-12-15' AS Date), NULL, NULL, N'5dc424c8-d86a-4aa9-9b6a-399678fd5ae5', N'9f23f735-2783-4dfd-ac62-bb9b9397466c', N'Chờ')
INSERT [dbo].[HoaDon] ([ID], [MaHD], [NgayLapHD], [ThanhTien], [PhuongThucThanhToan], [IDNV], [IDBan], [TinhTrang]) VALUES (N'1382fe58-a828-4dc6-8488-e7b19c996a54', N'HD61', CAST(N'2022-12-15' AS Date), NULL, NULL, N'5dc424c8-d86a-4aa9-9b6a-399678fd5ae5', N'd3239f31-94e3-41fd-b180-5c969e324853', N'Chờ')
INSERT [dbo].[HoaDon] ([ID], [MaHD], [NgayLapHD], [ThanhTien], [PhuongThucThanhToan], [IDNV], [IDBan], [TinhTrang]) VALUES (N'8fa84aa4-10a2-4580-9fba-ec0d1ce876b8', N'HD49', CAST(N'2022-12-15' AS Date), NULL, NULL, N'5dc424c8-d86a-4aa9-9b6a-399678fd5ae5', N'9f23f735-2783-4dfd-ac62-bb9b9397466c', N'Chờ')
GO
INSERT [dbo].[HoaDonChiTiet] ([IDSP], [IDHD], [Soluong], [Giatien], [Ghichu], [IDTopping]) VALUES (N'ee055469-102c-4d9f-959a-0feb79e99e4b', N'1382fe58-a828-4dc6-8488-e7b19c996a54', 1, NULL, NULL, N'2dfc770d-1309-4186-8497-a1770d96a2b3')
INSERT [dbo].[HoaDonChiTiet] ([IDSP], [IDHD], [Soluong], [Giatien], [Ghichu], [IDTopping]) VALUES (N'f6e0a6bf-4b5c-449f-aa37-21222777629b', N'1382fe58-a828-4dc6-8488-e7b19c996a54', 3, NULL, NULL, N'2dfc770d-1309-4186-8497-a1770d96a2b3')
GO
INSERT [dbo].[KhuVuc] ([ID], [MaKV], [TenKV], [TrangThai]) VALUES (N'2a0369ea-f5b8-4e9f-87a8-065ab1ed2eb4', N'KV2', N'Tầng 2', N'Trống')
INSERT [dbo].[KhuVuc] ([ID], [MaKV], [TenKV], [TrangThai]) VALUES (N'c0ed5c0b-e6f2-45c4-bfb6-29feefca36a1', N'KV1', N'Tầng 1', N'Trống')
INSERT [dbo].[KhuVuc] ([ID], [MaKV], [TenKV], [TrangThai]) VALUES (N'440fa864-3d5b-4b29-9c30-780fd44e60ff', N'KV3', N'Tầng 3', N'Trống')
INSERT [dbo].[KhuVuc] ([ID], [MaKV], [TenKV], [TrangThai]) VALUES (N'6b767368-1299-4330-ba37-a1409fdec32b', N'KV5', N'Tầng 6', N'Trống')
INSERT [dbo].[KhuVuc] ([ID], [MaKV], [TenKV], [TrangThai]) VALUES (N'f2351f1c-c6d8-4fe6-960c-c0ce28b69842', N'KV4', N'Tầng 4', N'Trống')
GO
INSERT [dbo].[KhuyenMai] ([ID], [MaKM], [TenKM], [HinhThucGG], [MucGiam], [TGBatDau], [TGKetThuc], [TrangThai], [Mota]) VALUES (N'22d90581-7848-4e23-8637-bc11586fdd09', N'M1', N'Giảm giá 10000', N'Giảm giá theo tiền', CAST(10000 AS Decimal(20, 0)), CAST(N'2022-01-01' AS Date), CAST(N'2022-02-02' AS Date), N'Đang kích hoạt', N'Ngon')
GO
INSERT [dbo].[NhanVien] ([ID], [MaNV], [TenNV], [NgaySinh], [SDT], [IDCV], [TrangThai], [GioiTinh], [Diachi]) VALUES (N'ae66ce37-dced-4a91-b65a-0efb7cf748e7', N'NV1', N'Dũng', CAST(N'2000-11-11' AS Date), N'0275023755', N'f82843f4-f6a9-4df1-9b0c-b78d02fcc44d', 1, 1, N'Hà nội')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [TenNV], [NgaySinh], [SDT], [IDCV], [TrangThai], [GioiTinh], [Diachi]) VALUES (N'5dc424c8-d86a-4aa9-9b6a-399678fd5ae5', N'NV2', N'Hùng', CAST(N'2000-11-11' AS Date), N'0847593479', N'f82843f4-f6a9-4df1-9b0c-b78d02fcc44d', 1, 1, N'Hà nội')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [TenNV], [NgaySinh], [SDT], [IDCV], [TrangThai], [GioiTinh], [Diachi]) VALUES (N'07d0b447-b438-45d1-90d8-48a7de2b52e0', N'NV3', N'Việt', CAST(N'2022-11-19' AS Date), N'0837348638', N'c75a4af1-aa17-40f6-9252-949a512138e4', 0, 0, N'Hà nội')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [TenNV], [NgaySinh], [SDT], [IDCV], [TrangThai], [GioiTinh], [Diachi]) VALUES (N'ef3831e3-541e-473f-8ab0-9f20e9155722', N'NV4', N'Minh', CAST(N'2000-11-11' AS Date), N'0327523787', N'f82843f4-f6a9-4df1-9b0c-b78d02fcc44d', 1, 1, N'Hà nội')
INSERT [dbo].[NhanVien] ([ID], [MaNV], [TenNV], [NgaySinh], [SDT], [IDCV], [TrangThai], [GioiTinh], [Diachi]) VALUES (N'273e79e7-128d-48b7-83ae-f0abc817bac2', N'NV5', N'Tuấn', CAST(N'2022-11-19' AS Date), N'0328577283', N'f82843f4-f6a9-4df1-9b0c-b78d02fcc44d', 0, 0, N'Hà nội')
GO
INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [Giaban], [MoTa], [Anh], [IDSize], [IDDM], [TrangThai]) VALUES (N'ee055469-102c-4d9f-959a-0feb79e99e4b', N'SP4', N'Sinh tố dâu', CAST(40000 AS Decimal(20, 0)), N'Ngon', NULL, N'653342b5-baab-4e2f-84b5-774c27b80d63', N'6dfcd28e-6c98-40a1-9097-bd79f4371f36', N'Đang bán')
INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [Giaban], [MoTa], [Anh], [IDSize], [IDDM], [TrangThai]) VALUES (N'f6e0a6bf-4b5c-449f-aa37-21222777629b', N'SP2', N'Cà phê đen', CAST(35000 AS Decimal(20, 0)), N'Ngon', NULL, N'653342b5-baab-4e2f-84b5-774c27b80d63', N'd7464601-31ef-4e64-b972-3036b5b75123', N'Đang bán')
INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [Giaban], [MoTa], [Anh], [IDSize], [IDDM], [TrangThai]) VALUES (N'ceeb3f9d-b646-4310-8780-53d502fc7065', N'SP3', N'Bạc xỉu', CAST(35000 AS Decimal(20, 0)), N'Ngon', NULL, N'653342b5-baab-4e2f-84b5-774c27b80d63', N'd7464601-31ef-4e64-b972-3036b5b75123', N'Đang bán')
INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [Giaban], [MoTa], [Anh], [IDSize], [IDDM], [TrangThai]) VALUES (N'9a47fca6-260c-4019-96ae-efb2f1ece52f', N'SP1', N'Trà hoa quả', CAST(20000 AS Decimal(20, 0)), N'Ngon', NULL, N'653342b5-baab-4e2f-84b5-774c27b80d63', N'b635c72c-141f-4bd0-9674-85d19d88fd18', N'Đang bán')
GO
INSERT [dbo].[Size] ([ID], [Size]) VALUES (N'423e0362-cc7d-421c-b947-5bbdba78b6cd', N'L')
INSERT [dbo].[Size] ([ID], [Size]) VALUES (N'653342b5-baab-4e2f-84b5-774c27b80d63', N'M')
INSERT [dbo].[Size] ([ID], [Size]) VALUES (N'9fceb6a8-501b-4868-85af-dab8e9ecc7ae', N'S')
GO
INSERT [dbo].[Tai_khoan] ([Username], [Password], [Role]) VALUES (N'nhanvien', N'123', N'nv')
INSERT [dbo].[Tai_khoan] ([Username], [Password], [Role]) VALUES (N'quanly', N'123', N'ql')
GO
INSERT [dbo].[Topping] ([ID], [Topping], [GiaTien], [TrangThai]) VALUES (N'96b4e2de-ceb5-4683-be33-1b54382c317c', N'Puddingg', CAST(10000 AS Decimal(20, 0)), N'Đang bán')
INSERT [dbo].[Topping] ([ID], [Topping], [GiaTien], [TrangThai]) VALUES (N'e9e5f7e0-de5c-4d04-9e60-56d2d93d02e9', N'Đá', CAST(10000 AS Decimal(20, 0)), N'Đang bán')
INSERT [dbo].[Topping] ([ID], [Topping], [GiaTien], [TrangThai]) VALUES (N'eb06c5dd-79ed-4fd4-93d2-7044cb3cfe92', N'Kem sữa', CAST(5000 AS Decimal(20, 0)), N'Đang bán')
INSERT [dbo].[Topping] ([ID], [Topping], [GiaTien], [TrangThai]) VALUES (N'2dfc770d-1309-4186-8497-a1770d96a2b3', N'Không topping', CAST(0 AS Decimal(20, 0)), N'Đang bán')
INSERT [dbo].[Topping] ([ID], [Topping], [GiaTien], [TrangThai]) VALUES (N'7579c433-2047-4795-a51d-f8f1d5b91534', N'Đường', CAST(10000 AS Decimal(20, 0)), N'Đang bán')
GO
ALTER TABLE [dbo].[Ban] ADD  CONSTRAINT [DF_Ban_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[ChucVu] ADD  CONSTRAINT [DF_ChucVu_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[DanhMuc] ADD  CONSTRAINT [DF_DanhMuc_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_IDNV]  DEFAULT (newid()) FOR [IDNV]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_IDBan]  DEFAULT (newid()) FOR [IDBan]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_IDSP]  DEFAULT (newid()) FOR [IDSP]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_IDHD]  DEFAULT (newid()) FOR [IDHD]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_IDCB]  DEFAULT (newid()) FOR [IDTopping]
GO
ALTER TABLE [dbo].[KhuVuc] ADD  CONSTRAINT [DF_KhuVuc_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  CONSTRAINT [DF_KhuyenMai_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[KhuyenMai_SanPham] ADD  CONSTRAINT [DF_KhuyenMai_SanPham_IDSP]  DEFAULT (newid()) FOR [IDSP]
GO
ALTER TABLE [dbo].[KhuyenMai_SanPham] ADD  CONSTRAINT [DF_KhuyenMai_SanPham_IDKM]  DEFAULT (newid()) FOR [IDKM]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_IDDM]  DEFAULT (newid()) FOR [IDDM]
GO
ALTER TABLE [dbo].[Size] ADD  CONSTRAINT [DF_Size_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[Topping] ADD  CONSTRAINT [DF_Topping_ID]  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[Ban]  WITH CHECK ADD  CONSTRAINT [FK_Ban_KhuVuc] FOREIGN KEY([IDKV])
REFERENCES [dbo].[KhuVuc] ([ID])
GO
ALTER TABLE [dbo].[Ban] CHECK CONSTRAINT [FK_Ban_KhuVuc]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Ban] FOREIGN KEY([IDBan])
REFERENCES [dbo].[Ban] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Ban]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([IDNV])
REFERENCES [dbo].[NhanVien] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([IDHD])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPham] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPham]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_Topping] FOREIGN KEY([IDTopping])
REFERENCES [dbo].[Topping] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_Topping]
GO
ALTER TABLE [dbo].[KhuyenMai_SanPham]  WITH CHECK ADD  CONSTRAINT [FK_KhuyenMai_SanPham_KhuyenMai] FOREIGN KEY([IDKM])
REFERENCES [dbo].[KhuyenMai] ([ID])
GO
ALTER TABLE [dbo].[KhuyenMai_SanPham] CHECK CONSTRAINT [FK_KhuyenMai_SanPham_KhuyenMai]
GO
ALTER TABLE [dbo].[KhuyenMai_SanPham]  WITH CHECK ADD  CONSTRAINT [FK_KhuyenMai_SanPham_SanPham] FOREIGN KEY([IDSP])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[KhuyenMai_SanPham] CHECK CONSTRAINT [FK_KhuyenMai_SanPham_SanPham]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([IDCV])
REFERENCES [dbo].[ChucVu] ([ID])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DanhMuc] FOREIGN KEY([IDDM])
REFERENCES [dbo].[DanhMuc] ([ID])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DanhMuc]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_Size] FOREIGN KEY([IDSize])
REFERENCES [dbo].[Size] ([ID])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_Size]
GO
