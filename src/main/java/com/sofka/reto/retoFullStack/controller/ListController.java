package com.sofka.reto.retoFullStack.controller;

import com.sofka.reto.retoFullStack.model.ListModel;
import com.sofka.reto.retoFullStack.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping()
    public List<ListModel> getList() throws Exception{
        return listService.findAll();
    }

    @PostMapping()
    public ListModel saveList(@RequestBody ListModel list) throws Exception{
        return this.listService.save(list);
    }

    @GetMapping(path = "/{id}")
    public Optional<ListModel> getListById(@PathVariable("id") Long id) throws Exception{
        return this.listService.finById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteListById(@PathVariable("id") Long id) throws Exception{
        boolean isDelete = this.listService.deleteById(id);
        if (isDelete){
            return "Lista Eliminada";
        }else {
            return "No se puedo eliminar la lista";
        }
    }

    @PutMapping(path = "/update/{id}")
    public ListModel updateList(@RequestBody ListModel listModel,@PathVariable("id") Long id) throws Exception{
       // return this.listService.update(listModel);
        return this.listService.finById(id)
                .map(listModelFlag -> {
                    listModelFlag.setName(listModel.getName());
                    try {
                        return listService.save(listModelFlag);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseGet(() -> {
                    listModel.setId(id);
                    try {
                        return listService.save(listModel);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

    }
}
