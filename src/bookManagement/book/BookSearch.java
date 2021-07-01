package bookManagement.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookSearch extends JFrame implements ActionListener {

	JPanel p1,p2,Last;
	JButton b1,b2;
	JLabel l1,l2;
	JTextField t1;
	BookManage bookManage;
	public BookSearch(String title, int width, int height, BookManage bookManage) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		this.bookManage = bookManage;
		p1 = new JPanel();
		l1 = new JLabel("도서검색");
		p1.setBackground(Color.DARK_GRAY);
		l1.setForeground(Color.WHITE);
		l1.setFont(l1.getFont().deriveFont(14.0f));
		p1.setPreferredSize(new Dimension(390, 30));
		p1.add(l1);

		p2 = new JPanel();
		l2 = new JLabel("도서제목:");
		t1 = new JTextField(10);
		p2.setPreferredSize(new Dimension(300, 80));
		p2.add(l2);
		p2.add(t1);

		b1 = new JButton("검색");
		b1.addActionListener(this);
		b2 = new JButton("취소");
		b2.addActionListener(this);
		Last = new JPanel();
		Last.add(p1);
		Last.add(p2);
		Last.add(b1);
		Last.add(b2);
		add(Last);
		setVisible(true);
	}

//	public static void main(String[] args) {
//		new BookSearch("도서검색", 300, 200);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b2) {
			this.dispose();
		}
		else if(obj == b1) {
			try {
				bookManage.getBookSearch(bookManage.getModel(), t1.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"검색이 완료되었습니다.","메시지",JOptionPane.INFORMATION_MESSAGE);
		}
	}

} 