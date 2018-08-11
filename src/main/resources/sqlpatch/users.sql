INSERT INTO users(username,password, roles,create_date, last_in_date)
	VALUES ('admin','$2a$10$4KpRoCAm.WE4qAsPXua2PeoyQiDRGCiBxPjcrz5dbSNByV21wl7Zy','Admin',now(),now()),-- password same admin
	('pm','$2a$10$4KpRoCAm.WE4qAsPXua2PeoyQiDRGCiBxPjcrz5dbSNByV21wl7Zy','Pm',now(),now()),-- password same pm
	('team','$2a$10$mz3MP0LngBF8fOsZtXVl2OeUd3CZIb1pJaI0Qn8yTMzdyoKKAv.qe','TeamLead',now(),now()),-- password same team
	('user','$2a$10$.9403m3G0u4nrOXbilGPC.FyIuWNQepHTnEVgwpt9dLwX6tuL1uyW','User',now(),now());-- password same user;