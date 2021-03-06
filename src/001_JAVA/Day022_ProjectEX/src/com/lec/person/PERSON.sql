-- 1 테이블 생성 및 데이터 입력 
CREATE TABLE JOB (
JNO NUMBER(2) PRIMARY KEY,
JNAME VARCHAR2(30) NOT NULL
);

CREATE SEQUENCE PERSON_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 9999
MINVALUE 1
NOCYCLE
NOCACHE;

CREATE TABLE PERSON (
NO NUMBER(5) PRIMARY KEY,
NAME VARCHAR2(30) NOT NULL,
JNO NUMBER(2) REFERENCES JOB(JNO),
KOR NUMBER(3) NOT NULL,
ENG NUMBER(3) NOT NULL,
MAT NUMBER(3) NOT NULL
);

SELECT * FROM JOB;
SELECT * FROM PERSON;

INSERT INTO  JOB VALUES (10,'배우');
INSERT INTO  JOB VALUES (20,'가수');
INSERT INTO  JOB VALUES (30,'MC');

INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL,'정우성',(SELECT JNO FROM JOB WHERE JNAME = '배우'),90,80,81);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL,'박세영',(SELECT JNO FROM JOB WHERE JNAME = '배우'),80,90,80);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL,'배수지',(SELECT JNO FROM JOB WHERE JNAME = '가수'),20,90,90);

COMMIT;

-- 2 1등  송혜교(5번) 직업 국어 영어 수학 총점 총점순으로 내림차순
SELECT NAME || '(' || NO || '번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON P, JOB J
WHERE P.JNO = J.JNO
AND JNAME = '배우'
ORDER BY SUM DESC; -- FROM절에 들어갈 서브 쿼리 

SELECT ROWNUM RANK , S.*
FROM (SELECT NAME || '(' || NO || '번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON P, JOB J
WHERE P.JNO = J.JNO
AND JNAME = '배우'
ORDER BY SUM DESC) S; -- 자바 2번 기능에 쓸 쿼리 


-- 3 모든 사람 직업 국어 영어 수학 총점 총점순으로 내림차순
SELECT ROWNUM RANK , S.*
FROM (SELECT NAME || '(' || NO || '번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON P, JOB J
WHERE P.JNO = J.JNO
ORDER BY SUM DESC) S;


-- 점수 UPDATE
SELECT * FROM PERSON;
UPDATE PERSON SET KOR = 100, ENG = 100, MAT = 100 WHERE NAME = '김다혜';
COMMIT;

-- 콤보박스에 넣을 직업 리스트
SELECT * FROM JOB;
SELECT JNAME FROM JOB;

