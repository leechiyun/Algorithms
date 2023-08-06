SELECT p.MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE,"%Y-%m-%d") REVIEW_DATE
FROM MEMBER_PROFILE p
JOIN REST_REVIEW r ON p.MEMBER_ID = r.MEMBER_ID
WHERE p.MEMBER_ID = (
    SELECT MEMBER_ID
    FROM (
        SELECT MEMBER_ID, COUNT(*) AS REVIEW_COUNT
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        ORDER BY REVIEW_COUNT DESC
        LIMIT 1
    ) sub
)
ORDER BY r.REVIEW_DATE ASC, r.REVIEW_TEXT ASC;