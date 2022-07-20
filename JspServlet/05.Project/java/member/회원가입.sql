-- 고객 관리 모듈 테이블
create table CUSTOMER (
id number CONSTRAINT customer_id_pk PRIMARY key,
name varchar2(50) not null,
gender varchar2(3) default '여',
email varchar2(50),
phone varchar2(13)
);

-- 시퀀스, 트리거 이용
-- 초기 더미 데이터를 입력시 loop

select * from customer;

begin   -- 실행문 java(PL&SQL)
 for i in 1..20
 loop
    begin
        insert into CUSTOMER(id, name, email)
        values(i, '이름' || i, i||'@naver');
    exception when others then
        rollback;
    end;
    end loop;
end;