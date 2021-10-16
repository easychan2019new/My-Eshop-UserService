package com.example.UserService.data.repository;

import com.example.UserService.data.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Integer> {
    List<State> findByCountryName(String name);
}
