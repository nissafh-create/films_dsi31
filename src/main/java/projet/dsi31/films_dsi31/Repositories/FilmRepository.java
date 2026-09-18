package projet.dsi31.films_dsi31.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.dsi31.films_dsi31.Models.Film;
import projet.dsi31.films_dsi31.Models.Genre;

import java.time.LocalDate;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByFilmTitleContainingIgnoreCase(String filmTitle); // ittaffi il upper case

    List<Film> findByFilmReleaseDate(LocalDate filmReleaseDate);

    /*
    @Query("select f from Film f where f.filmTitle like %?1% and f.filmDuration > ?2")
    List<Film> findByTitleDuration(String title, Integer duration);
    */

    @Query("select f from Film f where f.filmTitle like %:title% and f.filmDuration > :duration")
    List<Film> findByTitleDuration(
            @Param("title") String title,
            @Param("duration") Integer duration
    );

    @Query("select f from Film f where f.genre = :genre") // mafhimtich lweh aslan query here for there is no condition
    List<Film> findByGenre(@Param("genre") Genre genre);

    List<Film> findByGenre_GenreID(Long genreID); // il "_" so it's clearer

    List<Film> findByOrderByFilmTitleAsc();

    @Query("select f from Film f order by f.filmTitle ASC, f.filmReleaseDate DESC")
    List<Film> FilmByTitleAsc_DateDesc();

}