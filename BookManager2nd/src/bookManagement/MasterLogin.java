package bookManagement;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import jdbc.DB;

public class MasterLogin extends JFrame implements ActionListener {
	private JButton b1, b2;
	private JTextField tf1;
	private	JPasswordField tf2;
	private BookMain gm;

	public MasterLogin(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pa1 = new JPanel();
		pa1.setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("images/Intro.jpg");
		JLabel imgLabel = new JLabel(img);
		pa1.add(imgLabel);
		pa1.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
		add(pa1, BorderLayout.NORTH);
		
		JPanel pa2 = new JPanel();
		
		JLabel lb1 = new JLabel("ID : ");
		tf1 = new JTextField(10);
		pa2.add(lb1);
		pa2.add(tf1);
		
		JLabel lb2 = new JLabel("PW : ");
		tf2 = new JPasswordField(10);
		pa2.add(lb2);
		pa2.add(tf2);
		
		b1 = new JButton("로그인");
		b1.addActionListener(this);
		
	    b2 = new JButton("종료");
	    b2.addActionListener(this);
	    
		pa2.add(b1);
		pa2.add(b2);
		
		add(pa2);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			DB.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MasterLogin("관리자 로그인", 950, 430);
	}
	
	private boolean checkIDPW(String id, String pw) {
		boolean check = false;
		String sql = "SELECT * FROM admin WHERE id = '" + id +"' AND PW = '" + pw + "' " ;
		try {
			ResultSet rs = DB.getResultSet(sql);
			
			if(rs.next()) {
				check = true;
			}
			else {
				check = false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(b1 == obj) {
			String id = tf1.getText();
			String pw = tf2.getText();
			
			boolean check = checkIDPW(id, pw);
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "ID를 입력해주세요. ","로그인",JOptionPane.ERROR_MESSAGE);
			}
			else if(pw.equals("")) {
				JOptionPane.showMessageDialog(null, "PW를 입력해주세요. ","로그인",JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(check) {
					JOptionPane.showMessageDialog(null, "로그인 성공","로그인",JOptionPane.INFORMATION_MESSAGE);
					new BookMain("도서 관리 프로그램", 1008, 652);
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인 실패","로그인",JOptionPane.ERROR_MESSAGE);
					tf1.setText("");
					tf2.setText("");
					tf1.requestFocus();
				}
			}
				
			
		}
		else if(b2 == obj) {
			this.dispose();
		}
	}

} 
