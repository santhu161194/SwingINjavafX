
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@FXML
	private TextField actiontarget;
	@FXML
	private Pane pane;

	@FXML
	private SwingNode swingNode;

	@FXML
	private Pane pane1;

	@FXML
	private SwingNode swingNode1;

	JTextField field;

	// 1.launches the Stand-alone Application
	public static void main(String[] args) {
		launch(args);// launches the start method

	}

	// 2.Start Method
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Swing FX");

		initRootLayout();

		showPersonOverview();
	}

	// The root Layout
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// The inside Layout
	public void showPersonOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Overview.fxml"));
			AnchorPane Overview = (AnchorPane) loader.load();

			rootLayout.setCenter(Overview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Called By the FXML once the whole FXML threaD gets Loaded
	@FXML
	public void initialize() {
		createAndSetSwingButton(swingNode, swingNode1);
	}

	// Swing Thread that gets started after the JAVAFX thread
	public void createAndSetSwingButton(final SwingNode swingNode, final SwingNode swingNode1) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				swingNode.setContent(new JButton("Swing Button"));
				swingNode1.setContent(new JTextField("Swing Text Field"));
				JButton swingButton = (JButton) swingNode.getContent();

				// Swing Button Action
				swingButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(java.awt.event.ActionEvent e) {
						field = (JTextField) swingNode1.getContent();
						field.setText("Swing Button Pressed");
						actiontarget.setText("Swing Button Pressed");
					}
				});
			}
		});
	}

	// JAVAFX Button Action
	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) {
		actiontarget.setText("JAVAFX Button Pressed");
		field = (JTextField) swingNode1.getContent();
		field.setText("JAVAFX BUtton Pressed");
	}

}
