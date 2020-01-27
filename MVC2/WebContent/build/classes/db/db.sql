select * from member

select * from dba_users

select * from dba_role_privs
where grantee='YWY';

create table test(
class char(1) default 'z'
)

delete from MEMBER

drop table member


create table member(
id varchar2(30) primary key not null,
password varchar2(30) not null,
m_grade char(1) default 'z',
name varchar2(30) not null,
age number(3) default 0,
birth date default sysdate,
email varchar2(30) not null,
img varchar2(100) default '일반회원.jpg'
)
commit

insert into member values('admin','921107#','a','윤원용',29,'1992-11-07','ywyi1992@gmail.com','운영자.jpg')

select * from cols
where table_name='MEMBER';

alter table member rename column class to m_class
