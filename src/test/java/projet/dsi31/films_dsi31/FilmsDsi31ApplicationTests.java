package projet.dsi31.films_dsi31;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import projet.dsi31.films_dsi31.Models.Film;
import projet.dsi31.films_dsi31.Models.Genre;
import projet.dsi31.films_dsi31.Repositories.FilmRepository;
import projet.dsi31.films_dsi31.Repositories.GenreRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class FilmsDsi31ApplicationTests {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testCreateFilm() {
        Genre genre = new Genre();
        genre.setGenreID(2L);

        Film film = new Film(
                "Inception",
                "A thief who steals corporate secrets through dream-sharing technology.",
                LocalDate.of(2010, 7, 16),
                148,
                genre
        );
        filmRepository.save(film);
    }

    @Test
    public void testFindFilm()
    {
        Film f = filmRepository.findById(1L).orElse(null); // 5ir min get for it handles the not existence case
        System.out.println("\n"+f+"\n");
    }

    @Test
    public void testUpdateFilm()
    {
        Film f = filmRepository.findById(1L).orElse(null);
        if (f != null) {
            f.setFilmDuration(160);
            filmRepository.save(f);
        }
    }

    @Test
    public void testDeleteFilm()
    {
        filmRepository.deleteById(1L);
    }

    @Test
    public void testFinAllFilms()
    {
        List<Film> films = filmRepository.findAll();

        for (Film film : films) {
            System.out.println("\n"+film+"\n");
        }
    }


    @Test
    public void testFindFilmByTitle()
    {
        List<Film> films = filmRepository.findByFilmTitleContainingIgnoreCase("incep");

        for (Film f : films)
            System.out.println(f);
    }

    @Test
    public void testFindByTitleDuration()
    {
        List<Film> films = filmRepository.findByTitleDuration(
                "dark",
                120
        );

        for (Film f : films)
        {
            System.out.println(f);
        }
    }

    @Test
    public void testFindFilmByGenre()
    {
        Genre genre = new Genre();
        genre.setGenreID(2L);

        List<Film> films = filmRepository.findByGenre(genre);

        for (Film f : films)
        {
            System.out.println(f);
        }
    }

    @Test
    public void findByGenreGenreID()
    {
        List<Film> films = filmRepository.findByGenre_GenreID(2L);

        for (Film f : films)
        {
            System.out.println(f);
        }
    }


    @Test
    public void testFindByOrderByFilmTitleAsc()
    {
        List<Film> films = filmRepository.findByOrderByFilmTitleAsc();

        for (Film f : films)
        {
            System.out.println(f);
        }
    }

    @Test
    public void testFilmByTitleAsc_DateDesc()
    {
        List<Film> films = filmRepository.FilmByTitleAsc_DateDesc();

        for (Film f : films)
        {
            System.out.println(f);
        }
    }



    // genre section

    @Test
    public void testCreateGenre() {
        Genre genre = new Genre(
                null,
                "A genre based on imaginative concepts such as futuristic technology and space.",
                "Science Fiction"
        );
        genreRepository.save(genre);
    }


    @Test
    public void testFindGenre() {
        Genre g = genreRepository.findById(1L).orElse(null);
        System.out.println("\n" + g + "\n");
    }

    @Test
    public void testUpdateGenre() {
        Genre g = genreRepository.findById(1L).orElse(null);
        if (g != null) {
            g.setGenreDescription("A genre involving futuristic technology, space and imaginary concepts.");
            genreRepository.save(g);
        }
    }

    @Test
    public void testDeleteGenre() {
        genreRepository.deleteById(1L);
    }

    @Test
    public void testFinAllGenres() {
        List<Genre> genres = genreRepository.findAll();

        for (Genre genre : genres) {
            System.out.println("\n" + genre + "\n");
        }
    }

    @Test
    public void testFindGenreByName()
    {
        List<Genre> genres = genreRepository.findByGenreNameContainingIgnoreCase("act");

        for (Genre g : genres)
            System.out.println(g);
    }


}
