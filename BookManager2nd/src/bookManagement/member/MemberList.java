package bookManagement.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import bookManagement.BookMain;
import jdbc.DB;

public class MemberList extends JFrame implements ActionListener {
	private JPanel p1, p2, Last;
	private JButton b1, b2, b3, b4, b5, b6;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement st;
	
	public DefaultTableModel getModel() {
		return model;
	}

	public MemberList(String Title, int width, int height) {
		setTitle(Title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		Last = new JPanel();
		b1 = new JButton("새로고침");
		b1.addActionListener(this);
		b2 = new JButton("등록");
		b3 = new JButton("조회");
		b4 = new JButton("수정");
		b5 = new JButton("삭제");
		b6 = new JButton("돌아가기");
		p1.add(b1);
		p1.add(b2);
		b2.addActionListener(this);
		p1.add(b3);
		b3.addActionListener(this);
		p1.add(b4);
		b4.addActionListener(this);
		p1.add(b5);
		b5.addActionListener(this);
		p1.add(b6);
		b6.addActionListener(this);

		String header[] = {"이름","주민번호","전화번호","주소"};

		p2 = new JPanel();
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		scroll = new JScrollPane(table); // Scroll 팬 생성 안하면 정상적으로 테이블 출력못함
		p2.setBorder(new TitledBorder(new LineBorder(Color.gray, 1), "회원목록"));
		p2.add(scroll);
		userSelectAll(model);
		
		


		Last.add(p1);
		Last.add(p2);
		add(Last);

		setVisible(true);
	}



	public void userSelectAll(DefaultTableModel model) {
		String sql = "select * from member";
		try {
		 ResultSet rs = DB.getResultSet(sql);
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			
			while(rs.next()) {
				String data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) };
				model.addRow(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//인수로 들어온 num에 해당하는 레코드 검색하여 중복여부 체크하기 return = true 사용가능, false이면 중복임
	public boolean getNumCheck(String num) {
		boolean result = true;
		
		
		//preparestatemnet 사용하면 ''를 안써도 된다. ?에 데이터 값을 넣기 때문에 sql 사용이 쉬워짐
		// 위에 num 값이 아래 sql ?에 들어감
		String sql = "select * from member where mb_num = ?";
		try {
			//쿼리를 생성하고 실행할때 statemnet 랑 preparedStatement 방법이 있는데 둘의 차이점은 캐시 사용 유무이다.
			// preparestatement는 객체를 캐시에 담아 재사용하기에 반복적으로 쿼리를 수행한다면 statement에 비해 성능이 좋다
			// statement는 취약점을 갖짐
			ps = DB.conn.prepareStatement(sql);
			//1번 인덱스를 스트링 값으로 지정한다.
			ps.setString(1, num.trim());
			//executeQuery는 select문 쓸때 사용 execyteUpdate는 insert나 update 등등
			rs = ps.executeQuery();
			if(rs.next()) {
				//레코드가 존재하면 false 즉, 중복
				result = false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public boolean getNumCheck2(String num) {
		boolean result = true;
		
		String sql = "select * from member where mb_num = '"+ num +"' ";
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
	
	
	public void getNumSearch(DefaultTableModel model, String word) {
		String sql = "select * from member where mb_num" + " LIKE '%" + word.trim() + "%'";
		
		try {
			st = DB.conn.createStatement();
			rs = st.executeQuery(sql);
			
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			while(rs.next()) {
				String data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) };
				model.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		new MemberList("회원목록", 500, 600);
	}

	public JTable getTable() {
		return table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b2) {
			new MemberRegister("회원등록", 350, 240,this);
		} else if (obj == b3) {
			new MemberSearch("회원검색", 300, 200,this);
		} else if (obj == b4) {
			new MemberInfoModify("회원정보 수정", 300, 230,this);
		} else if (obj == b5) {
			new MemberDelete("회원삭제", 300, 200,this);
		} else if (obj == b6) {
			this.dispose();
			new BookMain("도서 관리 프로그램", 1008, 652);
		}
		else if(obj == b1) {	
			userSelectAll(model);
		}
		
	}

}
