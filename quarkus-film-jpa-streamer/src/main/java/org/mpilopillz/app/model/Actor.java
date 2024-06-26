package org.mpilopillz.app.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "actor", schema = "public")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    // Getters and Setters

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}


//@Entity
//@Table(name = "actor", schema = "public")
//public class Actor {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "actor_id")
//    private int actorId;
//    @Basic
//    @Column(name = "first_name")
//    private String firstName;
//    @Basic
//    @Column(name = "last_name")
//    private String lastName;
//    @Basic
//    @Column(name = "last_update")
//    private Timestamp lastUpdate;
//    @OneToMany(mappedBy = "actors")
//    private Set<Film> films = new HashSet<>();
//
//    public int getActorId() {
//        return actorId;
//    }
//
//    public void setActorId(int actorId) {
//        this.actorId = actorId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Timestamp getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(Timestamp lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Actor actor = (Actor) o;
//        return actorId == actor.actorId && Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName) && Objects.equals(lastUpdate, actor.lastUpdate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(actorId, firstName, lastName, lastUpdate);
//    }
//
//    public Set<Film> getFilms() {
//        return films;
//    }
//
//    public void setFilms(Set<Film> films) {
//        this.films = films;
//    }
//}
