package bookManagement.book;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import bookManagement.BookMain;
import jdbc.DB;

public class BookManage extends JFrame implements ActionListener {
	private JPanel p1,p2,Last;
	private JButton b1,b2,b3,b4,b5,b6;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;	
	
	public BookManage(String Title, int width, int height) {
		setTitle(Title);
		setSize(width, height);
		private 
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1 = new JPanel();
		Last = new JPanel();

		b1 = new JButton("새로고침");
		b1.addActionListener(this);
		b2 = new JButton("등록");b2.addActionListener(this);
		b3 = new JButton("조회");b3.addActionListener(this);
		b4 = new JButton("수정");b4.addActionListener(this);
		b5 = new JButton("삭제");b5.addActionListener(this);
		b6 = new JButton("돌아가기");b6.addActionListener(this);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);

		String header[] = {"도서번호","제목","저자","출판사","가격","대출여부"};
		p2 = new JPanel();
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		scroll = new JScrollPane(table);	//Scroll 팬 생성 안하면 정상적으로 테이블 출력못함 
		BookSelectAll(model);
		p2.setBorder(new TitledBorder(new LineBorder(Color.gray,1),"도서목록"));
		//p2.setPreferredSize(new Dimension(460, 300));
		p2.add(scroll);

		Last.add(p1);
		Last.add(p2);
		add(Last);



		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			DB.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BookManage("도서관리",500,550);
	}
	
	public void BookSelectAll(DefaultTableModel model) {
		String sql = "select * from lib";
		try {
			ResultSet rs = DB.getResultSet(sql);
			for (int i = 0; i < model.getRowCount();) {
					model.removeRow(0);
			}
			while(rs.next()) {
				String [] data = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
				model.addRow(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getBookSearch(DefaultTableModel model, String word) throws Exception {
		String sql = "select * from lib where lib_name" + " LIKE '" + word.trim() + "'";
		
		ResultSet rs = DB.getResultSet(sql);
		for (int i = 0; i < model.getRowCount();) {
			model.removeRow(0);
		}
		while(rs.next()) {
			String data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
			//System.out.println("1번 " + rs.getString(1) + "2번 " + rs.getString(2) + "3번 " + rs.getString(3) + "4번 " + rs.getString(4));
			model.addRow(data);
		}
	}
	public boolean getBookCheck2(String booknum) {
		boolean result = true;
		
		String sql = "select * from lib where lib_code = '"+ booknum +"' ";
		try {
			ResultSet rs = DB.getResultSet(sql);
			if(rs.next()) {
				result = false;
			}
			else {
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public DefaultTableModel getModel() {
		return model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b6) {
			this.dispose();
			new BookMain("도서 관리 프로그램", 1008, 652);
		}
		else if(obj == b1) {
			BookSelectAll(model);
		}
		else if (obj == b2) {
			new BookRegistration("도서등록",350,290,this);
		}
		else if (obj == b3) {
			new BookSearch("도서검색", 300, 200,this);
		}
		else if (obj == b4) {
			new BookInfoModify("도서정보 수정", 350, 275,this);
		}
		else if (obj == b5) {
			new BookDelete("도서삭제", 300, 200,this);

		}
	}
}
