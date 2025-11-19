CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE,
  password VARCHAR(255),
  role VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS agents (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  phone VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS delivery (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  pickup_address VARCHAR(255),
  drop_address VARCHAR(255),
  pickup_lat DOUBLE,
  pickup_lng DOUBLE,
  drop_lat DOUBLE,
  drop_lng DOUBLE,
  agent_id BIGINT,
  status VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS tracking (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  delivery_id BIGINT,
  lat DOUBLE,
  lng DOUBLE,
  timestamp TIMESTAMP
);
