create table receiver(
    id int primary key auto_increment,
    index varchar ,
    address varchar ,
    name varchar ,
    is_delivered boolean,
    time_of_delivered varchar ,
    identification int unique
);

create table types_of_post(
    id int primary key auto_increment,
    type varchar ,
    receiver_identification int
)