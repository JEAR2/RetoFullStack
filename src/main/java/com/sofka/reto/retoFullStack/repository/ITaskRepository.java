package com.sofka.reto.retoFullStack.repository;

import com.sofka.reto.retoFullStack.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<TaskModel,Long> {
}
