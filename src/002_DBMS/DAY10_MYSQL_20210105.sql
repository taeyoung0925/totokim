
 -- 자바(jdbc) 수업시간에 쓸 테이블
 drop table if exists personal;
 drop table if exists division;
 
create table division (
 dno int, -- 부서번호
 dname varchar(20), -- 부서이름
 phone varchar(20), -- 부서전화
 position varchar(20), -- 부서위치 
 primary key(dno)
 );
 
 create table personal(
 pno int , -- 사번
 pname varchar(20) not null, -- 사원명
 job varchar(20) not null, -- 직책
 manager int, -- 상사의 사번
 startdate date, -- 입사일
 pay int, -- 급여
 bonus int, -- 보너스
 dno int, -- 부서 번호
 primary key(pno),
 foreign key(dno) references division(dno)
 );
 
 select * from division;
 select * from personal;

 insert into division values (10, 'finance', '02-716-1006', '신촌');
 insert into division values (20, 'research', '02-707-7777', '용산');
 insert into division values (30, 'sales', '02-816-8886', '동작');
 insert into division values (40, 'marketing', '02-555-5555', '강남');

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

-- 실습 예제
-- 1. 사번, 이름, 급여를 출력
select pno,pname, pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal 
where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno from personal
where dno = 10 || dno = 20 ; 
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay from personal
where bonus is null
order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, pno, pay from personal
order by dno, pay desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname from personal p, division d
where d.dno = p.dno;
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname worker, m.pname manager from personal w, personal m
where w.manager = m.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname worker, m.pname manager from personal w
left outer join personal m
on w.manager = m.pno;
-- 8-1. 사번, 이름, 상사이름 (상사가 없는 사람도 출력, 상사가 없을경우 없다고 출력) 
select w.pno, w.pname worker, ifnull(m.pname,'없다') manager from personal w
left outer join personal m
on w.manager = m.pno;
select w.pno, w.pname worker, if(m.pname is null,'없다',m.pname) manager from personal w
left outer join personal m
on w.manager = m.pno;
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal 
where pname like 's%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname from personal w, personal m, division d 
where w.dno = d.dno && w.manager = m.pno;
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay) from personal
group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay), count(*) from personal p, division d
where p.dno = d.dno
group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay) from personal
group by dno
having count(*) >= 4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay  from personal
where pay = (select max(pay) from personal);
select * from personal;
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, pno from personal
where pay > (select avg(pay) from personal);
-- 16. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pno, pname, pay, dname  from personal p, division d 
where pay = (select max(pay) from personal)
and p.dno = d.dno
order by dname, pay desc;
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select pname, pay,p.dno, avgsal
from personal p, (select dno, avg(pay) avgsal from personal group by dno) s
where p.dno = s.dno 
and pay > avgsal;
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay dname from personal p, division d
where p.dno = d.dno
and startdate = (select min(startdate) from personal);
-- 19. 이름, 급여, 해당부서평균
select pname, pay, round((select avg(pay) from personal where dno = p.dno),1) 부서평균, dno from personal p ;
-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, dname, round((select avg(pay) from personal where dno=p.dno),1) 부서평균 
	from personal p, division d
	where d.dno=p.dno;







