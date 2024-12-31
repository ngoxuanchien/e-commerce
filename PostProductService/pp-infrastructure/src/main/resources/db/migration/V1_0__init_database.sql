
create table product_request
(
    status     varchar(31) not null,
    type       varchar(31) not null,
    timestamp  timestamp(6) with time zone,
    request_id uuid        not null
        primary key,
    dtype      varchar(31) not null,
    payload    varchar(255)
);
