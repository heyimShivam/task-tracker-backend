package com.backend.task_tracker.Service;

import com.backend.task_tracker.DTO.ResponseTasks;
import com.backend.task_tracker.DTO.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    public ResponseTasks getTasksDetails(UUID userID) {
        List<Task> taskList = new ArrayList<>();

        Task task1 = new Task("Learn Java", "Study records", false);
        taskList.add(task1);
        Task task2 = new Task("Learn Java", "Study records", false);
        taskList.add(task2);
        Task task3 = new Task("Learn Java", "Study records", false);
        taskList.add(task3);

        ResponseTasks responseTasks = new ResponseTasks(taskList);

        return responseTasks;
    }
}
