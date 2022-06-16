package com.sofka.reto.retoFullStack.controller;

import com.sofka.reto.retoFullStack.model.ToDoListModel;
import com.sofka.reto.retoFullStack.model.ToDoModel;
import com.sofka.reto.retoFullStack.service.ToDoListService;
import com.sofka.reto.retoFullStack.service.ToDoService;
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

    @Autowired
    private ToDoService toDoService;

    @GetMapping()
    public List<ToDoListModel> getTodosList() throws Exception{
        return this.toDoListService.findAll();
    }

    @PostMapping()
    public ToDoListModel saveTodoList(@RequestBody ToDoListModel todoList) throws Exception{
        Optional<ToDoModel> toDoModel = toDoService.finById(todoList.getTodo().getId());
        ToDoModel todo = new ToDoModel();
        todo.setId(toDoModel.get().getId());
        todo.setName(toDoModel.get().getName());
        todoList.setTodo(todo);
        return this.toDoListService.save(todoList);
    }

    @PutMapping(path = "/update/{id}")
    public ToDoListModel updateTodoList(@RequestBody ToDoListModel todoList,@PathVariable("id") Long id) throws Exception{
        return toDoListService.finById(id)
                .map(toDoListModel -> {
                    toDoListModel.setDescription(todoList.getDescription());
                    toDoListModel.setCompleted(todoList.isCompleted());
                    Optional<ToDoModel> toDoModel = null;
                    try {
                        toDoModel = toDoService.finById(todoList.getTodo().getId());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    ToDoModel todo = new ToDoModel();
                    todo.setId(toDoModel.get().getId());
                    todo.setName(toDoModel.get().getName());
                    toDoListModel.setTodo(todo);
                    try {
                        return toDoListService.save(toDoListModel);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseGet(() -> {
                    todoList.setId(id);
                    try {
                        return toDoListService.save(todoList);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
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
