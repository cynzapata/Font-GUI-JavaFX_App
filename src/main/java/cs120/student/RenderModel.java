package cs120.student;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 * This class creates properties of the text to be binded in 
 * the primary controller class
 */
public class RenderModel {
	
	private Text currentText;
	
	private StringProperty fontFamily = new SimpleStringProperty();
	private DoubleProperty fontSize = new SimpleDoubleProperty();
	private ObjectProperty fontWeight = new SimpleObjectProperty();
	
	/*
	 * This method gets the Font Family
	 */
	public StringProperty getFontFamily() {
		return fontFamily;
	}
	/*
	 * This method gets the Font Size
	 */
	public DoubleProperty getFontSize() {
		return fontSize;
	}
	/*
	 * This method gets the Font Weight
	 */
	public ObjectProperty getFontWeight() {
		return fontWeight;
	}
	/*
	 * This method sets the Font Family
	 */
	public void setFontFamily(StringProperty fontFamily) {
		this.fontFamily = fontFamily;
	}
	/*
	 * This method sets the Font Size
	 */
	public void setFontSize(DoubleProperty fontSize) {
		this.fontSize = fontSize;
	}
	/*
	 * This method sets the Font Weight
	 */
	public void setFontWeight(ObjectProperty fontWeight) {
		this.fontWeight = fontWeight;
	}
	/*
	 * This method returns text with attributes
	 */
	public Text getText() {
		return currentText;
	}
//	public void setGreenColor(DoubleProperty greenColor) {
//	this.greenColor = greenColor;
//}
//	public Shape getShape() {
//		return currentShape;
//	}
//	public DoubleProperty getGreenColor() {
//		return greenColor;
//	}
//	
}
