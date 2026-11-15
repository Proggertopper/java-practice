create table users(
                      id UUID primary key,
                      email varchar(100) unique not null,
                      password_hash varchar(150) not null
);

create table processing_log(
                               id UUID primary key,
                               user_id UUID ,
                               input_text text not null,
                               output_text text not null,
                               created_at TIMESTAMP default now(),
                               constraint fk_user
                                   foreign key (user_id)
                                       references users(id)
                                       on delete set null
                                       on update cascade
);