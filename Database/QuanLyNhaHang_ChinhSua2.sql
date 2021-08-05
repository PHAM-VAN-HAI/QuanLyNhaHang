USE master
GO

CREATE DATABASE [QuanLyNhaHang]
GO

USE [QuanLyNhaHang]
GO

CREATE TABLE [dbo].[KhoHang](
	[MaHangHoa] [nvarchar](15) NOT NULL,
	[TenHangHoa] [nvarchar](50) NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[SoLuong] [float] NOT NULL,
	[ChiPhi] [float] NOT NULL,
	[TongChiPhi] [float] NULL,
	PRIMARY KEY (MaHangHoa)
)
GO

CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](5) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[SoDT] [nvarchar](15) NOT NULL,
	[ChucVu] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NULL,
	[Avatar] [nvarchar](50) NULL,
	PRIMARY KEY (MaNV)
)	
GO

CREATE TABLE [dbo].[BanAn](
	[MaBan] [nvarchar](15) NOT NULL,
	[LoaiBan] [int] NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	PRIMARY KEY (MaBan)
)
GO

CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(1,1) NOT NULL,
	[NgayTao] [date] NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[MaNV] [nvarchar](5) NOT NULL,
	[MaBan] [nvarchar](15) NOT NULL,
	[TongTien] [float] NOT NULL,
	PRIMARY KEY (MaHD),
	CONSTRAINT FK_NhanVienHoaDon FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
	CONSTRAINT FK_BanAnHoaDon FOREIGN KEY (MaBan) REFERENCES BanAn(MaBan)
)
GO

CREATE TABLE [dbo].[ThucDon](
	[MaMon] [nvarchar](15) NOT NULL,
	[TenMon] [nvarchar](50) NOT NULL,
	[GiaTien] [float] NOT NULL,
	[HinhAnh] [nvarchar](50) NOT NULL,
	[Loai] [nvarchar](50) NOT NULL,
	PRIMARY KEY (MaMon),
)
GO

CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHDCT] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [int] NOT NULL,
	[MaMon] [nvarchar](15) NOT NULL,
	[SoLuong] [int] Not Null,
	PRIMARY KEY (MaHDCT),
	CONSTRAINT FK_HoaDonHDCT FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	CONSTRAINT FK_ThucDonHDCT FOREIGN KEY (MaMon) REFERENCES ThucDon(MaMon)
)
GO

CREATE TABLE [dbo].[DatBan](
	[MaDatBan] [nvarchar](15) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[SDTKH] [nvarchar](15) NOT NULL,
	[NgayDatBan] [date] NOT NULL,
	[GioDat] [nvarchar](10) NULL,
	[SoNguoi] [int] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaNV] [nvarchar](5),
	PRIMARY KEY (MaDatBan),
	CONSTRAINT FK_NhanVienDatBan FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)
GO

Insert into NhanVien VALUES ('NV01','123',N'Phạm Văn Hải','0348043458',N'Quản Lý',0,null),
('NV02','123',N'Phạm Quang Vũ','0123456789',N'Quản Lý',0,null),
('NV03','123',N'Bùi Đức Minh','0987654321',N'Quản Lý',0,null),
('NV04','123',N'Lê Thị Mộng','0123654789',N'Nhân Viên',0,null)

Insert into KhoHang Values('CHEN01',N'Chén sứ minh long','03/08/2021',N'Cái',100,10000,1000000),
('DIA',N'Dĩa sứ minh long','03/08/2021',N'Cái',100,10000,1000000),
('DUA',N'Đũa nhựa cao cấp','03/08/2021',N'Chiếc',200,10000,2000000),
('NIA',N'Nĩa inox cao cấp','03/08/2021',N'Chiếc',200,10000,2000000),
('GIAY',N'Giấy ăn vuông','03/08/2021',N'Gói',50,100000,5000000),
('BIAHNK',N'Bia Heineken','03/08/2021',N'Thùng',500,600000,300000000)

Insert into BanAn Values('B401',4,N'Còn trống'),
('B402',4,N'Còn trống'),
('B403',4,N'Còn trống'),
('B404',4,N'Còn trống'),
('B405',4,N'Còn trống'),
('B601',6,N'Còn trống'),
('B602',6,N'Còn trống'),
('B603',6,N'Còn trống'),
('B604',6,N'Còn trống'),
('B605',6,N'Còn trống'),
('B801',6,N'Còn trống'),
('B802',6,N'Còn trống'),
('B803',6,N'Còn trống'),
('B804',6,N'Còn trống'),
('B805',6,N'Còn trống'),
('B1001',6,N'Còn trống'),
('B1002',6,N'Còn trống'),
('B1003',6,N'Còn trống'),
('B1004',6,N'Còn trống'),
('B1005',6,N'Còn trống')