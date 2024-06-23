package org.mpilopillz.app.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.mpilopillz.app.model.Film;
import org.mpilopillz.app.repository.FilmRepository;

import java.util.List;
import java.util.Optional;

@Path("/")
public class FilmResource {

    @Inject
    private FilmRepository filmRepository;
    @GET
    @Path("/sanityTest")
    @Produces(MediaType.TEXT_PLAIN)
    public String sanityTest() {
        return "The app is running!";
    }

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilm(@PathParam("filmId") int filmId) {
        Optional<Film> film = filmRepository.getFilm(filmId);
        return film.isPresent() ? film.get().getTitle() : "Film not found";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getAllFilms() {
        return filmRepository.getAllFilms();
    }

}
