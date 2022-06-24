-- user_info 테이블에 데이터를 삽입(INSERT) 해보기.
-- 컬럼 갯수랑 데이터 갯수가 다르면 오류 발생
INSERT INTO user_info VALUES (5, 'SHS', 'hshs', 'HANSOL', 'SHIN', sysdate, sysdate);

SELECT  *
FROM    user_info;

-- INSERT문을 사용해서 데이터를 수정하게되면(추가) 트랜잭션이 발생한다 (작업한 결과를 임시로 가지고있음)
-- 어떠한 오류가 발생하거나 데이터추가를 잘못한 겨우, 되돌릴 수 있다.
-- COMMIT(확정), ROLLBACK(취소)

ROLLBACK;

COMMIT; -- 커밋을 하게 되면 다시 롤백할 수 없다. (임시에서 확정으로, 커밋 이후에는 임시데이터가 아니라 확정 데이터이기 때문에 ROLLBACK으로 되돌릴 수 없다)

 
 
-- UPDATE 쿼리를 이용해서 내가 등록한 USER_INFO 수정해보기
UPDATE  user_info
SET     user_pw = 'password'
WHERE   student_no = 5;


-- DELETE
DELETE  FROM user_info
WHERE   student_no = 5 AND user_id = 'SHS';


SELECT  *
FROM    student;


-- 로그인처리를 위한 쿼리를 작성하기오 (user_info 테이블 이용)




