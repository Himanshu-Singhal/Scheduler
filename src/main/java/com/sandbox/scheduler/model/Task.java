package com.sandbox.scheduler.model;

import java.time.LocalDateTime;

public class Task implements Comparable<Task> {

	public int urgency = -1;
	public Category category;
	public LocalDateTime timeStamp = LocalDateTime.now();

	public Task(int urgency, Category category) {
		this.urgency = urgency;
		this.category = category;
	}

	public String toString() {
		return "[TASK] URGENCY: " + urgency + " CATEGORY: " + category + " TIMESTAMP: " + timeStamp;
	}

	/*
	 * returns 1 if (the new task to be scheduled) has higher priority than the task
	 * already in the scheduled list (task) -1 if task (the parameter) has higher
	 * priority than the task (this)
	 */
	@Override
	public int compareTo(Task taskScheduled) {
		if (urgency < taskScheduled.urgency) {
			return 1;
		} else if (urgency > taskScheduled.urgency) {
			return -1;
		} else if (urgency == taskScheduled.urgency) {
			return compareCategory(taskScheduled);
		}
		return 0;
	}

	private int compareCategory(Task taskScheduled) {
		if (category.equals(Category.RED)
				&& (taskScheduled.category.equals(Category.BLUE) || taskScheduled.category.equals(Category.GREEN))) {
			return 1;
		} else if (taskScheduled.category.equals(Category.RED)
				&& (category.equals(Category.BLUE) || category.equals(Category.GREEN))) {
			return -1;
		} else if (category.equals(Category.BLUE) && taskScheduled.category.equals(Category.GREEN)) {
			return 1;
		} else if (taskScheduled.category.equals(Category.BLUE) && category.equals(Category.GREEN)) {
			return -1;
		} else if (this.category.equals(taskScheduled.category)) {
			return compareTimeStamp(taskScheduled);
		}

		return 0;
	}

	private int compareTimeStamp(Task task) {
		if (timeStamp.isBefore(task.timeStamp)) {
			return 1;
		} else {
			return -1;
		}
	}
}
