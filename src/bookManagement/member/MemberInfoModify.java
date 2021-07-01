package bookManagement.member;

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

public class MemberInfoModify extends JFrame implements ActionListener {

	JPanel p1, p2, Last;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3;
	MemberList memberList;

	public MemberInfoModify(String title, int width, int height, MemberList memberList) {
		this.setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this); // 화면 가운데 찍음
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임
		// 종료버튼이 클릭될때 프로그램도 같이 사라짐
		this.memberList = memberList;

		p1 = new JPanel();
		l1 = new JLabel("회원 주민번호:");
		t1 = new JTextField(10);
		b1 = new JButton("검색");
		b1.addActionListener(this);
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 2));
		p2.setPreferredSize(new Dimension(280, 100));
		l2 = new JLabel("이름");
		t2 = new JTextField(10);
		p2.add(l2);
		p2.add(t2);
		l3 = new JLabel("주민번호");
		t3 = new JTextField(10);
		p2.add(l3);
		p2.add(t3);
		l4 = new JLabel("연락처");
		t4 = new JTextField(10);
		p2.add(l4);
		p2.add(t4);
		l5 = new JLabel("주소");
		t5 = new JTextField(10);
		p2.add(l5);
		p2.add(t5);

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

		try {
			DB.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setVisible(true);
	}

//	public static void main(String[] args) {
//		new MemberInfoModify("회원정보 수정", 300, 230);
//	}

	public void getNumSearch(String sql) {
		try {
			ResultSet rs = DB.getResultSet(sql);

			while (rs.next()) {
				t2.setText(rs.getString(1));
				t3.setText(rs.getString(2));
				t4.setText(rs.getString(3));
				t5.setText(rs.getString(4));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void getUserUpdate(String sql) {
		try {
			DB.executeQuery(sql);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b3) {
			this.dispose();
		} else if (obj == b1) {
			if (t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "주민번호를 입력해주세요!", "메시지", JOptionPane.ERROR_MESSAGE);
			} else {
				if (memberList.getNumCheck2(t1.getText())) {
					JOptionPane.showMessageDialog(null, "해당 주민번호가 없습니다.", "메시지", JOptionPane.ERROR_MESSAGE);
				} else {
					String sql = "select * from member where mb_num = '" + t1.getText() + "'";
					getNumSearch(sql);
				}
			}
		}
		else if(obj == b2) {
			String sql = "update member set mb_name='" + t2.getText() + "', " + "mb_num='" + t3.getText() + "', "
					+ "mb_phone='" + t4.getText() + "', " + "mb_addr='" + t5.getText() + "'"   + " where mb_num='"
					+ t1.getText() + "'";
			getUserUpdate(sql);
			JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			
		}

	}
}
