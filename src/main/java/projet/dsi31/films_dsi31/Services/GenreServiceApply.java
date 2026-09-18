package projet.dsi31.films_dsi31.Services;

import org.springframework.beans.factory.annotation.Autowired;
import projet.dsi31.films_dsi31.Models.Genre;
import projet.dsi31.films_dsi31.Repositories.GenreRepository;

import java.util.List;

public class GenreServiceApply implements GenreService {

    @Autowired
    private final GenreRepository genreRepository;

    public GenreServiceApply(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre saveGenre(Genre g) {
        return genreRepository.save(g);
    }

    @Override
    public Genre updateGenre(Genre g) {
        return genreRepository.save(g);
    }

    @Override
    public void deleteGenre(Genre g) {
        genreRepository.delete(g);
    }

    @Override
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.getReferenceById(id);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findByGenreNameContainingIgnoreCase(String genreName){
        return genreRepository.findByGenreNameContainingIgnoreCase(genreName);
    }
}

