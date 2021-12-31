-- seq: users_id_seq
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(254) UNIQUE NOT NULL,
    password VARCHAR(500) NOT NULL
);

-- seq: roles_id_seq
CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  role_name VARCHAR(30) NOT NULL
);

CREATE TABLE users_roles (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES roles(id)
);