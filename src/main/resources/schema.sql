
create table if not exists restaurant (
    id INTEGER Primary Key AUTO_INCREMENT,
    name TEXT ,
    address TEXT,          
    cuisineType TEXT ,     
    rating INTEGER      

);
create table if not exists chef (
    id  INTEGER Primary Key AUTO_INCREMENT,
    firstName TEXT,
    lastName TEXT,
    expertise TEXT,
    experienceYears INTEGER,
    restaurantId INTEGER,
    FOREIGN KEY(restaurantId) REFERENCES restaurant(id)
    
);