package com.sofka.reto.retoFullStack.controller;

import com.sofka.reto.retoFullStack.model.ListModel;
import com.sofka.reto.retoFullStack.model.TaskModel;
import com.sofka.reto.retoFullStack.service.ListService;
import com.sofka.reto.retoFullStack.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public List<TaskModel> getList() throws Exception{
        return taskService.findAll();
    }

    @PostMapping()
    public TaskModel saveList(@RequestBody TaskModel task) throws Exception{
        return this.taskService.save(task);
    }

    @GetMapping(path = "/{id}")
    public Optional<TaskModel> getTaskById(@PathVariable("id") Long id) throws Exception{
        return this.taskService.finById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTaskById(@PathVariable("id") Long id) throws Exception{
        boolean isDelete = this.taskService.deleteById(id);
        if (isDelete){
            return "Tarea Eliminada";
        }else {
            return "No se puedo eliminar la Tarea";
        }
    }

    @PutMapping(path = "/update/{id}")
    public TaskModel updateTask(@RequestBody TaskModel taskModel,@PathVariable("id") Long id) throws Exception{
        return this.taskService.finById(id)
                .map(taskModelFlag -> {
                    taskModelFlag.setDescription(taskModel.getDescription());
                    taskModelFlag.setComplete(taskModel.isComplete());
                    try {
                        return taskService.save(taskModelFlag);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseGet(() -> {
                    taskModel.setId(id);
                    try {
                        return taskService.save(taskModel);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

    }
}
