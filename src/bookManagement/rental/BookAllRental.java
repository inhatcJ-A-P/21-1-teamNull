package bookManagement.rental;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import sun.tools.jps.Jps;

public class BookAllRental extends JFrame implements ActionListener{
	JButton jb;

	public BookAllRental(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		JPanel nPanel = new JPanel();
		jb = new JButton("돌아가기");
		nPanel.add(jb);
		jb.addActionListener(this);
		add(nPanel,BorderLayout.NORTH);

		JPanel cPanel = new JPanel();
		String header[] = {"대여번호","회원이름","회원전화","도서이름","도서번호","날짜"};
		String contents[][]= {
				{"1","이규남"," 010-1111-1111","개구쟁5이", "A11","10-11"},
				{"2","이규남"," 010-1111-1111","개구쟁이", "A11","10-11"},
				{"3","이규남"," 010-1111-1111","개구쟁이", "A11","10-11"},
				{"4","이규남"," 010-1111-1111","개구쟁이", "A11","10-11"},
				{"5","이규남"," 010-1111-1111","개구쟁이", "A11","10-11"},

		};
		JTable tb = new JTable(contents,header);
		JScrollPane sp =new JScrollPane(tb);
		cPanel.add(sp);
		add(cPanel,BorderLayout.CENTER);



		setVisible(true);
	}//end of ListEx

	public static void main(String[] args) {
		new BookAllRental("대여 정보",500,600);

	}//end of main

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jb) {
			this.dispose();
		}
	}

}//end of class