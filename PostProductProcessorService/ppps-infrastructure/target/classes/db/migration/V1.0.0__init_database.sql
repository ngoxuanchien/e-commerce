-- CREATE TABLE IF NOT EXISTS product (
--        id BIGSERIAL PRIMARY KEY,
--        name VARCHAR(255) NOT NULL,
--        description TEXT,
--        available_quantity DOUBLE PRECISION,
--        price NUMERIC NOT NULL
-- );
--
-- COMMENT ON COLUMN product.id IS 'Primary key';
-- COMMENT ON COLUMN product.name IS 'Product name';
-- COMMENT ON COLUMN product.description IS 'Product description';
-- COMMENT ON COLUMN product.available_quantity IS 'Available quantity';
-- COMMENT ON COLUMN product.price IS 'Product price';
--
-- CREATE TABLE IF NOT EXISTS category (
--         id BIGSERIAL PRIMARY KEY,
--         name VARCHAR(255) NOT NULL,
--         description TEXT
-- );
--
-- COMMENT ON COLUMN category.id IS 'Primary key';
-- COMMENT ON COLUMN category.name IS 'Category name';
-- COMMENT ON COLUMN category.description IS 'Category description';
--
-- CREATE TABLE IF NOT EXISTS product_category (
--         product_id INT NOT NULL,
--         category_id INT NOT NULL,
--         PRIMARY KEY (product_id, category_id),
--         FOREIGN KEY (product_id) REFERENCES product(id),
--         FOREIGN KEY (category_id) REFERENCES category(id)
-- );
--
-- COMMENT ON COLUMN product_category.product_id IS 'Product ID';
-- COMMENT ON COLUMN product_category.category_id IS 'Category ID';
create table category
(
    id          uuid not null
        primary key,
    description varchar(255),
    name        varchar(255)
);

create table product
(
    price       real not null,
    id          uuid not null
        primary key,
    description varchar(255),
    name        varchar(255)
);

create table product_category
(
    category_id uuid not null
        unique
        constraint fkpcmsq096b3sna4u2p9xnxlmgf
            references category,
    product_id  uuid not null
        constraint fk2k3smhbruedlcrvu6clued06x
            references product
);
