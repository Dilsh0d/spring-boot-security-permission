INSERT INTO "permission"(roles, workspace,"read","write","delete") VALUES
	('Admin', 'Dashboard', true, true, true),
	('Admin', 'Employee', true, true, true),
	('Admin', 'Project', true, true, true),
	('Admin', 'Task', true, true, true),
	('Admin', 'Team', true, true, true),

	('Pm', 'Dashboard', true, false, false),
	('Pm', 'Employee', true, false, false),
	('Pm', 'Project', true, true, true),
	('Pm', 'Task', true, true, true),
	('Pm', 'Team', true, false, false),

	('TemaLead', 'Dashboard', true, false, false),
	('TemaLead', 'Employee', true, true, true),
	('TemaLead', 'Project', true, false, false),
	('TemaLead', 'Task', true, false, false),
	('TemaLead', 'Team', true, true, true),

	('User', 'Dashboard', false, false, false),
	('User', 'Employee', true, false, false),
	('User', 'Project', true, false, false),
	('User', 'Task', true, true, false),
	('User', 'Team', true, false, false);