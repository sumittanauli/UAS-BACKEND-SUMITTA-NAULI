package com.example.uassumitta.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.uassumitta.model.Mahasiswa;
import com.example.uassumitta.repository.MahasiswaRepository;

@Service
@AllArgsConstructor
public class MahasiswaService {

    private MahasiswaRepository mahasiswaRepository;

    public List<Mahasiswa> getAll() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getById(Long id) {
        return mahasiswaRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mahasiswa not found")
                );
    }

    public Mahasiswa create(Mahasiswa mahasiswa) {
        if (mahasiswa.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Mahasiswa already exists"
            );
        }
        if (mahasiswaRepository.existsByName(mahasiswa.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mahasiswa name already exists");
        }
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa update(Long id, Mahasiswa mahasiswa) {
        getById(id);
        mahasiswa.setId(id);
        return mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa delete(Long id) {
        Mahasiswa mahasiswa = getById(id);
        mahasiswaRepository.delete(mahasiswa);
        return mahasiswa;
    }
}
