-- 코드를 력하세요
(SELECT DISTINCT CAR_ID, '대여중' AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE <= '2022-10-16' AND '2022-10-16' <= END_DATE)
UNION 
SELECT DISTINCT CAR_ID, '대여 가능' AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID NOT IN (SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE <= '2022-10-16' AND '2022-10-16' <= END_DATE)
ORDER BY CAR_ID DESC