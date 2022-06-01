package bookManagement.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jdbc.DB;

public class MemberDelete extends JFrame implements ActionListener {
 	
	private JPanel p1, p2, Last;
	private JButton b1, b2;
	private JLabel l1, l2;
	private JTextField t1;

	MemberList memberList;
	public MemberDelete(String title, int width, int height, MemberList memberList) {
		this.setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this); // 화면 가운데 찍음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐

		p1 = new JPanel();
		l1 = new JLabel("회원삭제");
		p1.setBackground(Color.DARK_GRAY);
		l1.setForeground(Color.WHITE);
		l1.setFont(l1.getFont().deriveFont(14.0f));
		p1.setPreferredSize(new Dimension(390, 30));
		p1.add(l1);
		this.memberList = memberList;
		p2 = new JPanel();
		l2 = new JLabel("회원주민번호:");
		t1 = new JTextField(10);
		p2.setPreferredSize(new Dimension(300, 80));
		p2.add(l2);
		p2.add(t1);

		b1 = new JButton("삭제");
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

	public void UserDelete(String sql) {

		try {
			DB.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		new MemberDelete("회원삭제", 300, 200);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b2) {
			this.dispose();
		} else if (obj == b1) {
			if(t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "주민번호를 입력해주세요.", "메시지", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(memberList.getNumCheck2(t1.getText())) {
					JOptionPane.showMessageDialog(null, "해당 주민번호가 없습니다..", "메시지", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String sql = "delete from member where mb_num='" + t1.getText() + "'";
					UserDelete(sql);
					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					t1.setText("");
				}
			}


		}
	}

}
