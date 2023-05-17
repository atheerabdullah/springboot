package com.example.homework.Controller;


import com.example.homework.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/")
public class taskController {

    // get

    public ArrayList<Task> tasks = new ArrayList<>();

    // get all tasks .
    @GetMapping("/get-all-tasks")
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    //post tasks
    @PostMapping("/creat-task")
    public ArrayList<Task> creatTask(@RequestBody Task task) {
        tasks.add(task);
        return tasks;
    }

    // update task
    @PutMapping("/update- task/{index}")
    public ArrayList<Task> updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return tasks;
    }

    //Delete a task
    @DeleteMapping("/delete- task/{index}")
    public ArrayList<Task> deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return tasks;
    }
    // search-by-title
    @GetMapping("/search-by-title/{title}")
    public ArrayList<Task> searchTasksByTitle(@PathVariable String title) {
        ArrayList<Task> matchingTitle = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                matchingTitle.add(task);
            }
        }
        return matchingTitle;
    }

    //Change the task status as done or not done

//    @PutMapping("/change- Status-Task/{index}")
//    public ArrayList<Task> changeStatus(@PathVariable int index, Task task) {
//        for (Task task : tasks) {
//            if (task.isStatus() == false) {
//                return tasks;
//            }
//        }
//
//    }

}
