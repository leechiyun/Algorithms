-- 코드를 입력하세요

SELECT USER_ID, PRODUCT_ID
FROM (SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, SALES_DATE) AS ss
GROUP BY ss.USER_ID, ss.PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC

# SELECT *
# FROM ONLINE_SALE 