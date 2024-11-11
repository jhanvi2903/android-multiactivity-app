package com.example.actorslist;

import java.io.Serializable;

public class ActorsModel implements Serializable {

    String  actorName, actorImage, age, birthplace, moreDetails, totalActors,  webLink, shortDescription;

    public ActorsModel(String actorName, String actorImage, String age, String birthplace, String shortDescription,String details, String totalActors, String webLink) {
        this.actorName = actorName;
        this.actorImage = actorImage;
        this.age = age;
        this.birthplace = birthplace;
        this.shortDescription = shortDescription;
        this.moreDetails = details;
        this.totalActors = totalActors;
        this.webLink = webLink;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getActorImage() {
        return actorImage;
    }

    public void setActorImage(String actorImage) {
        this.actorImage = actorImage;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return moreDetails;
    }

    public void setDetails(String details) {
        this.moreDetails = details;
    }

    public String getTotalActors() {
        return totalActors;
    }

    public void setTotalActors(String totalActors) {
        this.totalActors = totalActors;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }
}
