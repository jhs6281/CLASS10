

SELECT * FROM EMP;

SELECT empno, ename, deptno FROM emp;

SELECT empno, deptno FROM emp;

SELECT deptno FROM emp;

SELECT DISTINCT deptno FROM emp;

SELECT ename, sal, sal*12+comm, comm FROM emp;

-- AS로 이름 변경(생략 가능)
SELECT ename AS name, sal, sal*12+comm AS "ann sal", comm FROM emp;

-- DISTINCT (중복 제외)
SELECT DISTINCT job FROM EMP ;

-- 열 지정 호출 
SELECT job FROM emp;

SELECT ename enameeeeeeeeee FROM emp;

-- 내림 차순
SELECT * FROM emp
ORDER BY sal desc;

-- 오름 차순 (ASC 생략 가능)
SELECT * FROM EMP 
ORDER BY deptno asc

SELECT distinct job FROM emp;

SELECT 
	empno AS employee_no, 
	ename AS employee_name, 
	job, mgr AS manager , 
	hiredate , sal, comm, 
	deptno FROM EMP
ORDER BY deptno DESC, ename;

SELECT *
	FROM emp
	WHERE deptno = 30;

SELECT * FROM emp
WHERE deptno = 30
	AND job = 'SALESMAN';

SELECT * FROM EMP
		WHERE deptno = 30
		AND empno = 7499;

-- AND 문 // AND NOT
SELECT * FROM EMP
WHERE mgr = 7839
AND deptno = 20;

-- OR 문
SELECT * FROM emp 
WHERE deptno = 30
OR job = 'CLERK';

-- 한줄 주석
/* 범위 주석 */

--and 와 or가 함께 있을 때에는 and가 먼저 계산된다. 때문에 괄호를 이용하여 계산 순서를 지정.
SELECT * FROM EMP
WHERE ( deptno = 20 OR deptno = 30 )
AND job = 'CLERK';

SELECT * FROM EMP
WHERE sal >= 3000;

SELECT * FROM emp
WHERE sal >= 2500
AND job = 'ANALYST';

-- NOT 문
SELECT * FROM emp
WHERE NOT sal = 3000;
--'크거나 같지 않다' 와 같은 조건문에서 특별 사용
--WHERE sal ^= 3000;
--WHERE sal != 3000;
--WHERE sal <> 3000;
--다양한 부정형 표현 방법

SELECT * FROM emp
	WHERE NOT sal <= 3000;     

-- BETWEEN AND 문
SELECT * FROM EMP 
WHERE sal BETWEEN 2000 AND 3000;


-- NOT BETWEEN AND 문
SELECT * FROM EMP 
WHERE sal NOT BETWEEN 2000 AND 3000;

-- 중간에 BETWEEN AND 사용 괄호 이용
SELECT * FROM emp
WHERE (sal NOT BETWEEN 2000 AND 3000)
AND deptno = 30;

-- 2000 미만이거나 3000 초과 / not between
-- not (2000 >= sal and sal <= 3000)
-- 2000 < sal or sal > 3000

-- LIKE문 ㅇ로 시작
SELECT * FROM emp
WHERE ename LIKE 'S%';

-- LIKE문 두번째 글자에 ㅇ를 포함
SELECT * FROM emp
WHERE ename LIKE '_L%';

-- 그냥 어디든 중간에 ㅇ포함 검색 기능
SELECT * FROM emp
WHERE ename LIKE '%AM%';

-- LIKE문 ㅇ로 끝남
SELECT * FROM emp 
WHERE ename LIKE '%S';

-- 이름이 다섯 글자인 사람
SELECT * FROM emp
WHERE ename LIKE '_____';

-- NOT LIKE
SELECT * FROM emp
WHERE ename NOT LIKE '%A%';

-- 순서를 유지하면서 포함하는 단어
SELECT * FROM emp
WHERE ename LIKE '%A%S%';

--IS NULL (is를 반드시 사용) 값이 'NULL'인 것을 호출
SELECT * from emp
WHERE COMM = NULL;

SELECT * from emp
WHERE COMM is NULL;

-- IS NOT NULL 값이 'NULL'이 아닌 것을 호출
SELECT * FROM  emp
WHERE comm IS NOT NULL;

--응용
SELECT * FROM EMP
WHERE (DEPTNO = 20 OR DEPTNO = 30) AND (NOT SAL = 800) AND job IN (%);

-- 
SELECT * FROM emp
WHERE sal > NULL  comm IS NULL;

--UNION 집합 연산자 두 개 이상의 select문 사용할 때 
SELECT empno, ename, sal, deptno FROM EMP
WHERE deptno = 10
UNION 
SELECT empno, ename, sal, deptno FROM EMP WHERE deptno=20;

--보통이라면 IN문으로 요약 가능
SELECT empno, ename, sal, deptno FROM emp
WHERE deptno IN (10,20);

SELECT * FROM emp
WHERE deptno = 10
UNION 
SELECT * FROM emp WHERE deptno = 20;

-- UNION 값의 형식이 같다면 합쳐서 불러올 수 있다. (숫자, VARCHAR2, DATE)
SELECT empno, ename, sal, deptno
FROM EMP WHERE deptno = 10
UNION
SELECT sal, job, deptno, sal FROM emp
WHERE deptno = 20
UNION
SELECT empno, ename, deptno, sal FROM emp
WHERE deptno = 20;

-- UNION ALL 중복된 값 그대로 출력
SELECT empno, ename, sal, deptno FROM EMP 
WHERE deptno = 10
UNION all
SELECT empno, ename, sal, deptno FROM EMP 
WHERE deptno = 10;

-- 함수 시작
-- DUAL 비어있는 테이블
SELECT * FROM dual;

-- UPPER() 대문자, LOWER() 소문자, INITCAP() 앞글자만 대문자
SELECT ename, Upper(ENAME), Lower(ENAME), INITcap(ENAME) FROM emp;

SELECT 0 FROM dual;
SELECT UPPER('aBc'), lower('aBV'), initcap('ASDF') FROM dual;

--실무 활용 데이터 검색 방법 입력값 대(소)문자로 받아서 대(소)문자로 탐색
SELECT * FROM EMP
WHERE LOWER(ENAME) LIKE LOWER('%AM%');

SELECT ENAME, LENGTH(ENAME) FROM EMP;

--LENGTH문 5글자 이름만 출력
SELECT * FROM EMP
WHERE LENGTH(ENAME) = 5;

SELECT LENGTH('한글'),LENGTHB('한글')
FROM DUAL;

--SUBSTR(N열의, N번째 글자부터, N개 출력 설정 안하면 이후 전부 출력)
SELECT job, 
substr(job, 1, 2),
substr(job, 3, 2),
substr(job, 5)
FROM emp;

--SUBSTR 응용 문제
SELECT SUBSTR(ENAME, 2, 3) FROM EMP; 
SELECT SUBSTR(ENAME, 20, 3) FROM EMP; --시작 값이 크면 NULL 
SELECT SUBSTR(ENAME, 2, 30) FROM EMP; --마지막 숫자가 커도 끝까지만 출력
SELECT ENAME, SUBSTR(ENAME, -6, 3) FROM EMP; -- 음수는 뒤에서부터 N번째

--REPLACE(대상, 특정, 대체) 특정 문자 전부 대체 OR 전부 삭제
SELECT 'A-B-C',
REPLACE('A-B-C', 'A', 'HELLOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII')
FROM DUAL;

SELECT ENAME, REPLACE(ENAME, 'A', 'ABC')
FROM  EMP;

--LPAD(), RPAD() [왼/오]공간을 만든다(대상, 생성 공간의 양, 채우기).
SELECT LPAD(ENAME, 99, '5') FROM EMP;
-- 모자르면 채우고 넘치면 자른다. = 값의 길이가 일정해진다.
SELECT ENAME, LPAD(ENAME, 7, 'ABC') FROM EMP; 

-- 문제 1. ename에서 앞에 두 글자만 출력
SELECT ENAME, SUBSTR(ENAME, 1, 2) FROM EMP;
SELECT ENAME, LPAD(ENAME, 2) FROM EMP;
SELECT ENAME, REPLACE(ENAME, SUBSTR(ENAME, 3),'') FROM EMP;

-- 2. 앞 두글자만 표시 나머지는 4개의 로 표시
SELECT ENAME, RPAD(SUBSTR(ENAME, 1, 2), 6, '*') FROM EMP;
-- 3. 앞 두글자만 원본을 출력 나머지는로 * 출력
SELECT ENAME, RPAD(SUBSTR(ENAME, 1, 2), LENGTH(ENAME), '*') FROM EMP;
-- 4. 앞 두글자만 * 처리
--앞 두글자 이후 특정, *처리
SELECT LPAD(SUBSTR(ENAME, 3), LENGTH(ENAME), '*')
FROM EMP;
--|파이프: 문자열 더하기 N님 환영합니다.
SELECT EMPNO || ENAME, 
EMPNO || ' : ' || ENAME FROM EMP;

-- 띄어쓰기 없애기
SELECT 
'[' || TRIM(' _ _ORACLE_ _ ') || ']' AS TRIM,
'[' || TRIM(LEADING FROM ' _ _ORACLE_ _ ') || ']' AS TRIM_LEADING,
'[' || TRIM(TRAILING FROM ' _ _ORACLE_ _ ') || ']' AS TRIM_TRAILING,
'[' || TRIM(BOTH FROM' _ _ ORACLE_ _ ') || ']' AS TRIM_BOTHALTER 
FROM DUAL;

--ROUND 반올림 함수
SELECT ROUND(14.46),
ROUND(14.46, 0),
ROUND(14.46, 1),
ROUND(14.46, -1)
FROM DUAL;

--TRUNC 버림 함수
SELECT 
TRUNC(14.46),
TRUNC(14.46, 0),
TRUNC(14.46, 1),
TRUNC(14.46, -1)
FROM DUAL;

--CEIL 올림 함수, FLOOR 내림 함수
SELECT 
	CEIL(3.14),
	FLOOR(3.14),
	CEIL(-3.14),
	FLOOR(-3.14),
	TRUNC(-3.14)
FROM  DUAL;

--MOD 나머지 함수
SELECT MOD(15, 6),
	   MOD(10, 2),
	   MOD(11, 0)
FROM DUAL;

--숫자 가두기 (최대 숫자 0,1,2)
SELECT 
MOD(6, 3),
MOD(7, 3),
MOD(8, 3),
MOD(9, 3)
FROM DUAL;

--SYSDATE 날짜 함수(영국 시간이 세계 기준)
SELECT
SYSDATE AS NOW,
SYSDATE-1 AS YESTERDAY,
SYSDATE+1 AS TOMORROW
FROM DUAL;----

--출력 형식 지정
SELECT 
TO_CHAR(SYSDATE, 'YYYY:MM$DD HH24:MI:SS') AS 현재 
FROM DUAL;

/* 
일자:
CC 세기
YYYY,RRRR 년
YY,RR 년도 2자리
MM 월
MON 월 언어별 월 이름 줄임말
MONTH 월 전체
DD 일
DDD 1년중 며칠
DY 요일 줄임말
DAY 요일
W 1년중 몇 번째 주

시간:
HH24 24시간으로 표현
HH, HH12 12시간으로 표현한 시간
MI 분
SS 초
AM PM 오전 오후
*/

--입사 날짜 기준으로 출력 가능
SELECT * FROM EMP
WHERE HIREDATE > TO_DATE('1981/06/21', 'YYYY/MM/DD');

--NVL: 특정 열의 NULL값을 지정하는 함수
SELECT 
SAL, COMM,
NVL(COMM, 0),
SAL+NVL(COMM,0),
SAL+COMM,
NVL(tO_CHAR(COMM),'N/A')
FROM EMP;

--NVL2: 특정 열의 NULL값을 참, 거짓을 변수로 출력하는 함수
SELECT ALL EMPNO, ENAME, COMM,
NVL2(COMM, '0', 'X')
FROM EMP;

-- DECODE: 특정 조건에 따라 다루는 함수(IF)
SELECT JOB, SAL, 
DECODE(JOB,
	'MANAGER', SAL*1.1,
	'SALESMAN',SAL*1.05,
	'ANALYST', SAL,
	SAL*1.03
) AS UPOSAL 
FROM EMP;

-- CASE END 문: WHEN/THEN/ELSE 를 이용하여 IF 조건 함수
SELECT JOB, SAL,
CASE JOB
	WHEN 'MANAGER' THEN SAL*1.1
	WHEN 'SALESMAN' THEN SAL*1.05
	WHEN 'ANALYST' THEN SAL
	ELSE SAL*1.03
END UPSAL
FROM EMP;

-- CASE WHEN END 문: 첫번째 조건이 참이면 중간 조건의 형식에 자유롭게 사용 (비교 연산 등)
SELECT COMM,
CASE
	WHEN COMM IS NULL THEN '계약조건 참고'
	WHEN COMM = 0 THEN '수당 없음'
	WHEN COMM > 0 THEN '수당: ' || COMM
	END TEXT
FROM EMP;

--1
SELECT EMPNO, 
RPAD(SUBSTR(EMPNO, 1, 2), 4, '*') AS MASKING_EMPNO,
ENAME, 
RPAD(SUBSTR(ENAME, 1, 1), 5, '*') AS MASKING_ENAME
FROM EMP
WHERE LENGTH(ENAME) = 5;

--2
SELECT EMPNO, ENAME, SAL, 
	TRUNC((SAL/21.5), 2) AS DAY_PAY,
	ROUND((SAL/21.5/8), 1)
FROM EMP;

--3
SELECT EMPNO, ENAME, MGR,
CASE
	WHEN MGR IS NULL THEN '0000'
	WHEN SUBSTR(MGR, 1, 2) = 75 THEN '5555'
	WHEN SUBSTR(MGR, 1, 2) = 76 THEN '6666'
	WHEN SUBSTR(MGR, 1, 2) = 77 THEN '7777'
	WHEN SUBSTR(MGR, 1, 2) = 78 THEN '8888'
	ELSE TO_CHAR(MGR)
END AS CHG_MGR
FROM EMP;
SELECT ROUND(14.46, -1) FROM DUAL;

SELECT ename, length(ename) FROM emp; --한 줄 한 줄 나오는 결과

SELECT SUM(comm) FROM emp;

SELECT sum(sal) FROM emp;
--select sum (sal), sal FROM emp; 셀 병합이 안되어 에러

SELECT count(sal) FROM emp;
SELECT count(comm) FROM emp;
SELECT count(*) FROM emp;

SELECT count(*) FROM emp
WHERE deptno = 30;

SELECT max(sal) FROM emp;
SELECT min(sal) FROM emp;

SELECT
	max(sal), min(sal), min(hiredate), min(comm),
	count(*), sum(sal)
FROM emp;

SELECT avg(sal) FROM emp;

-- 이름에 a가 들어가는 사람은 몇 명 ? 

SELECT count(*) FROM EMP
WHERE lower(ename) LIKE lower ('%a%')

SELECT DISTINCT deptno FROM emp;

------------------------
-- group by
/*
 * 제약 1. select에는 group by 에 적은 컬럼 명만 가능하다
 * 제약 2. select에 집계 함수는 가능하다
 */

SELECT deptno, count(*), SUM(sal)
FROM emp
GROUP BY deptno; -- 묶어서 출력 (중복 제거랑 비슷) /  
-- Group By : 맵핑 + having 절로 더 많은 데이터를 서칭 가능 = 범용성 높음 
-- 셀 병합이 되지 않기 때문에 그 부분만 주의할 것!
-- 그냥 간단하게 중복 제거할 때는 dintinct가 편하다

SELECT * FROM emp
WHERE abg(sal) < sal;

SELECT deptno, job 
FROM emp
WHERE deptno = 10
GROUP BY deptno, job 
HAVING deptno = 10;

--SELECT deptno, job, avg(sal) 
--FROM emp
--GROUP BY deptno, job
--WHERE avg(sal) > 2000; 
--WHERE 버전

SELECT deptno, job, avg(sal) 
FROM emp
GROUP BY deptno, job
HAVING avg(sal) > 2000; --직계 함수가 들어갈 수 있다.  group by있어야만 사용 가능
--WHERE은 SELECT 보다 먼저 실행되기 떄문

--job 별로 3명 이상인 job과 count (*)를 표시
SELECT job, count(*) 
FROM emp
GROUP BY job
HAVING count(*) >= 3;

SELECT * FROM dept;
SELECT * FROM emp;

SELECT *
FROM emp, dept
ORDER BY empno;

-- emp 에서 SMITH의 deptno만 출력
SELECT deptno FROM emp WHERE ename = 'SMITH';
-- dept에서 deptno가 20인 줄 모든 칼럼 출력
SELECT * FROM dept WHERE deptno = 20;

SELECT *
FROM emp, dept
WHERE emp.deptno = dept.deptno;

SELECT *
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT ename, emp.* FROM emp;

--SELECT scott1_0.emp.ename 
--FROM scott1_0.emp; 정석

SELECT emp.* FROM emp;

SELECT ename
FROM emp e, dept d 
WHERE e.deptno = d.deptno;


SELECT ename, e.deptno, e.*
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT * FROM salgrade;

SELECT ename, sal, grade, losal, hisal
FROM emp e, salgrade s;
WHERE e.sal >= s.losal AND e.sal <= s.hisal;

SELECT mgr FROM emp WHERE ename = 'SMITH';
SELECT * FROM emp WHERE empno = 7902;

SELECT e1.empno, e1.ename, e1.mgr,
	   e2.empno, e2.ename, e2.mgr
FROM EMP e1, EMP e2
WHERE e1.mgr = e2.empno; 
--king은 null 이어서 빠졌다.

SELECT *
FROM emp e NATURAL JOIN dept d;


SELECT deptno, e.empno, dname
FROM emp e JOIN dept d USING (deptno);
-- 공통되는 컬럼

SELECT d.deptno, d.*
FROM emp e JOIN dept d on(e.deptno = d.deptno)
WHERE sal <= 2000;
-- 아무거나


SELECT *
FROM emp e1 JOIN emp e2 on(e1.mgr = e2.empno);
-- 공통되는 컬럼이 없을 때는 join using을 못 사용하지만, join on은 범용성이 넓다 

SELECT *
FROM emp e1 LEFT OUTER JOIN emp e2 on(e1.mgr = e2.empno);
--왼쪽 대상을 모두 최소한 한 번 이상 출현하는 조건.(king 등장)

-- 퀴즈
-- 각 부서별로
-- 급여가 가장 높은, 
-- 가장 낮은 급여
-- 그들의 급여 차이와, 
-- 부서번호 출력

--1
SELECT max(sal) FROM emp;

SELECT max(sal), min(sal), (max(sal)-min(sal)), deptno
FROM emp
GROUP BY deptno;

--2-1
SELECT e.deptno, d.DNAME, empno, ename, sal
FROM EMP e join dept d ON (e.deptno = d.deptno)
WHERE sal >= 2000
ORDER by deptno, job;

--2-2
SELECT e.deptno, dname, floor(avg(e.sal)), max(e.sal), min(e.sal), count(e.deptno)
FROM EMP e join dept d ON (e.deptno = d.deptno)
GROUP BY e.deptno, d.DNAME 
ORDER BY deptno;


--2-3
SELECT * 
FROM dept d
LEFT OUTER JOIN emp e 
USING (deptno)
ORDER BY d.dname;

--2-4 
SELECT * FROM salgrade;
SELECT * FROM dept;
SELECT * FROM emp;

SELECT d.deptno, 
	d.dname, 
	e.empno, 
	e.ename, 
	e.mgr,
	e.deptno,
	e.sal,
	sg.losal,
	sg.hisal,
	sg.grade,
	e.mgr,
	e2.ename  
FROM dept d
LEFT OUTER JOIN emp e ON (e.deptno = d.deptno)
LEFT OUTER JOIN emp e2 ON (e.mgr = e2.empno)
LEFT OUTER JOIN salgrade sg ON (e.sal >= sg.losal AND e.sal <= sg.hisal)
ORDER BY e.deptno, d.dname, e.empno;



----------------------------
--------서브쿼리--------------
----------------------------

SELECT *
FROM emp
--where sal > 2975;
WHERE sal > (SELECT sal FROM emp WHERE ename = 'JONES');

SELECT *
FROM emp e
WHERE hiredate < (SELECT hiredate 
					FROM emp 
					WHERE ename = 'SCOTT');
--scott 위로 집합


SELECT * FROM emp
WHERE sal > (SELECT avg(sal) FROM emp);

SELECT max(sal) FROM emp
GROUP BY deptno;

SELECT * FROM EMP
WHERE sal IN (2850, 3000, 5000);

SELECT * FROM EMP
WHERE sal IN (SELECT max(sal) FROM emp
				GROUP BY deptno);

SELECT *
FROM ( SELECT deptno, ename 
		FROM emp 
		WHERE deptno = 10 ) e10, DEPT d 
WHERE e10.deptno = d.deptno;


-- cnt 는 select 안에서 동작하고 
-- from 부터 시작하기 떄문에 작동 안함
SELECT job, count(*)
FROM EMP 
WHERE count (*) >= 3 직계 함수
GROUP BY job;
--HAVING count (*) >= 3;

SELECT *
FROM (
	SELECT job, count(*) cnt
	FROM emp
	GROUP BY job
)
-- where를 사용하기 위해 서브쿼리를 넣어서 작동 순서를 만들어낸다.	
WHERE cnt >= 3;

SELECT rownum, e.*
FROM emp e
ORDER BY sal;
-- rownum 은 줄 번호를 부여하는 기능
-- select에서 동작


SELECT rownum, e.* 
FROM 
	(
	SELECT * 
	FROM emp 
	ORDER BY sal
	) e;

WHERE rownum = 6; -- rownum 자체가 의미가 있다

SELECT rownum rnum, e.*
FROM (
	SELECT * FROM emp
	ORDER BY sal
	)e
	WHERE rnum = 6;

SELECT *
FROM (
	SELECT rownum rnum, e.*
	FROM (
		SELECT * FROM emp
		ORDER BY sal
		)e
	)
WHERE rnum >= 6 AND rnum <= 10;

-- from > where > select > ORDER BY 순서로 작동하는 부분을 유의깊게 

WITH e10 AS (
	SELECT * FROM emp WHERE deptno = 10
)
SELECT * FROM e10;

--서브쿼리 select에 사용 > 처리 속도에 효율이 떨어진다.
--필요하면 써야지
SELECT 
	sal, 
	ename,
	(SELECT 
		grade 
	FROM salgrade
	WHERE e.sal BETWEEN losal AND hisal) grade
FROM emp e;

-- 문제1
-- comm이 null인 사원을 급여 내림 차순으로 정렬
SELECT ename, comm 
FROM emp
WHERE comm IS NULL
ORDER BY sal desc;

-- 문제2
-- 급여 등급 별 사원 수를 등급 오름차순 정렬 
-- 등급 / 몇 명 
SELECT sg.grade, count(sg.grade)
FROM salgrade sg
	right OUTER JOIN emp e 
	ON (sg.losal <= e.sal AND sg.hisal >= e.sal)
GROUP BY sg.grade
ORDER BY sg.grade; 


-- 문제3
-- 출력: 이름, 급여, 급여등급, 부서 이름?
-- 급여 등급 3 이상, 급여 등급 내림 차순, 
-- 급여 등급이 같은 경우 급여 내림 차순
SELECT ename, sal, sg.grade, empno
FROM salgrade sg 
JOIN EMP e 
ON (sg.losal <= e.sal AND sg.hisal >= e.sal 
AND sg.grade >= 3)
ORDER BY sal DESC, sal desc;

-- 문제4
-- 부서명이 sales 인 사원 중 
-- 급여 등급이 2 또는 3인 사원 급여를 내림차순으로 정렬 

SELECT g.*
FROM 
	(SELECT sg.grade, ename, sal
	FROM salgrade sg 
	JOIN EMP e 
	ON (sg.losal <= e.sal AND sg.hisal >= e.sal)) g
WHERE g.grade = 2 OR g.grade = 3
ORDER BY sal desc;

---------------------------
--------- 249 page --------
---------------------------
--1
SELECT job, EMPNO , ename, sal, d.deptno, d.dname
FROM emp e, dept d
WHERE (job = (SELECT job FROM emp e WHERE ename = 'ALLEN')) AND (e.deptno = d.deptno);

--2
SELECT empno, ename, d.dname, e.HIREDATE, loc, sal, sg.grade
FROM emp e 
LEFT OUTER  JOIN salgrade sg ON (sg.losal <= e.sal AND sg.hisal >= e.sal)
LEFT OUTER JOIN dept d using (deptno)
WHERE sal > (SELECT avg(sal) FROM emp)
ORDER BY sal desc, empno;

--3
--10번 부서 근무, 30번 부서x

SELECT e.empno, e.ename, e.job, e.deptno, d.dname, d.loc
	FROM emp e
	LEFT OUTER JOIN dept d 
	ON (e.deptno = d.deptno) 
	LEFT OUTER JOIN SALGRADE sg
	ON (sg.losal <= e.sal AND sg.hisal >= e.sal)
	WHERE e.deptno = 10 AND job NOT IN (SELECT job FROM emp WHERE deptno = 30);
--WHERE job <> (SELECT job FROM emp WHERE deptno = 30);

--문제 4

SELECT empno, ename, sal, sg.grade 
FROM emp e
JOIN salgrade sg ON (sg.losal <= e.sal AND sg.hisal >= e.sal)
WHERE sal > ((SELECT max(sal) FROM emp WHERE job = 'SALESMAN'));


DESC emp; -- dbeaver 에서 안된다(원래 되어야 함)

CREATE TABLE emp_dd1(
	empno NUMBER(4),
	ename varchar2(10),
	job varchar2(9),
	mgr number(4),
	hiredate DATE, 
	sal number(7,2),
	comm NUMBER(7,2),
	deptno number(2)
);

SELECT * FROM emp_dd1;

CREATE TABLE dept_ddl
	AS SELECT * FROM dept;

SELECT * FROM dept_ddl;

CREATE TABLE emp_ddl
AS SELECT * FROM emp WHERE deptno = 30;

SELECT * FROM emp_ddl;

CREATE TABLE empdept_ddl 
AS 
SELECT empno, ename, job job2, d.deptno, dname
FROM emp e, dept d
WHERE 1 <> 1; -- 항상 false인 값을 만들어 껍데기 생성 

SELECT * FROM empdept_ddl;

CREATE TABLE emp_alter
	AS SELECT * FROM emp;
-- emp 내용물 그대로 깊은 복사
SELECT * FROM emp_alter;
-- 출력

ALTER TABLE emp_alter
	ADD hp varchar2(20);
-- hp 컬럼 생성
SELECT * FROM emp_alter;
-- 출력

ALTER TABLE emp_alter
	RENAME COLUMN hp TO tel;
-- 'hp' 컬럼 > 'tel'로 변경
SELECT * FROM emp_alter;
-- 출력

ALTER TABLE emp_alter
MODIFY empno number(5);

ALTER TABLE emp_alter
DROP COLUMN tel;

SELECT * FROM emp_alter;

RENAME emp_alter TO emp_rename;
-- 테이블 emp_alter를 emp_rename으로 변경

SELECT * FROM emp_rename;
SELECT * FROM emp_alter;
-- emp_alter는 없다

TRUNCATE TABLE emp_rename; -- 되돌리기 불가능 / 데이터 삭제
SELECT * FROM emp_rename;

CREATE TABLE dept_temp
AS SELECT * FROM dept;
-- dept 테이블 가져오기

SELECT * FROM dept_temp;
-- 출력

INSERT INTO dept_temp (deptno, dname, loc)
-- 테이블에 값 생성 insert into 테이블 명 (컬럼1, 컬럼2, 컬럼3)
VALUES (50, 'DATABASE', 'SEOUL');
-- values (값, 값, 값)

SELECT * FROM dept_temp;

INSERT INTO dept_temp 
--컬럼을 기입하지 않으면 순서대로 삽입 (생략 가능)
VALUES (60, 'Network', 'BUSAN');
-- values (값, 값, 값) 
SELECT * FROM dept_temp;

INSERT INTO dept_temp
VALUES (80, 'MOBILE', ''); 
-- NULL 값 만드는 방법
SELECT * FROM dept_temp;

INSERT INTO dept_temp (deptno, loc)
VALUES (90, 'INCHEON');
-- 그냥 아무것도 안쓰면 NULL 초기값
SELECT * FROM dept_temp;

create TABLE emp_temp
	AS SELECT *
	FROM emp
	WHERE 1 <> 1;
-- 빈 내용의 테이블 생성

SELECT * FROM emp_temp;

INSERT INTO emp_temp (empno, ename, hiredate)
values(9999, '홍길동', '2026/01/27');
-- 날짜 값 넣기
SELECT * FROM emp_temp;

INSERT INTO emp_temp (empno, ename, hiredate)
VALUES (7051, '최민수', to_date('2026-01-27', 'yyyy-mm-dd') );
-- 양식 안에 날짜를 입력하여 조금 더 안전하게 값 삽입
SELECT * FROM emp_temp;

INSERT INTO emp_temp (empno, ename, hiredate)
VALUES (3111, '심청이', sysdate);
SELECT * FROM emp_temp;

INSERT INTO emp_temp
-- deptno가 10인 대상들을 emp_temp 테이블에 추가
SELECT * FROM emp WHERE deptno = 10;

INSERT ALL
INTO EMP_TEMP (empno, ename, hiredate)
	values(3111, '심청이', sysdate)
	--dual 테이블 필수
SELECT * FROM dual;

SELECT * FROM dual;

-------------
----update---
-------------

CREATE TABLE dept_temp2
AS SELECT * FROM dept;
SELECT * FROM dept_temp2;

-- update / set 

UPDATE dept_temp2
SET loc = 'SEOUL';
-- where 조건 없이 update 를 하는 것은 굉장히 위험하다
-- 반드시 update를 한 뒤에 사용하자
SELECT * FROM dept_temp2;



ROLLBACK;
SELECT * FROM dept_temp2;

SELECT * FROM dept_temp2
WHERE deptno = 40;

UPDATE dept_temp2
SET dname = 'DATABASE', loc = 'SEOUL'
WHERE deptno = 40;

SELECT * FROM dept_temp2;

UPDATE dept_temp2
SET dname = (SELECT dname
			 FROM DEPT 
			 WHERE deptno = 40),
	loc = (SELECT loc
			FROM DEPT
			WHERE deptno = 40)
WHERE deptno = 40;
SELECT * FROM dept_temp2;

CREATE TABLE EMP_TMP 
AS SELECT * FROM emp;
SELECT * FROM emp_tmp;

SELECT sal, sal * 1.08 FROM emp_tmp
WHERE sal < 1000;

UPDATE emp_temp
--set 은 update 계의 select라고 생각 하는게 편함
SET sal = sal * 1.08
WHERE sal < 1000;

SELECT * FROM emp_tmp
WHERE ename IN ('SMITH', 'JAMES');

CREATE TABLE emp_temp2
AS SELECT * FROM emp;

delete FROM emp_temp2
WHERE job = 'MANAGER';
SELECT * FROM emp_temp2;

DELETE FROM emp_temp2;
--삭제
SELECT * FROM emp_temp2;

ROLLBACK;

delete FROM emp_temp2
WHERE job = 'MANAGER';
SELECT * FROM emp_temp2;

COMMIT;

SELECT * FROM emp_temp2;

ROLLBACK;

SELECT * FROM emp_temp2;


---------------
------13장-----
---------------

SELECT * FROM dict;
SELECT * FROM user_tables;


-------------
----index----
-------------

CREATE INDEX idx_emp_sal
ON emp (sal asc);
-- 인덱스 생성 ON 테이블 명 
SELECT * FROM user_indexes;
SELECT * FROM user_ind_columns;

SELECT *
FROM emp
WHERE sal = 2000;

SELECT /*+ index(e idx_emp_sal) */ -- 강제 hint
	ename, sal
FROM emp e
WHERE sal = 3000;

--GRANT : 권한 부여
--REVOKE : 권한 박탈

CREATE VIEW vw_emp20
		AS (SELECT empno, ename, job, deptno)
		FROM EMP
		WHERE deptno = 20);

SELECT * FROM vw_emp20;


CREATE TABLE dept_seq
AS SELECT * FROM dept WHERE 1 != 1;
SELECT * FROM dept_seq;

CREATE sequence seq_dept;

SELECT * FROM USER_sequences;
-- .nextval 다음 값
SELECT seq_dept.nextval FROM dual;

-- .currval 현재 값
SELECT seq_dept.currval FROM dual;

--제약 조건
-- 방법 1
CREATE TABLE table_pk(
	--pk = 중복 안됨
	login_id varchar2(20) PRIMARY KEY,
	-- not null = null 안됨
	login_pw varchar2(20) NOT NULL,
	tel varchar2(20)
);
SELECT * FROM table_pk;

--pk를 지정하면 index 자동 생성
SELECT * FROM USER_indexes;

INSERT INTO table_pk
values('id1', 'pw1', NULL);
INSERT INTO table_pk
values('id1', 'pw1', null);

INSERT INTO table_pk
values('id2', NULL, null);



SELECT * FROM table_pk;

-- id만 들어가게 되면 pw가 null이 되어 못들어감
INSERT INTO table_pk (login_id)
values('id3');
-- pk나 not null 값을 null로 변경
UPDATE TABLE_pk
SET login_id = NULL
WHERE login_id = 'id1';

SELECT * FROM TABLE_pk;
-- pk를 중복되는 값으로 변경
INSERT INTO table_pk
values('id2', 'pw2', NULL);
INSERT INTO table_pk

UPDATE TABLE_pk
SET login_id = 'id1'
WHERE login_id = 'id2';

--방법 2
--pk 하나 이상 지정 가능
CREATE TABLE table_pk2(
	login_id varchar2(20),
	login_pw varchar2(20),
	tel varchar2(20),
	--커서 위치에 따라 실행 안되는 버그 있음
	PRIMARY KEY (login_id, login_pw)
);

SELECT * FROM table_pk2;

--방법 3
CREATE TABLE table_pk3(
	login_id varchar2(20),
	login_pw varchar2(20),
	tel varchar2(20),
);
ALTER TABLE table_pk3
ADD PRIMARY KEY (login_id, login_pw); 

ALTER TABLE table_pk3
MODIFY login_id /PRIMARY KEY;

SELECT * FROM table_pk3;

--foreign key
CREATE TABLE dept_fk(
	deptno number(2) PRIMARY KEY,
	dname varchar2(14),
	loc varchar2(13)
);

CREATE TABLE emp_fk(
	empno number(4) PRIMARY KEY,
	ename varchar2(10),
	--number에 dept_fk테이블의 deptno만 삽입 가능
	deptno number(2) REFERENCES dept_fk(deptno)
);


INSERT INTO emp_fk
VALUES (2, '이름2', null);

INSERT INTO dept_fk
VALUES (10, '부서', '위치');


INSERT INTO emp_fk
VALUES (2, '이름2', 10);

INSERT INTO emp_fk
VALUES (3, '이름3', 10);

SELECT * FROM emp_fk;
SELECT * FROM dept_fk;

-- 없는 값으로 update 안됨
UPDATE emp_fk
SET deptno = 20
WHERE deptno = 10;

-- 쳐다보고 있는 원본 값 삭제 안됨
DELETE dept_fk
WHERE deptno = 10;

DROP TABLE dept_fk;
DROP TABLE emp_fk;

UPDATE dept_fk
SET deptno = 20
WHERE deptno = 10;

DELETE emp_fk
WHERE deptno = 10; 

UPDATE dept_fk
SET deptno = 20
WHERE deptno = 10;


SELECT * FROM SALGRADE ;
SELECT * FROM emp ;

SELECT * FROM (
	SELECT rownum AS rnum, e.* FROM (
		SELECT * FROM emp
		ORDER BY hiredate
	) e
)
WHERE rnum >= 3 AND rnum <= 7;

--WHERE rnum BETWEEN 3 AND 7;
