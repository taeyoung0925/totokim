-- �� <��������> PART1
--1. �̸�, ���ӻ��
SELECT W.ENAME , M.ENAME MANAGER FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME  MANAGER FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME,'����') MANAGER FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, D.DNAME, W.ENAME MANAGER FROM EMP W, EMP M, DEPT D
WHERE W.MGR = M.EMPNO
AND W.DEPTNO = D.DEPTNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, D.DNAME, D.LOC, NVL(M.ENAME,'����') MANAGER FROM EMP W, EMP M, DEPT D
WHERE W.MGR = M.EMPNO(+)
AND W.DEPTNO = D.DEPTNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, M.ENAME MANAGER FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE W.MGR = M.EMPNO
AND W.DEPTNO = D.DEPTNO
AND W.SAL BETWEEN S.LOSAL AND S.HISAL
AND W.SAL >= 2000;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, NVL(M.ENAME,'����') MANAGER FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE W.MGR = M. EMPNO(+)
AND W.SAL BETWEEN S.LOSAL AND S.HISAL
AND W.DEPTNO = D.DEPTNO;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, D.DNAME, (W.SAL+NVL(W.COMM,0))*12 ���� , M.ENAME MANAGER FROM EMP W, EMP M, DEPT D
WHERE W.MGR = M.EMPNO
AND W.DEPTNO = D.DEPTNO;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, D.DNAME, (W.SAL+NVL(W.COMM,0))*12 ���� , M.ENAME MANAGER FROM EMP W, EMP M, DEPT D
WHERE W.MGR = M.EMPNO
AND W.DEPTNO = D.DEPTNO
ORDER BY D.DNAME ASC, W.SAL DESC;

--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT E.ENAME,E.DEPTNO,D.DNAME FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT E.ENAME, E.JOB, E.SAL, D.DNAME FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND D.LOC = 'NEW YORK';
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT E.ENAME, D.DNAME, D.LOC FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.COMM > 0;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT E.ENAME, E.JOB, D.DNAME, D.LOC FROM EMP E, DEPT D
WHERE E.ENAME LIKE '%L%'
AND E.DEPTNO = D.DEPTNO;
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT E.EMPNO, E.ENAME, E.DEPTNO, D.DNAME FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY E.ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
--�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT E.EMPNO, E.ENAME, E.SAL, D.DNAME FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.SAL >=2000
ORDER BY E.SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, D.DNAME FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO 
AND E.JOB = 'MANAGER' 
AND E.SAL >=2500
ORDER BY E.EMPNO ASC;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, S.GRADE FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY E.SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME, NVL(M.ENAME,'����') MANAGER FROM EMP W,EMP M
WHERE W.MGR = M.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME, M.ENAME MANAGER , C.ENAME CEO FROM EMP W, EMP M , EMP C
WHERE W.MGR = M.EMPNO
AND M.MGR = C.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME, NVL(M.ENAME,'����') MANAGER, NVL(C.ENAME,'����') CEO FROM EMP W, EMP M , EMP C
WHERE W.MGR = M.EMPNO(+)
AND M.MGR = C.EMPNO(+);