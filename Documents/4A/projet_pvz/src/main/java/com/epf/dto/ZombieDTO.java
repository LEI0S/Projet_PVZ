package com.epf.dto;

public class ZombieDTO {

    private Long idZombie;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeDeplacement;
    private String cheminImage;
    private Long idMap;

    // Constructeur
    public ZombieDTO(Long idZombie, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque,
                     double vitesseDeDeplacement, String cheminImage, Long idMap) {
        this.idZombie = idZombie;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.vitesseDeDeplacement = vitesseDeDeplacement;
        this.cheminImage = cheminImage;
        this.idMap = idMap;
    }

    // Constructeur par défaut
    public ZombieDTO() {}

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
