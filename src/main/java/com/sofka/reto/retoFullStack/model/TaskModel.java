package com.sofka.reto.retoFullStack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean complete;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="list_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ListModel list;

    public TaskModel() {
    }

    public TaskModel(Long id, String description, boolean complete, ListModel list) {
        this.id = id;
        this.description = description;
        this.complete = complete;
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public ListModel getList() {
        return list;
    }

    public void setList(ListModel list) {
        this.list = list;
    }
}
