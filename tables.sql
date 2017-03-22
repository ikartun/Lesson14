create table product
(
  product_id    NUMBER(4) not null,
  name          VARCHAR2(100) not null,
  price_per_day NUMBER(4) not null,
  amount        NUMBER(4) not null
);

create table rent
(
  rent_id    NUMBER(4) not null,
  product_id NUMBER(4) not null,
  date_from  DATE not null,
  date_to    DATE
);

insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(1,
                    'Football ball',
                    2,
                    30
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(2,
                    'Basketball ball',
                    2,
                    20
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(3,
                    'Skiing',
                    6,
                    8
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(4,
                    'Skates',
                    7,
                    7
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(5,
                    'Bike',
                    7,
                    6
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(6,
                    'Chess',
                    2,
                    5
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(7,
                    'Flippers',
                    2,
                    4
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(8,
                    'Surfboard',
                    5,
                    5
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(9,
                    'Curling',
                    10,
                    2
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(10,
                    'Sports simulator',
                    15,
                    3
                   );
                   
insert into product(product_id, 
                    name,
                    price_per_day,
                    amount
                   )
             values(11,
                    'test',
                    1000,
                    1000
                   );
                   
                   
                   
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(1,
                 1,
                 to_date('3/1/2017', 'MM/DD/YYYY'),
                 to_date('3/3/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(2,
                 4,
                 to_date('3/2/2017', 'MM/DD/YYYY'),
                 to_date('3/6/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(3,
                 2,
                 to_date('2/7/2017', 'MM/DD/YYYY'),
                 to_date('3/1/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(4,
                 7,
                 to_date('10/19/2016', 'MM/DD/YYYY'),
                 to_date('2/2/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(5,
                 3,
                 to_date('3/16/2016', 'MM/DD/YYYY'),
                 to_date('3/1/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(6,
                 10,
                 to_date('3/17/2016', 'MM/DD/YYYY'),
                 to_date('5/19/2016', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(7,
                 6,
                 to_date('2/7/2017', 'MM/DD/YYYY'),
                 to_date('2/9/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(8,
                 4,
                 to_date('3/7/2017', 'MM/DD/YYYY'),
                 null
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(9,
                 1,
                 to_date('3/3/2017', 'MM/DD/YYYY'),
                 to_date('3/4/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(10,
                 10,
                 to_date('1/11/2017', 'MM/DD/YYYY'),
                 to_date('2/9/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(11,
                 9,
                 to_date('3/1/2017', 'MM/DD/YYYY'),
                 to_date('3/1/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(12,
                 1,
                 to_date('3/4/2017', 'MM/DD/YYYY'),
                 to_date('3/6/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(13,
                 6,
                 to_date('3/1/2017', 'MM/DD/YYYY'),
                 to_date('3/3/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(14,
                 10,
                 to_date('3/1/2017', 'MM/DD/YYYY'),
                 null
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(15,
                 2,
                 to_date('3/3/2017', 'MM/DD/YYYY'),
                 to_date('3/8/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(16,
                 9,
                 to_date('3/7/2017', 'MM/DD/YYYY'),
                 to_date('3/14/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(17,
                 7,
                 to_date('3/2/2017', 'MM/DD/YYYY'),
                 to_date('3/8/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(18,
                 1,
                 to_date('3/6/2017', 'MM/DD/YYYY'),
                 to_date('3/9/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(19,
                 8,
                 to_date('2/14/2017', 'MM/DD/YYYY'),
                 null
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(20,
                 3,
                 to_date('3/10/2017', 'MM/DD/YYYY'),
                 null
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(21,
                 7,
                 to_date('3/9/2017', 'MM/DD/YYYY'),
                 to_date('3/14/2017', 'MM/DD/YYYY')
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(22,
                 2,
                 to_date('3/11/2017', 'MM/DD/YYYY'),
                 null
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(23,
                 8,
                 to_date('3/2/2017', 'MM/DD/YYYY'),
                 null
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(24,
                 5,
                 to_date('3/12/2017', 'MM/DD/YYYY'),
                 null
                );
                
insert into rent(rent_id,
                 product_id,
                 date_from,
                 date_to
                )
          values(25,
                 5,
                 to_date('3/13/2017', 'MM/DD/YYYY'),
                 null
                );
                
        
