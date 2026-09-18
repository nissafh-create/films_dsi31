package projet.dsi31.films_dsi31.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.dsi31.films_dsi31.Models.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findByGenreNameContainingIgnoreCase(String genreName);
}