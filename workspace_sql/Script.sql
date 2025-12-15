--ID: 5

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

--문제 1
SELECT ename FROM emp
WHERE 1500 <= sal AND 3000 > sal;

--문제 2
SELECT ename FROM emp 
WHERE (job = 'CLERK' or sal > 2000) AND deptno = 10;

-- IN문
SELECT ename FROM emp
WHERE deptno IN (10, 20);

--문제 4
SELECT * FROM emp
WHERE (deptno = 20 OR deptno = 30) AND (sal BETWEEN 2000 and 3000)
ORDER BY sal, ename;

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
WHERE deptno = 20
;

-- UNION ALL 중복된 값 그대로 출력
SELECT empno, ename, sal, deptno FROM EMP 
WHERE deptno = 10
UNION all
SELECT empno, ename, sal, deptno FROM EMP 
WHERE deptno = 10;




-------------------------------------------
--1
SELECT * FROM emp
WHERE ename Like '%S';

--2
SELECT empno, ename, job, sal, deptno FROM EMP
WHERE job = 'SALESMAN';

--3
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP
WHERE SAL > 2000 AND (DEPTNO = 20
OR DEPTNO = 30);

SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP
WHERE SAL > 2000 
AND DEPTNO = 20
UNION ALL
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP
WHERE SAL > 2000 
AND DEPTNO = 30;

--4
SELECT * FROM EMP
WHERE NOT (SAL >= 2000 AND SAL <= 3000);

--5
SELECT ENAME, EMPNO, SAL, DEPTNO FROM EMP
WHERE ENAME LIKE '%E%'
AND DEPTNO = 30
AND SAL NOT BETWEEN 1000 AND 2000;

--6
SELECT * FROM EMP
WHERE COMM IS NULL
AND MGR IS NOT NULL
AND JOB IN ('MANAGER','CLERK')
AND ENAME NOT LIKE '_L%';




SELECT empno, ename, job, SAL, DEPTNO FROM EMP
WHERE DEPTNO = 10 AND SAL >= 2000
UNION
SELECT empno, ename, job, SAL, DEPTNO FROM EMP
WHERE DEPTNO = 30 AND JOB = 'SALESMAN';