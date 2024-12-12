--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2 (Debian 17.2-1.pgdg120+1)
-- Dumped by pg_dump version 17.0

-- Started on 2024-12-12 17:16:52

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
-- TOC entry 3621 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 242 (class 1259 OID 17377)
-- Name: seq_companies_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_companies_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_companies_id OWNER TO cmt;

--
-- TOC entry 243 (class 1259 OID 17379)
-- Name: seq_companies_trans_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_companies_trans_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_companies_trans_id OWNER TO cmt;

--
-- TOC entry 244 (class 1259 OID 17381)
-- Name: seq_departmant_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_departmant_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_departmant_id OWNER TO cmt;

--
-- TOC entry 246 (class 1259 OID 17385)
-- Name: seq_employee_details_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_details_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_details_id OWNER TO cmt;

--
-- TOC entry 247 (class 1259 OID 17387)
-- Name: seq_employee_expenses_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_expenses_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_expenses_id OWNER TO cmt;

--
-- TOC entry 245 (class 1259 OID 17383)
-- Name: seq_employee_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_id OWNER TO cmt;

--
-- TOC entry 248 (class 1259 OID 17389)
-- Name: seq_employee_overtime_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_overtime_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_overtime_id OWNER TO cmt;

--
-- TOC entry 249 (class 1259 OID 17391)
-- Name: seq_employee_pay_info_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_pay_info_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_pay_info_id OWNER TO cmt;

--
-- TOC entry 250 (class 1259 OID 17393)
-- Name: seq_employee_performance_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_performance_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_performance_id OWNER TO cmt;

--
-- TOC entry 251 (class 1259 OID 17395)
-- Name: seq_employee_performance_r_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_performance_r_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_performance_r_id OWNER TO cmt;

--
-- TOC entry 252 (class 1259 OID 17397)
-- Name: seq_employee_premium_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_premium_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_premium_id OWNER TO cmt;

--
-- TOC entry 255 (class 1259 OID 17403)
-- Name: seq_employee_sp_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_sp_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_sp_id OWNER TO cmt;

--
-- TOC entry 253 (class 1259 OID 17399)
-- Name: seq_employee_t_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_t_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_t_id OWNER TO cmt;

--
-- TOC entry 254 (class 1259 OID 17401)
-- Name: seq_employee_wt_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_employee_wt_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_employee_wt_id OWNER TO cmt;

--
-- TOC entry 256 (class 1259 OID 17405)
-- Name: seq_invoice_info_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_invoice_info_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_invoice_info_id OWNER TO cmt;

--
-- TOC entry 257 (class 1259 OID 17407)
-- Name: seq_invoice_process_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_invoice_process_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_invoice_process_id OWNER TO cmt;

--
-- TOC entry 258 (class 1259 OID 17409)
-- Name: seq_payment_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_payment_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_payment_id OWNER TO cmt;

--
-- TOC entry 259 (class 1259 OID 17411)
-- Name: seq_product_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_product_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product_id OWNER TO cmt;

--
-- TOC entry 260 (class 1259 OID 17413)
-- Name: seq_product_s_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_product_s_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product_s_id OWNER TO cmt;

--
-- TOC entry 261 (class 1259 OID 17415)
-- Name: seq_product_t_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_product_t_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_product_t_id OWNER TO cmt;

--
-- TOC entry 262 (class 1259 OID 17417)
-- Name: seq_sgk_t_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_sgk_t_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_sgk_t_id OWNER TO cmt;

--
-- TOC entry 263 (class 1259 OID 17419)
-- Name: seq_transcation_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_transcation_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_transcation_id OWNER TO cmt;

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

--
-- TOC entry 264 (class 1259 OID 17421)
-- Name: seq_user_detail_id; Type: SEQUENCE; Schema: public; Owner: cmt
--

CREATE SEQUENCE public.seq_user_detail_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_user_detail_id OWNER TO cmt;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 232 (class 1259 OID 17171)
-- Name: t_companies; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_companies (
    id integer DEFAULT nextval('public.seq_companies_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_companies_trans_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_departmant_id'::regclass) NOT NULL,
    name character varying
);


ALTER TABLE public.t_departmant OWNER TO cmt;

--
-- TOC entry 220 (class 1259 OID 17095)
-- Name: t_employee; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee (
    id integer DEFAULT nextval('public.seq_employee_id'::regclass) NOT NULL,
    name character varying,
    surname character varying,
    tckn character varying,
    address character varying,
    phone character varying,
    email character varying
);


ALTER TABLE public.t_employee OWNER TO cmt;

--
-- TOC entry 221 (class 1259 OID 17102)
-- Name: t_employee_details; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_employee_details (
    id integer DEFAULT nextval('public.seq_employee_details_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_expenses_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_overtime_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_pay_info_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_performance_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_performance_r_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_premium_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_t_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_wt_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_employee_sp_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_invoice_info_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_invoice_process_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_payment_id'::regclass) NOT NULL,
    type character varying
);


ALTER TABLE public.t_payment OWNER TO cmt;

--
-- TOC entry 233 (class 1259 OID 17178)
-- Name: t_product; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_product (
    id integer DEFAULT nextval('public.seq_product_id'::regclass) NOT NULL,
    name character varying
);


ALTER TABLE public.t_product OWNER TO cmt;

--
-- TOC entry 234 (class 1259 OID 17185)
-- Name: t_product_stock; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_product_stock (
    id integer DEFAULT nextval('public.seq_product_s_id'::regclass) NOT NULL,
    product_id integer,
    unit integer
);


ALTER TABLE public.t_product_stock OWNER TO cmt;

--
-- TOC entry 235 (class 1259 OID 17190)
-- Name: t_product_transaction; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_product_transaction (
    id integer DEFAULT nextval('public.seq_product_t_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_sgk_t_id'::regclass) NOT NULL,
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
    id integer DEFAULT nextval('public.seq_transcation_id'::regclass) NOT NULL,
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
    email character varying,
    is_active boolean
);


ALTER TABLE public.t_user OWNER TO cmt;

--
-- TOC entry 218 (class 1259 OID 17081)
-- Name: t_user_history; Type: TABLE; Schema: public; Owner: cmt
--

CREATE TABLE public.t_user_history (
    id integer DEFAULT nextval('public.seq_user_detail_id'::regclass) NOT NULL,
    user_id integer,
    is_active boolean,
    token character varying,
    login_date timestamp without time zone,
    logout_date date
);


ALTER TABLE public.t_user_history OWNER TO cmt;

--
-- TOC entry 3583 (class 0 OID 17171)
-- Dependencies: 232
-- Data for Name: t_companies; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_companies (id, name, phone, address, email) FROM stdin;
\.


--
-- TOC entry 3588 (class 0 OID 17204)
-- Dependencies: 237
-- Data for Name: t_companies_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_companies_transaction (id, company_id, type_id, date, status, payment_id, payment) FROM stdin;
\.


--
-- TOC entry 3570 (class 0 OID 17088)
-- Dependencies: 219
-- Data for Name: t_departmant; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_departmant (id, name) FROM stdin;
1	Admin
\.


--
-- TOC entry 3571 (class 0 OID 17095)
-- Dependencies: 220
-- Data for Name: t_employee; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee (id, name, surname, tckn, address, phone, email) FROM stdin;
11	baran can	anac	12345678900	asjkfhasfkjlasfkla	5515910897	baran@gmail.com
\.


--
-- TOC entry 3572 (class 0 OID 17102)
-- Dependencies: 221
-- Data for Name: t_employee_details; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_details (id, employee_id, departmant_id, is_active, start_time, end_time) FROM stdin;
11	11	1	t	2024-12-12	\N
\.


--
-- TOC entry 3580 (class 0 OID 17150)
-- Dependencies: 229
-- Data for Name: t_employee_expenses; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_expenses (id, employee_id, date, sgk_prim, issizlik_sigortasi, is_veren_prim, is_veren_issizlik) FROM stdin;
\.


--
-- TOC entry 3575 (class 0 OID 17119)
-- Dependencies: 224
-- Data for Name: t_employee_overtime; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_overtime (id, employee_id, date, overtime, overtime_salary) FROM stdin;
\.


--
-- TOC entry 3573 (class 0 OID 17107)
-- Dependencies: 222
-- Data for Name: t_employee_pay_info; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_pay_info (id, employee_id, salary, hourly_salary) FROM stdin;
11	11	100000	1000
\.


--
-- TOC entry 3577 (class 0 OID 17131)
-- Dependencies: 226
-- Data for Name: t_employee_performance; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_performance (id, employee_id, date, total_amount_product, rate_id) FROM stdin;
\.


--
-- TOC entry 3576 (class 0 OID 17126)
-- Dependencies: 225
-- Data for Name: t_employee_performance_rate; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_performance_rate (id, min_condition, max_condition, rate) FROM stdin;
\.


--
-- TOC entry 3578 (class 0 OID 17136)
-- Dependencies: 227
-- Data for Name: t_employee_premium; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_premium (id, employee_id, date, total_rate, total_premium) FROM stdin;
\.


--
-- TOC entry 3581 (class 0 OID 17157)
-- Dependencies: 230
-- Data for Name: t_employee_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_transaction (id, employee_id, date, status, payment_id, payment_salary) FROM stdin;
\.


--
-- TOC entry 3574 (class 0 OID 17114)
-- Dependencies: 223
-- Data for Name: t_employee_working_time; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employee_working_time (id, employee_id, date, hours_worked) FROM stdin;
\.


--
-- TOC entry 3579 (class 0 OID 17143)
-- Dependencies: 228
-- Data for Name: t_employeee_salary_pay; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_employeee_salary_pay (id, employee_id, date, total_hours_worked, total_overtime, total_salary, total_overtime_salary) FROM stdin;
\.


--
-- TOC entry 3590 (class 0 OID 17218)
-- Dependencies: 239
-- Data for Name: t_invoice_info; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_invoice_info (id, invoice_id, product_id, amount, unit_price, total_payment) FROM stdin;
\.


--
-- TOC entry 3589 (class 0 OID 17211)
-- Dependencies: 238
-- Data for Name: t_invoice_process; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_invoice_process (id, company_id, date, payment_id, total_payment, type_id) FROM stdin;
\.


--
-- TOC entry 3587 (class 0 OID 17197)
-- Dependencies: 236
-- Data for Name: t_payment; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_payment (id, type) FROM stdin;
\.


--
-- TOC entry 3584 (class 0 OID 17178)
-- Dependencies: 233
-- Data for Name: t_product; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_product (id, name) FROM stdin;
\.


--
-- TOC entry 3585 (class 0 OID 17185)
-- Dependencies: 234
-- Data for Name: t_product_stock; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_product_stock (id, product_id, unit) FROM stdin;
\.


--
-- TOC entry 3586 (class 0 OID 17190)
-- Dependencies: 235
-- Data for Name: t_product_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_product_transaction (id, product_id, date, status, amount) FROM stdin;
\.


--
-- TOC entry 3582 (class 0 OID 17164)
-- Dependencies: 231
-- Data for Name: t_sgk_transaction; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_sgk_transaction (id, employee_id, date, status, payment_id, payment_sgk) FROM stdin;
\.


--
-- TOC entry 3591 (class 0 OID 17352)
-- Dependencies: 240
-- Data for Name: t_transaction_type; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_transaction_type (id, type) FROM stdin;
\.


--
-- TOC entry 3568 (class 0 OID 17074)
-- Dependencies: 217
-- Data for Name: t_user; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_user (id, name, surname, username, password, departmant_id, email, is_active) FROM stdin;
12	nazım araz	anac	eden.hazard	$2a$10$Tk540aN0U/zdX6chZXlnkepy1o9uAzMYUkHyHa0MCdQwv.8x3sc.2	1	araz@gmail.com	t
13	nazım araz	anac	asd	$2a$10$UuHwTBRfTaPW95gsOLVZpeoFfkgXhCSQy7JgRxE9Kq63n7ikbr4Qe	1	araz@gmail.com	f
14	baran can	anac	barr	$2a$10$YWlqBa.Cs.hblWvymYHObu1O9IfNZyZzmtWgMazXVRjeYzToDL.h6	1	baran@gmail.com	t
15	baran can	anac	baradr	$2a$10$pPC7tRv07zrmSl7vKfJMYuMe9R.oR6fr2sFIGDTbtysS/PByoQGeO	1	baran@gmail.com	t
16	baran can	anac	barancan	$2a$10$8rszMXXSHU11aUoB.frePe/tWbCG/HtVkwmb5KSHitkVC.Wub/cMu	1	baran@gmail.com	f
17	baran can	anac	barancan	$2a$10$RxNZAwyZpiOanwNvQlL75OxYkbf7I1Ct3z9i2sz5/THRwMazHr3ga	1	baran@gmail.com	t
18	baran can	anac	eden.hazard	$2a$10$hqD0UchLQ.kYoNsC7gY83uZvx9tjkWH/GCjh9xTYkxEgjibFpynJq	1	baran@gmail.com	t
19	baran can	anac	barancan12	$2a$10$nJqG4yFpWUvU8FVHCP1q0edYzGfFz8bHlEWTqogqrBdUY9k8QfUMC	1	baran@gmail.com	t
20	baran can	anac	barancan1254	$2a$10$9Fkv9V6Tr81gGY2WLnRa4OOfIzBVGnzuzMaHFh3dK8dTLZo5iH1qC	1	baran@gmail.com	t
21	baran can	anac	barancan12542	$2a$10$oNOJ395CJa18IY41QkLYMOuUHemj7i1qXOUvtBsCqCfAA6U8HF.g.	1	baran@gmail.com	t
\.


--
-- TOC entry 3569 (class 0 OID 17081)
-- Dependencies: 218
-- Data for Name: t_user_history; Type: TABLE DATA; Schema: public; Owner: cmt
--

COPY public.t_user_history (id, user_id, is_active, token, login_date, logout_date) FROM stdin;
7	12	t	\N	2024-12-10 19:00:01.455	\N
8	12	t	\N	2024-12-10 19:11:21.914	\N
9	12	t	\N	2024-12-10 19:13:33.385	\N
10	12	t	\N	2024-12-10 19:13:33.454	\N
11	12	t	\N	2024-12-10 19:13:45.362	\N
12	12	t	\N	2024-12-10 19:13:45.435	\N
13	12	t	\N	2024-12-10 19:13:50.255	\N
14	12	t	\N	2024-12-10 19:13:50.323	\N
15	12	t	\N	2024-12-10 19:14:29.298	\N
16	12	t	\N	2024-12-10 19:14:29.365	\N
17	14	t	\N	2024-12-11 21:25:35.652	\N
18	14	t	\N	2024-12-11 21:26:06.481	\N
19	14	t	\N	2024-12-11 21:27:41.045	\N
20	14	t	\N	2024-12-11 21:29:01.291	\N
21	14	t	\N	2024-12-11 21:29:27.538	\N
22	14	t	\N	2024-12-11 21:29:50.441	\N
23	14	t	\N	2024-12-11 21:48:55.01	\N
24	14	t	\N	2024-12-11 21:56:51.142	\N
25	14	t	\N	2024-12-11 21:56:51.147	\N
\.


--
-- TOC entry 3622 (class 0 OID 0)
-- Dependencies: 242
-- Name: seq_companies_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_companies_id', 1, false);


--
-- TOC entry 3623 (class 0 OID 0)
-- Dependencies: 243
-- Name: seq_companies_trans_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_companies_trans_id', 1, false);


--
-- TOC entry 3624 (class 0 OID 0)
-- Dependencies: 244
-- Name: seq_departmant_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_departmant_id', 1, false);


--
-- TOC entry 3625 (class 0 OID 0)
-- Dependencies: 246
-- Name: seq_employee_details_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_details_id', 11, true);


--
-- TOC entry 3626 (class 0 OID 0)
-- Dependencies: 247
-- Name: seq_employee_expenses_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_expenses_id', 1, false);


--
-- TOC entry 3627 (class 0 OID 0)
-- Dependencies: 245
-- Name: seq_employee_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_id', 11, true);


--
-- TOC entry 3628 (class 0 OID 0)
-- Dependencies: 248
-- Name: seq_employee_overtime_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_overtime_id', 1, false);


--
-- TOC entry 3629 (class 0 OID 0)
-- Dependencies: 249
-- Name: seq_employee_pay_info_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_pay_info_id', 11, true);


--
-- TOC entry 3630 (class 0 OID 0)
-- Dependencies: 250
-- Name: seq_employee_performance_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_performance_id', 1, false);


--
-- TOC entry 3631 (class 0 OID 0)
-- Dependencies: 251
-- Name: seq_employee_performance_r_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_performance_r_id', 1, false);


--
-- TOC entry 3632 (class 0 OID 0)
-- Dependencies: 252
-- Name: seq_employee_premium_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_premium_id', 1, false);


--
-- TOC entry 3633 (class 0 OID 0)
-- Dependencies: 255
-- Name: seq_employee_sp_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_sp_id', 1, false);


--
-- TOC entry 3634 (class 0 OID 0)
-- Dependencies: 253
-- Name: seq_employee_t_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_t_id', 1, false);


--
-- TOC entry 3635 (class 0 OID 0)
-- Dependencies: 254
-- Name: seq_employee_wt_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_employee_wt_id', 1, false);


--
-- TOC entry 3636 (class 0 OID 0)
-- Dependencies: 256
-- Name: seq_invoice_info_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_invoice_info_id', 1, false);


--
-- TOC entry 3637 (class 0 OID 0)
-- Dependencies: 257
-- Name: seq_invoice_process_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_invoice_process_id', 1, false);


--
-- TOC entry 3638 (class 0 OID 0)
-- Dependencies: 258
-- Name: seq_payment_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_payment_id', 1, false);


--
-- TOC entry 3639 (class 0 OID 0)
-- Dependencies: 259
-- Name: seq_product_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_product_id', 1, false);


--
-- TOC entry 3640 (class 0 OID 0)
-- Dependencies: 260
-- Name: seq_product_s_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_product_s_id', 1, false);


--
-- TOC entry 3641 (class 0 OID 0)
-- Dependencies: 261
-- Name: seq_product_t_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_product_t_id', 1, false);


--
-- TOC entry 3642 (class 0 OID 0)
-- Dependencies: 262
-- Name: seq_sgk_t_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_sgk_t_id', 1, false);


--
-- TOC entry 3643 (class 0 OID 0)
-- Dependencies: 263
-- Name: seq_transcation_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_transcation_id', 1, false);


--
-- TOC entry 3644 (class 0 OID 0)
-- Dependencies: 241
-- Name: seq_user; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_user', 21, true);


--
-- TOC entry 3645 (class 0 OID 0)
-- Dependencies: 264
-- Name: seq_user_detail_id; Type: SEQUENCE SET; Schema: public; Owner: cmt
--

SELECT pg_catalog.setval('public.seq_user_detail_id', 25, true);


--
-- TOC entry 3380 (class 2606 OID 17177)
-- Name: t_companies t_companies_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies
    ADD CONSTRAINT t_companies_pkey PRIMARY KEY (id);


--
-- TOC entry 3390 (class 2606 OID 17210)
-- Name: t_companies_transaction t_companies_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3354 (class 2606 OID 17094)
-- Name: t_departmant t_departmant_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_departmant
    ADD CONSTRAINT t_departmant_pkey PRIMARY KEY (id);


--
-- TOC entry 3358 (class 2606 OID 17106)
-- Name: t_employee_details t_employee_details_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_details
    ADD CONSTRAINT t_employee_details_pkey PRIMARY KEY (id);


--
-- TOC entry 3374 (class 2606 OID 17156)
-- Name: t_employee_expenses t_employee_expenses_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_expenses
    ADD CONSTRAINT t_employee_expenses_pkey PRIMARY KEY (id);


--
-- TOC entry 3364 (class 2606 OID 17125)
-- Name: t_employee_overtime t_employee_overtime_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_overtime
    ADD CONSTRAINT t_employee_overtime_pkey PRIMARY KEY (id);


--
-- TOC entry 3360 (class 2606 OID 17113)
-- Name: t_employee_pay_info t_employee_pay_info_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_pay_info
    ADD CONSTRAINT t_employee_pay_info_pkey PRIMARY KEY (id);


--
-- TOC entry 3368 (class 2606 OID 17135)
-- Name: t_employee_performance t_employee_performance_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance
    ADD CONSTRAINT t_employee_performance_pkey PRIMARY KEY (id);


--
-- TOC entry 3366 (class 2606 OID 17130)
-- Name: t_employee_performance_rate t_employee_performance_rate_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance_rate
    ADD CONSTRAINT t_employee_performance_rate_pkey PRIMARY KEY (id);


--
-- TOC entry 3356 (class 2606 OID 17101)
-- Name: t_employee t_employee_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee
    ADD CONSTRAINT t_employee_pkey PRIMARY KEY (id);


--
-- TOC entry 3370 (class 2606 OID 17142)
-- Name: t_employee_premium t_employee_premium_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_premium
    ADD CONSTRAINT t_employee_premium_pkey PRIMARY KEY (id);


--
-- TOC entry 3376 (class 2606 OID 17163)
-- Name: t_employee_transaction t_employee_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_transaction
    ADD CONSTRAINT t_employee_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3362 (class 2606 OID 17118)
-- Name: t_employee_working_time t_employee_working_time_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_working_time
    ADD CONSTRAINT t_employee_working_time_pkey PRIMARY KEY (id);


--
-- TOC entry 3372 (class 2606 OID 17149)
-- Name: t_employeee_salary_pay t_employeee_salary_pay_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employeee_salary_pay
    ADD CONSTRAINT t_employeee_salary_pay_pkey PRIMARY KEY (id);


--
-- TOC entry 3388 (class 2606 OID 17203)
-- Name: t_payment t_payment_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_payment
    ADD CONSTRAINT t_payment_pkey PRIMARY KEY (id);


--
-- TOC entry 3382 (class 2606 OID 17184)
-- Name: t_product t_product_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product
    ADD CONSTRAINT t_product_pkey PRIMARY KEY (id);


--
-- TOC entry 3384 (class 2606 OID 17189)
-- Name: t_product_stock t_product_stock_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_stock
    ADD CONSTRAINT t_product_stock_pkey PRIMARY KEY (id);


--
-- TOC entry 3386 (class 2606 OID 17196)
-- Name: t_product_transaction t_product_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_transaction
    ADD CONSTRAINT t_product_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3394 (class 2606 OID 17224)
-- Name: t_invoice_info t_sales_info_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_info
    ADD CONSTRAINT t_sales_info_pkey PRIMARY KEY (id);


--
-- TOC entry 3392 (class 2606 OID 17217)
-- Name: t_invoice_process t_sales_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_sales_pkey PRIMARY KEY (id);


--
-- TOC entry 3378 (class 2606 OID 17170)
-- Name: t_sgk_transaction t_sgk_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_sgk_transaction
    ADD CONSTRAINT t_sgk_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3396 (class 2606 OID 17358)
-- Name: t_transaction_type t_transaction_type_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_transaction_type
    ADD CONSTRAINT t_transaction_type_pkey PRIMARY KEY (id);


--
-- TOC entry 3352 (class 2606 OID 17087)
-- Name: t_user_history t_user_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user_history
    ADD CONSTRAINT t_user_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 3350 (class 2606 OID 17080)
-- Name: t_user t_user_pkey; Type: CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user
    ADD CONSTRAINT t_user_pkey PRIMARY KEY (id);


--
-- TOC entry 3415 (class 2606 OID 17331)
-- Name: t_companies_transaction t_companies_transaction_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3416 (class 2606 OID 17369)
-- Name: t_companies_transaction t_companies_transaction_t_companies_fk; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_t_companies_fk FOREIGN KEY (company_id) REFERENCES public.t_companies(id);


--
-- TOC entry 3417 (class 2606 OID 17359)
-- Name: t_companies_transaction t_companies_transaction_t_transaction_type_fk; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_companies_transaction
    ADD CONSTRAINT t_companies_transaction_t_transaction_type_fk FOREIGN KEY (type_id) REFERENCES public.t_transaction_type(id);


--
-- TOC entry 3399 (class 2606 OID 17240)
-- Name: t_employee_details t_employee_details_departmant_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_details
    ADD CONSTRAINT t_employee_details_departmant_id_fkey FOREIGN KEY (departmant_id) REFERENCES public.t_departmant(id);


--
-- TOC entry 3400 (class 2606 OID 17235)
-- Name: t_employee_details t_employee_details_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_details
    ADD CONSTRAINT t_employee_details_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3408 (class 2606 OID 17281)
-- Name: t_employee_expenses t_employee_expenses_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_expenses
    ADD CONSTRAINT t_employee_expenses_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3403 (class 2606 OID 17265)
-- Name: t_employee_overtime t_employee_overtime_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_overtime
    ADD CONSTRAINT t_employee_overtime_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3401 (class 2606 OID 17250)
-- Name: t_employee_pay_info t_employee_pay_info_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_pay_info
    ADD CONSTRAINT t_employee_pay_info_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3404 (class 2606 OID 17255)
-- Name: t_employee_performance t_employee_performance_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance
    ADD CONSTRAINT t_employee_performance_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3405 (class 2606 OID 17260)
-- Name: t_employee_performance t_employee_performance_rate_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_performance
    ADD CONSTRAINT t_employee_performance_rate_id_fkey FOREIGN KEY (rate_id) REFERENCES public.t_employee_performance_rate(id);


--
-- TOC entry 3406 (class 2606 OID 17270)
-- Name: t_employee_premium t_employee_premium_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_premium
    ADD CONSTRAINT t_employee_premium_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3409 (class 2606 OID 17276)
-- Name: t_employee_transaction t_employee_transaction_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_transaction
    ADD CONSTRAINT t_employee_transaction_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3410 (class 2606 OID 17301)
-- Name: t_employee_transaction t_employee_transaction_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_transaction
    ADD CONSTRAINT t_employee_transaction_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3402 (class 2606 OID 17245)
-- Name: t_employee_working_time t_employee_working_time_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employee_working_time
    ADD CONSTRAINT t_employee_working_time_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3407 (class 2606 OID 17341)
-- Name: t_employeee_salary_pay t_employeee_salary_pay_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_employeee_salary_pay
    ADD CONSTRAINT t_employeee_salary_pay_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3418 (class 2606 OID 17364)
-- Name: t_invoice_process t_invoice_process_t_transaction_type_fk; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_invoice_process_t_transaction_type_fk FOREIGN KEY (type_id) REFERENCES public.t_transaction_type(id);


--
-- TOC entry 3413 (class 2606 OID 17291)
-- Name: t_product_stock t_product_stock_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_stock
    ADD CONSTRAINT t_product_stock_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.t_product(id);


--
-- TOC entry 3414 (class 2606 OID 17296)
-- Name: t_product_transaction t_product_transaction_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_product_transaction
    ADD CONSTRAINT t_product_transaction_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.t_product(id);


--
-- TOC entry 3419 (class 2606 OID 17306)
-- Name: t_invoice_process t_sales_company_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_sales_company_id_fkey FOREIGN KEY (company_id) REFERENCES public.t_companies(id);


--
-- TOC entry 3421 (class 2606 OID 17321)
-- Name: t_invoice_info t_sales_info_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_info
    ADD CONSTRAINT t_sales_info_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.t_product(id);


--
-- TOC entry 3422 (class 2606 OID 17316)
-- Name: t_invoice_info t_sales_info_sales_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_info
    ADD CONSTRAINT t_sales_info_sales_id_fkey FOREIGN KEY (invoice_id) REFERENCES public.t_invoice_process(id);


--
-- TOC entry 3420 (class 2606 OID 17311)
-- Name: t_invoice_process t_sales_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_invoice_process
    ADD CONSTRAINT t_sales_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3411 (class 2606 OID 17286)
-- Name: t_sgk_transaction t_sgk_transaction_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_sgk_transaction
    ADD CONSTRAINT t_sgk_transaction_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.t_employee(id);


--
-- TOC entry 3412 (class 2606 OID 17336)
-- Name: t_sgk_transaction t_sgk_transaction_payment_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_sgk_transaction
    ADD CONSTRAINT t_sgk_transaction_payment_id_fkey FOREIGN KEY (payment_id) REFERENCES public.t_payment(id);


--
-- TOC entry 3397 (class 2606 OID 17230)
-- Name: t_user t_user_departman_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user
    ADD CONSTRAINT t_user_departman_id_fkey FOREIGN KEY (departmant_id) REFERENCES public.t_departmant(id);


--
-- TOC entry 3398 (class 2606 OID 17225)
-- Name: t_user_history t_user_detail_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: cmt
--

ALTER TABLE ONLY public.t_user_history
    ADD CONSTRAINT t_user_detail_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.t_user(id);


-- Completed on 2024-12-12 17:16:52

--
-- PostgreSQL database dump complete
--

