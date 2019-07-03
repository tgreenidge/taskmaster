package com.tgreenidge.taskmaster.taskmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> rootMsg() {
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Task>> getTasks() {
        Iterable<Task> tasks = taskRepository.findAll();
        return new ResponseEntity(tasks, HttpStatus.OK);
    }

//    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
//    public @ResponseBody ResponseEntity<List<Task>> createTask() {
//        List<Task> tasks = taskRepository.findAll();
//        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/tasks/{id}/state", method = RequestMethod.PUT)
//    public @ResponseBody ResponseEntity<List<Task>> putTask() {
//        List<Task> tasks = taskRepository.findAll();
//        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
//    }
}
