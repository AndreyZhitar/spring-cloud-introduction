drop table if exists exchanges;
drop sequence if exists exchanges_seq;
CREATE SEQUENCE exchanges_seq
    START WITH 10
    INCREMENT BY 1;
create table if not exists exchanges
(
    id BIGINT DEFAULT exchanges_seq.nextval NOT NULL,
    currency_from VARCHAR(3) NOT NULL ,
    currency_to VARCHAR(3) NOT NULL ,
    conversion_multiple DECIMAL(10,2),
    PRIMARY KEY (id)
);