package com.sofka.reto.retoFullStack.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "todolist")
public class ToDoListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "id_todo")
    private ToDoModel todo;

}
