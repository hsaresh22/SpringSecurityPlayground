-- Sample init script for MySQL playground
-- This script runs automatically when the container starts

USE playground;

-- Create a sample table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT INTO users (username, email) VALUES
('john_doe', 'john@example.com'),
('jane_smith', 'jane@example.com'),
('bob_wilson', 'bob@example.com');

-- Create another sample table
CREATE TABLE IF NOT EXISTS posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert sample posts
INSERT INTO posts (user_id, title, content) VALUES
(1, 'First Post', 'This is my first blog post'),
(1, 'Second Post', 'Another great post'),
(2, 'Hello World', 'Welcome to my blog');
