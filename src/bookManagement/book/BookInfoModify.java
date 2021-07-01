package bookManagement.book;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.DB;

public class BookInfoModify extends JFrame implements ActionListener {
	JPanel p1,p2,Last;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	private BookManage bookManage;

	public BookInfoModify(String title, int width, int height, BookManage bookManage) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		setResizable(false);//화면 크기 변경 막음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		this.bookManage = bookManage;
		p1 = new JPanel();
		l1 = new JLabel("도서번호:");
		t1 = new JTextField(10);
		b1 = new JButton("검색");
		b1.addActionListener(this);
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
		b2.addActionListener(this);
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
	

//	public static void main(String[] args) {
//		try {
//			DB.init();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		new BookInfoModify("도서정보 수정", 350, 275);
//	}

	private void getBookSearch(String sql) {
		try {
			ResultSet rs = DB.getResultSet(sql);
			while(rs.next()) {
				t2.setText(rs.getString(1));
				t3.setText(rs.getString(2));
				t4.setText(rs.getString(3));
				t5.setText(rs.getString(4));
				t6.setText(rs.getString(5));
				t7.setText(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getBookUpdate(String sql)  {
		try {
			DB.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b3) {
			this.dispose();
		}
		else if (obj == b1) {
			if(t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "도서번호를 입력해주세요!", "메시지", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(bookManage.getBookCheck2(t1.getText())) {
					JOptionPane.showMessageDialog(null, "해당 도서번호가 없습니다.", "메시지", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String sql = "select * from lib where lib_code = '" + t1.getText() + "'";
					getBookSearch(sql);
				}
			}
		}
		else if(obj == b2) {
		if(t7.getText().equals("Y")||t7.getText().equals("N")){
			String sql = "update lib set lib_code='" + t2.getText() + "', " + "lib_name='" + t3.getText() + "', "
					+ "lib_author='" + t4.getText() + "', " + "lib_publisher='" + t5.getText() + "', lib_price='" + t6.getText() + "', lib_state='" + t7.getText() + "' " + " where lib_code='"
					+ t1.getText() + "'";
			getBookUpdate(sql); 
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Y나N만 입력해주세요");
		}
		}
		
}
}
