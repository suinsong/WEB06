

create table memo(
	mnum int not null primary key auto_increment,
	mname varchar(30) not null,
	mcontent varchar(2000) not null,
	mday datetime default now()

)

insert into memo(mname, mcontent) values("������","�ؽ�Ʈ�Դϴ�~");
insert into memo(mname, mcontent) values("�ڳ���","�ؽ�Ʈ�Դϴ�~");
select * from memo;