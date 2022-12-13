create table Candy.Candy
(
    id         int auto_increment,
    name       varchar(50) not null,
    weight     int         not null,
    sugar      double      not null,
    price      double      not null,
    hasCoconut tinyint(1)  null,
    hasNuts    tinyint(1)  null,
    chocolate  varchar(15) null,
    figure     varchar(20) null,
    favour     varchar(20) null,
    color      varchar(20) null,
    type       int         not null,
    constraint id
        unique (id)
);