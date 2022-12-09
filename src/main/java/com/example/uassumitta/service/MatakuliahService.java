/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.uassumitta.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.uassumitta.model.Matakuliah;
import com.example.uassumitta.repository.MatakuliahRepository;

@Service
public class MatakuliahService {

    private MatakuliahRepository matakuliahRepository;

    @Autowired
    public MatakuliahService(MatakuliahRepository matakuliahRepository) {
        this.matakuliahRepository = matakuliahRepository;
    }

    public List<Matakuliah> getAll() {
        return matakuliahRepository.findAll();
    }

    public Matakuliah getById(Long id) {
        return matakuliahRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matakuliah not found"));
    }

    public Matakuliah create(Matakuliah matakuliah) {
        if (matakuliah.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Matakuliah already exists");
        }
        if (matakuliahRepository.findByName(matakuliah.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Matakuliah name already exists");
        }
        return matakuliahRepository.save(matakuliah);
    }

    public Matakuliah update(Long id, Matakuliah matakuliah) {
        getById(id);
        matakuliah.setId(id);
        return matakuliahRepository.save(matakuliah);
    }

    public Matakuliah delete(Long id) {
        Matakuliah matakuliah = getById(id);
        matakuliahRepository.delete(matakuliah);
        return matakuliah;
    }

}
