BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE pokemon (
    poke_id SERIAL PRIMARY KEY,
    poke_api_id INT NOT NULL,
    poke_name varchar(50) NOT NULL,
    url varchar(100)
);

COMMIT TRANSACTION;
