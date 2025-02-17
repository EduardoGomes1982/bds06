package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Page<MovieDTO>> searcAllAsc(@RequestParam(name = "genreId", defaultValue = "0") Long genreId, Pageable pageable) {
        if (genreId == 0)
            return ResponseEntity.ok().body(service.searchAll(pageable));

        return ResponseEntity.ok().body(service.searchAllByGenre(genreId, pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> searchById(@PathVariable Long id) {
        MovieDTO dto = service.searchById(id);
        return ResponseEntity.ok().body(dto);
    }
}
