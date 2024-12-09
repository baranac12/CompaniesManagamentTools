--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2 (Debian 17.2-1.pgdg120+1)
-- Dumped by pg_dump version 17.0

-- Started on 2024-12-10 01:34:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3552 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 241 (class 1259 OID 17374)
-- Name: seq_user; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_user OWNER TO cmt;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 232 (class 1259 OID 17171)
-- Name: t_companies; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_companies (
    id integer NOT NULL,
    name character varying,
    phone character varying,
    address character varying,
    email character varying
);


ALTER TABLE public.t_companies OWNER TO cmt;

--
-- TOC entry 237 (class 1259 OID 17204)
-- Name: t_companies_transaction; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_companies_transaction (
    id integer NOT NULL,
    company_id integer,
    type_id integer,
    date date,
    status character varying,
    payment_id integer,
    payment numeric
);


ALTER TABLE public.t_companies_transaction OWNER TO cmt;

--
-- TOC entry 219 (class 1259 OID 17088)
-- Name: t_departmant; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_departmant (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.t_departmant OWNER TO cmt;

--
-- TOC entry 220 (class 1259 OID 17095)
-- Name: t_employee; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee (
    id integer NOT NULL,
    name character varying,
    surname character varying,
    tckn integer,
    address character varying,
    phone integer,
    email character varying
);


ALTER TABLE public.t_employee OWNER TO cmt;

--
-- TOC entry 221 (class 1259 OID 17102)
-- Name: t_employee_details; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_details (
    id integer NOT NULL,
    employee_id integer,
    departmant_id integer,
    is_active boolean,
    start_time date,
    end_time date
);


ALTER TABLE public.t_employee_details OWNER TO cmt;

--
-- TOC entry 229 (class 1259 OID 17150)
-- Name: t_employee_expenses; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_expenses (
    id integer NOT NULL,
    employee_id integer,
    date date,
    sgk_prim numeric,
    issizlik_sigortasi numeric,
    is_veren_prim numeric,
    is_veren_issizlik numeric
);


ALTER TABLE public.t_employee_expenses OWNER TO cmt;

--
-- TOC entry 224 (class 1259 OID 17119)
-- Name: t_employee_overtime; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_overtime (
    id integer NOT NULL,
    employee_id integer,
    date date,
    overtime integer,
    overtime_salary numeric
);


ALTER TABLE public.t_employee_overtime OWNER TO cmt;

--
-- TOC entry 222 (class 1259 OID 17107)
-- Name: t_employee_pay_info; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_pay_info (
    id integer NOT NULL,
    employee_id integer,
    salary numeric,
    hourly_salary numeric
);


ALTER TABLE public.t_employee_pay_info OWNER TO cmt;

--
-- TOC entry 226 (class 1259 OID 17131)
-- Name: t_employee_performance; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_performance (
    id integer NOT NULL,
    employee_id integer,
    date date,
    total_amount_product integer,
    rate_id integer
);


ALTER TABLE public.t_employee_performance OWNER TO cmt;

--
-- TOC entry 225 (class 1259 OID 17126)
-- Name: t_employee_performance_rate; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_performance_rate (
    id integer NOT NULL,
    min_condition integer,
    max_condition integer,
    rate integer
);


ALTER TABLE public.t_employee_performance_rate OWNER TO cmt;

--
-- TOC entry 227 (class 1259 OID 17136)
-- Name: t_employee_premium; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_premium (
    id integer NOT NULL,
    employee_id integer,
    date date,
    total_rate integer,
    total_premium numeric
);


ALTER TABLE public.t_employee_premium OWNER TO cmt;

--
-- TOC entry 230 (class 1259 OID 17157)
-- Name: t_employee_transaction; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_transaction (
    id integer NOT NULL,
    employee_id integer,
    date date,
    status character varying,
    payment_id integer,
    payment_salary numeric
);


ALTER TABLE public.t_employee_transaction OWNER TO cmt;

--
-- TOC entry 223 (class 1259 OID 17114)
-- Name: t_employee_working_time; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_working_time (
    id integer NOT NULL,
    employee_id integer,
    date date,
    hours_worked integer
);


ALTER TABLE public.t_employee_working_time OWNER TO cmt;

--
-- TOC entry 228 (class 1259 OID 17143)
-- Name: t_employeee_salary_pay; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employeee_salary_pay (
    id integer NOT NULL,
    employee_id integer,
    date date,
    total_hours_worked integer,
    total_overtime integer,
    total_salary numeric,
    total_overtime_salary numeric
);


ALTER TABLE public.t_employeee_salary_pay OWNER TO cmt;

--
-- TOC entry 239 (class 1259 OID 17218)
-- Name: t_invoice_info; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_invoice_info (
    id integer NOT NULL,
    invoice_id integer,
    product_id integer,
    amount integer,
    unit_price numeric,
    total_payment numeric
);


ALTER TABLE public.t_invoice_info OWNER TO cmt;

--
-- TOC entry 238 (class 1259 OID 17211)
-- Name: t_invoice_process; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_invoice_process (
    id integer NOT NULL,
    company_id integer,
    date date,
    payment_id integer,
    total_payment numeric,
    type_id integer
);


ALTER TABLE public.t_invoice_process OWNER TO cmt;

--
-- TOC entry 236 (class 1259 OID 17197)
-- Name: t_payment; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_payment (
    id integer NOT NULL,
    type character varying
);


ALTER TABLE public.t_payment OWNER TO cmt;

--
-- TOC entry 233 (class 1259 OID 17178)
-- Name: t_product; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_product (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.t_product OWNER TO cmt;

--
-- TOC entry 234 (class 1259 OID 17185)
-- Name: t_product_stock; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_product_stock (
    id integer NOT NULL,
    product_id integer,
    unit integer
);


ALTER TABLE public.t_product_stock OWNER TO cmt;

--
-- TOC entry 235 (class 1259 OID 17190)
-- Name: t_product_transaction; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_product_transaction (
    id integer NOT NULL,
    product_id integer,
    date date,
    status character varying,
    amount integer
);


ALTER TABLE public.t_product_transaction OWNER TO cmt;

--
-- TOC entry 231 (class 1259 OID 17164)
-- Name: t_sgk_transaction; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_sgk_transaction (
    id integer NOT NULL,
    employee_id integer,
    date date,
    status character varying,
    payment_id integer,
    payment_sgk numeric
);


ALTER TABLE public.t_sgk_transaction OWNER TO cmt;

--
-- TOC entry 240 (class 1259 OID 17352)
-- Name: t_transaction_type; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_transaction_type (
    id integer NOT NULL,
    type character varying
);


ALTER TABLE public.t_transaction_type OWNER TO cmt;

--
-- TOC entry 217 (class 1259 OID 17074)
-- Name: t_user; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_user (
    id integer DEFAULT nextval('public.seq_user'::regclass) NOT NULL,
    name character varying,
    surname character varying,
    username character varying,
    password character varying,
    departmant_id integer,
    email character varying
);


ALTER TABLE public.t_user OWNER TO cmt;

--
-- TOC entry 218 (class 1259 OID 17081)
-- Name: t_user_detail; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_user_detail (
    id integer NOT NULL,
    user_id integer,
    is_active boolean,
    token character varying,
    entry_date date
);


ALTER TABLE public.t_user_detail OWNER TO cmt;

--
-- TOC entry 3537 (class 0 OID 17171)
-- Dependencies: 232
-- Data for Name: t_companies; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_companies (id, name, phone, address, email) FROM stdin;
\.


--
-- TOC entry 3542 (class 0 OID 17204)
-- Dependencies: 237
-- Data for Name: t_companies_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_companies_transaction (id, company_id, type_id, date, status, payment_id, payment) FROM stdin;
\.


--
-- TOC entry 3524 (class 0 OID 17088)
-- Dependencies: 219
-- Data for Name: t_departmant; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_departmant (id, name) FROM stdin;
1	Admin
\.


--
-- TOC entry 3525 (class 0 OID 17095)
-- Dependencies: 220
-- Data for Name: t_employee; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee (id, name, surname, tckn, address, phone, email) FROM stdin;
\.


--
-- TOC entry 3526 (class 0 OID 17102)
-- Dependencies: 221
-- Data for Name: t_employee_details; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_details (id, employee_id, departmant_id, is_active, start_time, end_time) FROM stdin;
\.


--
-- TOC entry 3534 (class 0 OID 17150)
-- Dependencies: 229
-- Data for Name: t_employee_expenses; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_expenses (id, employee_id, date, sgk_prim, issizlik_sigortasi, is_veren_prim, is_veren_issizlik) FROM stdin;
\.


--
-- TOC entry 3529 (class 0 OID 17119)
-- Dependencies: 224
-- Data for Name: t_employee_overtime; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_overtime (id, employee_id, date, overtime, overtime_salary) FROM stdin;
\.


--
-- TOC entry 3527 (class 0 OID 17107)
-- Dependencies: 222
-- Data for Name: t_employee_pay_info; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_pay_info (id, employee_id, salary, hourly_salary) FROM stdin;
\.


--
-- TOC entry 3531 (class 0 OID 17131)
-- Dependencies: 226
-- Data for Name: t_employee_performance; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_performance (id, employee_id, date, total_amount_product, rate_id) FROM stdin;
\.


--
-- TOC entry 3530 (class 0 OID 17126)
-- Dependencies: 225
-- Data for Name: t_employee_performance_rate; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_performance_rate (id, min_condition, max_condition, rate) FROM stdin;
\.


--
-- TOC entry 3532 (class 0 OID 17136)
-- Dependencies: 227
-- Data for Name: t_employee_premium; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_premium (id, employee_id, date, total_rate, total_premium) FROM stdin;
\.


--
-- TOC entry 3535 (class 0 OID 17157)
-- Dependencies: 230
-- Data for Name: t_employee_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_transaction (id, employee_id, date, status, payment_id, payment_salary) FROM stdin;
\.


--
-- TOC entry 3528 (class 0 OID 17114)
-- Dependencies: 223
-- Data for Name: t_employee_working_time; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_working_time (id, employee_id, date, hours_worked) FROM stdin;
\.


--
-- TOC entry 3533 (class 0 OID 17143)
-- Dependencies: 228
-- Data for Name: t_employeee_salary_pay; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employeee_salary_pay (id, employee_id, date, total_hours_worked, total_overtime, total_salary, total_overtime_salary) FROM stdin;
\.


--
-- TOC entry 3544 (class 0 OID 17218)
-- Dependencies: 239
-- Data for Name: t_invoice_info; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_invoice_info (id, invoice_id, product_id, amount, unit_price, total_payment) FROM stdin;
\.


--
-- TOC entry 3543 (class 0 OID 17211)
-- Dependencies: 238
-- Data for Name: t_invoice_process; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_invoice_process (id, company_id, date, payment_id, total_payment, type_id) FROM stdin;
\.


--
-- TOC entry 3541 (class 0 OID 17197)
-- Dependencies: 236
-- Data for Name: t_payment; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_payment (id, type) FROM stdin;
\.


--
-- TOC entry 3538 (class 0 OID 17178)
-- Dependencies: 233
-- Data for Name: t_product; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_product (id, name) FROM stdin;
\.


--
-- TOC entry 3539 (class 0 OID 17185)
-- Dependencies: 234
-- Data for Name: t_product_stock; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_product_stock (id, product_id, unit) FROM stdin;
\.


--
-- TOC entry 3540 (class 0 OID 17190)
-- Dependencies: 235
-- Data for Name: t_product_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_product_transaction (id, product_id, date, status, amount) FROM stdin;
\.


--
-- TOC entry 3536 (class 0 OID 17164)
-- Dependencies: 231
-- Data for Name: t_sgk_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_sgk_transaction (id, employee_id, date, status, payment_id, payment_sgk) FROM stdin;
\.


--
-- TOC entry 3545 (class 0 OID 17352)
-- Dependencies: 240
-- Data for Name: t_transaction_type; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_transaction_type (id, type) FROM stdin;
\.


--
-- TOC entry 3522 (class 0 OID 17074)
-- Dependencies: 217
-- Data for Name: t_user; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_user (id, name, surname, username, password, departmant_id, email) FROM stdin;
1	asd	asd	asd	asd	1	asdasfa
2	asdasf	\N	ggggfdd	$2a$10$Z8oztYbh7qItZxZxbdA3H.l.V0fp0b7XYTF5xuO3b467O7mHhv7Ka	1	asd@gmail.com
3	asdasf	\N	ggggfdd	$2a$10$cOhHaDJU9BZRa1a9b8p3JOMH9aSknsya.fv8zKLm4wannreUohvMC	1	asd@gmail.com
4	asdasf	asfjlasfkla	ggggfdd	$2a$10$xmGNPSntBO/s2vlSjK25JutmCZARvdDNgGsbDoV7Oz8p3AmbZ9pDa	1	asd@gmail.com
5	asdasf	asfjlasfkla	ggggfdd	$2a$10$SAK2XrJKv5Gsj0D/mHHCOOcQGwm8vafssp9b5ts1gH8vPka3vv0fK	\N	asd@gmail.com
6	asdasf	asfjlasfkla	ggggfdd	$2a$10$P05jD0kiKkBFzU9HkyyCwe9mS2QSrNdtaSbHEuQlWNUtvSVG92Jv2	\N	asd@gmail.com
7	asdasf	asfjlasfkla	ggggfdd	$2a$10$2o9Q146gs0rzLm/cdZ5hAeNvum7HwiipylfGB6FfwFPiPcf179k8a	\N	asd@gmail.com
8	asdasf	asfjlasfkla	ggggfdd	$2a$10$wewN21HlNPwBX2fvTxjkz.EDaDpWF3Q5WQ4/sCMgtKDbyD4NknjjG	\N	asd@gmail.com
\.


--
-- TOC entry 3523 (class 0 OID 17081)
-- Dependencies: 218
-- Data for Name: t_user_detail; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_user_detail (id, user_id, is_active, token, entry_date) FROM stdin;
\.


--
-- TOC entry 3553 (class 0 OID 0)
-- Dependencies: 241
-- Name: seq_user; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_user', 8, true);


--
-- TOC entry 3334 (class 2606 OID 17177)
-- Name: t_companies t_companies_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies
    ADD CONSTRAINT t_companies_pkey PRIMARY KEY (id);


--
-- TOC entry 3344 (class 2606 OID 17210)
-- Name: t_companies_transaction t_companies_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3308 (class 2606 OID 17094)
-- Name: t_departmant t_departmant_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_departmant
    ADD CONSTRAINT t_departmant_pkey PRIMARY KEY (id);


--
-- TOC entry 3312 (class 2606 OID 17106)
-- Name: t_employee_details t_employee_details_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_details
    ADD CONSTRAINT t_employee_details_pkey PRIMARY KEY (id);


--
-- TOC entry 3328 (class 2606 OID 17156)
-- Name: t_employee_expenses t_employee_expenses_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_expenses
    ADD CONSTRAINT t_employee_expenses_pkey PRIMARY KEY (id);


--
-- TOC entry 3318 (class 2606 OID 17125)
-- Name: t_employee_overtime t_employee_overtime_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_overtime
    ADD CONSTRAINT t_employee_overtime_pkey PRIMARY KEY (id);


--
-- TOC entry 3314 (class 2606 OID 17113)
-- Name: t_employee_pay_info t_employee_pay_info_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_pay_info
    ADD CONSTRAINT t_employee_pay_info_pkey PRIMARY KEY (id);


--
-- TOC entry 3322 (class 2606 OID 17135)
-- Name: t_employee_performance t_employee_performance_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance
    ADD CONSTRAINT t_employee_performance_pkey PRIMARY KEY (id);


--
-- TOC entry 3320 (class 2606 OID 17130)
-- Name: t_employee_performance_rate t_employee_performance_rate_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance_rate
    ADD CONSTRAINT t_employee_performance_rate_pkey PRIMARY KEY (id);


--
-- TOC entry 3310 (class 2606 OID 17101)
-- Name: t_employee t_employee_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee
    ADD CONSTRAINT t_employee_pkey PRIMARY KEY (id);


--
-- TOC entry 3324 (class 2606 OID 17142)
-- Name: t_employee_premium t_employee_premium_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_premium
    ADD CONSTRAINT t_employee_premium_pkey PRIMARY KEY (id);


--
-- TOC entry 3330 (class 2606 OID 17163)
-- Name: t_employee_transaction t_employee_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_transaction
    ADD CONSTRAINT t_employee_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3316 (class 2606 OID 17118)
-- Name: t_employee_working_time t_employee_working_time_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_working_time
    ADD CONSTRAINT t_employee_working_time_pkey PRIMARY KEY (id);


--
-- TOC entry 3326 (class 2606 OID 17149)
-- Name: t_employeee_salary_pay t_employeee_salary_pay_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employeee_salary_pay
    ADD CONSTRAINT t_employeee_salary_pay_pkey PRIMARY KEY (id);


--
-- TOC entry 3342 (class 2606 OID 17203)
-- Name: t_payment t_payment_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_payment
    ADD CONSTRAINT t_payment_pkey PRIMARY KEY (id);


--
-- TOC entry 3336 (class 2606 OID 17184)
-- Name: t_product t_product_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product
    ADD CONSTRAINT t_product_pkey PRIMARY KEY (id);


--
-- TOC entry 3338 (class 2606 OID 17189)
-- Name: t_product_stock t_product_stock_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_stock
    ADD CONSTRAINT t_product_stock_pkey PRIMARY KEY (id);


--
-- TOC entry 3340 (class 2606 OID 17196)
-- Name: t_product_transaction t_product_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_transaction
    ADD CONSTRAINT t_product_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3348 (class 2606 OID 17224)
-- Name: t_invoice_info t_sales_info_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_info
    ADD CONSTRAINT t_sales_info_pkey PRIMARY KEY (id);


--
-- TOC entry 3346 (class 2606 OID 17217)
-- Name: t_invoice_process t_sales_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_sales_pkey PRIMARY KEY (id);


--
-- TOC entry 3332 (class 2606 OID 17170)
-- Name: t_sgk_transaction t_sgk_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_sgk_transaction
    ADD CONSTRAINT t_sgk_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3350 (class 2606 OID 17358)
-- Name: t_transaction_type t_transaction_type_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_transaction_type
    ADD CONSTRAINT t_transaction_type_pkey PRIMARY KEY (id);


--
-- TOC entry 3306 (class 2606 OID 17087)
-- Name: t_user_detail t_user_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user_detail
    ADD CONSTRAINT t_user_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 3304 (class 2606 OID 17080)
-- Name: t_user t_user_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user
    ADD CONSTRAINT t_user_pkey PRIMARY KEY (id);


--
-- TOC entry 3369 (class 2606 OID 17331)
-- Name: t_companies_transaction t_companies_transaction_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3370 (class 2606 OID 17369)
-- Name: t_companies_transaction t_companies_transaction_t_companies_fk; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_t_companies_fk FOREIGN KEY (company_id) REFERENCES public.t_companies(id);


--
-- TOC entry 3371 (class 2606 OID 17359)
-- Name: t_companies_transaction t_companies_transaction_t_transaction_type_fk; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_t_transaction_type_fk FOREIGN KEY (type_id) REFERENCES public.t_transaction_type(id);


--
-- TOC entry 3353 (class 2606 OID 17240)
-- Name: t_employee_details t_employee_details_departmant_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_details
    ADD CONSTRAINT t_employee_details_departmant_id_fkey FOREIGN KEY (departmant_id) REFERENCES public.t_departmant(id);


--
-- TOC entry 3354 (class 2606 OID 17235)
-- Name: t_employee_details t_employee_details_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_details
    ADD CONSTRAINT t_employee_details_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3362 (class 2606 OID 17281)
-- Name: t_employee_expenses t_employee_expenses_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_expenses
    ADD CONSTRAINT t_employee_expenses_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3357 (class 2606 OID 17265)
-- Name: t_employee_overtime t_employee_overtime_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_overtime
    ADD CONSTRAINT t_employee_overtime_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3355 (class 2606 OID 17250)
-- Name: t_employee_pay_info t_employee_pay_info_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_pay_info
    ADD CONSTRAINT t_employee_pay_info_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3358 (class 2606 OID 17255)
-- Name: t_employee_performance t_employee_performance_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance
    ADD CONSTRAINT t_employee_performance_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3359 (class 2606 OID 17260)
-- Name: t_employee_performance t_employee_performance_rate_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance
    ADD CONSTRAINT t_employee_performance_rate_id_fkey FOREIGN KEY (rate_id) REFERENCES public.t_employee_performance_rate(id);


--
-- TOC entry 3360 (class 2606 OID 17270)
-- Name: t_employee_premium t_employee_premium_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_premium
    ADD CONSTRAINT t_employee_premium_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3363 (class 2606 OID 17276)
-- Name: t_employee_transaction t_employee_transaction_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_transaction
    ADD CONSTRAINT t_employee_transaction_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3364 (class 2606 OID 17301)
-- Name: t_employee_transaction t_employee_transaction_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_transaction
    ADD CONSTRAINT t_employee_transaction_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3356 (class 2606 OID 17245)
-- Name: t_employee_working_time t_employee_working_time_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_working_time
    ADD CONSTRAINT t_employee_working_time_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3361 (class 2606 OID 17341)
-- Name: t_employeee_salary_pay t_employeee_salary_pay_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employeee_salary_pay
    ADD CONSTRAINT t_employeee_salary_pay_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3372 (class 2606 OID 17364)
-- Name: t_invoice_process t_invoice_process_t_transaction_type_fk; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_invoice_process_t_transaction_type_fk FOREIGN KEY (type_id) REFERENCES public.t_transaction_type(id);


--
-- TOC entry 3367 (class 2606 OID 17291)
-- Name: t_product_stock t_product_stock_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_stock
    ADD CONSTRAINT t_product_stock_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.t_product(id);


--
-- TOC entry 3368 (class 2606 OID 17296)
-- Name: t_product_transaction t_product_transaction_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_transaction
    ADD CONSTRAINT t_product_transaction_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.t_product(id);


--
-- TOC entry 3373 (class 2606 OID 17306)
-- Name: t_invoice_process t_sales_company_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_sales_company_id_fkey FOREIGN KEY (company_id) REFERENCES public.t_companies(id);


--
-- TOC entry 3375 (class 2606 OID 17321)
-- Name: t_invoice_info t_sales_info_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_info
    ADD CONSTRAINT t_sales_info_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.t_product(id);


--
-- TOC entry 3376 (class 2606 OID 17316)
-- Name: t_invoice_info t_sales_info_sales_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_info
    ADD CONSTRAINT t_sales_info_sales_id_fkey FOREIGN KEY (invoice_id) REFERENCES public.t_invoice_process(id);


--
-- TOC entry 3374 (class 2606 OID 17311)
-- Name: t_invoice_process t_sales_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_sales_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3365 (class 2606 OID 17286)
-- Name: t_sgk_transaction t_sgk_transaction_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_sgk_transaction
    ADD CONSTRAINT t_sgk_transaction_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3366 (class 2606 OID 17336)
-- Name: t_sgk_transaction t_sgk_transaction_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_sgk_transaction
    ADD CONSTRAINT t_sgk_transaction_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3351 (class 2606 OID 17230)
-- Name: t_user t_user_departman_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user
    ADD CONSTRAINT t_user_departman_id_fkey FOREIGN KEY (departmant_id) REFERENCES public.t_departmant(id);


--
-- TOC entry 3352 (class 2606 OID 17225)
-- Name: t_user_detail t_user_detail_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user_detail
    ADD CONSTRAINT t_user_detail_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.t_user(id);


-- Completed on 2024-12-10 01:34:03

--
-- PostgreSQL database dump complete
--

