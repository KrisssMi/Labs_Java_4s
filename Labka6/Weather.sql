										--������. � �� �������� ���������� � ������ � ��������� ��������. 
--��� ������ ���������� �������: � ������; � ����; � �����������; � ������. 
--��� �������� ���������� �������: � ��������; � �������; � ��� �������. 
--��� ����� ������� ���������� �������: � ��������; � ���� �������. 
drop table region;
drop table inhabitant_type;
drop table weather;

create database Weather;
use Weather;

--��� �������
create table inhabitant_type
(
	id_type int IDENTITY(1,1) primary key,	--��� �������
    name_inh nvarchar(50),					--��������
    language nvarchar(50)					--���� �������
);

--������
create table weather
(
	weather_id int IDENTITY(1,1) primary key,
    date date,
    temperature int,
	precipitation int						--������
);

--�������
create table region
(
	id_region int IDENTITY(1,1) primary key,
    name nvarchar(100),			
    area float,
    weather_id int foreign key references weather(weather_id),
    id_type int foreign key references inhabitant_type(id_type)		--��� �������
);


insert into region (name, area, weather_id, id_type) 
	values  ('Minsk', 348.8, '1', '1'),
			('Rome', 1285, '2', '2'),
			('Bern', 51.6, '3', '3'),
			('London', 1572, '4', '4');
    
insert into weather (date, temperature, precipitation) 
	values	('2022-03-22', -1, 0),
			('2022-03-30', 27, 10),
			('2022-03-29', 19, 15),
			('2022-03-19', 21, 7);
    
insert into weather (date, temperature, precipitation) 
	values ('2022-03-17', -8, 20);
    
insert into region (name, area, weather_id, id_type) 
	values  ('Minsk', 348.8, '5', '1');
    
insert into inhabitant_type (name_inh, language)
	values ('Belarusians', 'Belarusian'),
			('Italians', 'Italian'),
			('Swiss', 'French'),
			('British', 'English');

select * from weather;
select * from inhabitant_type;
  
 
--� ������� �������� � ������ � �������� �������. 
select date, temperature, precipitation, name
from weather, region
where weather.weather_id = region.weather_id and region.name like 'Rome';


--� ������� ����, ����� � �������� ������� ��� ���� � ����������� ���� ���� �������� �������������. 
select date, temperature, precipitation, name
from weather, region
where weather.weather_id = region.weather_id and (temperature <0  and precipitation >10);


--� ������� ���������� � ������ �� ��������� ������ � ��������, ������ ������� �������� �� �������� �����.
select date, temperature, precipitation, name, language
from weather, region, inhabitant_type
where weather.weather_id = region.weather_id and region.id_type = inhabitant_type.id_type
		and language like 'French' and date > '2022-02-10';


--� ������� ������� ����������� �� ��������� ������ � �������� � �������� ������ ��������.select avg(temperature), name, area, date
from weather, region
where weather.weather_id = region.weather_id and area > '350' and date > '2022-02-10'
group by name, area, date;