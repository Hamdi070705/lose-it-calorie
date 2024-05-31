package loseitcalorie.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import loseitcalorie.models.User;

public class StartScene {
    private Stage stage;

    public StartScene(Stage stage) {
        this.stage = stage;
    }

    public void showStartScene(User user) {
        ApplyScene applyScene = new ApplyScene(stage);
        ActivityScene activityScene = new ActivityScene(stage);

        Label label1 = new Label("LOSE IT");
        label1.getStyleClass().add("loseIt");

        Label label2 = new Label("CALORIE");
        label2.getStyleClass().add("calorie");

        Label yourName = new Label("YOUR NAME");
        yourName.getStyleClass().add("your");
        Label Labelname = new Label(user.getName().toUpperCase());
        Labelname.getStyleClass().add("user");

        Label yourGender = new Label("YOUR GENDER");
        yourGender.getStyleClass().add("your");
        Label Labelgender = new Label(user.getGender().toUpperCase());
        Labelgender.getStyleClass().add("user");

        Label yourWeight = new Label("YOUR WEIGHT");
        yourWeight.getStyleClass().add("your");

        TextField inputWeight = new TextField();
        inputWeight.setPromptText("input your weight here: ...kg");
        inputWeight.getStyleClass().add("textfield");
        
        Label yourAge = new Label("YOUR AGE");
        yourAge.getStyleClass().add("your");

        TextField inputAge = new TextField();
        inputAge.setPromptText("input your Age here");
        inputAge.getStyleClass().add("textfield");

        Label status = new Label();
        status.getStyleClass().add("status");

        Button btnBack = new Button("BACK");
        btnBack.getStyleClass().add("btnBackNext");

        Button btnNext = new Button("NEXT");
        btnNext.getStyleClass().add("btnBackNext");


        VBox layout1 = new VBox();
        layout1.setSpacing(0);
        layout1.setPadding(new Insets(20, 0, 0, 0));
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.getChildren().addAll(label1, label2);

        VBox layout2 = new VBox();
        layout2.setSpacing(10);
        layout2.setPadding(new Insets(0, 0, 0, 0));
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(yourName, Labelname, yourGender, Labelgender, yourWeight, inputWeight, yourAge, inputAge, status);

        VBox background = new VBox();
        background.getStyleClass().add("background");
        background.setPadding(new Insets(10, 0, 0, 0));
        background.setAlignment(Pos.TOP_CENTER);
        background.getChildren().addAll(layout2);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox hBoxButton = new HBox();
        hBoxButton.setPadding(new Insets(20, 50, 0, 50));
        hBoxButton.getChildren().addAll(btnBack, spacer, btnNext);

        btnBack.setOnAction(e -> {
            applyScene.showApplyScene(user);
        });

        btnNext.setOnAction(e -> {
            String weight = inputWeight.getText();
            String age = inputAge.getText();
            String name = user.getName();
            String gender = user.getGender();
            if (weight.isEmpty() || age.isEmpty()) {
                status.setText("Weight and Age cannot be empty!");
                return;
            }
            User loginUser = new User(name, gender, weight, age);
            activityScene.showActivityScene(loginUser);

        });

        VBox root = new VBox(layout1, background, hBoxButton);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 360, 640);
        scene.getStylesheets().add(getClass().getResource("/style/styleStart.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
