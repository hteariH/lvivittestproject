package com.mamoru;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 6/26/2017.
 */
public interface ContactRepository extends CrudRepository<ContactDTO, Long> {

    public List<ContactDTO> findAllByName(String name);
}
