DROP TABLE IF EXISTS exchange_value;

CREATE TABLE exchange_value (
id int,
currency_to varchar(5),
currency_from varchar(5),
conversion_multiple Decimal);

insert into exchange_value(id,currency_from,currency_to,conversion_multiple) 
values(1001,'USD','INR',70);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple) 
values(1002,'EUR','INR',90);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple) 
values(1003,'AUD','INR',30);