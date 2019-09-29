package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        final int numCols = 10 ;
        final int numRows = 22;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints(25);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints(25);
            root.getRowConstraints().add(rowConst);
        }

        root.setPadding(new Insets(30, 300,30,280));

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
