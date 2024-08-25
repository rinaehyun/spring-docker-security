package org.example.backend.movie.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public record Movie(
        String id,
        String title,
        String genre
) {
}
