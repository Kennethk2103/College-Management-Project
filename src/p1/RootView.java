package p1;


import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class RootView {

	private static Pane root;

	private RootView() {
		root = new BorderPane();
	}

	public static Pane getRootPane() {
		if (root == null) {
			new RootView();
		}
		return root;
	}

}