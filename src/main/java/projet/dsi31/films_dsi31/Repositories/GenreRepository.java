package projet.dsi31.films_dsi31.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import projet.dsi31.films_dsi31.Models.Genre;

import java.util.List;

@RepositoryRestResource(path = "genre")
@CrossOrigin(origins = "http://localhost:4200/")
public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findByGenreNameContainingIgnoreCase(String genreName);
}
