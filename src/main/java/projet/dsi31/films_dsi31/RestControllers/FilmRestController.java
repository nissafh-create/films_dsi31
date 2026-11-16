package projet.dsi31.films_dsi31.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.dsi31.films_dsi31.Models.Film;
import projet.dsi31.films_dsi31.Services.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
public class FilmRestController {

    private final FilmService filmService;

    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Film getFilmById(@PathVariable("id") Long id) {
        return filmService.getFilm(id);
    }

    @RequestMapping(path = "/addfilm", method = RequestMethod.POST)
    public Film createFilm(@RequestBody Film f) {
        return filmService.saveFilm(f);
    }

    @RequestMapping(path = "/updatefilm", method = RequestMethod.PUT)
    public Film updateFilm(@RequestBody Film f) {
        return filmService.updateFilm(f);
    }

    @RequestMapping(value = "/delfilm/{id}", method = RequestMethod.DELETE)
    public void deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilmById(id);
    }

    @RequestMapping(value = "/filmsGenre/{idGenre}", method = RequestMethod.GET)
    public List<Film> getFilmByGenre(@PathVariable("idGenre") Long idGenre) {
        return filmService.findByGenreGenreID(idGenre);
    }

    @GetMapping("/filmsByName/{title}")
    public List<Film> findByFilmTitleContains(@PathVariable("title") String title) {
        return filmService.findByFilmTitleContainingIgnoreCase(title);
    }
}
