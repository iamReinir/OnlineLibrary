create database library default character set utf8mb4 default collate utf8mb4_general_ci;
use library;

CREATE TABLE library.book(
  `id_BOOK` INT PRIMARY KEY AUTO_INCREMENT,
  `ISBN` VARCHAR(50) NOT NULL,
  `title` VARCHAR(255),
  `author` VARCHAR(255),
  `year_of_pub` YEAR,
  `download_link` VARCHAR(255),
  `add_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `is_delete` BOOLEAN DEFAULT false,
  `last_modified_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `summary` VARCHAR(255)
 );

CREATE TABLE library.user(
  `id_user` INT PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50),
  `telephone_number` CHAR(10),
  `role` VARCHAR(255),
  `is_delete` BOOLEAN DEFAULT false,
  `register_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `last_modified_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
  UNIQUE(email)
);
  
CREATE TABLE library.reservation(
  `reserve_id` INT PRIMARY KEY AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_BOOK` INT NOT NULL,
  `is_accept` BOOLEAN DEFAULT false,
  `request_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `accept_date` DATETIME,
  `is_delete` BOOLEAN DEFAULT false,
  `last_modified_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
  
CREATE TABLE library.borrowing(
  `borrow_id` INT PRIMARY KEY AUTO_INCREMENT,
  `borrower_id` INT NOT NULL,
  `id_BOOK` INT NOT NULL,  
  `start_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `due_date` DATETIME,
  `return_date` DATETIME,
  `last_modified_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` BOOLEAN DEFAULT false
);
  
CREATE TABLE library.review (
  `review_id` INT PRIMARY KEY AUTO_INCREMENT,
  `id_BOOK` INT NOT NULL,
  `id_user` INT NOT NULL,
  `rating` FLOAT,
  `user_review` TEXT,
  `review_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `is_delete` BOOLEAN DEFAULT false,
  `last_modified_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
  
CREATE TABLE library.renewal (
  `renewal_id` INT PRIMARY KEY AUTO_INCREMENT,
  `borrow_id` INT NOT NULL,
  `is_accept` BOOLEAN,
  `accept_librarian_id` INT,
  `request_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `accept_date` DATETIME,
  `is_delete` BOOLEAN DEFAULT false,
  `last_modified_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

alter table library.reservation add constraint FK_REVERSE_BOOK
	foreign key (id_BOOK) references library.book(id_BOOK);
    
alter table library.reservation add constraint FK_REVERSE_USER
	foreign key (id_user) references library.user(id_user);

alter table library.review add constraint FK_REVIEW_BOOK
	foreign key (id_BOOK) references library.book(id_BOOK);
    
alter table library.review add constraint FK_REVIEW_USER
	foreign key (id_user) references library.user(id_user);

alter table library.borrowing add constraint FK_BORROW_BOOK
	foreign key (id_BOOK) references library.book(id_BOOK);

alter table library.borrowing add constraint FK_BORROW_USER
    foreign key (borrower_id) references library.user(id_user);
    
alter table library.renewal add constraint FK_RENEWAL_BORROW
	foreign key (borrow_id) references library.borrowing(borrow_id);

-- CREATE USER onlLib@'%' IDENTIFIED BY '123456';
-- GRANT DELETE,UPDATE,SELECT,INSERT ON library.book TO onlLib@'%';
-- GRANT DELETE,UPDATE,SELECT,INSERT ON library.user TO onlLib@'%';
-- GRANT DELETE,UPDATE,SELECT,INSERT ON library.reservation TO onlLib@'%';
-- GRANT DELETE,UPDATE,SELECT,INSERT ON library.borrowing TO onlLib@'%';
-- GRANT DELETE,UPDATE,SELECT,INSERT ON library.review TO onlLib@'%';
-- GRANT DELETE,UPDATE,SELECT,INSERT ON library.renewal TO onlLib@'%';