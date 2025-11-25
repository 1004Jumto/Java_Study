SELECT emp.ename, dept.dname
FROM emp JOIN dept ON emp.deptno = dept.deptno;

-- 페이징 처리
SELECT * FROM emp ORDER BY deptno LIMIT 0,10;


-- 날짜
SELECT SYSDATE(), CURDATE(), CURRENT_DATE(), NOW();
SELECT DATEDIFF('2024-06-17', NOW());
SELECT DATEDIFF(NOW(),'2024-06-17') AS Dday;
SELECT DATE_ADD(NOW(), INTERVAL 10 DAY);
SELECT DATE_SUB(NOW(), INTERVAL 10 DAY);
SELECT DATE_ADD(NOW(), INTERVAL -10 DAY);
SELECT DATE_FORMAT(NOW(), '%y-%m-%d');

-- null
SELECT salary + bonus FROM emp;
SELECT salary + IFNULL(bonus, 0) FROM emp;

-- 조건
SELECT if(salary >= 1000, 'A', 'B') FROM emp;

-- concat
SELECT CONCAT(ename, ' : ', job) FROM emp;

INSERT INTO MEMBER(id) VALUES('hong');
SELECT * FROM MEMBER;
SELECT * FROM MEMBER WHERE id LIKE 'S%';





