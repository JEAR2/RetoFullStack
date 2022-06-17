package com.sofka.reto.retoFullStack.service;

import com.sofka.reto.retoFullStack.model.ListModel;
import com.sofka.reto.retoFullStack.model.TaskModel;
import com.sofka.reto.retoFullStack.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository iTaskRepository;

    public List<TaskModel> findAll() throws Exception {
        return iTaskRepository.findAll();
    }

    public TaskModel save(TaskModel taskModel) throws Exception {
        return iTaskRepository.save(taskModel);
    }

    public TaskModel update(TaskModel taskModel) throws Exception {
        return iTaskRepository.save(taskModel);
    }

    public Optional<TaskModel> finById(Long id) throws Exception {
        return iTaskRepository.findById(id);
    }

    public boolean deleteById(Long id) throws Exception {
        Optional<TaskModel> taskModel = iTaskRepository.findById(id);
        if(!taskModel.isEmpty()){
            iTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
