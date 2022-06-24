-- DATABASE : 데이터를 저장해놓은 곳 (게시판, 회원, 공공데이터 등)
-- 회원테이블을 이용해서 로그인, 회원가입, 아이디/비밀번호 찾기 등 응용
-- SELECT를 했을 때 어떤 결과가 나오지 않을 경우 로그인 실패, 조회한 정보 없음

 
SELECT  *
FROM    user_info
WHERE   user_id = ''
AND     user_pw = '';


SELECT  *
FROM    user_info
WHERE   user_id = ''
AND     user_pw = '';


UPDATE user_info
SET last_name = '신', first_name = '한솔'
WHERE user_id = 'hh';

DELETE FROM user_info WHERE student_no = 5 AND user_id = 'hh';


