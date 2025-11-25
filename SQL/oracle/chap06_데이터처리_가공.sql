/*
single-row function(단일행 함수) : 하나 들어가서 하나 나오는 함수
multi-row function(다중행 함수) : 여러개 들어가서 하나 나오는 함수
*/
-- 6-1
select ename, upper(ename), lower(ename), initcap(ename)
from emp;

-- 6-2
select * from emp
where upper(ename) = upper('scott');

-- 6-4
select ename, length(ename), length('홍길동'), lengthb('홍길동') from emp;

-- 함수 확인, 테스트
select length('한글') from dual;

-- 6-7
-- 시작인덱스가 1
select job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 5) from emp;

-- 6-8
select job,
    substr(job, -length(job)),
    substr(job, -length(job), 2),
    substr(job, -3)
from emp;

-- INSTR함수 : 들어있으면 인덱스, 없으면 0
select instr(ename, 'A') from emp;

select instr('aaaa', 'b') from dual; -- 확인


-- 6-12
select '010-1234-5678' replace_before,
    replace('010-1234-5678', '-', ' ') replace_1,
    replace('010-1234-5678', '-') replace_2,
    replace('010-1234-5678', '-', '') replace_3
from dual;

-- 6-15
select concat(empno, ename),
    concat(empno, concat(' : ', ename)),
    -- concat(empno, ' : ', ename)
    empno || ' : ' || ename
from emp
where ename = 'SCOTT';

-- 6-16
select '[' || trim('  __Oracle__  ') || ']' as trim,
    '[' || trim(leading from '  __Oracle__  ') || ']' as trim_leading,
    '[' || trim(trailing from '  __Oracle__  ') || ']' as trim_trailing,
    '[' || trim(both from '  __Oracle__  ') || ']' as trim_trim
from dual;

-- 6-19
select round(1234.5678) as round,
    round(1234.5678, 0) as round_0,
    round(1234.5678, 1) as round_1,
    round(1234.5678, 2) as round_2,
    round(1234.5678, -1) as round_minus1,
    round(1234.5678, -2) as round_minus2
from dual;

-- 6-20
select trunc(1234.5678) as trunc,
    trunc(1234.5678, 0) as trunc_0,
    trunc(1234.5678, 1) as trunc_1,
    trunc(1234.5678, 2) as trunc_2,
    trunc(1234.5678, -1) as trunc_minus1,
    trunc(1234.5678, -2) as trunc_minus2
from dual;

/*
ceil : 주어진값보다 큰 정수중에 가장 작은 정수 : 올림
floor : 주어진값보다 작은 정수중에 가장 큰 정수 : 내림
*/

-- 6-23
select
    sysdate as now,
    sysdate - 1 as yesterday,
    sysdate + 1 as tomorrow
from dual;

-- to_date() 날짜타입으로 변환해주는 함수
select trunc(sysdate - to_date('2025-10-23')) from dual;

-- 6-24
select sysdate, add_months(sysdate, 3) from dual; -- 3개월 후
select sysdate, add_months(sysdate, -3) from dual; -- 3개월 전


-- 6-22
select empno, ename, hiredate, sysdate,
    months_between(hiredate, sysdate) as months1,
    months_between(sysdate, hiredate) as months2,
    trunc(months_between(sysdate, hiredate)) as months3
from emp;

-- 6-28
select sysdate, to_char(sysdate, 'yyyy-mm-dd HH:mi:ss'),
    next_day(sysdate, '월요일'),
    last_day(sysdate)
from dual;

-- 6-31
-- 자동형변환 (문자 -> 숫자)
select empno, ename, empno+'500' from emp where ename = 'SCOTT';

-- 문자 -> 날짜
select * from emp where hiredate between '1987-01-01' and '1987-12-31';

-- 6-33
select to_char(sysdate, 'yyyy/mm/dd hh24:mi:ss') as 현재날짜시간 from dual;

-- 6-39
select
    1300 - '1500',
    '1300' - 1500,
    '1300'+ 1500,    
    1300 + '1500'
from dual;

select
    '1300' + '1300'
from dual;

select * from emp where deptno='20';
select * from emp where deptno=20;

/*
함수(값, 출력포맷)
함수(값, 입력포맷)

*/

-- 6-42
-- to_date(날짜타입으로 바꿀 문자열, 이문자열의 포맷)
select to_date('2024-08-14', 'yyyy-mm-dd') as todate1,
    to_date('2024/08/14', 'yyyy/mm/dd') as todate2
from dual;

select to_date('08/14/2024', 'mm/dd/yyyy') from dual;

-- 6-43
select * from emp where hiredate > to_date('1981/06/01', 'YYYY/MM/DD');

-- 날짜비교시 주의
select * from emp where hiredate >= to_date('1981-06-09 00:00:00', 'yyyy-mm-dd hh24:mi:ss');


-- 랭킹함수
/*
순서를 나타내는 함수
- row_number() : 행 넘버링
- rank() : 순위
- dense_rank() : 밀도 순위
*/
select
    ename, sal,
    row_number() over(order by sal desc) as rank1,
    rank() over(order by sal desc) as rank2,
    dense_rank() over(order by sal desc) as rank3
from emp;

/*
null 처리 함수

- nvl(값, 값이 null일때)
- nvl2(값, 값이 null이 아닐때, 값이 null일때)
*/
select nvl2(null, 1, 2) from dual;

-- 6-46
select empno, ename, comm,
    nvl2(comm, 'O', 'X'),
    nvl2(comm, sal*12+comm, sal*12) as annsal
from emp;

-- 6-47
select empno, ename, job, sal,
    decode(job,
        'MANAGER', sal*1.1,
        'SALESMAN', sal*1.05,
        'ANALYST', sal,
        sal*1.03) as upsal
from emp;

-- 6-48
select empno, ename, job, sal,
    case job
        when 'MANAGER' then sal*1.1
        when 'SALESMAN' then sal*1.05
        when 'ANALYST' then sal
        else sal * 1.03
    end as upsal
from emp;

-- 6-49 CASE 문
select empno, ename, comm,
    case
        when comm is null then '해당사항 없음'
        when comm = 0 then '수당 없음'
        when comm > 0 then '수당: ' || comm
    end AS comm_text
from emp;


-- 되새김 문제
-- chap06-1 방법 1
select empno, 
       rpad(substr(empno, -length(empno), 2),length(empno), '*') as masking_empno,
       ename, 
       rpad(substr(ename, -length(ename), 1),length(ename), '*') as masking_ename
from emp
where length(ename)=5;
---- 방법 2
select 
    empno, 
    substr(empno, 1, 2) || '**' as masking_empno,
    ename, 
    substr(ename, 1, 1) || '****' as masking_ename
from emp
where length(ename)=5;


-- chap06-2
select empno, ename, sal,
       trunc(sal/21.5, 2) as day_pay,
       round(sal/21.5/8, 1) as time_pay
from emp;


-- chap06-3
select 
    empno,
    ename,
    hiredate,
    next_day(add_months(hiredate,3), '월') as r_job,
    nvl(TO_CHAR(comm),'N/A')
from emp;



-- chap06-4
select empno, ename, mgr,
    case
        when mgr is null then 0000
        when mgr like '75%' then 5555
        when mgr like '76%' then 6666
        when mgr like '77%' then 7777
        when mgr like '78%' then 8888
        else mgr        
    end as chg_mgr
from emp;

