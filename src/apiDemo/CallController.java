package apiDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CallController {
	private static ActionListener test=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Controller.c.getInt();
		}
	};
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JButton button=new JButton("Test");
		button.addActionListener(test);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);
	}

}