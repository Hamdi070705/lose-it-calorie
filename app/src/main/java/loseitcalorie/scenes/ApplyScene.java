package loseitcalorie.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import loseitcalorie.models.User;
import loseitcalorie.controllers.UserController;

public class ApplyScene {
    private Stage stage;

    public ApplyScene(Stage stage) {
        this.stage = stage;
    }

    public void showApplyScene(User user) {
        HomeScene homeScene = new HomeScene(stage);
        StartScene startScene = new StartScene(stage);

        Label label1 = new Label("LOSE IT");
        label1.getStyleClass().add("loseIt");

        Label label2 = new Label("CALORIE");
        label2.getStyleClass().add("calorie");

        Button change = new Button("CHANGE");
        change.getStyleClass().add("change");

        Label yourName = new Label("YOUR NAME");
        yourName.getStyleClass().add("nameGender");

        Label yourGender = new Label("YOUR GENDER");
        yourGender.getStyleClass().add("nameGender");

        Label name = new Label(user.getName().toUpperCase());
        name.getStyleClass().add("user");

        Label gender = new Label(user.getGender().toUpperCase());
        gender.getStyleClass().add("user");
        
        Button btnStart = new Button("START!");
        btnStart.getStyleClass().add("btnStart");


        VBox layout1 = new VBox();
        layout1.setSpacing(0);
        layout1.setPadding(new Insets(20, 0, 0, 0));
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.getChildren().addAll(label1, label2);

        VBox layoutStart = new VBox();
        layoutStart.setPadding(new Insets (20, 0, 0, 0));
        layoutStart.setAlignment(Pos.BOTTOM_CENTER);
        layoutStart.getChildren().addAll(btnStart);
        
        VBox layout2 = new VBox();
        layout2.setSpacing(10);
        layout2.setPadding(new Insets(5, 0, 0, 0));
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(yourName, name, yourGender, gender, change);
        
        
        VBox background = new VBox();
        background.getStyleClass().add("background");
        background.setSpacing(10);
        background.setPadding(new Insets(0, 0, 0, 0));
        background.setAlignment(Pos.CENTER);
        background.getChildren().addAll(layout2);

        change.setOnAction(e -> {
           UserController.deleteUser(user.getName());
           homeScene.showHomeScene();
        });

        btnStart.setOnAction(e -> {
            startScene.showStartScene(user);
        });
        
        VBox root = new VBox(layout1, background, layoutStart);
        root.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(root, 360, 640);
        scene.getStylesheets().add(getClass().getResource("/style/styleApply.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
