insert into exchanges(id, currency_from, currency_to, conversion_multiple)
values
       (exchanges_seq.nextval, 'USD', 'INR', 65),
       (exchanges_seq.nextval, 'EUR', 'INR', 75),
       (exchanges_seq.nextval, 'RUB', 'INR', 2),
       (exchanges_seq.nextval, 'GRN', 'INR', 5);
