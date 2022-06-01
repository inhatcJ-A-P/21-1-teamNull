package Test;

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

import com.sun.net.httpserver.Authenticator.Result;

public class BbanTest extends JFrame implements ActionListener{

	private String [] cbitem = {"+","-","*","/"}; 
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JLabel jl;
	private JTextField tf1;
	private JComboBox<String> cb1;
	private JTextField tf2;
	private JButton btn1;
	private JTextField tf3;
	private JButton btnresult;
	private JButton btnclose;
	private BResult br;
	private int sum;
	private BbanTest bbanTest;
	private BBtnTwo bBtnTwo;

	public BbanTest(String title, int width, int height, BBtnTwo bBtnTwo) {
		setTitle(title);
		setSize(width, height);
		setLocation(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.bBtnTwo = bBtnTwo;
		
		jp1 = new JPanel();
		jl = new JLabel("2학년/C반/김민주");
		jp1.setBackground(Color.YELLOW);
		jp1.add(jl);	
		
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1, 5,10,10));
		jp2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		tf1 = new JTextField(5);
		tf1.addActionListener(this);
		
		cb1 = new JComboBox<String>(cbitem);
		cb1.addActionListener(this);
		
		tf2 = new JTextField(5);
		tf2.addActionListener(this);
		
		btn1 = new JButton("=");
		btn1.addActionListener(this);
		
		tf3 = new JTextField(3);
		tf3.addActionListener(this);
		
		jp2.add(tf1);
		jp2.add(cb1);
		jp2.add(tf2);
		jp2.add(btn1);
		jp2.add(tf3);
		
		jp3 = new JPanel();
		
		btnresult = new JButton("결과 보내기");
		btnresult.addActionListener(this);
		
		btnclose = new JButton("닫기");
		btnclose.addActionListener(this);
		
		jp3.add(btnresult);
		jp3.add(btnclose);
		
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		
		setVisible(true);
	}


	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		int x = 0;
		int y = 0;
		x = Integer.parseInt(tf1.getText());
		y = Integer.parseInt(tf2.getText());
		
		
		if(obj == btnclose) {
			System.exit(0);
		}if(obj == btn1) {
			if(cb1.getSelectedItem() == "+") {
				sum = x + y;
				tf3.setText(Integer.toString(sum));			
			}else if(cb1.getSelectedItem() == "-") {
				sum = x - y;
				tf3.setText(Integer.toString(sum));
			}else if(cb1.getSelectedItem() == "*") {
				sum = x * y;
				tf3.setText(Integer.toString(sum));
			}else if(cb1.getSelectedItem() == "/") {
				sum = x / y;
				tf3.setText(Integer.toString(sum));
			}
		}if(obj==btnresult) {
			bBtnTwo.getbResult().getTf().setText("");
			bBtnTwo.getbResult().getTf().setText(sum+"");
		}
		
	}





	public BbanTest getBbanTest() {
		return bbanTest;
	}





	public void setBbanTest(BbanTest bbanTest) {
		this.bbanTest = bbanTest;
	}

}
