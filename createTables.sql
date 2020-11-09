CREATE TABLE "users" (
  "user_id" serial,
  "username" varchar(10) not null,
  "password" varchar(10) not null,
  "email" varchar(10) not null,
  PRIMARY KEY (user_id)
);


CREATE TABLE "posts" (
  "post_id" serial,
  "user_id" int not null,
  "title" varchar (30) not null,
  "fileType" varchar (20),
  "genre" varchar (20),
  "price" numeric (4,2) default 00.00 ,
  PRIMARY KEY (post_id)
);

alter table posts add constraint FK_user_id 
foreign key (user_id) 
references users (user_id) on delete no action on update no action;


CREATE TABLE "purchases" (
  "purchase_id" serial,
  "post_id" int not null,
  "amount" numeric(4,2),
  PRIMARY KEY (purchase_id)
);
alter table posts add constraint FK_post_id 
foreign key (post_id) 
references posts (post_id) on delete no action on update no action;