package com.sofka.reto.retoFullStack.repository;

import com.sofka.reto.retoFullStack.model.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IListRrepository extends JpaRepository<ListModel,Long> {
}
