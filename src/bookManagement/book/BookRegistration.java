package bookManagement.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.DB;

	
public class BookRegistration extends JFrame implements ActionListener {
	JButton b2;
	private JButton b1;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6;	
	private BookManage bookManage;
	public BookRegistration(String title,int width, int height, BookManage bookManage) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.bookManage = bookManage;
		JPanel p1 = new JPanel();
		JLabel l1 = new JLabel("도서등록");
		p1.add(l1);
		p1.setBackground(Color.DARK_GRAY);					//배경색
		p1.setPreferredSize(new Dimension(350, 35));
		l1.setForeground(Color.white);					//글씨 색

		l1.setFont(l1.getFont().deriveFont(16.0f));		//글씨 크기
		

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(6, 2));
		p2.setPreferredSize(new Dimension(330, 150));
		JLabel l2 = new JLabel("도서번호");
		 tf1 = new JTextField(10);
		JLabel l3 = new JLabel("제목");
		 tf2 = new JTextField(10);
		JLabel l4 = new JLabel("저자");
		 tf3 = new JTextField(10);
		JLabel l5 = new JLabel("출판사");
		 tf4 = new JTextField(10);
		JLabel l6 = new JLabel("가격");
		tf5 = new JTextField(10);
		JLabel l7 = new JLabel("대여정보");
		 tf6 = new JTextField(10);
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(tf2);
		p2.add(l4);
		p2.add(tf3);
		p2.add(l5);
		p2.add(tf4);
		p2.add(l6);
		p2.add(tf5);
		p2.add(l7);
		p2.add(tf6);


		l2.setForeground(Color.BLACK);					//글씨 색
		l2.setFont(l2.getFont().deriveFont(16.0f));
		l3.setForeground(Color.BLACK);					//글씨 색
		l3.setFont(l3.getFont().deriveFont(16.0f));
		l4.setForeground(Color.BLACK);					//글씨 색
		l4.setFont(l4.getFont().deriveFont(16.0f));
		l5.setForeground(Color.BLACK);					//글씨 색
		l5.setFont(l5.getFont().deriveFont(16.0f));
		l6.setForeground(Color.BLACK);					//글씨 색
		l6.setFont(l6.getFont().deriveFont(16.0f));
		l7.setForeground(Color.BLACK);					//글씨 색
		l7.setFont(l7.getFont().deriveFont(16.0f));


		JPanel p3 = new JPanel();
		b1 = new JButton("확인");
		b1.addActionListener(this);
		b2 = new JButton("취소");b2.addActionListener(this);
		b1.setPreferredSize(new Dimension(75, 40));		//버튼 크기조정
		b2.setPreferredSize(new Dimension(75, 40));		//버튼 크기조정
		b1.setForeground(Color.BLACK);					//글씨 색
		b1.setFont(l1.getFont().deriveFont(16.0f));
		b2.setForeground(Color.BLACK);					//글씨 색
		p3.add(b1);
		p3.add(b2);


		JPanel p4 = new JPanel();


		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		add(p4);




		setVisible(true);
	}
	
	public void InsertBookDB(String sql) {
		try {
			DB.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b2) {
			this.dispose();
		}
		else if(obj == b1) {
		
		
			if(tf6.getText().equals("Y")||tf6.getText().equals("N")) {
			if(bookManage.getBookCheck2(tf1.getText())) {
			
				String sql = "INSERT INTO lib VALUES ('"+ tf1.getText() +"', '"+ tf2.getText() +"', '"+ tf3.getText() + "', '" + tf4.getText() +  "', '" + tf5.getText() + "', '" + tf6.getText() + "')";
				InsertBookDB(sql);
				JOptionPane.showMessageDialog(null,"입력이 완료되었습니다.","메시지",JOptionPane.INFORMATION_MESSAGE);
				bookManage.BookSelectAll(bookManage.getModel());
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null,"중복된 도서번호가 있습니다.","메시지",JOptionPane.ERROR_MESSAGE);
			
			 }
			}else {
				JOptionPane.showMessageDialog(null, "Y나N만 입력해주세요");
			}
		
			
		}
	}

}
