package com.sofka.reto.retoFullStack.service;

import com.sofka.reto.retoFullStack.model.ListModel;
import com.sofka.reto.retoFullStack.repository.IListRrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {
    @Autowired
    private IListRrepository iListRrepository;

    public List<ListModel> findAll() throws Exception {

        return iListRrepository.findAll();
    }

    public ListModel save(ListModel listModel) throws Exception {
        return iListRrepository.save(listModel);
    }

    public ListModel update(ListModel listModel) throws Exception {
        return iListRrepository.save(listModel);

    }

    public Optional<ListModel> finById(Long id) throws Exception {
        return iListRrepository.findById(id);
    }

    public boolean deleteById(Long id) throws Exception {
        Optional<ListModel> toDoModel = iListRrepository.findById(id);
        if(!toDoModel.isEmpty()){
            iListRrepository.deleteById(id);
            return true;
        }
        return false;
    }
}
