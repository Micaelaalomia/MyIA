package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    //Open ObservableList in App to avoid the location from resetting.

    static Scene scene;
    static ObservableList<Plant> plants = FXCollections.observableArrayList(); //ObservableList to keep all plants
    static ObservableList<PlantTemp> plantsTemp = FXCollections.observableArrayList(); //ObservableList to keep all plants
    static ObservableList<DayTime> days = FXCollections.observableArrayList(); //ObservableList to organize per day

    @Override
    public void start(Stage stage) throws IOException {
        loadPlants();
        loadDays();
        scene = new Scene(loadFXML("MainScreen"));
        stage.setScene(scene);
        stage.show();
    }

    private void loadDays() {
        //loads days from saved file
        //open and read JSON for any previously saved data
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try(Reader reader = new FileReader("diary.json")){
            //convert JSON file to Java object
            ArrayList<DayTime> imports = gson.fromJson(reader, new TypeToken<ArrayList<DayTime>>(){ //each item in JSON file will be considered to be a day
            }.getType());
            App.days = FXCollections.observableArrayList(imports); //temporary ArrayList

        }catch (IOException e){
            e.printStackTrace();
        }
        // https://mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
    }
    private void loadPlants() {
        //loads plants from saved file
        //open and read JSON for any previously saved data
        Gson gson = new GsonBuilder().create();
        try(Reader reader = new FileReader("plants.json")){
            //convert JSON file to Java object
            ArrayList<PlantTemp> imports = gson.fromJson(reader, new TypeToken<ArrayList<PlantTemp>>(){
                //each item in JSON file will be considered to be a plant
            }.getType());
            App.plantsTemp = FXCollections.observableArrayList(imports); //temporary ArrayList

        }catch (IOException e){
            e.printStackTrace();
        }
        // https://mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/


        for (PlantTemp p: plantsTemp) {
            plants.add(new Plant(p.getName(),p.getType(),p.getLocation(),p.getpX(),p.getpY(),p.color));
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


}