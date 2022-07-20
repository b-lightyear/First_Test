-- 아이디가 admin인 회원의 존재여부 확인
select count(userid)
from member
where userid='admin1'

alter table member modify (userpw null);