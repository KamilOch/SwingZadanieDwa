

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.xml.bind.JAXBIntrospector.getValue;

public class ButtonDwaZadanie extends JFrame{

	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;

	public ButtonDwaZadanie() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

		buttonPanel = new JPanel();

		// define actions
		Action p1Action = new PrintAction("Jeden");
		Action p2Action = new PrintAction("Dwa");
		Action p3Action = new PrintAction("Jeden");

		JButton p1Button = new JButton(p1Action);
		p1Button.setName("lewy");
		JButton p2Button = new JButton(p2Action);
		JButton p3Button = new JButton(p3Action);
		p3Button.setName("prawy");

		//all buttons listener
		AllButtonListener allButtonListener = new AllButtonListener(p1Button,p2Button,p3Button);
		p1Button.addActionListener(allButtonListener);
		p2Button.addActionListener(allButtonListener);
		p3Button.addActionListener(allButtonListener);

		// add buttons for these actions
		buttonPanel.add(p1Button);
		buttonPanel.add(p2Button);
		buttonPanel.add(p3Button);

		add(buttonPanel);

		// associate the names with actions
		ActionMap actionMap = buttonPanel.getActionMap();
		actionMap.put("Jeden", p1Action);
		actionMap.put("Dwa", p2Action);
		actionMap.put("Jeden", p3Action);

	}

		class PrintAction extends AbstractAction{

			public PrintAction(String name) {

				putValue(Action.NAME, name);
				putValue(Action.SHORT_DESCRIPTION, "Nazwa Przycisu: "+ name.toLowerCase());
			}

			public void actionPerformed(ActionEvent event) {
				//TODO rozwiazanie bazujace na dodaniu unikalnej nazwy dla prawego i lewego przycisku
				String przycisk = (String) getValue(Action.NAME);
				JButton button = (JButton) event.getSource();

				String ktoryPrzycisk = "";
				String lewyPrzycisk = "lewy";
				String prawyPrzycisk = "prawy";

				if(lewyPrzycisk.equals(button.getName()))
					ktoryPrzycisk = "lewy";
				else if(prawyPrzycisk.equals(button.getName()))
					ktoryPrzycisk= "prawy";
				else ktoryPrzycisk= "inny";

				System.out.println("Akkuku ktoś nacisnął przycisk "+przycisk + " Typ przycisku "+ ktoryPrzycisk);
			}

		}

		private class AllButtonListener extends JFrame implements ActionListener{

			private JButton przycisk1;
			private JButton przycisk2;
			private JButton przycick3;

			public AllButtonListener(JButton przycisk1, JButton przycisk2, JButton przycick3) throws HeadlessException {
				this.przycisk1 = przycisk1;
				this.przycisk2 = przycisk2;
				this.przycick3 = przycick3;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Klasa AllButtonListener! Został wciśnięty "+ e.getActionCommand());
			}
		}
}
