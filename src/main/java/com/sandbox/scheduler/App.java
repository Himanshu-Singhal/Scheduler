package com.sandbox.scheduler

import com.sandbox.scheduler.model.Task;

import java.util.Arrays;
import java.util.List;


public class App {
	
	public static void main(String[] args) {
		Task task1 = new Task(0, Category.RED);
		Task task2 = new Task(0, Category.BLUE);
		Task task3 = new Task(0, Category.GREEN);
		Task task4 = new Task(0, Category.GREEN);
		Task task5 = new Task(0, Category.RED);
		Task task6 = new Task(0, Category.RED);
		
		List<Task> unsorted = Arrays.asList(task1, task2, task3, task4, task5, task6);
		
		
		//Uncoment your line after implementing Scheduler.scheduleTask
		//unsorted.forEach(t -> Scheduler.scheduleTask(t));
		
		//Uncoment your line after implementing Scheduler.printSchedule()
		//Scheduler.printSchedule();
	}
}
