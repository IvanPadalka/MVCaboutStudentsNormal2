import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.List;

public class JavaFXView extends Application {

    public  ObservableList names =
            FXCollections.observableArrayList();
    public  ObservableList data =
            FXCollections.observableArrayList();

    List<EmployerModel> temp=Controller.getList();


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employers List View");
        HBox root = new HBox();
        //
        ComboBox<String> comboBox=new ComboBox();
        comboBox.getItems().addAll("Show All Employers","Show First Five Employers","Show Last Three Employers");
        root.getChildren().addAll(comboBox);
        //
        root.setPadding(new Insets(0, 20, 10, 20));
        root.setMinSize(400,400);
        root.setMaxSize(400,400);
        root.setAlignment(Pos.TOP_CENTER);
        ///
        Button button1=new Button("Show All Employers");
        Button button2=new Button("Show First Five Employers");
        Button button3=new Button("Show Last Three Employers");
        //
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        button1.setPrefSize(100,20);
        //
        Region region2 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        button2.setPrefSize(100,20);
        //
        Region region3 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        button3.setPrefSize(100,20);
        //root.getChildren().addAll(button1,region1,button2,region2,button3,region3);
        //
        ListView listView = new ListView(data);
        ListView listView1 = new ListView(data);
        ListView listView2 = new ListView(data);
        comboBox.setOnAction(event -> { switch (comboBox.getValue().toString()){
            case "Show All Employers":
                data.clear();
                root.getChildren().remove(listView2);
                root.getChildren().remove(listView1);
                listView.setPrefSize(200, 250);
                listView.setEditable(true);

                for (int i = 0; i < Controller.getList().size(); i++) {
                    data.add(temp.get(i));
                }
                listView.setItems(data);
                listView.setCellFactory(ComboBoxListCell.forListView(names));
                root.getChildren().add(listView);
                break;
            case "Show First Five Employers":
                data.clear();
                root.getChildren().remove(listView);
                root.getChildren().remove(listView2);
                listView1.getItems().removeAll();
                listView1.setPrefSize(200, 250);
                listView1.setEditable(true);

                for (int i = 0; i < Controller.getList().size(); i++) {
                    data.add(temp.get(i));
                    if (i == 4) {
                        break;
                    }
                }
                listView1.setItems(data);
                listView1.setCellFactory(ComboBoxListCell.forListView(names));
                root.getChildren().add(listView1);
                break;
            case "Show Last Three Employers":
                data.clear();
                root.getChildren().remove(listView1);
                root.getChildren().remove(listView);
                listView2.getItems().removeAll();
                listView2.setPrefSize(200, 250);
                listView2.setEditable(true);

                for (int i = temp.size()-3; i < temp.size(); i++) {
                    data.add(temp.get(i));
                }
                listView2.setItems(data);
                listView2.setCellFactory(ComboBoxListCell.forListView(names));
                root.getChildren().add(listView2);
        } });
        ////
        //
        //
        button1.setOnAction(e -> {
            data.clear();
            root.getChildren().remove(listView2);
            root.getChildren().remove(listView1);
            listView.setPrefSize(200, 250);
            listView.setEditable(true);

            for (int i = 0; i < Controller.getList().size(); i++) {
                data.add(temp.get(i));
            }
            listView.setItems(data);
            listView.setCellFactory(ComboBoxListCell.forListView(names));
            root.getChildren().add(listView);
        });
        button2.setOnAction(e -> {
            data.clear();
            root.getChildren().remove(listView);
            root.getChildren().remove(listView2);
            listView1.getItems().removeAll();
            listView1.setPrefSize(200, 250);
            listView1.setEditable(true);

            for (int i = 0; i < Controller.getList().size(); i++) {
                data.add(temp.get(i));
                if (i == 5) {
                    break;
                }
            }
            listView1.setItems(data);
            listView1.setCellFactory(ComboBoxListCell.forListView(names));
            root.getChildren().add(listView1);

        });
        button3.setOnAction(e -> {
            data.clear();
            root.getChildren().remove(listView1);
            root.getChildren().remove(listView);
            listView2.getItems().removeAll();
            listView2.setPrefSize(200, 250);
            listView2.setEditable(true);

            for (int i = temp.size()-3; i < temp.size(); i++) {
                data.add(temp.get(i));
            }
            listView2.setItems(data);
            listView2.setCellFactory(ComboBoxListCell.forListView(names));
            root.getChildren().add(listView2);

        });
        Scene scene =new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        //

    }
}