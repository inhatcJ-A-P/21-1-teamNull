package bookManagement.member;

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

public class MemberRegister extends JFrame implements ActionListener {
	//종하
	
	private JButton b1,b2;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private MemberList memberList;
	public MemberRegister(String title,int width, int height, MemberList memberList) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.memberList = memberList;


		JPanel p1 = new JPanel();
		JLabel l1 = new JLabel("회원등록");
		p1.add(l1);
		p1.setBackground(Color.DARK_GRAY);					//배경색
		p1.setPreferredSize(new Dimension(350, 35));
		l1.setForeground(Color.white);					//글씨 색
		l1.setFont(l1.getFont().deriveFont(16.0f));		//글씨 크기



		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 2));
		p2.setPreferredSize(new Dimension(330, 100));
		JLabel l2 = new JLabel("이름:");
		 tf1 = new JTextField(10);
		JLabel l3 = new JLabel("주민번호:");
		 tf2 = new JTextField(10);
		JLabel l4 = new JLabel("연락처:");
		 tf3 = new JTextField(10);
		JLabel l5 = new JLabel("주소:");
		 tf4 = new JTextField(10);
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(tf2);
		p2.add(l4);
		p2.add(tf3);
		p2.add(l5);
		p2.add(tf4);

		l2.setForeground(Color.BLACK);					//글씨 색
		l2.setFont(l1.getFont().deriveFont(16.0f));
		l3.setForeground(Color.BLACK);					//글씨 색
		l3.setFont(l1.getFont().deriveFont(16.0f));
		l4.setForeground(Color.BLACK);					//글씨 색
		l4.setFont(l1.getFont().deriveFont(16.0f));
		l5.setForeground(Color.BLACK);					//글씨 색
		l5.setFont(l1.getFont().deriveFont(16.0f));

		JPanel p3 = new JPanel();
		 b1 = new JButton("확인");
		b1.addActionListener(this);
		b2 = new JButton("취소"); 
		b2.addActionListener(this);
		b1.setPreferredSize(new Dimension(75, 40));		//버튼 크기조정
		b2.setPreferredSize(new Dimension(75, 40));		//버튼 크기조정
		b1.setForeground(Color.BLACK);					//글씨 색
		b1.setFont(l1.getFont().deriveFont(16.0f));
		b2.setForeground(Color.BLACK);					//글씨 색
		b2.setFont(l1.getFont().deriveFont(16.0f));

		p3.add(p1);
		p3.add(p2);
		p3.add(b1);
		p3.add(b2);
		add(p3);
		
	
		
		
	
		setVisible(true);
	}

	private void setInsertDB(String sql) {
		try {
		
			DB.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	public static void main(String[] args) {
//			new MemberRegister("회원등록",350,240);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b2) {
			this.dispose();
		}
		else if(obj == b1) {
			//if가 false이면 아래 else 찍음
			if(memberList.getNumCheck2(tf2.getText())) {
				String sql = "INSERT INTO member VALUES ('"+ tf1.getText() +"', '"+ tf2.getText() +"', '"+ tf3.getText() + "', '" + tf4.getText() + "')";
				setInsertDB(sql);
				JOptionPane.showMessageDialog(null,"처리가 완료되었습니다.","메시지",JOptionPane.INFORMATION_MESSAGE);
				memberList.userSelectAll(memberList.getModel());
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null,"주민번호 중복입니다.","메시지",JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

} 
