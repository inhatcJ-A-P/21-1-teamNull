package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BResult extends JFrame implements ActionListener{

	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JLabel lb;
	private JTextField tf;
	private JButton btndraw;
	private JLabel label;
	private BResult bResult;

	public BResult(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(900, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1, 3, 5, 5));
		jp1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jp1.setBackground(Color.PINK);
		
		lb = new JLabel("별의 갯수:");
		jp1.add(lb);
		
		tf = new JTextField();
		tf.addActionListener(this);
		jp1.add(tf);
		
		btndraw = new JButton("그리기");
		btndraw.addActionListener(this);
		jp1.add(btndraw);
	
		
		jp2 = new JPanel();
		jp2.setLayout(null);
		
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		
		setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btndraw) {
			jp2.repaint();
			int num = Integer.parseInt(tf.getText());
			JLabel [] label = new JLabel[num];
			
			for(int i = 0; i<num; i++) {
				label[i] = new JLabel("*");
				int x = (int)(Math.random()*200);
				int y = (int)(Math.random()*200);
				label[i].setSize(20, 20);
				label[i].setLocation(x, y);
				label[i].setBackground(Color.RED);
				jp2.add(label[i]);
				
			}
		}
		setVisible(true);
	}


	public BResult getbResult() {
		return bResult;
	}


	public JTextField getTf() {
		return tf;
	}


	public void setbResult(BResult bResult) {
		this.bResult = bResult;
	}


	
}
