package swing.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Bsubsubtest extends JFrame implements ActionListener{
	private AbstractButton btn;
	private JTextField tf;
	private JPanel pan2;
	private JLabel[] lb1;

	public Bsubsubtest(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1100, 350);
		
		panTop();
		panCenter();
	
		setVisible(true);
	}

	private void panTop() {
		JPanel pan = new JPanel();
		pan.setBackground(Color.PINK);
		
		JLabel lb1 = new JLabel("별의 갯수 : ");
		pan.add(lb1);
		
		tf = new JTextField(5);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		pan.add(tf);
		
		btn = new JButton("그리기");
		btn.addActionListener(this);
		pan.add(btn);
		
		add(pan, BorderLayout.NORTH);
	}

	private void panCenter() {
		pan2 = new JPanel();
		pan2.setLayout(null);
		
		add(pan2);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		lb1 = new JLabel[Integer.parseInt(tf.getText())];
		
		if(obj == btn) {
			pan2.repaint();
			for(int i = 0; i < Integer.parseInt(tf.getText()); i++) {
			
			lb1[i] = new JLabel("*");
			int x = (int)(Math.random()*275) + 10;
			int y = (int)(Math.random()*190) + 30; 
						
			lb1[i].setSize(20, 20);
			lb1[i].setLocation(x, y);
			pan2.add(lb1[i]);
			}
		}
	}

	public JTextField getTf() {
		return tf;
	}

	
}
