package com.sofka.reto.retoFullStack.service;

import com.sofka.reto.retoFullStack.model.ToDoListModel;
import com.sofka.reto.retoFullStack.model.ToDoModel;
import com.sofka.reto.retoFullStack.repository.ToDoListRepository;
import com.sofka.reto.retoFullStack.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService implements CrudService<ToDoListModel,Long>{
    @Autowired
    private ToDoListRepository toDoListRepository;

    @Autowired
    private ToDoRepository toDoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ToDoListModel> findAll() throws Exception {
        return toDoListRepository.findAll();
    }

    @Transactional
    @Override
    public ToDoListModel save(ToDoListModel toDoListModel) throws Exception {
        return toDoListRepository.save(toDoListModel);
    }

    @Transactional
    @Override
    public ToDoListModel update(ToDoListModel toDoListModel) throws Exception {
        return toDoListRepository.save(toDoListModel);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ToDoListModel> finById(Long id) throws Exception {
        return toDoListRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) throws Exception {
        Optional<ToDoListModel> toDoListModel = toDoListRepository.findById(id);
        if(!toDoListModel.isEmpty()){
            toDoListRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void deleteAll() throws Exception {
        toDoListRepository.deleteAll();
    }

    public List<ToDoListModel> finByIdTodo(Long id) throws Exception {
        Optional<ToDoModel> toDoModel = toDoRepository.findById(id);
        List<ToDoListModel> toDoListModels = new ArrayList<>();
        for (ToDoListModel element: findAll() ) {
            if(element.getTodo().getId().equals(toDoModel.get().getId())){
                toDoListModels.add(element);
            }
        }
        return toDoListModels;
    }

}
