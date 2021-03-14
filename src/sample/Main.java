package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private StringProperty message = new SimpleStringProperty();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label userIdLbl = new Label("user id:");
        TextField userIdTxt = new TextField();
        Label userPwd = new Label("Password");
        PasswordField userPwdTxt = new PasswordField();
        Button signBtn = new Button("Sign in");
        Button cancelBtn = new Button("cancel");

        Hyperlink forgetPwdLink = new Hyperlink("Forget Password");
        Label messageLbl = new Label();
        messageLbl.textProperty().bind(message);

        GridPane root = new GridPane();
        root.setVgap(20);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        GridPane.setConstraints(userIdLbl, 0, 0);
        GridPane.setConstraints(userIdTxt, 1, 0);
        GridPane.setConstraints(userPwd, 0, 1);
        GridPane.setConstraints(userPwdTxt, 1, 1);
        GridPane.setConstraints(signBtn, 0, 2);
        GridPane.setConstraints(cancelBtn, 1, 2, 1, 1, HPos.RIGHT, VPos.CENTER);
        GridPane.setConstraints(forgetPwdLink, 0, 3, 2, 1);
        GridPane.setConstraints(messageLbl,0,4,2,1);
        root.getChildren().addAll(userIdLbl, userIdTxt, userPwd, userPwdTxt, signBtn, cancelBtn, forgetPwdLink,messageLbl);
        signBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Anonymous class handler sign in clicked");
                message.set("Anonymous class handler sign in clicked");
            }


        });
        cancelBtn.setOnAction(evt ->
                {
                    System.out.println("lambda handler cancel clicked");
                    message.set("lambda handler cancel clicked");
                }
        );

        forgetPwdLink.setOnAction(this::forgotPwdHandler);
        Scene scene = new Scene(root, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
    }

    private void forgotPwdHandler(ActionEvent actionEvent) {
        System.out.println("Method reference handler forgot password clicked");
        message.set("Method reference handler forgot password clicked");
    }
}
