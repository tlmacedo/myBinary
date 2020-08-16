package br.com.tlmacedo.binary.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewPrincipal {
    static Stage stage;

    public void openViewPrincipal() throws IOException {
        setStage(new Stage());
        Parent parent;
        Scene scene = null;

        parent = FXMLLoader.load(getClass().getResource("/fxml/FxmlBinary.fxml"));
        scene = new Scene(parent);

        stage.setTitle("Binary by Thiago Macedo.");
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ViewPrincipal.stage = stage;
    }
}


