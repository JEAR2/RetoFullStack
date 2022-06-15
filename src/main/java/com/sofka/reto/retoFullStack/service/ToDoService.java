package com.sofka.reto.retoFullStack.service;

import com.sofka.reto.retoFullStack.model.ToDoModel;
import com.sofka.reto.retoFullStack.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService implements CrudService<ToDoModel,Long>{
    @Autowired
    private ToDoRepository toDoRepository;

    @Transactional(readOnly = true)
    public Optional<ToDoModel> findToDo(Long id){
        return toDoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ToDoModel> findAll() throws Exception {
        return toDoRepository.findAll();
    }

    @Override
    @Transactional
    public ToDoModel Save(ToDoModel toDoModel) throws Exception {
        return toDoRepository.save(toDoModel);
    }

    @Override
    @Transactional
    public ToDoModel update(ToDoModel toDoModel) throws Exception {
        return toDoRepository.save(toDoModel);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ToDoModel> finById(Long id) throws Exception {
        return toDoRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) throws Exception {
        Optional<ToDoModel> toDoModel = toDoRepository.findById(id);
        if(!toDoModel.isEmpty()){
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void deleteAll() throws Exception {
        toDoRepository.deleteAll();
    }
}
