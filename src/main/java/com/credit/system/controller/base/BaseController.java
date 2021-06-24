package com.credit.system.controller.base;

import com.credit.system.entity.BaseEntity;
import com.credit.system.service.base.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<ENTITY extends BaseEntity, SERVICE extends BaseService<ENTITY>> {

    private final SERVICE baseService;

    public BaseController(SERVICE service) {
        this.baseService = service;
    }

    @GetMapping("/findById/{id}")
    public ENTITY findById(@PathVariable Long id){
        return  baseService.findById(id);
    }

    @GetMapping("/findAll")
    public List<ENTITY> findAll(){
        return baseService.findAll();
    }

    @PostMapping("/save")
    public ENTITY save(@RequestBody ENTITY model){
        return baseService.create(model);
    }

    @PutMapping("/update/{id}")
    public ENTITY update(@RequestBody ENTITY model, @PathVariable Long id){
        model.setId(id);
        return baseService.update(model);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        baseService.deleteById(id);
    }
}
