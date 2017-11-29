

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application implements Initializable {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @FXML private TextField actiontarget;
    @FXML
    private Pane pane;

    @FXML
    private SwingNode swingNode;
    
    @FXML
    private Pane pane1;

    @FXML
    private SwingNode swingNode1;
    
    JTextField field;
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Swing FX");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
        
    }





	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 createAndSetSwingButton(swingNode,swingNode1);
    }

    public void createAndSetSwingButton(final SwingNode swingNode,final SwingNode swingNode1) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingNode.setContent(new JButton("Swing Button"));
                swingNode1.setContent(new JTextField("Swing Text Field"));
                JButton swingButton=(JButton)swingNode.getContent();
                swingButton.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(java.awt.event.ActionEvent e) {
						field=(JTextField) swingNode1.getContent();
						field.setText("Swing BUtton Pressed");
						actiontarget.setText("Swing Button Pressed");
					}
				});
            }
        });
    }
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("JAVAFX Button Pressed");
         field=(JTextField) swingNode1.getContent();	
        field.setText("JAVAFX BUtton Pressed");
    }
    
    @FXML protected void handleSubmitButtonAction2(ActionEvent event) {
        actiontarget.setText("JAVAFXasfdasfasd Button Pressed");
        field=(JTextField) swingNode1.getContent();
        field.setText("JAVAFX BUtton Pressed");
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
