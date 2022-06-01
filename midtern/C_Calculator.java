package c;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class C_Calculator extends JFrame implements ActionListener {

	private JPanel panInfo;
	private JLabel lblInfo;
	private JPanel panTf;
	private JTextField tfResult;
	private JPanel panBtns;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnC;
	private JButton btnEqual;
	private JPanel panTfBtns;
	private C_Main cm;
	private String str = "";
	
	private ArrayList<Integer> num = new ArrayList<>();

	public C_Calculator(String title, int width, int height, C_Main cm) {
		
		this.cm = cm;
		
		setTitle(title);
		setSize(width, height);
		setLocation(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 창 크기 변경 제한
		
		// 레이아웃
//		setLayout(new FlowLayout());

		
		// 학번 반 이름 패널
		panInfo = new JPanel();
		panInfo.setBackground(Color.YELLOW);

		lblInfo = new JLabel("202045053 / 지수빈");
		lblInfo.setHorizontalAlignment(JLabel.CENTER);
		lblInfo.setPreferredSize(new Dimension(350, 20));
		
		panInfo.add(lblInfo);
		
		// 텍스트 필드 + 버튼 패널
		panTfBtns = new JPanel();
		panTfBtns.setLayout(new BorderLayout());
		
		// 텍스트 필드 패널
		panTf = new JPanel();
		
		tfResult = new JTextField(30);
		tfResult.setText("0");
		tfResult.setHorizontalAlignment(JTextField.RIGHT);
		
		panTf.add(tfResult);
		
		panTfBtns.add(panTf, BorderLayout.NORTH);
		
		// 버튼 패널
		panBtns = new JPanel();
		panBtns.setLayout(new GridLayout(2, 4, 5, 5));
		panBtns.setBorder(BorderFactory.createEmptyBorder(5, 20, 15, 20));
		
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btnC = new JButton("C");
		btnEqual = new JButton("=");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btnC.addActionListener(this);
		btnEqual.addActionListener(this);
		
		panBtns.add(btn1);
		panBtns.add(btn2);
		panBtns.add(btn3);
		panBtns.add(btnC);
		panBtns.add(btn4);
		panBtns.add(btn5);
		panBtns.add(btn6);
		panBtns.add(btnEqual);
		
		panTfBtns.add(panBtns);
		
		// 붙이기
		add(panInfo, BorderLayout.NORTH);
		add(panTfBtns);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if (obj == btn1) {
			str += "1";
			tfResult.setText(str);
		} else if (obj == btn2) {
			str += "2";
			tfResult.setText(str);
		} else if (obj == btn3) {
			str += "3";
			tfResult.setText(str);
		}else if (obj == btn4) {
			str += "4";
			tfResult.setText(str);
		}else if (obj == btn5) {
			str += "5";
			tfResult.setText(str);
		}else if (obj == btn6) {
			str += "6";
			tfResult.setText(str);
		}
		
		if (obj == btnC) {
			str = "";
			tfResult.setText("0");
		}
		
		if (obj == btnEqual) {
			cm.getListModel().addElement(str);
			str = "0";
			tfResult.setText(str);
		}
	}

}
