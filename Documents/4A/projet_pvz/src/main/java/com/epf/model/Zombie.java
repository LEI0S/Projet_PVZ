package com.epf.model;

public class Zombie {

    private Long idZombie;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeDeplacement;
    private String cheminImage;
    private Long idMap;

    // Constructeur
    public Zombie(Long idZombie, String nom, Long idMap) {
        this.idZombie = idZombie;
        this.nom = nom;
        this.idMap = idMap;
    }

    // Constructeur par défaut
    public Zombie() {
    }

    // Getters et Setters

    public Long getIdZombie() {
        return idZombie;
    }

    public void setIdZombie(Long idZombie) {
        this.idZombie = idZombie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }

    public void setAttaqueParSeconde(double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }

    public int getDegatAttaque() {
        return degatAttaque;
    }

    public void setDegatAttaque(int degatAttaque) {
        this.degatAttaque = degatAttaque;
    }

    public double getVitesseDeDeplacement() {
        return vitesseDeDeplacement;
    }

    public void setVitesseDeDeplacement(double vitesseDeDeplacement) {
        this.vitesseDeDeplacement = vitesseDeDeplacement;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public Long getIdMap() {
        return idMap;
    }

    public void setIdMap(Long idMap) {
        this.idMap = idMap;
    }
}
