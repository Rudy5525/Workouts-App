package org.projects.workoutsapp.objects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WorkoutRecord {
	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	//public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	private String name;
	public final LocalDateTime startTime;
	public LocalDateTime endTime;
	private final ArrayList<ExerciseRecord> exercises;

	public WorkoutRecord() {
		this.name = "";
		this.startTime = LocalDateTime.now();
		this.exercises = new ArrayList<>();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public String getStartTime() {
		return this.startTime.format(dtf);
	}
	public String getEndTime() {
		return this.endTime.format(dtf);
	}
	public static String getDuration(String start, String end){
		Duration duration = Duration.between(LocalTime.parse(start, WorkoutRecord.dtf), LocalTime.parse(end, WorkoutRecord.dtf));
		StringBuilder formattedTime = new StringBuilder();
		duration = duration.plusSeconds(1);

		if(duration.toHours() > 0) formattedTime.append(duration.toHours()).append("h ");
		if(duration.toMinutes() > 0) formattedTime.append(duration.toMinutes()%60).append("m ");
		formattedTime.append(duration.getSeconds()%60).append("s");

		return formattedTime.toString();
	}
	public void addExercise(ExerciseRecord exercise){
		this.exercises.add(exercise);
	}
	public ArrayList<ExerciseRecord> getExercises(){
		return this.exercises;
	}

}
