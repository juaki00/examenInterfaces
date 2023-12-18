package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start( Stage stage ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication.class.getResource( "hello-view.fxml" ) );
        Scene scene = new Scene( fxmlLoader.load( ) , 900 , 600 );
        stage.setTitle( "Hello!" );
        stage.setScene( scene );
        stage.setMaxHeight( 600 );
        stage.setMinHeight( 600 );
        stage.setMaxWidth( 900 );
        stage.setMinWidth( 900 );
        stage.show( );
    }

    public static void main( String[] args ) {
        launch( );
    }
}