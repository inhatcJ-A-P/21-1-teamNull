package Train;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RogIn extends JFrame implements ActionListener{

	private JPanel jp1;
	private JPanel jp2;
	private JLabel lblid;
	private JLabel lblpw;
	private JTextField tf1;
	private JPasswordField tf2;
	private JButton btn;
	private JOptionPane no;
	private MainPro sf;


	public RogIn(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		jp1 = new JPanel();
		
		lblid = new JLabel("ID :");
		jp1.add(lblid);
		tf1 = new JTextField(20);
		tf1.addActionListener(this);
		jp1.add(tf1);
		
		lblpw = new JLabel("PW :");
		jp1.add(lblpw);
		tf2 = new JPasswordField(20);
		tf2.addActionListener(this);
		jp1.add(tf2);
		
		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout(0,0));
		btn = new JButton("Login");
		btn.addActionListener(this);
		jp2.add(btn, BorderLayout.CENTER);
		
	
		
		setVisible(true);
		 
		add(jp1, BorderLayout.CENTER);
		add(jp2, BorderLayout.SOUTH);
	}


	public static void main(String[] args) {
		new RogIn("로그인", 260, 150 );
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn) {
			if(!tf1.getText().equals("japjjang")&&!tf2.getText().equals("1111")) {
				no = new JOptionPane();
				no.showMessageDialog(null, "id 또는 password를 확인해 주세요","",JOptionPane.ERROR_MESSAGE);
			} else  {
				no.showMessageDialog(null, "JAP대장님 환영합니다");
				sf = new MainPro("메인", 600, 500, this);
			}
			
		}
	}

}
