-- 서브쿼리 실습예제
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE FROM EMP 
    WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP);

-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL FROM EMP 
    WHERE SAL=(SELECT MIN(SAL) FROM EMP);

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO FROM EMP 
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);

--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND SAL<=(SELECT AVG(SAL) FROM EMP);
    
--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL
      AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
        
--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에
    -- 부서명 추가하고 급여가 큰 순 정렬
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME 
    FROM EMP E, SALGRADE, DEPT D 
    WHERE SAL BETWEEN LOSAL AND HISAL AND 
        D.DEPTNO=E.DEPTNO AND 
        HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')  
        ORDER BY SAL DESC;
        
--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='BLAKE');
    
--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일을 검색하시오
SELECT EMPNO, ENAME, HIREDATE FROM EMP 
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP 
                        WHERE ENAME='MILLER');
                        
--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
    
--10. 사원테이블에서 CLARK와 같은 부서며, 사번이 7698인 직원의 급여보다 
        -- 많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK'; -- 서브쿼리(CLARK의 부서번호)
SELECT SAL FROM EMP WHERE EMPNO=7698;  -- 서브쿼리(7698사번 직원의 급여)
SELECT EMPNO, ENAME, SAL FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') 
    AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);
    
--11. 사원테이블에서 CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 
--  많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK';-- 서브쿼리1
SELECT SAL FROM EMP WHERE EMPNO=7698; -- 서브쿼리2
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND 
        DNAME=(SELECT DNAME FROM EMP E, DEPT D 
            WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') 
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);

--12.  BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력
SELECT ENAME, HIREDATE FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름을 출력
        --(단 급여가 많은 순으로 출력하여라.)
SELECT EMPNO, ENAME FROM EMP 
    WHERE SAL>=(SELECT AVG(SAL) FROM EMP) 
    ORDER BY SAL DESC;

-- 14. 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 사원에 대해
    --사번,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사번 순으로 출력
SELECT EMPNO, ENAME, SAL FROM emp 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT 
                    WHERE INITCAP(LOC)='Dallas');
SELECT ENAME, JOB, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND INITCAP(LOC)='Dallas';

-- 16. King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문
SELECT ENAME, SAL FROM EMP 
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE INITCAP(ENAME)='King');

SELECT ENAME, SAL FROM EMP W 
    WHERE EXISTS (SELECT * FROM EMP 
                    WHERE EMPNO=W.MGR AND INITCAP(ENAME)='King');
                    
-- 17. SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
    -- join을 이용하면 아래와 같음 -- 
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES';

-- 18. 사원 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력
SELECT * FROM EMP 
    WHERE SAL>(SELECT MIN(SAL)  FROM EMP WHERE DEPTNO=30);
SELECT * FROM EMP 
    WHERE SAL > ANY (SELECT sal  FROM EMP WHERE DEPTNO=30);

-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름,업무를 출력
SELECT ENAME, JOB FROM EMP WHERE DEPTNO=10 AND 
            JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);

-- 20. 사원 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력
SELECT * FROM EMP 
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP 
                        WHERE ENAME='FORD') AND ENAME != 'FORD';

-- 21. 이름이 JONES인 직원의 JOB과 같거나 
    --월급이 FORD 월급 이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성.
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력하여라.
SELECT JOB FROM EMP WHERE ENAME='JONES';--단일행 서브쿼리
SELECT SAL FROM EMP WHERE ENAME='FORD'; --단일행 서브쿼리
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP 
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='JONES') OR 
        SAL>=(SELECT SAL FROM EMP WHERE ENAME='FORD')
    ORDER BY JOB, SAL DESC;

-- 22. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' 
                                                OR ENAME='WARD') 
        AND ENAME NOT IN ('SCOTT', 'WARD');
        
SELECT ENAME, JOB, SAL FROM EMP 
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN 
                                                ('SCOTT','WARD')) 
        AND ENAME NOT IN ('SCOTT','WARD');

-- 23. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB FROM EMP 
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D 
                    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');
    
-- 24. 사원 테이블에서 월급이 부서별 평균 월급보다 높은 사원을 사원번호,이름,급여를 출력하는 SELECT문을 작성하시오.
--사원번호, 이름, 급여, DEPTNO, 해당부서별평균SAL
SELECT EMPNO, ENAME, SAL, DEPTNO,
        (select avg(sal) from emp where deptno=e.deptno)
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);

-- 25. 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력
SELECT DEPTNO, ENAME, SAL,
        (SELECT AVG(SAL) FROM EMP WHERE JOB=E.JOB) 
    FROM EMP E 
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE E.JOB=JOB);

-- 26 사원 테이블에서 적어도 한명 이상으로부터 보고를 받을 수 있는 사원을 
    --업무,이름,사원번호,부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP)
    ORDER BY DEPTNO;
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP M
    WHERE EXISTS (SELECT EMPNO FROM EMP WHERE M.EMPNO=MGR) 
    ORDER BY DEPTNO;

-- 27. 말단 사원의 사원번호,이름,업무,부서번호를 출력하는 SELECT문을 작성하시오.
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP M 
    WHERE NOT EXISTS (SELECT EMPNO FROM EMP WHERE M.EMPNO=MGR);
SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO FROM EMP W, EMP M 
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL; 
    
-- 서브쿼리 결과가 NULL이 있어 아래의 질의는 안 됨
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP); 
--그래서 아래와 같이 함
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
    WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL);
