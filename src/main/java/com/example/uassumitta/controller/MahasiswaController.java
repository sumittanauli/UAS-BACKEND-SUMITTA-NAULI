/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.uassumitta.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.uassumitta.model.Mahasiswa;
import com.example.uassumitta.service.MahasiswaService;
/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    private MahasiswaService mahasiswaService;

    @Autowired
    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    // http://localhost:8088/mahasiswa
    @GetMapping
    public List<Mahasiswa> getAll() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities()                );
        return mahasiswaService.getAll();
    }

    @GetMapping("/{id}")
    public Mahasiswa getById(@PathVariable Long id) {
        return mahasiswaService.getById(id);
    }

  // http://localhost:8088/region/1   (PathVariable) Detail
    @PostMapping
    public Mahasiswa create(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.create(mahasiswa);
    }

  // http://localhost:8088/country
    @PutMapping("/{id}")
    public Mahasiswa update(@PathVariable Long id, @RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.update(id, mahasiswa);
    }

  // http://localhost:8088/country/1
    @DeleteMapping("/{id}")
    public Mahasiswa delete(@PathVariable Long id) {
        return mahasiswaService.delete(id);
    }
}
