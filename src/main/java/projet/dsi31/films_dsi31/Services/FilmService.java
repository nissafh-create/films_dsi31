package projet.dsi31.films_dsi31.Services;

import projet.dsi31.films_dsi31.Models.Film;

import java.time.LocalDate;
import java.util.List;

public interface FilmService {

    Film saveFilm(Film f);

    Film updateFilm(Film f);

    void deleteFilm(Film f);

    void deleteFilmById(Long id);

    Film getFilm(Long id);


    // customs

    List<Film> getAllFilms();

    List<Film> findByFilmTitleContainingIgnoreCase(String filmTitle);

    List<Film> findByFilmReleaseDate(LocalDate filmReleaseDate);

    List<Film> findByTitleDuration(
            String title,
            Integer duration
    );

    List<Film> findByGenre(
            projet.dsi31.films_dsi31.Models.Genre genre
    );

    List<Film> findByGenre_GenreID(Long genreID);

    List<Film> findByOrderByFilmTitleAsc();

    List<Film> FilmByTitleAsc_DateDesc();
}

