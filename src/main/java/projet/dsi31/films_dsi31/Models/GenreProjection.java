package projet.dsi31.films_dsi31.Models;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "genreName", types = { Genre.class })
public interface GenreProjection {
    public String getGenreName();
}
