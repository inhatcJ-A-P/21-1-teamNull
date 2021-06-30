package bookManagement.book;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookInfoModify extends JFrame implements ActionListener {
	//종하
	JPanel p1,p2,Last;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	

	public BookInfoModify(String title, int width, int height) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 

		p1 = new JPanel();
		l1 = new JLabel("도서번호:");
		t1 = new JTextField(10);
		b1 = new JButton("검색");
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		

		p2 = new JPanel();
		p2.setLayout(new GridLayout(6, 2));
		p2.setPreferredSize(new Dimension(330, 150));
		l2 = new JLabel("도서번호");
		t2 = new JTextField(10);
		p2.add(l2);
		p2.add(t2);
		l3 = new JLabel("제목");
		t3 = new JTextField(10);
		p2.add(l3);
		p2.add(t3);
		l4 = new JLabel("저자");
		t4 = new JTextField(10);
		p2.add(l4);
		p2.add(t4);
		l5 = new JLabel("출판사");
		t5 = new JTextField(10);
		p2.add(l5);
		p2.add(t5);
		l6 = new JLabel("가격");
		t6 = new JTextField(10);
		p2.add(l6);
		p2.add(t6);
		l7 = new JLabel("대여여부");
		t7 = new JTextField(10);
		p2.add(l7);
		p2.add(t7);
		
		b2 = new JButton("수정");
		b3 = new JButton("돌아가기");
		b3.addActionListener(this);

		Last = new JPanel();
		Last.add(p1);
		Last.add(p2);
		Last.add(b2);
		Last.add(b3);
		add(Last);
		

		setVisible(true);
	}
	

	public static void main(String[] args) {
		new BookInfoModify("도서정보 수정", 350, 275);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b3) {
			this.dispose();
		}
	}

}