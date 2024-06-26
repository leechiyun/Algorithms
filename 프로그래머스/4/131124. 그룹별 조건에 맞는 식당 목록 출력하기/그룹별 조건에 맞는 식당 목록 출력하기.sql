# -- 코드를 입력하세요
SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE AS m JOIN (
    SELECT *, COUNT(MEMBER_ID) OVER (PARTITION BY MEMBER_ID) AS REVIEW_COUNT
    FROM REST_REVIEW
) AS r ON m.MEMBER_ID = r.MEMBER_ID
WHERE REVIEW_COUNT = (SELECT MAX(REVIEW_COUNT) FROM (SELECT COUNT(MEMBER_ID) AS REVIEW_COUNT
    FROM REST_REVIEW
    GROUP BY MEMBER_ID) AS maxR)
ORDER BY r.REVIEW_DATE ASC, r.REVIEW_TEXT ASC;

