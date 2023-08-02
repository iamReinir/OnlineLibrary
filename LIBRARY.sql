create database library default character set utf8mb4 default collate utf8mb4_general_ci;
use library;

CREATE TABLE library.book(
  `book_id` INT AUTO_INCREMENT,
  `ISBN` VARCHAR(50) NOT NULL,
  `title` VARCHAR(255),
  `author` VARCHAR(255),
  `year_of_pub` DATE,
  `dowload_link` VARCHAR(255),
  `add_date` DATE,
  `delete_date` DATE,
  UNIQUE(ISBN),
  PRIMARY KEY (`book_id`)
);

CREATE TABLE library.user(
  `id` INT AUTO_INCREMENT,
  `usename` VARCHAR(255) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50),
  `telephone_number` CHAR(10),
  `role` VARCHAR(255),
  `delete_date` DATE,
  `register_date` DATE,
  PRIMARY KEY (`id`),
  UNIQUE(email)
);
  
CREATE TABLE library.reservation(
  `reserve_id` INT AUTO_INCREMENT,
  `reserv_user` INT,
  `book_id` INT,
  `is_accept` BOOLEAN,
  `request_date` DATE,
  `accept_date` DATE,
  `delete_date` DATE,
  PRIMARY KEY (`reserve_id`)
 );
 
alter table library.reservation add constraint FK_REVERSE_BOOK
	foreign key (book_id) references library.book(book_id);
    
alter table library.reservation add constraint FK_REVERSE_USER
	foreign key (reserv_user) references library.user(id);
  
CREATE TABLE library.borrowing(
  `borrow_id` INT PRIMARY KEY AUTO_INCREMENT,
  `borrower_id` INT,
  `book_id` INT,  
  `start_date` DATE,
  `due_date` DATE,
  `return_date` DATE  
 );
 
alter table library.borrowing add constraint FK_BORROW_BOOK
	foreign key (book_id) references library.book(book_id);

alter table library.borrowing add constraint FK_BORROWER_ID
	foreign key (borrower_id) references library.user(id);
  
CREATE TABLE library.review (
  `review_id` INT PRIMARY KEY AUTO_INCREMENT,
  `book_id` INT,
  `reviewer_id` INT,
  `rating` FLOAT,
  `user_review` TEXT,
  `review_date` DATE,
  `delete_date` DATE
);
 
alter table library.review add constraint FK_REVIEW_BOOK
	foreign key (book_id) references library.book(book_id);
    
alter table library.review add constraint FK_REVIEW_USER
	foreign key (reviewer_id) references library.user(id);
  
CREATE TABLE `library`.`renewal` (
  `renewal_id` INT AUTO_INCREMENT,
  `borrow_id` INT,
  `is_accept` BOOLEAN,
  `accept_librarian_id` INT,
  `request_date` DATE,
  `accept_date` DATE,
  `delete_date` DATE,
  PRIMARY KEY (`renewal_id`)
);
    
alter table library.renewal add constraint FK_RENEWAL_BORROW
	foreign key (borrow_id) references library.borrowing(borrow_id);
	
alter table library.renewal add constraint FK_RENEWAL_LIBRARIAN
	foreign key (accept_librarian_id) references library.user(id);