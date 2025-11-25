select ename, job from emp;
select * from dept;
desc emp;

-- 전체 열 조회
SELECT * FROM emp;

-- 열이 여러 개일 때 distinct로 열 중복 제거하기
SELECT DISTINCT job, deptno
FROM emp;

-- 별칭 사용하기
SELECT ename, sal, sal*12+comm, comm from emp;
SELECT ename, sal, sal*12+comm AS annsal, comm from emp;

-- 오름차순 정렬하기
SELECT * FROM emp ORDER BY sal;

-- 내림차순 정렬하기
SELECT * FROM emp ORDER BY sal DESC;

-- 각각 열에 오름차순 내림차순 정렬하기
SELECT * FROM emp ORDER BY deptno ASC, sal DESC;

-- 5-5 곱셈 산술연산자 
select *  from emp where sal*12 = 36000;
-- null은 연산 불가/ null이면 0이 되도록 하는 함수
select ename, sal, comm, nvl(comm, 0), sal*12+nvl(comm, 0) AS annsal from emp;
-- null 인 데이터 필터링(is null, is not null)
select * from emp where comm is null;

-- 5-9 비교 연산자
select * from emp where sal != 3000;
select * from emp where sal <> 3000;
select * from emp where sal ^= 3000;


-- 5-14 IN 연산자
select * from emp where job in ('MANAGER','SALESMAN','CLERK');
select * from emp where job not in ('MANAGER','SALESMAN','CLERK');

-- 5-18 BETWEEN
select * from emp where sal between 2000 and 3000;
select * from emp where sal not between 2000 and 3000;
select * from emp where hiredate BETWEEN '1981-05-01' and '1981-06-30';
/*
시간까지 포함된 데이터
조회: 주문일자 between '2025-01-01' and '2025-01-31' -> 에러
이유: between '2025-01-01' and '2025-01-31' 는 기본적으로 00:00:00 이므로 1월31일의 데이터는 안나옴
해결방법
1. 조회시 between '2025-01-01 00:00:00' and '2025-01-31 23:59:59' 시간까지 설정
2. 주문일자 -> 동일한 형태로 변환(YYYY-MM-DD)
*/

-- 5-20 LIKE
select * from emp where ename like 'S%';
select * from emp where ename like '%M%';
/*
LIKE연산 시 사용하는 와일드 카드
% : 0개 이상
_ : 1개
*/
select * from emp where ename like 'WAR_';


