package com.example.theheroproject_g2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;

public class Hero implements Serializable {

    private String id;
    private String name;
    private Map<String, String> powerstats;
    private Map<String, String> biography;
    private Map<String, Object> appearance;
    private Map<String, String> work;
    private Map<String, String> connections;
    private Map<String, String> image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getPowerstats() {
        return powerstats;
    }

    public Map<String, String> getBiography() {
        return biography;
    }

    public Map<String, Object> getAppearance() {
        return appearance;
    }

    public Map<String, String> getWork() {
        return work;
    }

    public Map<String, String> getConnections() {
        return connections;
    }

    public Map<String, String> getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerstats(Map<String, String> powerstats) {
        this.powerstats = powerstats;
    }

    public void setBiography(Map<String, String> biography) {
        this.biography = biography;
    }

    public void setAppearance(Map<String, Object> appearance) {
        this.appearance = appearance;
    }

    public void setWork(Map<String, String> work) {
        this.work = work;
    }

    public void setConnections(Map<String, String> connections) {
        this.connections = connections;
    }

    public void setImage(Map<String, String> image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Hereo" + name ;
    }
}