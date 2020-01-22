select * from member
select * from dba_users

select * from dba_role_privs
where grantee='YWY';

create table test(
class char(1) default 'z'
)

drop table test

create table member(
id varchar2(30) primary key not null,
password varchar2(30) not null,
class char(1) default 'z',
name varchar2(30) not null,
age number(3) default 0,
birth date default sysdate,
email varchar2(30) not null,
img varchar2(100) default '일반회원.jpg'
)
commit


select * from cols
where table_name='MEMBER';

alter table member rename column class to m_class
