package a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class A_Calculator extends JFrame implements ActionListener {

	private JPanel panInfo;
	private JLabel lblInfo;
	private JPanel panCal;
	private JPanel panBtns;
	private JTextField tfNum1;
	private JComboBox cbGiho;
	private A_Main am;
	
	private String[] strs = {"+", "-", "*", "/"};
	private JTextField tfNum2;
	private JButton btnEqual;
	private JTextField tfSeq;
	private JButton btnSend;
	private JButton btnClose;
	private int iNum1;
	private int iNum2;
	private int sum;

	public A_Calculator(String title, int width, int height, A_Main am) {
		
		this.am = am;
		
		setTitle(title);
		setSize(width, height);
		setLocation(860, 400);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 창 크기 변경 제한
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		// 학년/반/이름 패널
		panInfo = new JPanel();
		
		panInfo.setBackground(Color.YELLOW);
		
		lblInfo = new JLabel("2학년 / B반 / 지수빈");
		lblInfo.setForeground(Color.black);
		
		panInfo.add(lblInfo);
		
		// 계산 패널
		panCal = new JPanel();
		
		tfNum1 = new JTextField(4);
		tfNum1.setHorizontalAlignment(JTextField.CENTER);
		tfNum1.setPreferredSize(new Dimension(50, 40));
		
		cbGiho = new JComboBox<String>(strs);
		cbGiho.setPreferredSize(new Dimension(50, 40));
		cbGiho.addActionListener(this);
		
		tfNum2 = new JTextField(4);
		tfNum2.setHorizontalAlignment(JTextField.CENTER);
		tfNum2.setPreferredSize(new Dimension(50, 40));
		
		btnEqual = new JButton("=");
		btnEqual.setPreferredSize(new Dimension(50, 40));
		btnEqual.addActionListener(this);
		
		tfSeq = new JTextField(4);
		tfSeq.setHorizontalAlignment(JTextField.CENTER);
		tfSeq.setPreferredSize(new Dimension(50, 40));
		
		panCal.add(tfNum1);
		panCal.add(cbGiho);
		panCal.add(tfNum2);
		panCal.add(btnEqual);
		panCal.add(tfSeq);
		
		
		// 버튼 패널
		panBtns = new JPanel();
		
		btnSend = new JButton("결과 보내기");
		btnSend.addActionListener(this);
		
		btnClose = new JButton("닫기");
		btnClose.addActionListener(this);
		
		panBtns.add(btnSend);
		panBtns.add(btnClose);
		
		// 붙이기
		add(panInfo, BorderLayout.NORTH);
		add(panCal, BorderLayout.CENTER);
		add(panBtns, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		iNum1 = Integer.parseInt(tfNum1.getText());
		iNum2 = Integer.parseInt(tfNum2.getText());
		
		Object obj = e.getSource();
		
		if(obj == btnClose) {
			System.exit(0);
		}
		
		if(obj == btnEqual) {
			if(cbGiho.getSelectedItem() == "+") {
				sum = iNum1 + iNum2;
			} else if (cbGiho.getSelectedItem() == "-") {
				sum = iNum1 - iNum2;
			} else if (cbGiho.getSelectedItem() == "*") {
				sum = iNum1 * iNum2;
			} else if (cbGiho.getSelectedItem() == "/") {
				sum = iNum1 / iNum2;
			}
			tfSeq.setText(sum + "");
		}
		
		if (obj == btnSend) {
			am.getTa().append("계산결과:" + iNum1 + cbGiho.getSelectedItem().toString() + iNum2 + "=" + tfSeq.getText() + "\n");
		}
		
	}

}