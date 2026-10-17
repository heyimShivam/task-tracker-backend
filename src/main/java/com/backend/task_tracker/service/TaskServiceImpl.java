package com.backend.task_tracker.service;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {
    private final Map<UUID, List<Task>> tempStorage = new HashMap<>();

    public ResponseTasks getTasksDetails(UUID userID) {
        List<Task> taskList = getTasksForUUID(userID);

        ResponseTasks responseTasks = new ResponseTasks(taskList);

        return responseTasks;
    }

    public ResponseTasks addTasks(UUID userID, Task taskDeails) {
        List<Task> taskList = getTasksForUUID(userID);

        taskList.add(taskDeails);

        ResponseTasks responseTasks = new ResponseTasks(taskList);

        return responseTasks;
    }

    private List<Task> getTasksForUUID(UUID userID) {
        if(!tempStorage.containsKey(userID)) {
            tempStorage.put(userID, new ArrayList<>());
        }

        return tempStorage.get(userID);
    }
}
