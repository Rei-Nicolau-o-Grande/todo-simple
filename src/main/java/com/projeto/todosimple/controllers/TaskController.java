package com.projeto.todosimple.controllers;

import com.projeto.todosimple.models.Task;
import com.projeto.todosimple.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = this.taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Task>> findAllByUserId(@PathVariable Long user_id) {
        List<Task> tasks_user = this.taskService.findAllByUserId(user_id);
        return ResponseEntity.ok(tasks_user);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Task> create(@Valid @RequestBody Task task) {
        task = this.taskService.create(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@Valid @RequestBody Task task, @PathVariable Long id) {
        task.setId(id);
        this.taskService.update(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
