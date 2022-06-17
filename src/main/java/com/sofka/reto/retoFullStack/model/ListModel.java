package com.sofka.reto.retoFullStack.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "list",cascade = CascadeType.ALL)
    private Set<TaskModel> task = new HashSet<>();

    public ListModel() {
    }

    public ListModel(Long id, String name, Set<TaskModel> toDoListModel) {
        this.id = id;
        this.name = name;
        this.task = toDoListModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TaskModel> getToDoListModel() {
        return task;
    }

    public void setToDoListModel(Set<TaskModel> task) {
        this.task = task;

    }
}
