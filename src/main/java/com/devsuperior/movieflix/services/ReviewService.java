package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
	private ReviewRepository repository;

	@Autowired
	private AuthService authService;

	@Transactional
    public ReviewDTO insert(ReviewDTO dto) {
		User user = authService.authenticated();
		Movie movie = new Movie();
		Review review = new Review();

		movie.setId(dto.getMovieId());
		review.setUser(user);
		review.setMovie(movie);
		review.setText(dto.getText());

		return new ReviewDTO(repository.save(review));
    }
}
