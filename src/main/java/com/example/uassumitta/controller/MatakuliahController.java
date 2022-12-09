/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.uassumitta.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.uassumitta.model.Matakuliah;
import com.example.uassumitta.service.MatakuliahService;


@RestController
@RequestMapping("/matakuliah")
public class MatakuliahController {

    private MatakuliahService matakuliahService;

    @Autowired
    public MatakuliahController(MatakuliahService matakuliahService) {
        this.matakuliahService = matakuliahService;
    }

    // http://localhost:8088/matakuliah
    @GetMapping
    public List<Matakuliah> getAll() {
        return matakuliahService.getAll();
    }

    @GetMapping("/{id}")
    public Matakuliah getById(@PathVariable Long id) {
        return matakuliahService.getById(id);
    }
    // http://localhost:8088/matakuliah/1   (PathVariable) Detail

    @PostMapping
    public Matakuliah create(@RequestBody Matakuliah matakuliah) {
        return matakuliahService.create(matakuliah);
    }
    // http://localhost:8088/matakuliah 

    @PutMapping("/{id}")
    public Matakuliah update(@PathVariable Long id, @RequestBody Matakuliah matakuliah) {
        return matakuliahService.update(id, matakuliah);
    }
    // http://localhost:8088/matakuliah/1

    @DeleteMapping("/{id}")
    public Matakuliah delete(@PathVariable Long id) {
        return matakuliahService.delete(id);
    }
    // http://localhost:8088/matakuliah/1

}
