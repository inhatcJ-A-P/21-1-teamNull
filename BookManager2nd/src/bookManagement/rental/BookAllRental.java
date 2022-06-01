package bookManagement.rental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import bookManagement.BookMain;
import jdbc.DB;

//민주 수정
public class BookAllRental extends JFrame implements ActionListener{
	
	
	 private JButton btnReturn;
	 private JPanel jpTable,jpButton;
	 private JTable tb;
	 private JScrollPane sp;
	 private BookRental bookRental;
	 private BookMain bookMain;
	 private DefaultTableModel model;
	 private PreparedStatement ps;
	 private ResultSet rs;
	 private Statement st;
	 private String header[] = {"대여번호","회원이름","회원전화","도서이름","도서번호","날짜"};
	 
	 public DefaultTableModel getModel() {
		 return model;
	 }
	 

	public BookAllRental(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		//돌아가기 패널
		jpButton = new JPanel();
		btnReturn = new JButton("돌아가기");
		jpButton.add(btnReturn);
		btnReturn.addActionListener(this);
		add(jpButton,BorderLayout.NORTH);

		//테이블 패널
		jpTable = new JPanel();
		model = new DefaultTableModel(header,0);
		 tb = new JTable(model);
		 sp =new JScrollPane(tb);
		jpTable.add(sp);
		sp.setPreferredSize(new Dimension(485, 600));
		add(jpTable,BorderLayout.CENTER);
		createTable(model);
		



		setVisible(true);
	}

	private void createTable(DefaultTableModel model) {
		
		String sql = "select * from rent";
		
		try {
			rs = DB.getResultSet(sql);
			for(int i = 0; i<model.getRowCount();) {
				model.removeRow(0);
			}
			while(rs.next()) {
				String data[] = {rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
				model.addRow(data);
			}
		} catch (Exception e) {
			//작성된 sql문 확인
			System.out.println(sql);
			e.printStackTrace();
		}
		
		
	}


	public static void main(String[] args) {
		try {
			DB.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BookAllRental("대여 정보",500,600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnReturn) {
			//돌아가기 구현
			bookMain = new BookMain("도서 관리 프로그램", 1008, 652);
			this.dispose();
		}
	}

}