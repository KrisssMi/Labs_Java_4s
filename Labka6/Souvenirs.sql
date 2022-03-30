--��� ��������� ���������� �������: � ��������; � ��������� �������������; � ���� �������; � ����. 
--��� �������������� ���������� �������: � ��������; � ������. 

use Souvenirs;

------�������� � ���������� ������� Souvenirs
create table Souvenirs
(     Name  nvarchar(20) primary key, 
	  Manufacturer nvarchar(15),
	  Production_date date,
	  Price int,
	  foreign key(Manufacturer) references Manufacturers(Manufacturer)
);

insert into Souvenirs (Name, Manufacturer, Production_date, Price)
	values	('�����', 'OZ','2012-01-12', 25),
			('������','FixPrice', '2013-05-10',10),
			('��������','Wildberries', '2015-10-11',3),
			('���������', 'AliExpress', '2022-01-01', 50),
			('�������','Shain', '2021-07-27',20),
			('�������', 'FixPrice', '2022-03-29',15),
			('������','OZ', '2020-02-22',23);



------�������� � ���������� ������� Manufacturers
create table Manufacturers
(     Manufacturer  nvarchar(15) primary key, 
	  Country nvarchar(10)
);

insert into Manufacturers (Manufacturer, Country)
	values	('FixPrice', 'Russia'),
			('Shain','Japane'),
			('OZ','Belarus'),
			('Wildberries', 'Belarus'),
			('AliExpress','China');



--� ������� ���������� � ��������� ��������� �������������. 
select * 
from Souvenirs
where Souvenirs.Manufacturer='OZ';

--� ������� ���������� � ���������, ������������� � �������� ������. 
select Souvenirs.Name, Souvenirs.Manufacturer, Souvenirs.Production_date, Souvenirs.Price, Manufacturers.Country
from Souvenirs,  Manufacturers
where Manufacturers.Country='China';

--� ������� ���������� � ��������������, ��� ���� �� �������� ������ ��������.


--� ������� ���������� � �������������� ��������� ��������, �������������� � �������� ����. 


--� ������� ��������� ������������� � ��� ��������

