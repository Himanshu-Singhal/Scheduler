package com.sandbox.scheduler;

import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// Task task1 = new Task(0, Category.RED);
		// Task task2 = new Task(0, Category.BLUE);
		// Task task3 = new Task(0, Category.GREEN);
		// Task task4 = new Task(0, Category.GREEN);
		// Task task5 = new Task(0, Category.RED);
		// Task task6 = new Task(0, Category.RED);

		// List<Task> unsorted = Arrays.asList(task1, task2, task3, task4, task5,
		// task6);

		List<Task> unsorted = generateTasks();

		// Uncoment your line after implementing Scheduler.scheduleTask
		unsorted.forEach(t -> Scheduler.scheduleTask(t));

		// Uncoment your line after implementing Scheduler.printSchedule()
		Scheduler.printSchedule();
	}

	public static List<Task> generateTasks() throws InterruptedException {

		List<Task> tasks = new ArrayList<Task>();

		for (int i = 0; i < 100; i++) {
			Task task = new Task(getRandomNumberUsingInts(0, 6), Category.randomLetter());
			System.out.println("task" + task + '\n');

			Thread.sleep(5);
			tasks.add(task);

		}

		return tasks;
	}

	public static int getRandomNumberUsingInts(int min, int max) {
		Random random = new Random();
		return random.ints(min, max).findFirst().getAsInt();
	}

}
