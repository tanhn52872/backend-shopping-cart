use ecommerce

CREATE TABLE cart (
    id integer PRIMARY KEY,
    created_date timestamp ,
    product_id int,
    quantity integer NOT NULL,
    user_id integer
);

CREATE TABLE categories (
    id bigint NOT NULL,
    category_name character varying(255),
    description character varying(255),
    image_url character varying(255)
);


CREATE TABLE products (
    id bigint  ,
    description character varying(255),
    imageurl character varying(255),
    name character varying(255),
    price double precision ,
    category_id bigint
);

insert into products(id,description,imageurl,name,price,category_id)
values(1,'description1','url1','product1',20.4,2)

select * from products