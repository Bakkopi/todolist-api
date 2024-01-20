-- Insert data into 'user' table
INSERT INTO user (address, gender, password, username) VALUES
('123 Main St', 1, 'securePass123', 'john_doe'),
('456 Oak St', 2, 'strongPass789', 'jane_smith'),
('789 Elm St', 1, 'safePassword456', 'sam_jones');

-- Insert data into 'tag' table
INSERT INTO TAG (name, user_id) VALUES
('Work', 1),
('Personal', 1),
('Important', 1),
('Meeting', 2),
('Project', 2),
('Urgent', 2),
('Study', 3),
('Health', 3),
('Shopping', 3),
('Work', 3);

-- Insert data into 'task' table
INSERT INTO TASK (description, due_date, priority, status, task_name, user_id) VALUES
('Prepare report for client meeting', '2024-02-01', 1, 1, 'Client Report', 1),
('Buy groceries for the week', '2024-02-02', 2, 2, 'Grocery Shopping', 1),
('Complete coding assignment', '2024-02-03', 3, 2, 'Coding Assignment', 1),
('Discuss project timeline with team', '2024-02-04', 1, 3, 'Project Meeting', 2),
('Review and submit project proposal', '2024-02-05', 1, 2, 'Project Proposal', 2),
('Prepare presentation for conference', '2024-02-06', 1, 2, 'Conference Presentation', 2),
('Attend yoga class', '2024-02-07', 1, 1, 'Yoga Class', 3),
('Read a chapter of a book', '2024-02-08', 1, 2, 'Reading Time', 3),
('Complete workout routine', '2024-02-09', 2, 3, 'Fitness Routine', 3),
('Plan weekend outing with friends', '2024-02-10', 1, 3, 'Weekend Outing', 3);