package projet.dsi31.films_dsi31;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import projet.dsi31.films_dsi31.Models.Film;
import projet.dsi31.films_dsi31.Models.Genre;

@SpringBootApplication
public class FilmsDsi31Application implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(FilmsDsi31Application.class, args);
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Film.class, Genre.class);
    }
}
