package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {
    private Long id;
    private String name;

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
