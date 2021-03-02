package com.sandbox.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.sandbox.scheduler.model.Task;

public class Scheduler {

    static List<Task> scheduled = new ArrayList<>();

    public static void scheduleTask(Task taskToAdd) {
        if (scheduled.isEmpty()) {
            scheduled.add(taskToAdd);
            return;
        } else {
            for (int i = 0; i < scheduled.size(); i++) {

                if (taskToAdd.compareTo(scheduled.get(i)) == 1) {
                    scheduled.add(i, taskToAdd);
                    return;
                }
            }
            // if it has the lowest priority added it as the last element in the list
            scheduled.add(taskToAdd);
        }

    }

    public static void printSchedule() {
        for (Task task : scheduled) {
            System.out.println(task.toString());
        }
    }

}
