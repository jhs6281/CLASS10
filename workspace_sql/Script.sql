

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
