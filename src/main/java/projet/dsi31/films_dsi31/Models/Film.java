package projet.dsi31.films_dsi31.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate; // khir, modern and represents ../../....

@Data
@NoArgsConstructor
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmID;

    private String filmTitle;
    private String filmDescription;
    private LocalDate filmReleaseDate;
    private Integer filmDuration;

    @ManyToOne
    @JoinColumn(name = "genreID")
    @ToString.Exclude // 5ater reverse elationship donc to93ad dima fi loop
    @EqualsAndHashCode.Exclude
    private Genre genre;


    //constructor

    public Film(String filmTitle,
                String filmDescription,
                LocalDate filmReleaseDate,
                Integer filmDuration,
                Genre genre) {
        this.filmTitle = filmTitle;
        this.filmDescription = filmDescription;
        this.filmReleaseDate = filmReleaseDate;
        this.filmDuration = filmDuration;
        this.genre = genre;
    }
}

