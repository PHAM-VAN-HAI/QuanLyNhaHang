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
	[MaBan] [int] NOT NULL,
	[LoaiBan] [int] NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	PRIMARY KEY (MaBan)
)
GO

CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(1,1) NOT NULL,
	[NgayTao] [datetime] NULL,
	[MaNV] [nvarchar](5) NOT NULL,
	[MaBan] [int] NOT NULL,
	[TongTien] [float] NOT NULL,
	[TrangThai] [nvarchar](20) NOT NULL,
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
insert into ThucDon
values('TD01',N'Salad trái cây',150000,'saladtraicay.jpg',N'Món khác'),
	  ('TD02',N'Kim chi cải thảo',190000,'kimchi.jpg',N'Món khác'),
	  ('TD03',N'Cơm cuộn Kimbap',150000,'kimbap.jpg',N'Món khác'),
	  ('TD04',N'Bánh hải sản',190000,'banhhaisan.jpg',N'Món khác'),
	  ('TD05',N'Salad rong biển',190000,'saladrongbien.jpg',N'Món khác'),
	  ('TD07',N'Lươn biển nhật', 150000,'luonbien.png',N'Món ăn'),
	  ('TD12',N'Trà đào', 119000,'tradao.jpg',N'Món uống'),
	  ('TD13',N'Strawberry tea', 150000,'strawberrytea.jpg',N'Món uống'),
	  ('TD14',N'Soju', 119000,'soju.jpg',N'Món uống'),
	  ('TD15',N'Rượu gạo', 150000,'ruougao.jpg',N'Món uống'),
	  ('TD17',N'Râu mục chiên giòn',119000,'raumucchien.png',N'Món khác'),
	  ('TD18',N'Mực vòng chiên giòn',150000,'mucvongchien.jpg',N'Món khác'),
	  ('TD20',N'Salad cá ngừ với trứng',150000,'saladcangu.jpg',N'Món khác'),
	  ('TD28',N'Coca light', 119000,'cocalight.jpg',N'Món uống'),
	  ('TD29',N'Sprite', 190000,'sprite.jpg',N'Món uống'),
	  ('TD30',N'Nước suối', 119000,'nuocsuoi.png',N'Món uống'),
	  ('TD31',N'Bạch tuộc sốt cay', 190000,'bachtuocsotcay.jpg',N'Món ăn'),
	  ('TD32',N'Mực lá sốt cay', 150000,'mucsotcay.jpg',N'Món ăn'),
	  ('TD33',N'Cá hồi nướng giấy bạc', 165000,'cahoi.png',N'Món ăn'),
	  ('TD34',N'Tôm sốt Guang yang', 130000,'tomsot.jpg',N'Món ăn'),
	  ('TD35',N'Tôm lột vỏ sốt tỏi', 165000,'tomsottoi.png',N'Món ăn'),
	  ('TD36',N'Cơm trộn Hàn Quốc', 75000,'comtron.jpg',N'Món ăn'),
	  ('TD37',N'Cơm trộn hải sản', 120000,'comtronhaisan.jpg',N'Món ăn'),
	  ('TD38',N'Cơm trộng bạch tuộc', 99000,'comtronbachtuoc.jpg',N'Món ăn'),
	  ('TD39',N'Miến lạnh trộn', 140000,'mienlanh.jpg',N'Món ăn'),
	  ('TD40',N'Mì Udon xào hải sản', 165000,'miudon.jpg',N'Món ăn'),
	  ('TD41',N'Miến xào hải sản', 165000,'mienxao.jpg',N'Món ăn'),
	  ('TD42',N'Canh sườn bò Hàn Quốc', 189000,'canhsuonbo.jpg',N'Món ăn'),
	  ('TD43',N'Canh rong biển', 119000,'canhrongbien.jpg',N'Món ăn'),
	  ('TD44',N'Canh kim chi hải sản', 150000,'canhhaisan.jpg',N'Món ăn'),
	  (N'TD46', N'Rau càng cua', 80000, N'raucangcua.jpg', N'Khai vị'),
      (N'TD47', N'Salad dầu dấm', 110000, N'saladdaudam.jpg', N'Khai vị'),
	  (N'TD48', N'Salad cá hồi', 100000, N'saladcahoi.jpg', N'Khai vị'),
	  (N'TD49', N'Nộm hải sản ', 99000, N'monhaisan.jpg', N'Khai vị'),
	  (N'TD50', N'Salad rong nha cá ngừ', 130000, N'saladrongnhacangu.jpg', N'Khai vị'),
	  (N'TD51', N'Sashimi Bào Ngư', 220000, N'sashimibaongu.jpg', N'Sashimi'),
	  (N'TD52', N'Sashimi Cá Cơm Hàn Quốc', 250000, N'sashimicacomhanquoc.jpg', N'Sashimi'),
	  (N'TD53', N'Sashimi Cá Hồi', 300000, N'sashimicahoi.jpg', N'Sashimi'),
	  (N'TD54', N'Sashimi Hàu Sữa ', 250000, N'sashimihausua.jpg', N'Sashimi'),
	  (N'TD55', N'Sashimi Tôm Hùm', 1000000, N'sashimitomhum.jpg', N'Sashimi'),
	  (N'TD56', N'Sashimi Tôm Sú', 180000, N'sashimitomsu.jpg', N'Sashimi'),
	  (N'TD57', N'Cua hoàng đế hấp ', 2500000, N'cuahoangdehap.jpg', N'Cua'),
	  (N'TD58', N'Cua rang me', 300000, N'cuarangme.jpg', N'Cua'),
	  (N'TD59', N'Cua sốt ớt Singapo', 350000, N'cuasototsing.jpg', N'Cua'),
	  (N'TD60', N'Cua sốt tiêu đen', 260000, N'cuasottieuden.jpg', N'Cua'),
	  (N'TD61', N'Ghẹ sốt me', 120000, N'ghesotme.jpg', N'Cua'),
	  (N'TD62', N'Lẩu hồng công', 250000, N'laucuahongcong.png', N'Lẩu'),
	  (N'TD63', N'Lẩu cua thái', 250000, N'laucuathai.jpg', N'Lẩu'),
	  (N'TD64', N'Suop Hải Sản', 25000, N'suphaisan.jpg', N'Súp'),
	  (N'TD65', N' Soup Tôm Bắp', 25000, N'suptombap.jpg', N'Súp')

insert into NhanVien values
							('NV01','123',N'Phạm Văn Hải','0348888888',N'Quản lý',1,null),
							('NV02', N'123', N'Phạm Quang Vũ', '055687954', N'Quản lý', 1,null),
							('NV03', N'123', N'Bùi Đức Minh','0123456789', N'Quản lý', 1,null),
							('NV04', N'123', N'Lê Thị Liễu','0123456798', N'Lễ Tân',0,null),
							('NV05', N'123', N'Lê Mạnh Hùng','0123456987', N'Nhân Viên Phục Vụ', 1,null)

insert into BanAn values
						(1,4,N'Sẵn Sàng'),
						(2,4,N'Sẵn Sàng'),
						(3,4,N'Sẵn Sàng'),
						(4,4,N'Sẵn Sàng'),
						(5,4,N'Sẵn Sàng'),
						(6,8,N'Sẵn Sàng'),
						(7,8,N'Sẵn Sàng'),
						(8,8,N'Sẵn Sàng'),
						(9,8,N'Sẵn Sàng'),
						(10,8,N'Sẵn Sàng'),
						(11,10,N'Sẵn Sàng'),
						(12,10,N'Sẵn Sàng'),
						(13,10,N'Sẵn Sàng'),
						(14,10,N'Sẵn Sàng')

insert into KhoHang values 
							('CHEN01',N'Chén sứ minh long','03/08/2021',N'Cái',100,10000,1000000),
							('DIA',N'Dĩa sứ minh long','03/08/2021',N'Cái',100,10000,1000000),
							('DUA',N'Đũa nhựa cao cấp','03/08/2021',N'Chiếc',200,10000,2000000),
							('NIA',N'Nĩa inox cao cấp','03/08/2021',N'Chiếc',200,10000,2000000),
							('GIAY',N'Giấy ăn vuông','03/08/2021',N'Gói',50,100000,5000000),
							('BIAHNK',N'Bia Heineken','03/08/2021',N'Thùng',500,600000,300000000),
							('CUAHD',N'Cua Hoàng Đế','15/08/2021',N'KG',50,2590000,129500000),
							('TOMHB',N'Tôm Hùm Bông','15/08/2021',N'KG',50,2590000,129500000),


GO
CREATE PROCEDURE sp_NVSoBanbyHD (@TrangThai nvarchar(30),@MaBan nvarchar(15))
AS
select MaHD, hd.MaNV ,HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV
where TrangThai like @TrangThai and MaBan = @MaBan
go
create proc sp_SoSanhNgay(@ngayHT nvarchar(50))
as
select MaHD, hd.MaNV, HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV
where TrangThai = N'Đã Thanh Toán'
and NgayTao = @ngayHT
exec sp_SoSanhNgay '2021-08-04'
go
CREATE PROCEDURE sp_NVbyHD (@TrangThai nvarchar(30))
AS
select MaHD, hd.MaNV , HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV
where TrangThai like @TrangThai

select MaHD, hd.MaNV , HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV order by NgayTao desc

