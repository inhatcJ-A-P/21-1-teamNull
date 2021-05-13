package swing.midterm.b;

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
import javax.swing.border.Border;



public class Sub extends JFrame implements ActionListener {
	


	private JPanel p1;
	private JPanel p2;
	private JLabel l1;
	private JPanel Last;
	private String [] Giho = {"+","-","*","/"};
	private JTextField tx1;
	private JComboBox<String> cb;
	private JTextField tx2;
	private JButton b1;
	private JLabel l2;
	private int Result = 0;
	private char op = '+';		
	private int one, two;
	private JPanel p3;
	private JButton b2;
	private JButton b3;

	private JTextField tx3;
	private Sub2 st;
	private Main main;
	//JFrame을 상속 받아 만드는 방법 << 이걸 더 선호함.
	public Sub(String title, int width, int height, Main main) {
		this.main = main;

		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		p1 = new JPanel();
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1,5,5,5));
		p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p3 = new JPanel();
		
		l1 = new JLabel("2학년 / B반 / 김종하");
		p1.add(l1);
		p1.setBackground(Color.yellow);
		
		tx1 = new JTextField(2);
		cb = new JComboBox<String>(Giho);
		cb.addActionListener(this);
		tx2 = new JTextField(2);
		b1 = new JButton("=");
		b1.addActionListener(this);
		tx3 = new JTextField(2);
		
		p2.add(tx1);
		p2.add(cb);
		p2.add(tx2);
		p2.add(b1);
		p2.add(tx3);
		
		
		b2 = new JButton("결과 보내기");
		b2.addActionListener(this);
		b3 = new JButton("닫기");
		b3.addActionListener(this);
		p3.add(b2);
		p3.add(b3);
		add(p1,BorderLayout.NORTH);
		add(p2);
		add(p3,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == cb) {
			int index = cb.getSelectedIndex();
			op = Giho[index].charAt(0);
		}
		else if(obj == b1) {
				one = Integer.parseInt(tx1.getText());
				two = Integer.parseInt(tx2.getText());
				switch (op) {
				case '+':
					Result = one + two;
					tx3.setText(Result+"");
					break;
				case '-':
					Result = one - two;
					tx3.setText(Result+"");
					break;
				case '*':
					Result = one * two;
					tx3.setText(Result+"");
					break;
				case '/':
					Result = one / two;
					tx3.setText(Result+"");
					break;
				}
		}
		else if(obj == b2) {
			main.getSf2().getTx1().setText("");
			main.getSf2().getTx1().setText(Result+"");
		}
		else if(obj == b3) {
			dispose();
		}
	}

}
