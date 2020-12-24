-- <�ǽ�����1>
--1. emp ���̺��� ���� ���
DESC EMP;

--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;

--3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB;

--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO,ENAME,SAL,JOB,HIREDATE FROM EMP;

--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP 
WHERE SAL <2000;

--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP
WHERE HIREDATE >= '81/02/01';

--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP 
WHERE JOB = 'SALESMAN';

--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP
WHERE JOB != 'CLERK';

--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL BETWEEN 1500 AND 3000;

--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
WHERE DEPTNO IN (10,30);

--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP
WHERE JOB  = 'SALESMAN' OR SAL >= 3000;

--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP
WHERE SAL >= 2500 AND JOB = 'MANAGER';

--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM);
SELECT ENAME || '��(��) ' || JOB || ' �����̰�, ������ ' || (SAL*12 + NVL(COMM,0))||'�� �̴�.'  EMP FROM EMP;  


-- <�ǽ�����2>
--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
 SELECT EMPNO,ENAME,JOB,SAL FROM EMP
 WHERE SAL >=3000;

--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP
WHERE EMPNO = 7788;

--3.	������ 2400�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL >= 2400 ORDER BY SAL DESC;

--4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� 
--ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP
WHERE HIREDATE BETWEEN  '81/02/20' AND '81/05/01' ORDER BY HIREDATE ASC;

--5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP
WHERE DEPTNO = 10 OR DEPTNO = 20 ORDER BY ENAME ASC;

--6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME, SAL FROM EMP
WHERE SAL >= 1500 AND (DEPTNO = 10 OR DEPTNO = 30);

--7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP
WHERE HIREDATE LIKE '82%';

--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP
WHERE ENAME BETWEEN 'C' AND 'Q' ORDER BY ENAME ASC;

--9.	EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP
WHERE COMM*1.1 > SAL;

--10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP
WHERE JOB IN('CLERK' , 'ANALYST') AND SAL NOT IN(1000,3000,5000);

--11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP
WHERE ENAME LIKE '%L%L%' AND (DEPTNO = 30 OR MGR = 7782);

--12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
WHERE HIREDATE LIKE '81%';

--13.	��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
WHERE HIREDATE LIKE '81%' AND JOB != 'SALESMAN';

--14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE,JOB,SAL FROM EMP
ORDER BY SAL DESC, HIREDATE ASC;

--15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP
WHERE ENAME LIKE '__N%';

--16.	��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO ���, ENAME �����, SAL*12 ���� FROM EMP
WHERE SAL*12 >= 35000;