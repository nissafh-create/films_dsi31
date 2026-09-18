package projet.dsi31.films_dsi31.Services;

import projet.dsi31.films_dsi31.Models.Genre;

import java.util.List;

public interface GenreService {

    Genre saveGenre(Genre g);

    Genre updateGenre(Genre g);

    void deleteGenre(Genre g);

    void deleteGenreById(Long id);

    Genre getGenre(Long id);

    List<Genre> getAllGenres();

    List<Genre> findByGenreNameContainingIgnoreCase(String genreName);

}

