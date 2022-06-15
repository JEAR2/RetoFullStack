package com.sofka.reto.retoFullStack.repository;

import com.sofka.reto.retoFullStack.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoModel,Long> {
}
