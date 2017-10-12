CREATE TABLE user_details(
		id INT,
        username VARCHAR(255) UNIQUE NOT NULL,
        first_name  VARCHAR(255) NOT NULL,
		last_name VARCHAR(255) NOT NULL,
		phone VARCHAR(10) UNIQUE NOT NULL,
		pwd VARCHAR(255) NOT NULL,
        email VARCHAR(255) UNIQUE NOT NULL,
        PRIMARY KEY (id)
);

CREATE TABLE topic (
	id INT,
    topic_name VARCHAR(255) UNIQUE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE book (
	id INT,
    book_name VARCHAR(255) UNIQUE NOT NULL,
    author VARCHAR(255) NOT NULL,
    topic_id INT NOT NULL,
     PRIMARY KEY (id),
     FOREIGN KEY (topic_id) REFERENCES topic(id)
);

CREATE TABLE activity (
	id INT,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    read_date DATE NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (book_id) REFERENCES book(id),
	FOREIGN KEY (user_id) REFERENCES user_details(id)
);