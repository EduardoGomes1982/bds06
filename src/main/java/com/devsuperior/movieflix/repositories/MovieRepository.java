package com.devsuperior.movieflix.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    @Query("select obj from Movie obj join fetch obj.genre where obj.id = :id")
    public Optional<Movie> searchMovieIdWithGenre(Long id);

    public Page<Movie> findAllByOrderByTitleAsc(Pageable pageable);
    
    public Page<Movie> findByGenreInOrderByTitleAsc(List<Genre> genres, Pageable pageable);
}
