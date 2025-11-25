-- SQL1. 장바구니의 수

CREATE TABLE CARTS 
(
  ID NUMBER 
, USER_ID NUMBER 
, PAYED_AT DATE 
, PRODUCT_COUNT NUMBER 
);


insert into CARTS values (636, 3, to_date('2001-02-23 00:00:00','yyyy-mm-dd hh24:mi:ss'), 5);
insert into CARTS values (287, 4, to_date('2000-05-27 00:00:00','yyyy-mm-dd hh24:mi:ss'), 13);
insert into CARTS values (448, 4, to_date('2000-08-17 00:00:00','yyyy-mm-dd hh24:mi:ss'), 17);
insert into CARTS values (578, 4, to_date('2001-01-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), 9);
insert into CARTS values (734, 11, to_date('2001-04-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), 10);
insert into CARTS values (195, 11, to_date('2000-04-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), 11);
commit;

SELECT * FROM CARTS;

-- 풀이

SELECT USER_ID,
        COUNT(*) AS PAYED_COUNT
FROM CARTS
WHERE PRODUCT_COUNT >= 10
GROUP BY USER_ID
ORDER BY PAYED_COUNT ASC, USER_ID DESC;


-- SQL2. 결제를 가장 많이한 가게

create table MERCHANTS(
	id number primary key,
	name varchar2(50),
	BUSINESS_ID  varchar2(30),
	TAX_TYPE varchar2(30),
	CATEGORY_ID  number
);

create table CARD_USAGES (
	id number,
	CREATED_AT date,
	CATEGORY number,
	AMOUNT number,
	MERCHANT_ID number
);

insert into MERCHANTS values(3907, 'KFC학동역', '201-81-89723', '일반과세자', 1);
insert into MERCHANTS values(4989, '미켈 (Mikelle)고깃집', '785-49-00298' , '일반과세자', 1);
insert into MERCHANTS values(6297, '뉴발란스 강남점' , '214-85-50334' , '일반과세자', 6);
insert into MERCHANTS values(27052, '주식회사이마트몰-주식회사이마트몰' , '104-86-50432', '일반과세자', 2);
insert into MERCHANTS values(118009, '플라이앤컴퍼니(주)' ,'211-88-57343', '일반과세자', 1);

insert into CARD_USAGES values('195772', to_date('2018-05-02 18:54:43','yyyy-mm-dd hh24:mi:ss'), 0, 2700, 3907);
insert into CARD_USAGES values('2530342', to_date('2019-01-28 09:47:33','yyyy-mm-dd hh24:mi:ss'), 0, 12300, 3907);
insert into CARD_USAGES values('899325', to_date('2018-08-03 16:57:36','yyyy-mm-dd hh24:mi:ss'), 0, 45000, 4989);
insert into CARD_USAGES values('400811', to_date('2018-05-28 12:45:34','yyyy-mm-dd hh24:mi:ss'), 0, 4000, 6297);
insert into CARD_USAGES values('743640', to_date('2018-07-07 11:47:17','yyyy-mm-dd hh24:mi:ss'), 0, 299000, 27052);
insert into CARD_USAGES values('1052039', to_date('2018-08-15 13:40:01','yyyy-mm-dd hh24:mi:ss'), 1, -12900, 118009);
insert into CARD_USAGES values('1120840', to_date('2018-08-21 06:58:55','yyyy-mm-dd hh24:mi:ss'), 0, 20800, 118009);
commit;


SELECT * FROM MERCHANTS;
SELECT * FROM CARD_USAGES;

-- 풀이 
SELECT 
    MERCHANT_ID AS ID, 
    M.NAME, 
    SUM(AMOUNT) AS 결제금액 
FROM CARD_USAGES, MERCHANTS M
WHERE CATEGORY = 0 AND M.ID = MERCHANT_ID
GROUP BY MERCHANT_ID, CATEGORY, M.NAME
ORDER BY 결제금액 DESC;






-- SQL3. 월급 대비 매출
create table EMPLOYEES_shinhan(
    id number primary key ,
    NAME VARCHAR(20) not null,
    SALARY number(20,0) not null,
    BRANCH_ID NUMERIC  not null);

insert into EMPLOYEES_shinhan values(1015, 'Vex', 900, 1);
insert into EMPLOYEES_shinhan values(3317, 'Stephanie', 250, 3);
insert into EMPLOYEES_shinhan values(3884 , 'Audrina',470, 1);
insert into EMPLOYEES_shinhan values(3912, 'Courtney', 300, 2);

create table SELLINGS_shinhan (
CAR_ID number not null,
EMPLOYEE_ID number not null,
CREATED_AT date not null,
PRICE NUMERIC(20,0) not null);

insert into SELLINGS_shinhan values(306, 3317,  to_date('2016-07-19 12:40:54','yyyy-mm-dd hh24:mi:ss'), 500);
insert into SELLINGS_shinhan values(414, 3884 , to_date('2016-07-17 07:53:19','yyyy-mm-dd hh24:mi:ss'), 1700);
insert into SELLINGS_shinhan values(537, 3317,  to_date('2016-07-22 18:47:05','yyyy-mm-dd hh24:mi:ss'), 1600);
insert into SELLINGS_shinhan values(594, 3884,  to_date('2016-12-02 19:33:28','yyyy-mm-dd hh24:mi:ss'), 700);
insert into SELLINGS_shinhan values(810, 3912,  to_date('2016-07-09 03:09:21','yyyy-mm-dd hh24:mi:ss'), 4100);
insert into SELLINGS_shinhan values(900, 1015,  to_date('2016-08-14 13:20:56','yyyy-mm-dd hh24:mi:ss'), 15300);

commit;

SELECT * FROM EMPLOYEES_SHINHAN;
SELECT * FROM SELLINGS_SHINHAN;

/*
한 달 동안 각 직원이 판매한 자동차 판매 가격의 합을 해당 직원의 월급으로 나눈 것을 월급 대비 매출이라 합니다. 월급 대비 매출은 소수점 첫째 자리에서 반올림하여 정수로 나타냅니다. 2016년 7월 월급 대비 매출이 10 이하인 직원의 이름과 월급을 조회하는 SQL 문을 작성해주세요. 단, 2016년 7월에 매출이 없는 직원은 결과에 포함하지 않습니다. 결과는 월급을 기준으로 내림차순 정렬하고, 월급이 같은 경우 직원의 이름으로 사전 순 정렬해주세요.
*/

-- 풀이
/*
자동차 판매 합 / 월급 < 10
*/

SELECT 
    E.NAME, 
    E.SALARY
FROM SELLINGS_SHINHAN S, EMPLOYEES_SHINHAN E
WHERE S.EMPLOYEE_ID = E.ID
GROUP BY E.SALARY, E.NAME
HAVING ROUND(SUM(S.PRICE) / E.SALARY, 0) <= 10
ORDER BY E.SALARY DESC, E.NAME ASC;
 
