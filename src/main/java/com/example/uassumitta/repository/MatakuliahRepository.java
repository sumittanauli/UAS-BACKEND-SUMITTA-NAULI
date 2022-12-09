/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.uassumitta.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.uassumitta.model.Matakuliah;

@Repository
public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long>{
    Optional<Matakuliah> findByName(String name);
//Select * FROM user WHERE name="?1"   
}
