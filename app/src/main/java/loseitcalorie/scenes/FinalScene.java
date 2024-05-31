package loseitcalorie.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import loseitcalorie.abstracts.AbstractScene;
import loseitcalorie.models.User;

public class FinalScene extends AbstractScene {
    

    public FinalScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(User user) {
        ApplyScene applyScene = new ApplyScene(stage);

        Label label1 = new Label("LOSE IT");
        label1.getStyleClass().add("loseIt");

        Label label2 = new Label("CALORIE");
        label2.getStyleClass().add("calorie");

        Label yourActivity = new Label("YOUR ACTIVITY");
        yourActivity.getStyleClass().add("your");

        Label activity = new Label(user.getActivity() + " for " + user.getDuration() + " Minutes.");
        activity.getStyleClass().add("user");

        Label valueLabel = new Label("RESULT");
        valueLabel.getStyleClass().add("your");
        
        Label loseIt = new Label(user.getName().toUpperCase() + " LOSE IT");
        loseIt.getStyleClass().add("userLoseIt");
        
        Label calorieUser = new Label("CALORIE");
        calorieUser.getStyleClass().add("userCalorie");
        double duration = Double.parseDouble(user.getDuration());
        double weight = Double.parseDouble(user.getWeight());
        String activityUser = user.getActivity();
        double mets = 0;

        switch (activityUser) {
            case "Running":
                mets = 8.0;
            case "Swimming":
                mets = 6.0;
            case "Cycling":
                mets = 3.5;
            case "Weightlifting":
                mets = 3.0;
            case "Walking":
                mets = 2.5;
            case "Skipping":
                mets = 8.5;
            default:
                break;
        }

        double calorie = duration * (mets * 3.5 * weight) / 200;

        Label value = new Label(String.format("%.1f", calorie));
        value.getStyleClass().add("value");

        Button btnFinish = new Button("FINISH!");
        btnFinish.getStyleClass().add("btnFinish");

        VBox layoutFinish = new VBox();
        layoutFinish.setPadding(new Insets (20, 0, 0, 0));
        layoutFinish.setAlignment(Pos.BOTTOM_CENTER);
        layoutFinish.getChildren().addAll(btnFinish);

        btnFinish.setOnAction(e -> {
            applyScene.show(user);
        });

        VBox layout1 = new VBox();
        layout1.setSpacing(0);
        layout1.setPadding(new Insets(20, 0, 0, 0));
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.getChildren().addAll(label1, label2);

        VBox layout2 = new VBox();
        layout2.setSpacing(10);
        layout2.setPadding(new Insets(5, 0, 0, 0));
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(yourActivity, activity);

        VBox layoutValue = new VBox();
        layoutValue.setSpacing(10);   
        layoutValue.setPadding(new Insets(0, 0, 0, 0));
        layoutValue.setAlignment(Pos.CENTER);
        layoutValue.getChildren().addAll(valueLabel, loseIt, value, calorieUser);

        VBox background = new VBox();
        background.setSpacing(30);
        background.getStyleClass().add("background");
        background.setPadding(new Insets(10, 0, 0, 0));
        background.setAlignment(Pos.TOP_CENTER);
        background.getChildren().addAll(layout2, layoutValue);

        VBox root = new VBox(layout1, background, layoutFinish);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 360, 640);
        scene.getStylesheets().add(getClass().getResource("/style/styleFinal.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
