# -- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, tb.CATEGORY, tb.TOTAL_SALES
FROM AUTHOR AS a
JOIN (SELECT AUTHOR_ID, CATEGORY, SUM(PRICE * SUM_SALES) AS TOTAL_SALES
FROM BOOK AS b JOIN (
    SELECT BOOK_ID, SUM(SALES) AS SUM_SALES
    FROM BOOK_SALES 
    WHERE SALES_DATE LIKE '2022-01%'
    GROUP BY BOOK_ID) AS bs
ON b.BOOK_ID = bs.BOOK_ID
GROUP BY AUTHOR_ID, CATEGORY ) tb
ON tb.AUTHOR_ID = a.AUTHOR_ID
ORDER BY a.AUTHOR_ID ASC, tb.CATEGORY DESC
 