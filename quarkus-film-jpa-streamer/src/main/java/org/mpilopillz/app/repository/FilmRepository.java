package org.mpilopillz.app.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.mpilopillz.app.model.Film;
import org.mpilopillz.app.model.Film$;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class FilmRepository {
    @Inject
    JPAStreamer jpaStreamer;
    @Inject
    EntityManager entityManager;

    public Optional<Film> getFilm(int filmId) {
    return jpaStreamer.stream(Film.class)
            .filter(Film$.filmId.equal((Integer) filmId))
            .findFirst();
    }

    public List<Film> getAllFilms() {
        TypedQuery<Film> query = entityManager.createQuery("SELECT f FROM Film f", Film.class);
        return query.getResultList();
    }

//    public Optional<Film> getFilm(int filmId) {
//        try {
//            Film film = (Film) entityManager.createNativeQuery(
//                            "SELECT title FROM film WHERE film_id = :filmId", Film.class)
//                    .setParameter("filmId", filmId)
//                    .getSingleResult();
//            return Optional.of(film);
//        } catch (NoResultException e) {
//            return Optional.empty();
//        }
//    }
}
