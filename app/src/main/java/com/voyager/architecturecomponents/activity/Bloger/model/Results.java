package com.voyager.architecturecomponents.activity.Bloger.model;

import java.util.List;

public class Results {


    /**
     * title : A New Hope
     * episode_id : 4
     * opening_crawl : It is a period of civil war.
     Rebel spaceships, striking
     from a hidden base, have won
     their first victory against
     the evil Galactic Empire.

     During the battle, Rebel
     spies managed to steal secret
     plans to the Empire's
     ultimate weapon, the DEATH
     STAR, an armored space
     station with enough power
     to destroy an entire planet.

     Pursued by the Empire's
     sinister agents, Princess
     Leia races home aboard her
     starship, custodian of the
     stolen plans that can save her
     people and restore
     freedom to the galaxy....
     * director : George Lucas
     * producer : Gary Kurtz, Rick McCallum
     * release_date : 1977-05-25
     * characters : ["https://swapi.co/api/people/1/","https://swapi.co/api/people/2/","https://swapi.co/api/people/3/","https://swapi.co/api/people/4/","https://swapi.co/api/people/5/","https://swapi.co/api/people/6/","https://swapi.co/api/people/7/","https://swapi.co/api/people/8/","https://swapi.co/api/people/9/","https://swapi.co/api/people/10/","https://swapi.co/api/people/12/","https://swapi.co/api/people/13/","https://swapi.co/api/people/14/","https://swapi.co/api/people/15/","https://swapi.co/api/people/16/","https://swapi.co/api/people/18/","https://swapi.co/api/people/19/","https://swapi.co/api/people/81/"]
     * planets : ["https://swapi.co/api/planets/2/","https://swapi.co/api/planets/3/","https://swapi.co/api/planets/1/"]
     * starships : ["https://swapi.co/api/starships/2/","https://swapi.co/api/starships/3/","https://swapi.co/api/starships/5/","https://swapi.co/api/starships/9/","https://swapi.co/api/starships/10/","https://swapi.co/api/starships/11/","https://swapi.co/api/starships/12/","https://swapi.co/api/starships/13/"]
     * vehicles : ["https://swapi.co/api/vehicles/4/","https://swapi.co/api/vehicles/6/","https://swapi.co/api/vehicles/7/","https://swapi.co/api/vehicles/8/"]
     * species : ["https://swapi.co/api/species/5/","https://swapi.co/api/species/3/","https://swapi.co/api/species/2/","https://swapi.co/api/species/1/","https://swapi.co/api/species/4/"]
     * created : 2014-12-10T14:23:31.880000Z
     * edited : 2015-04-11T09:46:52.774897Z
     * url : https://swapi.co/api/films/1/
     */

    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private String created;
    private String edited;
    private String url;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }
}
