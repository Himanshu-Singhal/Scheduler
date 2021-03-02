package com.sandbox.scheduler.model;

import java.time.LocalDateTime;

public class Task {

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
	 * returns 1 if (this) has higher priority than the task in the parameter return
	 * -1 if task (the parameter) has higher priority than the task (this)
	 */

	public int compareTo(Task task) {
		if (urgency < task.urgency) {
			return 1;
		} else if (urgency > task.urgency) {
			return -1;
		} else if (urgency == task.urgency) {
			return compareCategory(task);
		}
		return 0;
	}

	private int compareCategory(Task task) {
		if (category.equals(Category.RED)
				&& (task.category.equals(Category.BLUE) || task.category.equals(Category.GREEN))) {
			return 1;
		} else if (task.category.equals(Category.RED)
				&& (category.equals(Category.BLUE) || category.equals(Category.GREEN))) {
			return -1;
		} else if (category.equals(Category.BLUE) && task.category.equals(Category.GREEN)) {
			return 1;
		} else if (task.category.equals(Category.BLUE) && category.equals(Category.GREEN)) {
			return -1;
		} else if (this.category.equals(task.category)) {
			return compareTimeStamp(task);
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
