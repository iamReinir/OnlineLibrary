INSERT INTO book (ISBN, title, author, year_of_pub, summary) VALUES ("123456789", "WorldEnd", "ADeprDude",16, "Depressing story about tactical nuclear bomb girls.");

INSERT INTO book (ISBN, title, author, year_of_pub, summary) VALUES ("123456788", "HaryPotter", "JKRolling",16,"Harry Potter's knock off. Even the author pen name is knocked off.");

INSERT INTO book (ISBN, title, author, year_of_pub, summary, download_link) VALUES ("123456787", "Hope's Avenue", "CloudyRice",23,"A story about a train that slower than it should be","https://www.youtube.com/watch?v=o14pj9CsNVY");

INSERT INTO library.user (username, password, email, telephone_number,role)
	VALUES ("reinir", "reinir", "reinir@mail.com", "0987654321", "reader");

INSERT INTO review (id_BOOK,id_user,rating,user_review) VALUES ("1","1",3,"Hello, this is a review test");

INSERT INTO user (username,password,role) VALUES ("reinir_lib","reinir","librarian");