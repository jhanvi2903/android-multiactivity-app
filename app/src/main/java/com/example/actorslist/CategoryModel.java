package com.example.actorslist;

import java.io.Serializable;
import java.util.List;

public class CategoryModel implements Serializable {

    String sectionName, image, totalActors;
    List<ActorsModel> actors;
    List<ActorsModel> actorAge;
    List<ActorsModel> birthplace;
    List<ActorsModel> shortDescription;
    List<ActorsModel> moreDetails;

    public CategoryModel(String sectionName, String image, String totalActors, List<ActorsModel> actors, List<ActorsModel> actorAge, List<ActorsModel> birthplace,List<ActorsModel> shortDescription, List<ActorsModel> moreDetails) {
        this.sectionName = sectionName;
        this.image = image;
        this.totalActors = totalActors;
        this.actors = actors;
        this.actorAge = actorAge;
        this.birthplace = birthplace;
        this.shortDescription = shortDescription;
        this.moreDetails = moreDetails;
    }

    public List<ActorsModel> getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(List<ActorsModel> moreDetails) {
        this.moreDetails = moreDetails;
    }

    public List<ActorsModel> getActorAge() {
        return actorAge;
    }

    public void setActorAge(List<ActorsModel> actorAge) {
        this.actorAge = actorAge;
    }

    public List<ActorsModel> getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(List<ActorsModel> birthplace) {
        this.birthplace = birthplace;
    }

    public List<ActorsModel> getActors() {
        return actors;
    }

    public void setActors(List<ActorsModel> actors) {
        this.actors = actors;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getTotalActors() {
        return totalActors;
    }

    public void setTotalActors(String totalActors) {
        this.totalActors = totalActors;
    }

    public List<ActorsModel> getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(List<ActorsModel> shortDescription) {
        this.shortDescription = shortDescription;
    }
}
