-- 8-1 from 절에 여러 테이블 지정
SELECT * FROM emp, dept ORDER BY empno;

-- 8-2 join 과 별칭
SELECT * 
FROM emp e, dept d
WHERE e.deptno = d.deptno
order by empno;

-- 8-5 equi join
SELECT e.empno, e.ename, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
order by d.deptno, e.empno;

-- 8-7 non equi join
SELECT *
FROM emp E, salgrade S
WHERE E.sal BETWEEN S.losal AND S.hisal;


-- 8-8 inner join
select e1.empno, e1.ename, e1.mgr,
    e2.empno as mgr_empno,
    e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr = e2.empno;


-- 8-9 outer join
SELECT e1.empno, e1.ename, e1.mgr,
    e2.empno AS mgr_empno,
    e2.ename AS mgr_ename
FROM emp e1, emp e2
WHERE e1.mgr(+) = e2.empno
ORDER BY e1.empno;


-- JOIN ON 
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
    E2.EMPNO AS MGR_EMPNO,
    E2.ENAME AS MGR_ENAME
FROM EMP E1 JOIN EMP E2
ON E1.MGR(+) = E2.EMPNO
ORDER BY E1.EMPNO;

-- Natural Join
SELECT E.empno, E.ename, E.JOB, E.mgr, E.hiredate, E.sal, E.comm
    deptno, D.dname, D.loc
FROM emp E NATURAL JOIN dept D
ORDER BY deptno, E.empno;



-- 문제 1. 급여가 2000을 초과한 사원의 부서 정보, 사원 정보를 출력
SELECT D.DEPTNO, D.DNAME, E.EMPNO, E.ENAME, E.SAL
FROM EMP E JOIN DEPT D
ON E.SAL > 2000 AND E.DEPTNO = D.DEPTNO
ORDER BY D.DEPTNO;

SELECT D.DEPTNO, D.DNAME, E.EMPNO, E.ENAME, E.SAL
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
WHERE E.SAL > 2000 
ORDER BY D.DEPTNO;

SELECT D.DEPTNO, D.DNAME, E.EMPNO, E.ENAME, E.SAL
FROM EMP E, DEPT D
WHERE E.SAL > 2000 AND E.DEPTNO = D.DEPTNO
ORDER BY D.DEPTNO;

-- 문제 2. 부서별 평균 급여, 최대/최소 급여, 사원 수 출력
SELECT D.DEPTNO, D.DNAME,
    TRUNC(AVG(E.SAL)) AVG_SAL,
    MAX(E.SAL) MAX_SAL,
    MIN(E.SAL) MIN_SAL,
    COUNT(*) CNT
FROM EMP E JOIN DEPT D ON E.DEPTNO = D.DEPTNO
GROUP BY D.DEPTNO, D.DNAME;

-- 문제 3. 모든 부서 정보와 사원 정보를 부서 번호, 사원 이름 순으로 정렬하여 출력
SELECT 
    D.deptno, D.dname, 
    E.empno, E.ename, E.JOB, E.sal
FROM emp E RIGHT JOIN dept D 
ON E.deptno = D.deptno
ORDER BY D.deptno, E.ename;

-- 문제 4. 부서 정보, 사원 정보, 급여 등급 정보, 각 사원의 직속상관 정보
를 부서 번호, 사원 번호 순서로 정렬하여 출력
SELECT
    D.DEPTNO, D.DNAME, 
    E.EMPNO, E.ENAME,E.MGR, E.SAL,E.DEPTNO,
    G.LOSAL, G.HISAL, G.GRADE,
    M.EMPNO MGR_EMPNO, M.ENAME MGR_ENAME
FROM DEPT D LEFT JOIN EMP E ON D.DEPTNO = E.DEPTNO
    LEFT JOIN SALGRADE G ON E.SAL BETWEEN G.LOSAL AND G.HISAL
    LEFT JOIN EMP M ON E.EMPNO = M.EMPNO
ORDER BY D.DEPTNO, E.EMPNO;

SELECT
    D.deptno, D.dname, 
    E.empno, E.ename,E.mgr, E.sal,E.deptno,
    G.losal, G.hisal, G.grade,
    M.empno mgr_empno, M.ename mgr_ename
FROM emp E RIGHT JOIN  dept D  ON D.deptno = E.deptno
    LEFT JOIN salgrade G ON E.sal BETWEEN G.losal AND G.hisal
    LEFT JOIN emp M ON E.empno = M.empno
ORDER BY D.deptno, E.empno;
