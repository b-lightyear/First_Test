/*공지글관리*/
create table notice (
id        number constraint notice_id_pk primary key/*PK*/, 
title     varchar2(300) not null/*제목*/,
content   varchar2(4000) not null/*내용*/,
writer    varchar2(50)   /*작성자의 id*/,
writedate date default sysdate /*작성일자*/,
readcnt   number default 0 /*조회수*/
);

desc notice;

alter table notice 
add constraint notice_id_pk primary key(id);

alter table notice 
modify (title not null, content not null);

--notice 테이블의 PK인 id 컬럼에 적용할 시퀀스
create sequence seq_notice
start with 1 increment by 1;


--notice 테이블의 PK인 id 컬럼에 시퀀스를 자동적용시킬 트리거
-- notice 테이블에 데이터행을 insert 할때 PK인 id컬럼에 시퀀스값을 담는 처리를 한다
create or replace trigger trg_notice
  before insert on notice
  for each row
begin
  select seq_notice.nextval into :new.id from dual;
end;
/

update employees set salary=5000;
delete from departments where department_id > 120;
rollback;

select name from customer;
select seq_notice.nextval from dual;

시퀀스명.currval, 시퀀스명.nextval

insert into notice (id, title, content, writer)
values ( seq_notice.nextval, '테스트 공지글입니다', '테스트 공지글',  'admin');
commit;
select * from notice;

select title, m.name, writedate
from notice n LEFT OUTER JOIN member m
ON n.writer = m.userid;

