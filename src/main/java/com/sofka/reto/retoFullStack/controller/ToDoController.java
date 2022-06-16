package com.sofka.reto.retoFullStack.controller;

import com.sofka.reto.retoFullStack.model.ToDoModel;
import com.sofka.reto.retoFullStack.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping()
    public List<ToDoModel> getTodos() throws Exception{
        return toDoService.findAll();
    }

    @PostMapping()
    public ToDoModel saveTodo(@RequestBody ToDoModel todo) throws Exception{
        return this.toDoService.save(todo);
    }

    @GetMapping(path = "/{id}")
    public Optional<ToDoModel> getTodoById(@PathVariable("id") Long id) throws Exception{
        return this.toDoService.finById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTodoById(@PathVariable("id") Long id) throws Exception{
        boolean isDelete = this.toDoService.deleteById(id);
        if (isDelete){
            return "Usuario Eliminado";
        }else {
            return "No se puedo eliminar el usuario";
        }
    }






}
