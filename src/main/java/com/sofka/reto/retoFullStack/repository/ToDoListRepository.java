package com.sofka.reto.retoFullStack.repository;

import com.sofka.reto.retoFullStack.model.ToDoListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListModel,Long> {
}
