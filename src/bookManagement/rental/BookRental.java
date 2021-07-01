package bookManagement.rental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookRental extends JFrame implements ActionListener {
	//종하
	private JPanel p1,p2,p3,Last;
	private JButton b1,b2,b3,b4,b5;
	private JLabel j1,j2,j3,j4;
	private JTextField tx1,tx2,tx3,tx4;
	private JLabel j5;
	private JTextField tx5;
	private JLabel j6;
	private JTextField tx6;
	private JLabel j7;
	private JTextField tx7;
	private JPanel p4;
	private JPanel p5,p6;
	private JTable table;
	private JScrollPane scroll;
	private JPanel p7;
	public BookRental(String Title, int width, int height) {
		setTitle(Title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Last = new JPanel();
		Last.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		p3 = new JPanel();
		j1 = new JLabel("도서명");
		tx1 = new JTextField(14);
		b1 = new JButton("검색");
		p3.setPreferredSize(new Dimension(680, 40));


		p3.add(j1);
		p3.add(tx1);
		p3.add(b1);


		p4 = new JPanel();
		p4.setPreferredSize(new Dimension(180, 85));


		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
		j2 = new JLabel("도서번호");
		tx2 = new JTextField(10);
		j3 = new JLabel("저   자");
		tx3 = new JTextField(10);
		j4 = new JLabel("가  격");
		tx4 = new JTextField(10);
		b2 = new JButton("대여/반납");
		b2.addActionListener(this);
		b3 = new JButton("초기화");
		b4 = new JButton("새로고침");
		b5 = new JButton("돌아가기");b5.addActionListener(this);
		p1.setPreferredSize(new Dimension(180, 120));


		p1.add(j2);
		p1.add(tx2);
		p1.add(j3);
		p1.add(tx3);
		p1.add(j4);
		p1.add(tx4);



		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
		j5 = new JLabel("제    목");
		tx5 = new JTextField(10);
		j6 = new JLabel("출 판 사");
		tx6 = new JTextField(10);
		j7 = new JLabel("대출여부");
		tx7 = new JTextField(10);
		p2.setPreferredSize(new Dimension(180, 120));


		p2.add(j5);
		p2.add(tx5);
		p2.add(j6);
		p2.add(tx6);
		p2.add(j7);
		p2.add(tx7);


		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p5.setPreferredSize(new Dimension(680, 100));
		p5.add(b2);
		p5.add(b3);
		p5.add(b4);
		p5.add(b5);



		String header[] = {"도서번호","제목","저자","출판사","가격","대출여부"};
		String content[][] = {
				{"A016","빅 픽처","더글라스 케네디","땡땡땡","30000","N"},
				{"A013","더 잡","더글라스 케네디","땡땡땡","30000","N"},
				{"A014","모멘트","더글라스 케네디","땡땡땡","35000","N"},
				{"A015","위험한 관계","더글라스 케네디","땡땡땡","22000","N"},
				{"A016","빅 픽처","더글라스 케네디","땡땡땡","30000","N"},
				{"A013","더 잡","더글라스 케네디","땡땡땡","30000","N"},
				{"A014","모멘트","더글라스 케네디","땡땡땡","35000","N"},
				{"A015","위험한 관계","더글라스 케네디","땡땡땡","22000","N"}
		};


		table = new JTable(content,header);
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(680, 400));




		Last.add(p3);
		Last.add(p1);
		Last.add(p4);
		Last.add(p2);
		Last.add(p5);
		Last.add(scroll);


		add(Last);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BookRental("도서대여/반납",700,700);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b5) {
			this.dispose();
		}
		else if (obj == b2) {
			JOptionPane.showMessageDialog(null,"대여중인 도서입니다.","ErrorMessage",JOptionPane.ERROR_MESSAGE);
		}
	}

}