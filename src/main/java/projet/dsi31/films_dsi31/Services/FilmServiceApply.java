package projet.dsi31.films_dsi31.Services;

import org.springframework.beans.factory.annotation.Autowired;
import projet.dsi31.films_dsi31.Models.Film;
import projet.dsi31.films_dsi31.Models.Genre;
import projet.dsi31.films_dsi31.Repositories.FilmRepository;

import java.time.LocalDate;
import java.util.List;

public class FilmServiceApply implements FilmService{

    @Autowired
    private final FilmRepository filmRepository; // final bech needed to initialize and can't be updated

    public FilmServiceApply(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film saveFilm(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public Film updateFilm(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public void deleteFilm(Film f) {
        filmRepository.delete(f);
    }

    @Override
    public void deleteFilmById(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Film getFilm(Long id) {
        return filmRepository.getReferenceById(id);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public List<Film> findByFilmTitleContainingIgnoreCase(String filmTitle) {
        return filmRepository.findByFilmTitleContainingIgnoreCase(filmTitle);
    }

    @Override
    public List<Film> findByFilmReleaseDate(LocalDate filmReleaseDate) {
        return filmRepository.findByFilmReleaseDate(filmReleaseDate);
    }

    @Override
    public List<Film> findByTitleDuration(
            String title,
            Integer duration
    ) {
        return filmRepository.findByTitleDuration(
                title,
                duration
        );
    }

    @Override
    public List<Film> findByGenre(
            Genre genre
    ) {
        return filmRepository.findByGenre(genre);
    }

    @Override
    public List<Film> findByGenre_GenreID(Long genreID) {
        return filmRepository.findByGenre_GenreID(genreID);
    }

    @Override
    public List<Film> findByOrderByFilmTitleAsc() {
        return filmRepository.findByOrderByFilmTitleAsc();
    }

    @Override
    public List<Film> FilmByTitleAsc_DateDesc() {
        return filmRepository.FilmByTitleAsc_DateDesc();
    }
}

