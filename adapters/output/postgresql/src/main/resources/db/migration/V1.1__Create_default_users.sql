INSERT INTO USERS (name, email, status)  
VALUES ('Jane Smith', 'jane.smith@example.com', 'INACTIVE')  
RETURNING *;
