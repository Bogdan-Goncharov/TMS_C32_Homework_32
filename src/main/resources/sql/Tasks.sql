create table if not exists public.tasks
(
    id          serial
    primary key,
    user_id     integer      not null
    references public.users,
    title       varchar(255) not null,
    description text,
    due_date    timestamp,
    status      varchar(20) default 'pending'::character varying,
    created_at  timestamp   default CURRENT_TIMESTAMP
    );

alter table public.tasks
    owner to "user";

