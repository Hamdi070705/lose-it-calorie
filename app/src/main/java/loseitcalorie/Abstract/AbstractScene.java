package loseitcalorie.Abstract;

import javafx.stage.Stage;
import loseitcalorie.models.User;

public abstract class AbstractScene {
    protected Stage stage = new Stage();

    public AbstractScene(Stage stage) {
        this.stage = stage;
    }

    public abstract void show(User user);
}
