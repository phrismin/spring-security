package com.example.springsecurity.rest;

import com.example.springsecurity.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Developer> DEVELOPERS = new ArrayList<>(Arrays.asList(
            new Developer(1, "Ivan", "Ivanov"),
            new Developer(2, "Sergey", "Sergeev"),
            new Developer(3, "Petr", "Petrov")
    ));

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Integer id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("ASAAAAAAAAAAAAAA"));
    }

    @PostMapping("/create")
    public Developer create(@RequestBody Developer developer) {
        DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }
}
