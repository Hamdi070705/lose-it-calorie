package loseitcalorie.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import loseitcalorie.controllers.UserController;
import loseitcalorie.models.User;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void showHomeScene() {
        User user = UserController.isUserLoggedIn();
        if (user != null) {
            ApplyScene applyScene = new ApplyScene(stage);
            applyScene.showApplyScene(user);
            return;
        }

        Label label1 = new Label("LOSE IT");
        label1.getStyleClass().add("loseIt");

        Label label2 = new Label("CALORIE");
        label2.getStyleClass().add("calorie");

        Label yourName = new Label("YOUR NAME");
        yourName.getStyleClass().add("nameGender");
        Label yourGender = new Label("YOUR GENDER");
        yourGender.getStyleClass().add("nameGender");

        TextField inputName = new TextField();
        inputName.setPromptText("input your name here");
        inputName.getStyleClass().add("textfield");

        TextField inputGender = new TextField();
        inputGender.setPromptText("input your gender here: Male/Female");
        inputGender.getStyleClass().add("textfield");

        Button apply = new Button("APPLY");
        apply.getStyleClass().add("apply");

        Label status = new Label();
        status.getStyleClass().add("status");

        Button btnStart = new Button("START!");
        btnStart.getStyleClass().add("btnStart");
        btnStart.relocate(0, 0);

        VBox layout1 = new VBox();
        layout1.setSpacing(0);
        layout1.setPadding(new Insets(20, 0, 0, 0));
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.getChildren().addAll(label1, label2);

        VBox layoutStart = new VBox();
        layoutStart.setPadding(new Insets(0, 0, 80, 0));
        layoutStart.setAlignment(Pos.BOTTOM_CENTER);
        layoutStart.getChildren().addAll(btnStart);

        VBox layout2 = new VBox();
        layout2.setSpacing(10);
        layout2.setPadding(new Insets(5, 0, 0, 0));
        layout2.setAlignment(Pos.BOTTOM_CENTER);
        layout2.getChildren().addAll(yourName, inputName, yourGender, inputGender, apply, status);

        VBox background = new VBox();
        background.getStyleClass().add("background");
        background.setSpacing(10);
        background.setPadding(new Insets(20, 0, 0, 0));
        background.setAlignment(Pos.CENTER);
        background.getChildren().addAll(layout2);

        apply.setOnAction(e -> {
            String name = inputName.getText();
            String gender = inputGender.getText();
            if (name.isEmpty() || gender.isEmpty()) {
                status.setText("Name and Gender cannot be empty!");
                return;
            } else if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
                status.setText("Gender must be Male or Female!");
                return;
            }

            User loginUser = new User(1, name, gender);

            boolean isSuccess = UserController.addUser(name, gender);

            if (isSuccess) {
                ApplyScene applyScene = new ApplyScene(stage);
                applyScene.showApplyScene(loginUser);
            }
        });

        btnStart.setOnAction(e -> {
            status.setText("Name and Gender must be apply before start!");
        });

        Scene scene = new Scene(new StackPane(layout1, layoutStart, background), 360, 640);
        scene.getStylesheets().add(getClass().getResource("/style/styleHome.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
