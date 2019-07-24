-- Database: db000

-- DROP DATABASE db000;

CREATE DATABASE db000
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
-- SEQUENCE: public.carriers_sequence

-- DROP SEQUENCE public.carriers_sequence;

CREATE SEQUENCE public.carriers_sequence;

ALTER SEQUENCE public.carriers_sequence
    OWNER TO postgres;
-- SEQUENCE: public.categorys_of_station_sequence

-- DROP SEQUENCE public.categorys_of_station_sequence;

CREATE SEQUENCE public.categorys_of_station_sequence;

ALTER SEQUENCE public.categorys_of_station_sequence
    OWNER TO postgres;
-- SEQUENCE: public.categorys_of_transport_sequence

-- DROP SEQUENCE public.categorys_of_transport_sequence;

CREATE SEQUENCE public.categorys_of_transport_sequence;

ALTER SEQUENCE public.categorys_of_transport_sequence
    OWNER TO postgres;
-- SEQUENCE: public.citys_sequence

-- DROP SEQUENCE public.citys_sequence;

CREATE SEQUENCE public.citys_sequence;

ALTER SEQUENCE public.citys_sequence
    OWNER TO postgres;
-- SEQUENCE: public.countries_sequence

-- DROP SEQUENCE public.countries_sequence;

CREATE SEQUENCE public.countries_sequence;

ALTER SEQUENCE public.countries_sequence
    OWNER TO postgres;
-- SEQUENCE: public.flyghts_sequence

-- DROP SEQUENCE public.flyghts_sequence;

CREATE SEQUENCE public.flyghts_sequence;

ALTER SEQUENCE public.flyghts_sequence
    OWNER TO postgres;
-- SEQUENCE: public.timetables_sequence

-- DROP SEQUENCE public.timetables_sequence;

CREATE SEQUENCE public.timetables_sequence;

ALTER SEQUENCE public.timetables_sequence
    OWNER TO postgres;
-- SEQUENCE: public.transports_sequence

-- DROP SEQUENCE public.transports_sequence;

CREATE SEQUENCE public.transports_sequence;

ALTER SEQUENCE public.transports_sequence
    OWNER TO postgres;
-- Table: public.carriers

-- DROP TABLE public.carriers;

CREATE TABLE public.carriers
(
    id_of_carrier bigint NOT NULL,
    contacts text COLLATE pg_catalog."default",
    url text COLLATE pg_catalog."default",
    logo_svg text COLLATE pg_catalog."default",
    title text COLLATE pg_catalog."default",
    phone text COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    logo text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    code text COLLATE pg_catalog."default",
    CONSTRAINT carriers_pkey PRIMARY KEY (id_of_carrier)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.carriers
    OWNER to postgres;
-- Table: public.categorys_of_station

-- DROP TABLE public.categorys_of_station;

CREATE TABLE public.categorys_of_station
(
    id_of_category_of_station bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    CONSTRAINT categorys_of_station_pkey PRIMARY KEY (id_of_category_of_station)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.categorys_of_station
    OWNER to postgres;
-- Table: public.categorys_of_transport

-- DROP TABLE public.categorys_of_transport;

CREATE TABLE public.categorys_of_transport
(
    id_of_category_of_transport bigint NOT NULL,
    name_of_category_of_transport text COLLATE pg_catalog."default",
    CONSTRAINT categorys_of_transport_pkey PRIMARY KEY (id_of_category_of_transport)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.categorys_of_transport
    OWNER to postgres;
-- Table: public.citys

-- DROP TABLE public.citys;

CREATE TABLE public.citys
(
    id_of_city bigint NOT NULL,
    name_of_city text COLLATE pg_catalog."default",
    id_of_region bigint,
    code text COLLATE pg_catalog."default",
    CONSTRAINT citys_pkey PRIMARY KEY (id_of_city),
    CONSTRAINT regions_fkey FOREIGN KEY (id_of_region)
        REFERENCES public.regions (id_of_region) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.citys
    OWNER to postgres;
-- Table: public.countries

-- DROP TABLE public.countries;

CREATE TABLE public.countries
(
    id_of_country bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    code text COLLATE pg_catalog."default",
    CONSTRAINT countries_pkey PRIMARY KEY (id_of_country)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.countries
    OWNER to postgres;
-- Table: public.flyghts

-- DROP TABLE public.flyghts;

CREATE TABLE public.flyghts
(
    id_of_flyght bigint NOT NULL,
    time_to_path double precision,
    date_to_departure date,
    date_to_arrival date,
    number_of_flyght text COLLATE pg_catalog."default",
    CONSTRAINT flyghts_pkey PRIMARY KEY (id_of_flyght)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.flyghts
    OWNER to postgres;
-- Table: public.regions

-- DROP TABLE public.regions;

CREATE TABLE public.regions
(
    id_of_region bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    id_of_country bigint,
    code text COLLATE pg_catalog."default",
    CONSTRAINT regions_pkey PRIMARY KEY (id_of_region),
    CONSTRAINT countrys_fkey FOREIGN KEY (id_of_country)
        REFERENCES public.countries (id_of_country) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.regions
    OWNER to postgres;
-- Table: public.stations

-- DROP TABLE public.stations;

CREATE TABLE public.stations
(
    id_of_station bigint NOT NULL,
    code text COLLATE pg_catalog."default",
    title text COLLATE pg_catalog."default",
    id_of_category_of_station bigint,
    popular_title text COLLATE pg_catalog."default",
    short_title text COLLATE pg_catalog."default",
    id_of_category_of_transport bigint,
    id_of_city bigint,
    CONSTRAINT stations_pkey PRIMARY KEY (id_of_station),
    CONSTRAINT categorys_of_station_fkey FOREIGN KEY (id_of_category_of_station)
        REFERENCES public.categorys_of_station (id_of_category_of_station) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT categorys_of_transport_fkey FOREIGN KEY (id_of_category_of_transport)
        REFERENCES public.categorys_of_transport (id_of_category_of_transport) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT citys_fkey FOREIGN KEY (id_of_city)
        REFERENCES public.citys (id_of_city) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.stations
    OWNER to postgres;
-- Table: public.stops

-- DROP TABLE public.stops;

CREATE TABLE public.stops
(
    id_of_stop bigint NOT NULL,
    id_of_station bigint,
    id_of_thread bigint,
    status integer,
    CONSTRAINT stops_pkey PRIMARY KEY (id_of_stop),
    CONSTRAINT stations_fkey FOREIGN KEY (id_of_station)
        REFERENCES public.stations (id_of_station) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT threads_fkey FOREIGN KEY (id_of_thread)
        REFERENCES public.threads (id_of_thread) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.stops
    OWNER to postgres;
-- Table: public.sub_categorys_of_transport

-- DROP TABLE public.sub_categorys_of_transport;

CREATE TABLE public.sub_categorys_of_transport
(
    id_of_sub_category_of_transport bigint NOT NULL,
    name_of_sub_category_of_transport text COLLATE pg_catalog."default",
    code text COLLATE pg_catalog."default"
    CONSTRAINT sub_categorys_of_transport_pkey PRIMARY KEY (id_of_sub_category_of_transport)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.sub_categorys_of_transport
    OWNER to postgres;
-- Table: public.threads
-- Table: public.threads

-- DROP TABLE public.threads;

CREATE TABLE public.threads
(
    id_of_thread bigint NOT NULL,
    uid text COLLATE pg_catalog."default",
    title text COLLATE pg_catalog."default",
    short_title text COLLATE pg_catalog."default",
    link_of_method text COLLATE pg_catalog."default",
    id_of_carrier bigint,
    id_of_transport bigint,
    id_of_category_of_transport bigint,
    express_type text COLLATE pg_catalog."default",
    id_of_sub_category_of_transport bigint,
    CONSTRAINT threads_pkey PRIMARY KEY (id_of_thread),
    CONSTRAINT carriers_fkey FOREIGN KEY (id_of_carrier)
        REFERENCES public.carriers (id_of_carrier) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT categorys_of_transport_fkey FOREIGN KEY (id_of_category_of_transport)
        REFERENCES public.categorys_of_transport (id_of_category_of_transport) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT sub_categorys_of_transport_fkey FOREIGN KEY (id_of_sub_category_of_transport)
        REFERENCES public.sub_categorys_of_transport (id_of_sub_category_of_transport) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT transports_fkey FOREIGN KEY (id_of_transport)
        REFERENCES public.transports (id_of_transport) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.threads
    OWNER to postgres;
-- Table: public.timetables

-- DROP TABLE public.timetables;

CREATE TABLE public.timetables
(
    id_of_timetable bigint NOT NULL,
    id_of_flyght bigint,
    id_of_thread bigint,
    CONSTRAINT timetable_pkey PRIMARY KEY (id_of_timetable),
    CONSTRAINT flyghts_fkey FOREIGN KEY (id_of_flyght)
        REFERENCES public.flyghts (id_of_flyght) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT threads_fkey FOREIGN KEY (id_of_thread)
        REFERENCES public.threads (id_of_thread) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.timetables
    OWNER to postgres;
-- Table: public.transports

-- DROP TABLE public.transports;

CREATE TABLE public.transports
(
    id_of_transport bigint NOT NULL,
    id_of_category_of_transport bigint,
    "number" text COLLATE pg_catalog."default",
    CONSTRAINT transport_pkey PRIMARY KEY (id_of_transport),
    CONSTRAINT categorys_of_transport_fkey FOREIGN KEY (id_of_category_of_transport)
        REFERENCES public.categorys_of_transport (id_of_category_of_transport) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE SET NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.transports
    OWNER to postgres;