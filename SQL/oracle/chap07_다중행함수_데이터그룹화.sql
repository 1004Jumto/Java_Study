/*
다중행 함수
여러행 -> 하나의 행으로 출력
null 제외
MIN MAX AVG COUNT SUM
*/

-- 7-1 
select SUM(sal)
from emp;

select count(comm) from emp;
select count(*) from emp;

/*
그룹핑
- ~별로
- 같은 값끼리 묶는 것
- 주의점: group by 사용시 col자리에는 그룹핑한 col 또는 집계함수만 가능
*/
-- 7-17
select round(avg(sal),1), deptno
from emp
group by deptno;

-- 7-18
select deptno, job, avg(sal)
from emp
group by deptno, job
order by deptno, job;


/*Having*/
-- 7-20 group by절과 having 절을 사용해 출력하기
SELECT deptno, job, avg(sal)
FROM emp
GROUP BY deptno, job
HAVING avg(sal) >=2000
ORDER BY deptno, job;

-- 문제 1. 부서별 평균 급여, 최고 급여, 최저 급여, 사원 수 출력
SELECT
    deptno, 
    TRUNC(AVG(sal), 0),
    MAX(sal),
    MIN(sal),
    COUNT(empno) as CNT
FROM emp
GROUP BY deptno;

-- 문제 2. 같은 직책에 종사하는 사원이 3명 이상인 직책과 인원 수 출력
SELECT
    job,
    COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*)>=3;

-- 문제 3. 사원의 입사연도를 기준으로 부서별로 몇 명씩 입사했는지 출력
select 
    to_char(hiredate, 'YYYY') as hire_year,
    deptno,
    count(*)
from emp
group by deptno, to_char(hiredate, 'YYYY');
-- extract, substr 사용도 가능

-- 문제 4. 추가 수당을 받는 사원 수와 받지 않는 사원 수 출력
SELECT 
    NVL2(COMM, 'O', 'X') AS EXIST_COMM,
    COUNT(*)
FROM EMP
GROUP BY NVL2(COMM, 'O', 'X');
     