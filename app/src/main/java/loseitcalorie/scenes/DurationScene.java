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
import loseitcalorie.Abstract.AbstractScene;
import loseitcalorie.models.User;

public class DurationScene extends AbstractScene {
    
    public DurationScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(User user) {
        FinalScene finalScene = new FinalScene(stage);
        ActivityScene activityScene = new ActivityScene(stage);

        Label label1 = new Label("LOSE IT");
        label1.getStyleClass().add("loseIt");

        Label label2 = new Label("CALORIE");
        label2.getStyleClass().add("calorie");

        Label yourName = new Label("YOUR NAME");
        yourName.getStyleClass().add("your");
        Label name = new Label(user.getName().toUpperCase());
        name.getStyleClass().add("user");

        Label yourGender = new Label("YOUR GENDER");
        yourGender.getStyleClass().add("your");
        Label gender = new Label(user.getGender().toUpperCase());
        gender.getStyleClass().add("user");

        Label yourWeight = new Label("YOUR WEIGHT");
        yourWeight.getStyleClass().add("your");
        Label weight = new Label(user.getWeight() + "kg");
        weight.getStyleClass().add("user");

        Label yourAge = new Label("YOUR AGE");
        yourAge.getStyleClass().add("your");
        Label age = new Label(user.getAge() + " Years Old");
        age.getStyleClass().add("user");
        
        Label yourActivity = new Label("YOUR ACTIVITY");
        yourActivity.getStyleClass().add("your");
        Label activity = new Label(user.getActivity());
        activity.getStyleClass().add("user");

        Label duration = new Label("ACTIVITY DURATION IN MINUTES");
        duration.getStyleClass().add("your");
        TextField inputDuration = new TextField();
        inputDuration.setPromptText("input duration activity here: ..minutes");
        inputDuration.getStyleClass().add("textfield");

        Label status = new Label();
        status.getStyleClass().add("status");

        Button btnBack = new Button("BACK");
        btnBack.getStyleClass().add("btnBackNext");

        Button btnNext = new Button("NEXT");
        btnNext.getStyleClass().add("btnBackNext");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox hBoxButton = new HBox();
        hBoxButton.setPadding(new Insets(2, 60, 0, 60));
        hBoxButton.getChildren().addAll(btnBack, spacer, btnNext);

        VBox layout1 = new VBox();
        layout1.setSpacing(0);
        layout1.setPadding(new Insets(20, 0, 0, 0));
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.getChildren().addAll(label1, label2);

        VBox layout2 = new VBox();
        layout2.setSpacing(8);
        layout2.setPadding(new Insets(0, 0, 0, 0));
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(yourName, name, yourGender, gender, yourWeight, weight, yourAge, age, yourActivity, activity, duration, inputDuration, status);

        VBox background = new VBox();
        background.getStyleClass().add("background");
        background.setPadding(new Insets(10, 0, 0, 0));
        background.setAlignment(Pos.TOP_CENTER);
        background.getChildren().addAll(layout2);

        btnNext.setOnAction(e -> {
            String activityDuration = inputDuration.getText();
            if (activityDuration.isEmpty()) {
                status.setText("activity duration cannot be empty!");
                return;
            }
            String nameUser = user.getName();
            String genderUser = user.getGender();
            String weightUser = user.getWeight();
            String ageUser = user.getAge();
            String duraionActicity = inputDuration.getText();
            String activityUser = user.getActivity();
            User loginUser = new User(nameUser, genderUser, activityUser, weightUser, ageUser, duraionActicity);
            finalScene.show(loginUser);
        });

        btnBack.setOnAction(e -> {
            activityScene.show(user);
        });

        VBox root = new VBox(layout1, background, hBoxButton);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 360, 640);
        scene.getStylesheets().add(getClass().getResource("/style/styleDuration.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
