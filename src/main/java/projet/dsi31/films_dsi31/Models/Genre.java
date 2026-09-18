package projet.dsi31.films_dsi31.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreID;

    private String genreName;
    private String genreDescription;

    @OneToMany(mappedBy = "genre")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Film> films;


    //constructor

    public Genre(List<Film> films,
                 String genreDescription,
                 String genreName) {
        this.films = films;
        this.genreDescription = genreDescription;
        this.genreName = genreName;
    }
}

