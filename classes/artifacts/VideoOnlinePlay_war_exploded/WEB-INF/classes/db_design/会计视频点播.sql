CREATE TABLE `user` (
`id` varchar(64) NOT NULL,
`role_id` varchar(64) NULL,
`account` varchar(64) NULL,
`password` varchar(64) NULL,
`name` varchar(64) NULL,
`age` int(11) NULL,
`sex` varchar(2) NULL,
`telephone` varchar(15) NULL,
`mail` varchar(64) NULL,
`level` int(3) NULL COMMENT '用户权限等级',
`header` varchar(100) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `course` (
`id` varchar(64) NOT NULL,
`teacher_id` varchar(64) NULL,
`classify_id` varchar(64) NULL,
`name` varchar(64) NULL,
`description` varchar(500) NULL,
`create_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
`play_src` varchar(100) NULL,
`require_level` int(3) NULL,
`study_times` int(11) NOT NULL COMMENT '报名一次, 就更新一次',
PRIMARY KEY (`id`) 
);

CREATE TABLE `comment` (
`id` varchar(64) NOT NULL,
`time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
`content` varchar(1000) CHARACTER SET utf8 NULL,
`comment_user_id` varchar(64) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `user_course_apply` (
`user_id` varchar(64) NULL,
`course_id` varchar(64) NULL,
`apply_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `role` (
`id` varchar(64) NOT NULL,
`name` varchar(64) CHARACTER SET utf8 NULL,
`description` varchar(200) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `user_role` (
`user_id` varchar(64) NULL,
`role_id` varchar(64) NULL
);

CREATE TABLE `menu` (
`id` varchar(64) NOT NULL,
`name` varchar(64) CHARACTER SET utf8 NULL,
`parent_id` varchar(64) NULL,
`icon` varchar(16) NULL,
`url` varchar(64) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `role_menu` (
`role_id` varchar(64) NULL,
`menu_id` varchar(64) NULL
);

CREATE TABLE `question` (
`id` varchar(64) NOT NULL,
`user_id` varchar(64) NULL,
`course_id` varchar(64) NULL,
`question1` varchar(255) NULL,
`question2` varchar(255) NULL,
`question3` varchar(255) NULL,
`question4` varchar(255) NULL,
`question5` varchar(255) NULL,
`question6` varchar(255) NULL,
`question7` varchar(255) NULL,
`question8` varchar(255) NULL,
`question9` varchar(255) NULL,
`question10` varchar(255) NULL,
`score` int(5) NULL,
`status` int(1) NULL COMMENT '状态, 已批改还是未批改',
PRIMARY KEY (`id`) 
);

CREATE TABLE `survey` (
`id` varchar(64) NOT NULL,
`course_id` varchar(64) NULL,
`user_id` varchar(64) NULL,
`question1` varchar(255) NULL,
`question2` varchar(255) NULL,
`question3` varchar(255) NULL,
`question4` varchar(255) NULL,
`question5` varchar(255) NULL,
`question6` varchar(255) NULL,
`question7` varchar(255) NULL,
`question8` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `user_survey` (
`survey_id` varchar(64) NULL,
`user_id` int(11) NULL
);

CREATE TABLE `classify` (
`id` varchar(64) NOT NULL,
`name` varchar(64) NULL COMMENT '分类名',
PRIMARY KEY (`id`) 
);

CREATE TABLE `apply` (
`id` varchar(64) NOT NULL,
`apply_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
`course_id` varchar(64) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `course_comment` (
`course_id` varchar(64) NULL,
`comment_id` varchar(64) NULL
);

CREATE TABLE `user_apply` (
`user_id` varchar(64) NULL,
`apply_id` varchar(64) NULL
);


ALTER TABLE `user_course_apply` ADD CONSTRAINT `fk_table_1_table_1_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `user_course_apply` ADD CONSTRAINT `fk_table_1_table_1_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);
ALTER TABLE `user` ADD CONSTRAINT `fk_user_user_survey_1` FOREIGN KEY (`id`) REFERENCES `user_survey` (`survey_id`);
ALTER TABLE `survey` ADD CONSTRAINT `fk_survey_user_survey_1` FOREIGN KEY (`id`) REFERENCES `user_survey` (`user_id`);
ALTER TABLE `apply` ADD CONSTRAINT `fk_apply_course_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);
ALTER TABLE `course_comment` ADD CONSTRAINT `fk_course_comment_comment_1` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`);
ALTER TABLE `course_comment` ADD CONSTRAINT `fk_course_comment_course_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);
ALTER TABLE `user_apply` ADD CONSTRAINT `fk_user_apply_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `user_apply` ADD CONSTRAINT `fk_user_apply_apply_1` FOREIGN KEY (`apply_id`) REFERENCES `apply` (`id`);
ALTER TABLE `question` ADD CONSTRAINT `fk_question(调查问卷)_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `question` ADD CONSTRAINT `fk_question(调查问卷)_course(课程)_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);
ALTER TABLE `role_menu` ADD CONSTRAINT `fk_role_menu_role_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
ALTER TABLE `role_menu` ADD CONSTRAINT `fk_role_menu_menu_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`);
ALTER TABLE `user_role` ADD CONSTRAINT `fk_user_role_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `user_role` ADD CONSTRAINT `fk_user_role_role_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
ALTER TABLE `survey` ADD CONSTRAINT `fk_survey_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `survey` ADD CONSTRAINT `fk_survey_course_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);
ALTER TABLE `course` ADD CONSTRAINT `fk_course_classify_1` FOREIGN KEY (`classify_id`) REFERENCES `classify` (`id`);
ALTER TABLE `comment` ADD CONSTRAINT `fk_comment_user_1` FOREIGN KEY (`comment_user_id`) REFERENCES `user` (`id`);

