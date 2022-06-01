package swing.midterm.c;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sub extends JFrame implements ActionListener {
	
	private JPanel p1;
	private JPanel p2;
	private JTextField tx;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b10;
	private JButton b11;
	private JButton b12;
	private String temp = "";
	private Main main;
	private JPanel p3;
	private JLabel l1;
	//JFrame을 상속 받아 만드는 방법 << 이걸 더 선호함.
	public Sub(String title, int width, int height, Main main) {
		this.main = main;
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		
		p1 = new JPanel();
		p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 4, 5, 5));
		p2.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		//p2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		p3 = new JPanel();
		p3.setBackground(Color.yellow);
		
		l1 = new JLabel("202045059 / 김종하");
		p3.add(l1);
		
		tx = new JTextField("0",18);
		tx.setHorizontalAlignment(JTextField.RIGHT);
		p1.add(tx);
		
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("C");
		b5 = new JButton("4");
		b6 = new JButton("5");
		b7 = new JButton("6");
		b8 = new JButton("=");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		
		
		
		
		
		add(p3,BorderLayout.NORTH);
		add(p1);
		add(p2,BorderLayout.SOUTH);
		setVisible(true);
		
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1) {
			temp += "1";
			tx.setText(temp);
		}
		else if(obj == b2) {
			temp += "2";
			tx.setText(temp);
		}
		else if(obj == b3) {
			temp += "3";
			tx.setText(temp);
		}
		else if(obj == b4) {
			temp = temp.substring(0,temp.length() - 1);
			tx.setText(temp);
			if(temp.equals("")) {
				tx.setText("0");
			}
		}
		else if(obj == b5) {
			temp += "4";
			tx.setText(temp);
		}
		else if(obj == b6) {
			temp += "5";
			tx.setText(temp);
		}
		else if(obj == b7) {
			temp += "6";
			tx.setText(temp);
		}
		
		else if(obj == b8) {
			main.getV().add(temp);
			main.getList().setListData(main.getV()); //리스트에 변경된 벡터내용 추가하는 명령어
			tx.setText("0");
			temp = "";
		}
	}

}
