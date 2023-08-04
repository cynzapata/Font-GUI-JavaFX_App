package cs120.student;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * This class controls what actions occur when buttons(radio, render, and quit buttons) are pressed
 * It binds properties and enables radiobuttons when checkbox is checked
 * @author cynthiazapata
 *
 */
public class PrimaryController implements Initializable{
	
	private RenderModel theModel;
	@FXML
	TextField textField;
	@FXML
	ComboBox<String> boxFontFamily;
	@FXML
	ComboBox<FontWeight> boxFontWeight;
	@FXML
	ComboBox<Double> boxFontSize;
	@FXML
	Rectangle rect; //rectangle that shows text and shape user chose to create
	@FXML
	StackPane stackPane; //pane that holds Rectangle rect 
	@FXML
	CheckBox checkBox;
	@FXML
	RadioButton rectRadioBtn;
	@FXML
	RadioButton ellipseRadioBtn;
	@FXML
	RadioButton starRadioBtn;
	@FXML
	Slider redSlider;
	@FXML
	Slider greenSlider;
	@FXML
	Slider blueSlider;
	private Rectangle rect2;
	private Ellipse ell;
	private Polygon pol;
	private double redColor;
	private double blueColor;
	private double greenColor;
	/**
	 * This method calls our super class and creates our render model
	 */
	public PrimaryController() {
		super();
	theModel = new RenderModel();
	
	}
	/**
	 * This method controls what actions occur when the render button is pressed
	 * When the render button is pressed, the text and shape are called
	 * from the render model and shown on the stack pane so the user can view
	 * the shape or text they chose
	 */
	@FXML
    private void renderButtonAction() throws IOException {
		
		/*
		 * First we call our text and shape methods from the render model class
		 */
        Text theText = theModel.getText(); //gets the current text based on users selections
       // Shape shape = theModel.getShape(); //gets the current shape based on users selections
      /*
       * After that, we get a handle on the text the user inputed and add it to the frame
       */
        String borderText = textField.getText(); //gets handle on text inputed in the text field 
		theText = new Text(borderText); //converts the String to Text 
		theText.setFont(Font.font(theModel.getFontFamily().getValue(),(FontWeight) theModel.getFontWeight().getValue(),theModel.getFontSize().doubleValue())); //calls properties from Render Model class
		makeShape(); //adds shape to the frame
		stackPane.getChildren().add(theText); //adds text to the frame
       

    }
	/**
	 * This method controls what actions occur when the quit buttons is pressed
	 * The Action event is used to close the window 
	 * @param e
	 * @throws IOException
	 */
	@FXML
    private void quitButtonAction(ActionEvent e) throws IOException {
        ((Stage) (((Button) e.getSource()).getScene().getWindow())).close(); 
        //the window is closed when button is pressed
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*
		 * First, we create a toggle group and add our radio buttons to the group
		 * This will limit the user to choose only one shape from the shape
		 * button selection 
		 */
		ToggleGroup group = new ToggleGroup();
		rectRadioBtn.setToggleGroup(group);
		ellipseRadioBtn.setToggleGroup(group);
		starRadioBtn.setToggleGroup(group);
		/*
		 * After that we add our values to the combo boxes(font, font weight, size)
		 */
		boxFontFamily.getItems().addAll(Font.getFontNames());
		boxFontWeight.getItems().addAll(FontWeight.values());
		boxFontSize.getItems().addAll(8.0, 12.0, 16.0, 24.0);
		/*
		 * After that, we bind our combo boxes to the selected item property
		 */
		theModel.getFontFamily().bind(
				boxFontFamily.getSelectionModel().selectedItemProperty());
		theModel.getFontSize().bind(
				boxFontSize.getSelectionModel().selectedItemProperty());
		theModel.getFontWeight().bind(
				boxFontWeight.getSelectionModel().selectedItemProperty());
//		theShapeModel.getGreenColor().bind(
//				greenSlider.valueProperty());
		
		/*
		 * Then, we write code to bind the disable property to the buttons 
		 * This disables the radio button when the the user doesn't check
		 * the shape check box
		 */
		rectRadioBtn.disableProperty().bind(checkBox.selectedProperty().not());
		ellipseRadioBtn.disableProperty().bind(checkBox.selectedProperty().not());
		starRadioBtn.disableProperty().bind(checkBox.selectedProperty().not());

	} 
	/*
	 * This method makes a shape based on the shape chosen and the color selected
	 */
	public void makeShape() {
		/*
		 * We first create the shapes that will be displayed in the window(stack pane)
		 */
		rect2 = new Rectangle(110, 140, 190, 170);
		ell = new Ellipse(110, 140, 140, 120);
		pol = new Polygon();
		// the following lines are the points of the star
		pol.getPoints().addAll(new Double[] { 250.0, 50.0, 220.0, 120.0, 175.0, 150.0, 210.0, 190.0, 175.0, 250.0,
				270.0, 190.0, 350.0, 250.0, 310.0, 190.0, 350.0, 150.0, 310.0, 140.0 });
		/*
		 * Then, we use the value property and add listeners to determine the 
		 * tick mark the user moves the slider to, this number will determine
		 * the color of the shape
		 */
		redSlider.valueProperty().addListener(new ChangeListener<Number>() {

			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				System.out.println(new_val.doubleValue());
				redColor = new_val.doubleValue(); // value of red color based on tick number

			}
		});
		blueSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_va, Number new_va) {
				System.out.println(new_va.doubleValue());
				blueColor = old_va.doubleValue(); // value of blue color based on tick number
			}
		});
		greenSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_vals) {
				System.out.println(new_vals.doubleValue());
				greenColor = new_vals.doubleValue(); // value of green color based on tick number
			}
		});
		/*
		 * We then get handles on the integers we receive based on the tick mark the
		 * user decided to move the slider to
		 */
		int reds = ((int) redColor);
		int blues = ((int) blueColor);
		int greens = ((int) greenColor);
		/*
		 * After that, we create a color that holds the values of reds, greens, and blues
		 */
		Color c = Color.rgb(reds, greens, blues);
		/*
		 * Next, we set the color and add the shape to the stack pane when the
		 * radio button is selected
		 */
		if (rectRadioBtn.isSelected()) {
			rect.setFill(c); // sets color of rectangle
			stackPane.getChildren().add(rect); // adds rectangle to window/main pane
		}
		if (ellipseRadioBtn.isSelected()) {
			ell.setFill(c); // sets color of ellipse
			stackPane.getChildren().add(ell); // adds ellipse to window/main pane
		}
		if (starRadioBtn.isSelected()) {
			pol.setFill(c); // sets color of star
			stackPane.getChildren().add(pol); // adds star to window/main pane
		}
	}

}
