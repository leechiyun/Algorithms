-- 코드를 입력하세요
# SELECT
SELECT i.ANIMAL_ID, o.ANIMAL_TYPE, NAME
FROM ANIMAL_OUTS AS o
JOIN (SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE SEX_UPON_INTAKE != 'Spayed Female' AND SEX_UPON_INTAKE != 'Neutered Male') AS i
ON o.ANIMAL_ID = i.ANIMAL_ID
WHERE SEX_UPON_OUTCOME = 'Spayed Female' OR SEX_UPON_OUTCOME = 'Neutered Male'
ORDER BY ANIMAL_ID

# 중성화 되지 않고 보호소에 들어온 동물 id
# (SELECT ANIMAL_ID
# FROM ANIMAL_INS
# WHERE SEX_UPON_INTAKE != 'Spayed Female' AND SEX_UPON_INTAKE != 'Intact Male')