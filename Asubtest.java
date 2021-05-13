package swing.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Asubtest extends JFrame implements ActionListener{
	private String[] str = {"+", "-", "*", "/"};
	private JComboBox<String> jc;
	private JButton btnEqual;
	private JTextField tf, tf2, tf3;
	private int sum = 0;
	private Atest atest;
	private JButton btnSent;
	private JButton btnExit;

	public Asubtest(String title, int width, int height, Atest atest) {
		setTitle(title);
		setSize(width, height);
		setLocation(950, 350);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.atest = atest;
		
		panTop();
		panCenter();
		panBottom();
		
		
		
		
		
		setVisible(true);
	}
	private void panTop() {
		JPanel panTop = new JPanel();
		JLabel lb1 = new JLabel("2학년/C반/이성호");
		panTop.setBackground(Color.YELLOW);
		panTop.add(lb1);
		add(panTop, BorderLayout.NORTH);
	}
	
	private void panCenter() {
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new GridLayout(1, 5, 5, 5));
		panCenter.setBorder(BorderFactory.createEmptyBorder(12, 10, 12, 10));
		tf =  new JTextField();
		panCenter.add(tf);
		
		jc = new JComboBox<String>(str);
		panCenter.add(jc);
		
		tf2 = new JTextField();
		panCenter.add(tf2);
		
		btnEqual = new JButton("=");
		btnEqual.addActionListener(this);
		panCenter.add(btnEqual);
		
		tf3= new JTextField();
		panCenter.add(tf3);
		
		add(panCenter);
	}
	
	private void panBottom() {
		JPanel panBottom = new JPanel();
		btnSent = new JButton("결과 보내기");
		btnSent.addActionListener(this);
		panBottom.add(btnSent);
		
		btnExit = new JButton("닫기");
		btnExit.addActionListener(this);
		panBottom.add(btnExit);
		
		add(panBottom, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		int x = Integer.parseInt(tf.getText());
		int y = Integer.parseInt(tf2.getText());
		
		if(obj == btnEqual) {
			if(jc.getSelectedItem() == "+") {
				sum = x + y;
				tf3.setText(Integer.toString(sum));
			} else if(jc.getSelectedItem() == "-") {
				sum = x - y;
				tf3.setText(Integer.toString(sum));
			} else if(jc.getSelectedItem() == "*") {
				sum = x * y;
				tf3.setText(Integer.toString(sum));
			} else if(jc.getSelectedItem() == "/") {
				sum = x / y;
				tf3.setText(Integer.toString(sum));
			}
		} else if(obj == btnSent) {
			atest.getTa().append("계산결과:" + tf.getText() + jc.getSelectedItem() + tf2.getText() + "=" + Integer.toString(sum) + "\n");
		} else if(obj == btnExit) {
			System.exit(0);
		}
		
	}
	
}
