create table if not exists public.users
(
    id         serial
    primary key,
    username   varchar(50)  not null,
    email      varchar(100) not null,
    created_at timestamp default CURRENT_TIMESTAMP
    );

alter table public.users
    owner to "user";

