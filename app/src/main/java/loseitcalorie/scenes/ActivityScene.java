package loseitcalorie.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import loseitcalorie.Abstract.AbstractScene;
import loseitcalorie.models.User;

public class ActivityScene extends AbstractScene {
    
    public ActivityScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(User user) {
        StartScene startScene = new StartScene(stage);
        DurationScene durationScene = new DurationScene(stage);

        String name = user.getName();
        String gender = user.getGender();
        String weight = user.getWeight();
        String age = user.getAge();

        Label label1 = new Label("LOSE IT");
        label1.getStyleClass().add("loseIt");

        Label label2 = new Label("CALORIE");
        label2.getStyleClass().add("calorie");

        Label label3 = new Label("SELECT YOUR ACTIVITY");
        label3.getStyleClass().add("select");

        VBox layout1 = new VBox();
        layout1.setSpacing(0);
        layout1.setPadding(new Insets(20, 0, 0, 0));
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.getChildren().addAll(label1, label2);
        
        Image run = new Image(getClass().getResourceAsStream("/icon/run.png"));
        ImageView imageRun = new ImageView(run);
        Image runHover = new Image(getClass().getResourceAsStream("/icon/runHover.png"));
        ImageView imageRunHover = new ImageView(runHover);
        
        imageRun.setFitWidth(110);
        imageRun.setFitHeight(110);
        imageRunHover.setFitWidth(110);
        imageRunHover.setFitHeight(110);
        
        Button buttonRun = new Button();
        buttonRun.setGraphic(imageRun);
        buttonRun.getStyleClass().add("btnIcon");
        
        buttonRun.setOnMouseEntered(e -> {
            buttonRun.setGraphic(imageRunHover);
        });
        
        buttonRun.setOnMouseExited(e -> {
            buttonRun.setGraphic(imageRun);
        });

        buttonRun.setOnAction(e -> {
            User loginUser = new User(name, gender, "Running", weight, age);
            durationScene.show(loginUser);
        });
        
        Image swimming = new Image(getClass().getResourceAsStream("/icon/swimming.png"));
        ImageView imageSwimming = new ImageView(swimming);
        Image swimmingHover = new Image(getClass().getResourceAsStream("/icon/swimmingHover.png"));
        ImageView imageSwimmingHover = new ImageView(swimmingHover);
        
        imageSwimming.setFitWidth(110);
        imageSwimming.setFitHeight(110);
        imageSwimmingHover.setFitWidth(110);
        imageSwimmingHover.setFitHeight(110);
        
        Button buttonSwimming = new Button();
        buttonSwimming.setGraphic(imageSwimming);
        buttonSwimming.getStyleClass().add("btnIcon");
        
        buttonSwimming.setOnMouseEntered(e -> {
            buttonSwimming.setGraphic(imageSwimmingHover);
        });
        
        buttonSwimming.setOnMouseExited(e -> {
            buttonSwimming.setGraphic(imageSwimming);
        });

        buttonSwimming.setOnAction(e -> {
            User loginUser = new User(name, gender, "Swimming", weight, age);
            durationScene.show(loginUser);
        });
        
        Image bycicle = new Image(getClass().getResourceAsStream("/icon/bycicle.png"));
        ImageView imageBycicle = new ImageView(bycicle);
        Image bycicleHover = new Image(getClass().getResourceAsStream("/icon/bycicleHover.png"));
        ImageView imageBycicleHover = new ImageView(bycicleHover);
        
        imageBycicle.setFitWidth(110);
        imageBycicle.setFitHeight(110);
        imageBycicleHover.setFitWidth(110);
        imageBycicleHover.setFitHeight(110);
        
        Button buttonBycicle = new Button();
        buttonBycicle.setGraphic(imageBycicle);
        buttonBycicle.getStyleClass().add("btnIcon");
        
        buttonBycicle.setOnMouseEntered(e -> {
            buttonBycicle.setGraphic(imageBycicleHover);
        });
        
        buttonBycicle.setOnMouseExited(e -> {
            buttonBycicle.setGraphic(imageBycicle);
        });

        buttonBycicle.setOnAction(e -> {
            User loginUser = new User(name, gender, "Cycling", weight, age);
            durationScene.show(loginUser);
        });
        
        Image weightlifting = new Image(getClass().getResourceAsStream("/icon/weightlifting.png"));
        ImageView imageWeightlifting = new ImageView(weightlifting);
        Image weightliftingHover = new Image(getClass().getResourceAsStream("/icon/weightliftingHover.png"));
        ImageView imageWeightliftingHover = new ImageView(weightliftingHover);
        
        imageWeightlifting.setFitWidth(110);
        imageWeightlifting.setFitHeight(110);
        imageWeightliftingHover.setFitWidth(110);
        imageWeightliftingHover.setFitHeight(110);
        
        Button buttonWeightlifting = new Button();
        buttonWeightlifting.setGraphic(imageWeightlifting);
        buttonWeightlifting.getStyleClass().add("btnIcon");
        
        buttonWeightlifting.setOnMouseEntered(e -> {
            buttonWeightlifting.setGraphic(imageWeightliftingHover);
        });
        
        buttonWeightlifting.setOnMouseExited(e -> {
            buttonWeightlifting.setGraphic(imageWeightlifting);
        });

        buttonWeightlifting.setOnAction(e -> {
            User loginUser = new User(name, gender, "Weightlifting", weight, age);
            durationScene.show(loginUser);
        });
        
        Image walking = new Image(getClass().getResourceAsStream("/icon/walking.png"));
        ImageView imageWalking = new ImageView(walking);
        Image walkingHover = new Image(getClass().getResourceAsStream("/icon/walkingHover.png"));
        ImageView imageWalkingHover = new ImageView(walkingHover);
        
        imageWalking.setFitWidth(110);
        imageWalking.setFitHeight(110);
        imageWalkingHover.setFitWidth(110);
        imageWalkingHover.setFitHeight(110);
        
        Button buttonWalking = new Button();
        buttonWalking.setGraphic(imageWalking);
        buttonWalking.getStyleClass().add("btnIcon");
        
        buttonWalking.setOnMouseEntered(e -> {
            buttonWalking.setGraphic(imageWalkingHover);
        });
        
        buttonWalking.setOnMouseExited(e -> {
            buttonWalking.setGraphic(imageWalking);
        });

        buttonWalking.setOnAction(e -> {
            User loginUser = new User(name, gender, "Walking", weight, age);
            durationScene.show(loginUser);
        });
        
        Image skipping = new Image(getClass().getResourceAsStream("/icon/skipping.png"));
        ImageView imageSkipping = new ImageView(skipping);
        Image skippingHover = new Image(getClass().getResourceAsStream("/icon/skippingHover.png"));
        ImageView imageSkippingHover = new ImageView(skippingHover);
        
        imageSkipping.setFitWidth(110);
        imageSkipping.setFitHeight(110);
        imageSkippingHover.setFitWidth(110);
        imageSkippingHover.setFitHeight(110);
        
        Button buttonSkipping = new Button();
        buttonSkipping.setGraphic(imageSkipping);
        buttonSkipping.getStyleClass().add("btnIcon");
        
        buttonSkipping.setOnMouseEntered(e -> {
            buttonSkipping.setGraphic(imageSkippingHover);
        });
        
        buttonSkipping.setOnMouseExited(e -> {
            buttonSkipping.setGraphic(imageSkipping);
        });

        buttonSkipping.setOnAction(e -> {
            User loginUser = new User(name, gender, "Skipping", weight, age);
            durationScene.show(loginUser);
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        HBox hBoxButton1 = new HBox();
        hBoxButton1.setPadding(new Insets(0, 50, 0, 50));
        hBoxButton1.getChildren().addAll(buttonRun, spacer, buttonSwimming);
        
        HBox hBoxButton2 = new HBox();
        hBoxButton2.setPadding(new Insets(0, 50, 0, 50));
        hBoxButton2.getChildren().addAll(buttonBycicle, spacer, buttonWeightlifting);
        
        HBox hBoxButton3 = new HBox();
        hBoxButton3.setPadding(new Insets(0, 50, 0, 50));
        hBoxButton3.getChildren().addAll(buttonWalking, spacer, buttonSkipping);


        VBox background = new VBox();
        background.getStyleClass().add("background");
        background.setPadding(new Insets(10, 0, 0, 0));
        background.setAlignment(Pos.TOP_CENTER);
        background.getChildren().addAll(label3, hBoxButton1, hBoxButton2, hBoxButton3);

        Button btnBack = new Button("BACK");
        btnBack.getStyleClass().add("btnBack");
        
        VBox back = new VBox();
        back.setAlignment(Pos.BOTTOM_CENTER);
        back.setPadding(new Insets(10, 0, 0, 0));
        back.getChildren().addAll(btnBack);

        btnBack.setOnAction(e -> {
            startScene.show(user);
        });

        VBox root = new VBox(layout1, background, back);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 360, 640);
        scene.getStylesheets().add(getClass().getResource("/style/styleActivity.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        
    }     

}