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

    //@Autowired
    private final FilmService filmService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @GetMapping("/{idFilm}")
    public Film getFilmById(@PathVariable("idFilm") Long id) {
        return filmService.getFilm(id);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film f) {
        return filmService.saveFilm(f);
    }

    @PutMapping("/{id}") // better than putting the id in json
    public Film updateFilm(@PathVariable("id") Long id, @RequestBody Film f) {
        f.setFilmID(id);
        return filmService.updateFilm(f);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilmById(id);
    }

    @GetMapping("/filmsGenre/{idGenre}")
    public List<Film> getFilmByGenre(@PathVariable("idGenre") Long idGenre) {
        return filmService.findByGenreGenreID(idGenre);
    }

    @GetMapping("/filmsByName/{title}")
    public List<Film> findByFilmTitleContains(@PathVariable("title") String title) {
        return filmService.findByFilmTitleContainingIgnoreCase(title);
    }
}
