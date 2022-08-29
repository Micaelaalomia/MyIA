package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.apache.commons.io.FileUtils;

public class DiaryScreenController{

    public TableView dateTable;
    public TableColumn<DayTime, String> dateOptions = new TableColumn<>("Days");
    public VBox imageVBox;
    public TextArea notesTxt;
    Window stage;
    File file;

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }

    public void switchToScheduleScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("ScheduleScreen");
    }

    public void initialize(){

        dateOptions.setCellValueFactory(new PropertyValueFactory<>("dateString"));
        dateOptions.setPrefWidth(204);
        dateTable.getColumns().add(dateOptions); //adds first column into table


        dateTable.setItems(App.days);

        dateTable.setRowFactory(rowClick ->{ //when row is clicked, something happens
            TableRow<DayTime> row = new TableRow<>(); // a temporary row were information is saved into
            row.setOnMouseClicked(event ->{
                if(!row.isEmpty() && event.getButton()== MouseButton.PRIMARY && event.getClickCount() == 2){
                    DayTime clickedRow = row.getItem();
                    dateOptions.setText(String.valueOf(clickedRow.getDate()));
                    notesTxt.setText(clickedRow.getNotes());
                }
            });
            return row;
        });
    }



    public void selectImageBtn(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a file");
        File file = fileChooser.showOpenDialog(stage);
        File dest = new File("Photos\\"+"timeWithSeconds.jpg");
        try {
            FileUtils.copyFile(file, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(file != null){
            String img = null;
            try{
                img = file.toURI().toURL().toExternalForm();
            } catch (MalformedURLException ex){
                ex.printStackTrace();
            }

            Image image = new Image(img);
            ImageView imageHolder = new ImageView();
            imageHolder.setImage(image);
            imageHolder.setFitHeight(200);
            imageHolder.setPreserveRatio(true);
            imageVBox.getChildren().add(imageHolder);

        }
    }

    public void addDayBtn(ActionEvent actionEvent) {
        App.days.add(new DayTime(LocalDateTime.now(), notesTxt.getText()));       //adds new day
        System.out.println(App.days.get(0));

    }

    public void saveBtnAction(ActionEvent actionEvent) {
        //save notes in case changed
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        try (FileWriter writer = new FileWriter("diary.json")) {
            gson.toJson(App.days, writer);
            System.out.println("Saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}