INSERT INTO exercise (exercise_name, exercise_description, exercise_target_muscle_group, exercise_image, exercise_video_link)
VALUES ('Dead lift', 'The exercise is p', 'core your posture', null, null);



INSERT INTO exercise (exercise_name, exercise_description, exercise_target_muscle_group, exercise_image, exercise_video_link)
VALUES ('Leg press', 'Push yourweight.', 'Quads, Glutes, Adductors', null, null);



INSERT INTO exercise (exercise_name, exercise_description, exercise_target_muscle_group, exercise_image, exercise_video_link)
VALUES ('Bulgarian split squat', 'One foot knee.', 'Quads, Glutes, Adductors', null, null);



INSERT INTO exercise (exercise_name, exercise_description, exercise_target_muscle_group, exercise_image, exercise_video_link)
VALUES ('Seated leg curl', 'Sit and bend your knees.', 'Hamstrings', null, null);



INSERT INTO set (set_exercise_repetition) VALUES (4);
INSERT INTO set (set_exercise_repetition) VALUES (3);





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




INSERT INTO goal (goal_end_date, goal_achieved) VALUES ('2022-09-01', true);
INSERT INTO goal (goal_end_date, goal_achieved) VALUES ('2022-09-07', false);
INSERT INTO goal (goal_end_date, goal_achieved) VALUES ('2022-09-14', false);





INSERT INTO profile (profile_weight, profile_height, profile_medical_conditions, profile_disabilities)
VALUES (60, 170, 'Diabetes', 'None');