package apiDemo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

public class position extends JPanel {
	static JTextField txtInput = new JTextField();
	static JTextField txtOutput = new JTextField();
	
	public static void main(String[] args) {
		int i = 0;
		final HashMap<String,Integer> m_map = new HashMap<String,Integer>();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton input = new JButton("input");
		JButton output = new JButton("output");
		String ms = new String("ԭʼֵ");
		m_map.put(ms, 1);
		ActionListener lisInput = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == txtInput) {
					String in = txtInput.getText();
					int out = m_map.get("ԭʼֵ");
					out = out + 10;
					String nms = new String("ԭʼֵ");
					m_map.put(nms, 0);
					//m_map.clear();
					//String[] out = in.split("\\\\");
					txtOutput.setText(String.valueOf(m_map.get("ԭʼֵ")));
				}
			}
		};
		
		input.setBounds(40,40,80,40);
		txtInput.setBounds(160,40,240,40);
		output.setBounds(40,120,80,40);
		txtOutput.setBounds(160,120,240,40);
		
		txtInput.addActionListener(lisInput);
		
		panel.setLayout(null);
		panel.add(input);
		panel.add(txtInput);
		panel.add(output);
		panel.add(txtOutput);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(new Dimension(500,600));
	}
	
	static class MString {
		String m_String;
		MString(String s) {
			m_String = s;
		}
	}
	
}