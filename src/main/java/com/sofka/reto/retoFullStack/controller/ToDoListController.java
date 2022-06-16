package com.sofka.reto.retoFullStack.controller;

import com.sofka.reto.retoFullStack.model.ToDoListModel;
import com.sofka.reto.retoFullStack.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/todoList")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping()
    public List<ToDoListModel> getTodosList() throws Exception{
        return this.toDoListService.findAll();
    }

    @PostMapping()
    public ToDoListModel saveTodoList(@RequestBody ToDoListModel todoList) throws Exception{
        return this.toDoListService.save(todoList);
    }

    @GetMapping(path = "/{id}")
    public Optional<ToDoListModel> getTodoListById(@PathVariable("id") Long id) throws Exception{
        return this.toDoListService.finById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTodoListById(@PathVariable("id") Long id) throws Exception{
        boolean isDelete = this.toDoListService.deleteById(id);
        if (isDelete){
            return "Usuario Eliminado";
        }else {
            return "No se puedo eliminar el usuario";
        }
    }

    @GetMapping(path = "/todo/{id}")
    public List<ToDoListModel> getTodoListByIdTodo(@PathVariable("id") Long id) throws Exception{
        return this.toDoListService.finByIdTodo(id);
    }
}
