--ƒл€ сувениров необходимо хранить: Ч название; Ч реквизиты производител€; Ч дату выпуска; Ч цену. 
--ƒл€ производителей необходимо хранить: Ч название; Ч страну. 

use Souvenirs;

------—оздание и заполнение таблицы Souvenirs
create table Souvenirs
(     Name  nvarchar(20) primary key, 
	  Manufacturer nvarchar(15),
	  Production_date date,
	  Price int,
	  foreign key(Manufacturer) references Manufacturers(Manufacturer)
);

insert into Souvenirs (Name, Manufacturer, Production_date, Price)
	values	('–амка', 'OZ','2012-01-12', 25),
			('ћагнит','FixPrice', '2013-05-10',10),
			('Ќаклейки','Wildberries', '2015-10-11',3),
			('Ѕижутери€', 'AliExpress', '2022-01-01', 50),
			('Ѕрелоки','Shain', '2021-07-27',20),
			('ѕостеры', 'FixPrice', '2022-03-29',15),
			(' ружки','OZ', '2020-02-22',23);



------—оздание и заполнение таблицы Manufacturers
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



--Х ¬ывести информацию о сувенирах заданного производител€. 
select * 
from Souvenirs
where Souvenirs.Manufacturer='OZ';

--Х ¬ывести информацию о сувенирах, произведенных в заданной стране. 
select Souvenirs.Name, Souvenirs.Manufacturer, Souvenirs.Production_date, Souvenirs.Price, Manufacturers.Country
from Souvenirs,  Manufacturers
where Manufacturers.Country='China';

--Х ¬ывести информацию о производител€х, чьи цены на сувениры меньше заданной.


--Х ¬ывести информацию о производител€х заданного сувенира, произведенного в заданном году. 


--Х ”далить заданного производител€ и его сувениры

