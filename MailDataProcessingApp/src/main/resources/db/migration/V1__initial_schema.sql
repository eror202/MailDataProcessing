create table receiver
(
    id                int primary key auto_increment ,
    index             varchar,
    address           varchar,
    name              varchar,
    is_delivered      varchar,
    time_of_delivered varchar,
    identification    int unique
);

create table types_of_post
(
    id                      int primary key auto_increment,
    type                    varchar,
    receiver_identification int not null ,
    foreign key (receiver_identification) references receiver (identification)
);
create table post_office
(
    id      int primary key auto_increment,
    index   int,
    name    varchar unique,
    address varchar
);

create table post_path
(
    id                                     int primary key auto_increment,
    registration_time                      varchar,
    date_of_arrival_at_the_post_office     varchar,
    post_office_name                       varchar,
    date_of_departure_from_the_post_office varchar,
    receiver_identification                int not null ,
    foreign key (post_office_name) references post_office(name),
    foreign key (receiver_identification) references receiver(identification)
)

