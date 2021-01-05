--<�� ��������>
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
AS SELECT DNAME, ENAME FROM DEPT D, EMP E 
WHERE D.DEPTNO = E.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;
-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
AS SELECT W.ENAME WORKER, M.ENAME MANAGER FROM EMP W, EMP M 
WHERE W.MGR = M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;
-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���) 
SELECT ROWNUM ���, DEPTNO �μ���ȣ, SUM �޿��հ� FROM (SELECT DEPTNO, SUM(SAL) SUM  FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);
-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT  RN ���,DEPTNO �μ���ȣ, SUM �޿��հ� FROM (SELECT DEPTNO, SUM, ROWNUM RN FROM (SELECT DEPTNO, SUM(SAL) SUM  FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
WHERE RN BETWEEN 2 AND 3;
-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT * FROM EMP;
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;
-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC)
WHERE ROWNUM <=5;
-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN, EMPNO, ENAME, HIREDATE FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
WHERE RN BETWEEN 6 AND 10;