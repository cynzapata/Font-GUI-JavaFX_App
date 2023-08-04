module cs120.student {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens cs120.student to javafx.fxml;
    exports cs120.student;
}