package projet.dsi31.films_dsi31.Models;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "filmTitle", types = { Film.class })
public interface FilmProjection {
    public String getFilmTitle();
}
