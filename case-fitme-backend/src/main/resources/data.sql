INSERT INTO app_user (user_password, user_first_name, user_last_name, user_is_contributor, user_is_admin)
VALUES ( 'secretpass', 'Nemo', 'Nemosson', false, false);

INSERT INTO exercise (exercise_name, exercise_description, exercise_target_muscle_group, exercise_image, exercise_video_link)
VALUES ('Leg press', 'Push your legs with weight.', 'Quads, Glutes, Adductors', null, null);

INSERT INTO exercise (exercise_name, exercise_description, exercise_target_muscle_group, exercise_image, exercise_video_link)
VALUES ('Bulgarian split squat', 'One foot infront of the other and bend your knee.', 'Quads, Glutes, Adductors', null, null);

INSERT INTO exercise (exercise_name, exercise_description, exercise_target_muscle_group, exercise_image, exercise_video_link)
VALUES ('Seated leg curl', 'Sit and bend your knees.', 'Hamstrings', null, null);

INSERT INTO set (set_exercise_repetition) VALUES (4);
INSERT INTO set (set_exercise_repetition) VALUES (3);

-- UPDATE exercise SET set_id = 1
-- 	WHERE exercise_id = 1;
--
-- UPDATE exercise SET set_id = 2
-- 	WHERE exercise_id = 2;
--
-- UPDATE exercise SET set_id = 1
-- 	WHERE exercise_id = 3;

INSERT INTO workout (workout_name, workout_type, workout_complete)
VALUES ('Legs & glutes', 'Weights', true);
INSERT INTO workout (workout_name, workout_type, workout_complete)
VALUES ('Hamstrings', 'Weights', true);
INSERT INTO workout (workout_name, workout_type, workout_complete)
VALUES ('Arms', 'Weights', false);

INSERT INTO program (program_name, program_category)
VALUES ('Monday', 'Lower Body');
INSERT INTO program (program_name, program_category)
VALUES ('Tuesday', 'Upper Body');

-- INSERT INTO program_workout (program_id, workout_id) VALUES (1, 1);
-- INSERT INTO program_workout (program_id, workout_id) VALUES (1, 2);
-- INSERT INTO program_workout (program_id, workout_id) VALUES (2, 3);

INSERT INTO goal (goal_end_date, goal_achieved) VALUES ('2022-09-01', true);
INSERT INTO goal (goal_end_date, goal_achieved) VALUES ('2022-09-07', false);
INSERT INTO goal (goal_end_date, goal_achieved) VALUES ('2022-09-14', false);

-- INSERT INTO goal_workout (goal_id, workout_id) VALUES (1, 1);
-- INSERT INTO goal_workout (goal_id, workout_id) VALUES (1, 2);
-- INSERT INTO goal_workout (goal_id, workout_id) VALUES (1, 3);

INSERT INTO profile (profile_weight, profile_height, profile_medical_conditions, profile_disabilities)
VALUES (60, 170, 'Diabetes', 'None');

-- INSERT INTO profile_program (profile_id, program_id) VALUES (1, 1);

-- UPDATE profile SET user_id = 1
-- 	WHERE profile_id = 1;
--
-- UPDATE set SET workout_id = 1
-- 	WHERE set_id = 1;
--
-- UPDATE set SET workout_id = 2
-- 	WHERE set_id = 2;
--
-- UPDATE set SET workout_id = 3
-- 	WHERE set_id = 3;
