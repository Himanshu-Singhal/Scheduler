package com.sandbox.scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import com.sandbox.scheduler.model.Task;

public class Scheduler {

    static List<Task> scheduled = new ArrayList<>();

    static SortedMap<Task, Task> map = new TreeMap<>(new SortAscendingComparator());

    public static void scheduleTask(Task taskToAdd) {
        map.put(taskToAdd, taskToAdd);
    }

    public static void printSchedule() {
        for (Entry<Task, Task> entry : map.entrySet()) {
            Task task = entry.getKey();
            System.out.println(task.toString());
        }
    }
}

class SortAscendingComparator implements Comparator<Task> {
    @Override
    public int compare(Task taskAdded, Task taskScheduled) {
        return taskScheduled.compareTo(taskAdded);
    }
}
