create table if NOT EXISTS users (
  username varchar(50) not null primary key,
  password varchar(50) not null,
  enabled boolean not null
) engine = InnoDb;

create table if NOT EXISTS authorities (
  username varchar(50) not null,
  authority varchar(50) not null,
  foreign key (username) references users (username),
  unique index authorities_idx_1 (username, authority)
) engine = InnoDb;

create table if NOT EXISTS groups (
  id bigint unsigned not null auto_increment primary key,
  group_name varchar(50) not null
) engine = InnoDb;

create table if NOT EXISTS group_authorities (
  group_id bigint unsigned not null,
  authority varchar(50) not null,
  foreign key (group_id) references groups (id)
) engine = InnoDb;

create table if NOT EXISTS group_members (
  id bigint unsigned not null auto_increment primary key,
  username varchar(50) not null,
  group_id bigint unsigned not null,
  foreign key (group_id) references groups (id)
) engine = InnoDb;

create table if NOT EXISTS persistent_logins (
  username varchar(64) not null,
  series varchar(64) primary key,
  token varchar(64) not null,
  last_used timestamp not null
) engine = InnoDb;

