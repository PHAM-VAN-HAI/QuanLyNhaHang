USE master
GO

CREATE DATABASE [QuanLyNhaHang]
GO

USE [QuanLyNhaHang]
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

CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[NgayXuat] [date] NULL,
	[MaKH] [int] NOT NULL,
	[MaNV] [nvarchar](5) NOT NULL,
	[MaBan] [nvarchar](10) NOT NULL,
	[GiaTien] [money] NULL,
	PRIMARY KEY (MaHoaDon)
)
GO

CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHoaDonCT] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [int] NOT NULL,
	[MaMon] [int] NOT NULL,
	[SoLuong] [int] Not Null,
	PRIMARY KEY (MaHoaDonCT)
)
GO

CREATE TABLE [dbo].[KhachHang](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](20) NOT NULL,
	[SoDT] [nvarchar](15) NOT NULL,
	PRIMARY KEY (MaKH)
)
GO

CREATE TABLE [dbo].[ThucDon](
	[MaMon] [int] IDENTITY(1,1) NOT NULL,
	[TenMon] [nvarchar](50) NOT NULL,
	[GiaTien] [money] NOT NULL,
	[HinhAnh] [nvarchar](50) NOT NULL,
	[MaDanhMuc] [int] NOT NULL,
	PRIMARY KEY (MaMon)
)
GO

CREATE TABLE [dbo].[DanhMuc](
	[MaDanhMuc] [int] IDENTITY(1,1) NOT NULL,
	[TenDanhMuc] [nvarchar](50) NOT NULL,
	[MoTa] [nvarchar](50) NULL,
	PRIMARY KEY (MaDanhMuc)
)
GO

CREATE TABLE [dbo].[DanhSachBan](
	[MaBan] [nvarchar](10) NOT NULL,
	[LoaiBan] [int] NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	PRIMARY KEY (MaBan)
)
GO

CREATE TABLE [dbo].[DatBan](
	[MaDatBan] [int] IDENTITY(1,1) NOT NULL,
	[MaBan] [nvarchar](10) NOT NULL,
	[MaKH] [int] NOT NULL,
	[NgayDatBan] [date] NOT NULL,
	[GioDat] [nvarchar](10) NULL,
	[SoNguoi] [int] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	PRIMARY KEY (MaDatBan)
)
GO

CREATE TABLE [dbo].[KhoHang](
	[MaHangHoa] [nvarchar](10) NOT NULL,
	[TenHangHoa] [nvarchar](50) NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[SoLuong] [date] NOT NULL,
	[ChiPhi] [int] NOT NULL,
	[TongChiPhi] [int] NULL,
	PRIMARY KEY (MaHangHoa)
)
GO

ALTER TABLE HoaDon
ADD CONSTRAINT FK_NhanVienHoaDon
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_KhachHangHoaDon
FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_DSBanHoaDon
FOREIGN KEY (MaBan) REFERENCES DanhSachBan(MaBan);

ALTER TABLE ChiTietHoaDon
ADD CONSTRAINT FK_HoaDonCTHD
FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon);

ALTER TABLE ChiTietHoaDon
ADD CONSTRAINT FK_ThucDonCTHD
FOREIGN KEY (MaMon) REFERENCES ThucDon(MaMon);

ALTER TABLE ThucDon
ADD CONSTRAINT FK_DanhMucThucDon
FOREIGN KEY (MaDanhMuc) REFERENCES DanhMuc(MaDanhMuc);

ALTER TABLE DatBan
ADD CONSTRAINT FK_KhachHangDatBan
FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH);

ALTER TABLE DatBan
ADD CONSTRAINT FK_DSBanDatBan
FOREIGN KEY (MaBan) REFERENCES DanhSachBan(MaBan);

