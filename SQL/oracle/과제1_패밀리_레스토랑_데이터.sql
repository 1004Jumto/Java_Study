-- 01. 환경 분석
SELECT * FROM ADDRESS;
SELECT * FROM CUSTOMER;
SELECT * FROM ITEM;
SELECT * FROM ORDER_INFO;
SELECT * FROM RESERVATION;

-- 02. 매출 분석
SELECT 
    COUNT(*) 총주문건, 
    SUM(SALES) 총매출합계, 
    ROUND(AVG(SALES),0) 평균매출, 
    MAX(SALES) 최고매출, 
    MIN(SALES) 최저매출
FROM ORDER_INFO;

-- 03. 매출 비교 분석
SELECT 
    COUNT(*) 총주문건, 
    SUM(SALES) 총매출합계,
    SUM(CASE WHEN ITEM_ID = 'M0001' THEN 1 ELSE 0 END) 온라인전용상품주문건,
    SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES END) 온라인전용상품매출합
FROM ORDER_INFO;

SELECT 
    COUNT(*) 총주문건, 
    SUM(SALES) 총매출합계,
    SUM(CASE WHEN ITEM_ID = 'M0001' THEN 1 ELSE 0 END) 온라인전용상품주문건,
    SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES END) 온라인전용상품매출합,
    ROUND(SUM(CASE WHEN ITEM_ID = 'M0001' THEN 1 ELSE 0 END) / COUNT(*) * 100,2) 주문건수비율,
    ROUND(SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES END) / SUM(SALES) * 100,2) 매출합계비율
FROM ORDER_INFO;

-- 04. 상품별 매출 분석
SELECT  
    O.ITEM_ID,
    I.PRODUCT_NAME,
    SUM(O.SALES) 매출합계
FROM ORDER_INFO O JOIN ITEM I
ON O.ITEM_ID = I.ITEM_ID 
GROUP BY O.ITEM_ID, I.PRODUCT_NAME
ORDER BY 매출합계 DESC;

-- 05. 월별 상품 매출 분석(시계열 분석)
SELECT
    SUBSTR(O.RESERV_NO, 0, 6) 년월,
    SUM(CASE WHEN O.ITEM_ID = 'M0001' THEN O.SALES ELSE 0 END) AS SPECIAL_SET,
    SUM(CASE WHEN O.ITEM_ID = 'M0002' THEN O.SALES ELSE 0 END) AS PASTA,
    SUM(CASE WHEN O.ITEM_ID = 'M0003' THEN O.SALES ELSE 0 END) AS PIZZA,
    SUM(CASE WHEN O.ITEM_ID = 'M0004' THEN O.SALES ELSE 0 END) AS SEA_FOOD,
    SUM(CASE WHEN O.ITEM_ID = 'M0005' THEN O.SALES ELSE 0 END) AS STEAK,
    SUM(CASE WHEN O.ITEM_ID = 'M0006' THEN O.SALES ELSE 0 END) AS SALAD_BAR,
    SUM(CASE WHEN O.ITEM_ID = 'M0007' THEN O.SALES ELSE 0 END) AS SALAD,
    SUM(CASE WHEN O.ITEM_ID = 'M0008' THEN O.SALES ELSE 0 END) AS SANDWITCH,
    SUM(CASE WHEN O.ITEM_ID = 'M0009' THEN O.SALES ELSE 0 END) AS WINE,
    SUM(CASE WHEN O.ITEM_ID = 'M0010' THEN O.SALES ELSE 0 END) AS JUICE
FROM ORDER_INFO O
GROUP BY SUBSTR(O.RESERV_NO, 0, 6) 
ORDER BY 년월;

-- 06. 월별 총매출, 전용상품매출 비교 분석
SELECT
    SUBSTR(RESERV_NO, 0, 6) AS 년월,
    SUM(SALES) AS 매출합계,
    SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES ELSE 0 END) AS SPECIAL_SET
FROM ORDER_INFO
GROUP BY SUBSTR(RESERV_NO, 0, 6) 
ORDER BY 년월;

-- 07. 매출 기여율
SELECT
    SUBSTR(RESERV_NO, 0, 6) AS 년월,
    SUM(CASE WHEN ITEM_ID != 'M0001' THEN SALES ELSE 0 END) AS ETC,
    SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES ELSE 0 END) AS SPECIAL_SET,
    ROUND(SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES ELSE 0 END) / SUM(SALES) * 100, 1) AS 매출기여율
FROM ORDER_INFO
GROUP BY SUBSTR(RESERV_NO, 0, 6) 
ORDER BY 년월;

SELECT
    년월,
    ETC,
    SPECIAL_SET,
    ROUND(SPECIAL_SET / TOTAL * 100, 1) AS 매출기여율
FROM 
    (SELECT
        SUBSTR(RESERV_NO, 0, 6) AS 년월,
        SUM(SALES) AS TOTAL,
        SUM(CASE WHEN ITEM_ID != 'M0001' THEN SALES ELSE 0 END) AS ETC,
        SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES ELSE 0 END) AS SPECIAL_SET
        FROM ORDER_INFO
        GROUP BY SUBSTR(RESERV_NO, 0, 6) 
    ) T
ORDER BY 년월;

-- 08. 예약 완료/취소건 분석
SELECT
    년월,
    ETC,
    SPECIAL_SET,
    ROUND(SPECIAL_SET / TOTAL * 100, 1) AS 매출기여율,
    총주문건,
    총주문건 - 취소주문건 AS 예약완료건,
    취소주문건
FROM 
    (SELECT
        SUBSTR(R.RESERV_NO, 0, 6) AS 년월,
        SUM(O.SALES) AS TOTAL,
        SUM(CASE WHEN O.ITEM_ID != 'M0001' THEN O.SALES ELSE 0 END) AS ETC,
        SUM(CASE WHEN O.ITEM_ID = 'M0001' THEN O.SALES ELSE 0 END) AS SPECIAL_SET, 
        COUNT(*) AS 총주문건,
        SUM(CASE WHEN O.ORDER_NO is null THEN 1 ELSE 0 END) AS 취소주문건
    FROM ORDER_INFO O RIGHT OUTER JOIN RESERVATION R 
    ON O.RESERV_NO = R.RESERV_NO
    GROUP BY SUBSTR(R.RESERV_NO, 0, 6) 
    ) T
ORDER BY 년월;

-- 09. 월별 취소율 추이 분석
SELECT
    년월,
    총주문건,
    총주문건 - 예약취소권 AS 예약완료건,
    예약취소권,
    TO_CHAR(ROUND(예약취소권 / 총주문건 * 100, 1)) || '%' AS 예약취소율
FROM 
    (SELECT
        SUBSTR(R.RESERV_NO, 0, 6) AS 년월,
        COUNT(*) AS 총주문건,
        SUM(CASE WHEN O.ORDER_NO is null THEN 1 ELSE 0 END) AS 예약취소권
    FROM ORDER_INFO O RIGHT OUTER JOIN RESERVATION R 
    ON O.RESERV_NO = R.RESERV_NO
    GROUP BY SUBSTR(R.RESERV_NO, 0, 6) 
    ) T
ORDER BY 년월;

-- 10.요일별 매출 분석
/*
- 전용상품의 데이터는 예약정보, 주문정보, 상품정보 3개의 테이블을 조인하여 인라인 뷰 영역으로 지정
- 인라인 뷰 영역을 서브쿼리로 테이블처럼 사용
- 요일별 건수 합계를 계산하고, 일자순으로 정렬
*/ 
SELECT
    년월, 상품명, 일요일, 월요일, 화요일, 수요일, 목요일, 금요일, 토요일
FROM(
    SELECT SUBSTR(O.RESERV_NO, 0, 6) AS 년월,
            I.PRODUCT_NAME AS 상품명,
            SUM(CASE WHEN TO_CHAR(TO_DATE(R.RESERV_DATE, 'YYYYMMDD'), 'D') = '1' THEN O.SALES ELSE 0 END) AS 일요일,
            SUM(CASE WHEN TO_CHAR(TO_DATE(R.RESERV_DATE, 'YYYYMMDD'), 'D') = '2' THEN O.SALES ELSE 0 END) AS 월요일,
            SUM(CASE WHEN TO_CHAR(TO_DATE(R.RESERV_DATE, 'YYYYMMDD'), 'D') = '3' THEN O.SALES ELSE 0 END) AS 화요일,
            SUM(CASE WHEN TO_CHAR(TO_DATE(R.RESERV_DATE, 'YYYYMMDD'), 'D') = '4' THEN O.SALES ELSE 0 END) AS 수요일,
            SUM(CASE WHEN TO_CHAR(TO_DATE(R.RESERV_DATE, 'YYYYMMDD'), 'D') = '5' THEN O.SALES ELSE 0 END) AS 목요일,
            SUM(CASE WHEN TO_CHAR(TO_DATE(R.RESERV_DATE, 'YYYYMMDD'), 'D') = '6' THEN O.SALES ELSE 0 END) AS 금요일,
            SUM(CASE WHEN TO_CHAR(TO_DATE(R.RESERV_DATE, 'YYYYMMDD'), 'D') = '7' THEN O.SALES ELSE 0 END) AS 토요일
    FROM ORDER_INFO O JOIN ITEM I ON I.ITEM_ID = O.ITEM_ID
                        JOIN RESERVATION R ON  O.RESERV_NO = R.RESERV_NO
    WHERE O.ITEM_ID = 'M0001'
    GROUP BY SUBSTR(O.RESERV_NO, 0, 6), I.PRODUCT_NAME
) T
ORDER BY 년월;


-- 11. 월별 전용 상품 실적 순위 분석  
SELECT *
FROM (SELECT 
            년월, 지점, 매출액,    
            RANK() OVER (PARTITION BY 년월 ORDER BY 매출액 DESC) AS 순위 
        FROM (
            SELECT 
                SUBSTR(O.RESERV_NO, 0, 6) AS 년월, 
                R.BRANCH AS 지점, 
                SUM(O.SALES) AS 매출액
            FROM ORDER_INFO O JOIN RESERVATION R ON O.RESERV_NO = R.RESERV_NO
            WHERE O.ITEM_ID = 'M0001'
            GROUP BY SUBSTR(O.RESERV_NO, 0, 6), R.BRANCH
        ) T
        ORDER BY 년월, 매출액 DESC)
WHERE 순위 <= 3;

SELECT *
FROM (SELECT 
            년월, 지점, 매출액,    
            ROW_NUMBER() OVER (PARTITION BY 년월 ORDER BY 매출액 DESC) AS 순위 
        FROM (
            SELECT 
                SUBSTR(O.RESERV_NO, 0, 6) AS 년월, 
                R.BRANCH AS 지점, 
                SUM(O.SALES) AS 매출액
            FROM ORDER_INFO O JOIN RESERVATION R ON O.RESERV_NO = R.RESERV_NO
            WHERE O.ITEM_ID = 'M0001'
            GROUP BY SUBSTR(O.RESERV_NO, 0, 6), R.BRANCH
        ) T
        ORDER BY 년월, 매출액 DESC)
WHERE 순위 = 1;

-- 12. 종합 리포트
SELECT
    년월, 
    MAX(총매출) 총매출, MAX(전용상품외매출)전용상품외매출, MAX(전용상품매출)전용상품매출, MAX(전용상품판매율)전용상품판매율,
    MAX(총예약건) 총예약건, MAX(예약완료건) 예약완료건, MAX(예약취소권) 예약취소권, 
    MAX(예약취소율) 예약취소율, MAX(최대매출지점) 최대매출지점, MAX(지점매출액) 지점매출액
FROM (
    SELECT
        년월,
        TOTAL 총매출,
        ETC 전용상품외매출,
        SPECIAL_SET 전용상품매출,
        TO_CHAR(ROUND(SPECIAL_SET / TOTAL * 100, 1)) || '%' AS 전용상품판매율,
        NULL AS 총예약건, NULL AS 예약완료건, NULL AS 예약취소권, NULL AS 예약취소율, 
        NULL AS 최대매출지점,  NULL AS 지점매출액, NULL AS 순위
    FROM 
        (SELECT
            SUBSTR(RESERV_NO, 0, 6) AS 년월,
            SUM(SALES) AS TOTAL,
            SUM(CASE WHEN ITEM_ID != 'M0001' THEN SALES ELSE 0 END) AS ETC,
            SUM(CASE WHEN ITEM_ID = 'M0001' THEN SALES ELSE 0 END) AS SPECIAL_SET
        FROM ORDER_INFO
        GROUP BY SUBSTR(RESERV_NO, 0, 6) 
        )  
    
    UNION

    SELECT
        년월, 
        NULL AS 총매출, NULL AS 전용상품외매출, NULL AS 전용상품매출, NULL AS 전용상품판매율,
        총예약건,
        총예약건 - 예약취소권 AS 예약완료건,
        예약취소권,
        TO_CHAR(ROUND(예약취소권 / 총예약건 * 100, 1)) || '%' AS 예약취소율,
        NULL AS 최대매출지점,  NULL AS 지점매출액, NULL AS 순위
    FROM 
        (SELECT
            SUBSTR(R.RESERV_NO, 0, 6) AS 년월,
            COUNT(*) AS 총예약건,
            SUM(CASE WHEN O.ORDER_NO is null THEN 1 ELSE 0 END) AS 예약취소권
        FROM ORDER_INFO O RIGHT OUTER JOIN RESERVATION R 
        ON O.RESERV_NO = R.RESERV_NO
        GROUP BY SUBSTR(R.RESERV_NO, 0, 6) 
        ) T 

    UNION 

    SELECT 
        년월, 
        NULL AS 총매출, NULL AS 전용상품외매출, NULL AS 전용상품매출, NULL AS 전용상품판매율,
        NULL AS 총예약건, 
        NULL AS 예약완료건, 
        NULL AS 예약취소권, 
        NULL AS 예약취소율, 
        최대매출지점, 지점매출액, 순위
    FROM (SELECT 
                년월, 최대매출지점, 지점매출액,    
                ROW_NUMBER() OVER (PARTITION BY 년월 ORDER BY 지점매출액 DESC) AS 순위 
            FROM (
                SELECT 
                    SUBSTR(O.RESERV_NO, 0, 6) AS 년월, 
                    R.BRANCH AS 최대매출지점, 
                    SUM(O.SALES) AS 지점매출액
                FROM ORDER_INFO O JOIN RESERVATION R ON O.RESERV_NO = R.RESERV_NO
                WHERE O.ITEM_ID = 'M0001'
                GROUP BY SUBSTR(O.RESERV_NO, 0, 6), R.BRANCH
            ) 
        ) V 
    WHERE 순위 = 1)
GROUP BY 년월
ORDER BY 년월;


-- 13. 고객 특징 분석
SELECT COUNT(*) AS 고객수, 
        SUM(CASE WHEN SEX_CODE = 'M' THEN 1 ELSE 0 END) AS 남자,
        SUM(CASE WHEN SEX_CODE = 'F' THEN 1 ELSE 0 END) AS 여자,
        ROUND(AVG(MONTHS_BETWEEN(SYSDATE, TO_DATE(BIRTH)) / 12),1) AS 평균나이
FROM CUSTOMER;

-- 14. 개인별 매출 분석
SELECT 
    C.CUSTOMER_ID, C.CUSTOMER_NAME,
    COUNT(*) AS 전체상품주문건수,
    SUM(O.SALES) AS 총매출,
    SUM(CASE WHEN O.ITEM_ID = 'M0001' THEN 1 ELSE 0 END) AS 전용상품주문건수,
    SUM(CASE WHEN O.ITEM_ID = 'M0001' THEN O.SALES ELSE 0 END) AS 전용상품매출
FROM CUSTOMER C JOIN RESERVATION R ON R.CUSTOMER_ID = C.CUSTOMER_ID
        JOIN ORDER_INFO O ON O.RESERV_NO = R.RESERV_NO
GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME
ORDER BY 전용상품매출 DESC, 총매출 DESC;

-- 15. 상위 매출 기준 10위 고객
SELECT *
FROM (SELECT CUSTOMER_ID,
            CUSTOMER_NAME,
            전용상품매출,
            ROW_NUMBER() OVER(ORDER BY 전용상품매출 DESC) AS 순위
        FROM (SELECT 
                C.CUSTOMER_ID AS CUSTOMER_ID, 
                C.CUSTOMER_NAME AS CUSTOMER_NAME, 
                SUM(CASE WHEN O.ITEM_ID = 'M0001' THEN O.SALES ELSE 0 END) AS 전용상품매출
            FROM CUSTOMER C JOIN RESERVATION R ON R.CUSTOMER_ID = C.CUSTOMER_ID
                    JOIN ORDER_INFO O ON O.RESERV_NO = R.RESERV_NO
            GROUP BY C.CUSTOMER_ID, C.CUSTOMER_NAME
            ORDER BY 전용상품매출 DESC, C.CUSTOMER_ID
            ) T
    )
WHERE 순위 <= 10;
