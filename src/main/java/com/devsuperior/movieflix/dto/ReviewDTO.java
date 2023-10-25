package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;

    @NotBlank(message = "Required data")
    private String text;
    private Long movieId;
    private UserDTO user;

    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        movieId = entity.getMovie().getId();
        user = new UserDTO(entity.getUser());
    }
}
