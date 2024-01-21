-- USER table
INSERT INTO user (address, gender, password, username) VALUES
('123 Main St', 1, 'securePass123', 'john_doe'),
('456 Oak St', 2, 'strongPass789', 'jane_smith'),
('789 Elm St', 1, 'safePassword456', 'sam_jones');

-- TAG table
INSERT INTO Tag (hex_code, name) VALUES
  ('#0000FF', 'Personal'),
  ('#00FF00', 'Health'),
  ('#FF0000', 'Work'),
  ('#800080', 'Project'),
  ('#FFA500', 'Study'),
  ('#FFFF00', 'Event');

-- TASK table
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
('Plan weekend outing with friends', '2024-02-10', 1, 3, 'Weekend Outing', 3),
('Submit monthly expense report', '2024-02-11', 2, 1, 'Expense Report', 1),
('Prepare for upcoming presentation', '2024-02-11', 3, 2, 'Presentation Prep', 1),
('Attend team-building workshop', '2024-02-12', 1, 1, 'Team Workshop', 2),
('Write blog post on latest technology trends', '2024-02-12', 2, 3, 'Tech Blog', 2),
('Plan and host project kickoff meeting', '2024-02-13', 1, 2, 'Project Kickoff', 2),
('Complete online course on programming', '2024-02-14', 2, 1, 'Programming Course', 3),
('Visit the art exhibition at the museum', '2024-02-15', 1, 3, 'Art Exhibition', 3),
('Review and update project documentation', '2024-02-15', 3, 1, 'Documentation Review', 3),
('Attend leadership seminar', '2024-02-16', 2, 2, 'Leadership Seminar', 1),
('Prepare for upcoming job interview', '2024-02-16', 1, 2, 'Job Interview Prep', 1);

-- TASK_TAGS
INSERT INTO TASK_TAGS (task_id, tag_id) VALUES
  (1, 1),
  (1, 4),
  (2, 2),
  (3, 3),
  (4, 6),
  (5, 5),
  (6, 1),
  (6, 6),
  (7, 1),
  (8, 2),
  (8, 5),
  (11, 3),
  (11, 5),
  (12, 4),
  (12, 6),
  (13, 1),
  (14, 5),
  (15, 2),
  (15, 6),
  (16, 4),
  (17, 1),
  (17, 2),
  (18, 1),
  (19, 3),
  (20, 1),
  (20, 2);