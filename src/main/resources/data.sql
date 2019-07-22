-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    image_url text COLLATE pg_catalog."default",
    status boolean,
    status_timestamp timestamp with time zone,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;
INSERT INTO users (id, name, email, image_url, status, status_timestamp) VALUES
  (1, '0', '0@yandex.ru', '/photo1', true, '2019-01-12 13:48:13'),
  (2, '000', '000@yandex.ru', '/photo2', true, '2019-01-12 13:49:13'),
  (3, '000000', '000000@yandex.ru', '/photo3', true, '2019-01-12 13:50:13');