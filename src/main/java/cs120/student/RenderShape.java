package cs120.student;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RenderShape {
	private Shape currentShape;
	private DoubleProperty greenColor;
	private Rectangle rectShape;
	Rectangle rect;
	public void setGreenColor(DoubleProperty greenColor) {
	this.greenColor = greenColor;
}
	public void setRectShape(ObjectProperty rectShape) {
		rect = new Rectangle(110, 140, 190, 170);
		this.currentShape = rect;
	}
	public Shape getShape() {
		
	return currentShape;
}
	public DoubleProperty getGreenColor() {
	return greenColor;
}

}
