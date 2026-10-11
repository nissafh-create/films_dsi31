package projet.dsi31.films_dsi31.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.dsi31.films_dsi31.Models.Genre;
import projet.dsi31.films_dsi31.Services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@CrossOrigin
@AllArgsConstructor
public class GenreRestController {

    private final GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{idGenre}")
    public Genre getGenreById(@PathVariable("idGenre") Long id) {
        return genreService.getGenre(id);
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre g) {
        return genreService.saveGenre(g);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable("id") Long id, @RequestBody Genre g) {
        g.setGenreID(id);
        return genreService.updateGenre(g);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") Long id) {
        genreService.deleteGenreById(id);
    }
}
