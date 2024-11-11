package com.example.actorslist;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXML implements Serializable {
    private CategoryModel[] data;
    Context context;

    public ReadXML(Context context){
        this.context = context;

        InputStream stream = null;
        DocumentBuilder builder = null;
        Document document = null;
        Log.d("DEBUG", "in XML parsing");
        try {
            stream = this.context.getResources().openRawResource(R.raw.actors);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(stream);
        } catch (Exception e) {
            Log.e("TEST", e.toString());
        }
        Log.d("Debug", "Docment is made");
        NodeList nameList = document.getElementsByTagName("name");
        NodeList imageList = document.getElementsByTagName("image");
        NodeList totalList = document.getElementsByTagName("total_actors");

        NodeList sectionList = document.getElementsByTagName("section");
        Log.d("DEBUG", "Slicing done");
        data = new CategoryModel[sectionList.getLength()];

        for (int i=0;i<nameList.getLength();i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String totalActors = totalList.item(i).getFirstChild().getNodeValue();
            List<ActorsModel> actorsList = new ArrayList<>();
            List<ActorsModel> shortDescriptionList = new ArrayList<>();
            List<ActorsModel> ageList = new ArrayList<>();
            List<ActorsModel> birthplaceList = new ArrayList<>();
            List<ActorsModel> moreDetailsList = new ArrayList<>();
            Node section = sectionList.item(i);
            Element sectionElement = (Element) section;
            NodeList actorsLists = sectionElement.getElementsByTagName("actress");
            for (int j=0;j<actorsLists.getLength();j++) {

                Node companyNode = actorsLists.item(j);
                if (companyNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element companyElement = (Element) companyNode;
                    String actorName = companyElement.getElementsByTagName("Actorname").item(0).getTextContent();
                    String industryLogo = companyElement.getElementsByTagName("industry_logo").item(0).getTextContent();
                    String age = companyElement.getElementsByTagName("age").item(0).getTextContent();
                    String birthplace = companyElement.getElementsByTagName("birthplace").item(0).getTextContent();
                    String shortDescription = companyElement.getElementsByTagName("shortDescription").item(0).getTextContent();
                    String details = companyElement.getElementsByTagName("details").item(0).getTextContent();
                    String webLink = companyElement.getElementsByTagName("webURL").item(0).getTextContent();
                    Log.d("Actor Details", "Name: " + actorName);
                    ActorsModel cm = new ActorsModel(actorName, industryLogo, age, birthplace,shortDescription, details,totalActors,  webLink);

                    actorsList.add(cm);
                    ageList.add(cm);
                    birthplaceList.add(cm);
                    shortDescriptionList.add(cm);
                    moreDetailsList.add(cm);
                }
            }
            data[i] = new CategoryModel(name, image, totalActors, actorsList, ageList,birthplaceList, shortDescriptionList, moreDetailsList);

        }
    }

    public int getCount(){return data.length;}



    public CategoryModel getCategoryModel(int i){return data[i];}

    public String [] getCategoryNames(){
        String [] names = new String[getCount()];
        for(int i=0;i<getCount();i++)
            names[i] = data[i].getSectionName();
        return names;
    }

    public String [] getActorsNames(int position){

        List<ActorsModel> cm = data[position].getActors();
        String actorsNames[] = new String[cm.size()];
        int i=0;
        for (ActorsModel c : cm) {
            actorsNames[i++] = c.getActorName();
        }
        return actorsNames;
    }

    public String[] getActorAge(int position){

        List<ActorsModel> cm = data[position].getActorAge();
        String actorAge[] = new String[cm.size()];
        int i=0;
        for (ActorsModel c : cm) {
            actorAge[i++] = c.getAge();
        }
        return actorAge;
    }

    public String[] getActorBirthplace(int position){

        List<ActorsModel> cm = data[position].getBirthplace();
        String actorBirthplace[] = new String[cm.size()];
        int i=0;
        for (ActorsModel c : cm) {
            actorBirthplace[i++] = c.getBirthplace();
        }
        return actorBirthplace;
    }

    public String [] getShortDescription(int position){

        List<ActorsModel> cm = data[position].getShortDescription();
        String shortDescription[] = new String[cm.size()];
        int i=0;
        for (ActorsModel c : cm) {
            shortDescription[i++] = c.getShortDescription();
        }
        return shortDescription;
    }

    public String [] getMoreDetails(int position) {

        List<ActorsModel> cm = data[position].getMoreDetails();
        String moreDetails[] = new String[cm.size()];
        int i = 0;
        for (ActorsModel c : cm) {
            moreDetails[i++] = c.getDetails();
        }
        return moreDetails;
    }


    public int [] getactorsLogo(int position){
        List<ActorsModel> cm = data[position].getActors();
        int actorsLogos[] = new int[cm.size()];
        int i=0;
        for (ActorsModel c : cm) {
            String imageName = c.getActorImage();
            imageName = imageName.substring(0,imageName.indexOf("."));
            actorsLogos[i++] = context.getResources().getIdentifier(imageName,
                    "drawable", context.getPackageName());
        }
        return actorsLogos;
    }


    public ActorsModel getActorsData (int sectionPosition, int companyPosition) {
        return data[sectionPosition].getActors().get(companyPosition);
    }

    public String [] getTotalActorsCount(){
        String [] getTotalActors = new String[getCount()];
        for(int i=0;i<getCount();i++)
            getTotalActors[i] = data[i].getTotalActors();
        return getTotalActors;
    }

    public int [] getImageIds(){
        int [] imageIds = new int[getCount()];
        for(int i=0;i<getCount();i++){
            String imageName = data[i].getImage();
            imageName = imageName.substring(0,imageName.indexOf("."));
            imageIds[i] = context.getResources().getIdentifier(imageName,
                    "drawable", context.getPackageName());
        }
        return imageIds;
    }
}
