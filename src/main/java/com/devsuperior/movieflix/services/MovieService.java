package com.devsuperior.movieflix.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
    @Autowired
	private MovieRepository repository;

	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	public MovieDTO searchById(Long id) {
		Optional<Movie> item = repository.searchMovieIdWithGenre(id);
		if (!item.isPresent()) throw new ResourceNotFoundException("User does not exist");
		return new MovieDTO(item.get());
	}

	@Transactional(readOnly = true)
	public Page<MovieDTO> searchAll(Pageable pageable) {
		genreRepository.findAll();
		Page<Movie> page = repository.findAllByOrderByTitleAsc(pageable);
		return page.map(e -> new MovieDTO(e));
	}

	@Transactional(readOnly = true)
	public Page<MovieDTO> searchAllByGenre(Long genreId, Pageable pageable) {
		Optional<Genre> genre = genreRepository.findById(genreId);
		if (!genre.isPresent()) throw new ResourceNotFoundException("No content");
		Page<Movie> page = repository.findByGenreInOrderByTitleAsc(Arrays.asList(genre.stream().toArray(Genre[]::new)), pageable);
		return page.map(e -> new MovieDTO(e));
	}
}
