package principal;

import javax.swing.JFrame;

import controller.EventManager;
import model.HTMLManager;
import model.XMLManager;
import view.LaunchView;

public class Principal {

	public static void main(String[] args) {

		XMLManager model1 = new XMLManager();
		HTMLManager model2 = new HTMLManager();
		
		LaunchView view = new LaunchView();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
		
		EventManager controller = new EventManager(model1, model2, view);
		controller.control();

	}

}
