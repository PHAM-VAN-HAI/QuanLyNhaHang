USE master
GO

CREATE DATABASE [QuanLyNhaHang]
GO

USE [QuanLyNhaHang]
GO

CREATE TABLE [dbo].[KhoHang](
	[MaHangHoa] [nvarchar](15) NOT NULL,
	[TenHangHoa] [nvarchar](50) NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[SoLuong] [date] NOT NULL,
	[ChiPhi] [int] NOT NULL,
	[TongChiPhi] [int] NULL,
	PRIMARY KEY (MaHangHoa)
)
GO

CREATE TABLE [dbo].[DanhMuc](
	[MaDanhMuc] [nvarchar](15) NOT NULL,
	[TenDanhMuc] [nvarchar](50) NOT NULL,
	[MoTa] [nvarchar](50) NULL,
	PRIMARY KEY (MaDanhMuc)
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
	[GhiChu] [nvarchar](50) NULL,
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
	[MaDanhMuc] [nvarchar](15) NOT NULL,
	PRIMARY KEY (MaMon),
	CONSTRAINT FK_DanhMucThucDon FOREIGN KEY (MaDanhMuc) REFERENCES DanhMuc(MaDanhMuc)
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