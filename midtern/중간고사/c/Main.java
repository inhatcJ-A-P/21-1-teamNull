package swing.midterm.c;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class Main extends JFrame implements ActionListener {
	
	private JList<String> list;
	private JMenuBar mb;
	private JMenu con;
	private JMenuItem sub;
	private Vector<String> v;
	private JLabel label;
	private Sub sf;
	//JFrame을 상속 받아 만드는 방법 << 이걸 더 선호함.
	public Main(String title, int width, int height) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		//setLayout(new FlowLayout());
		
		setMenu();
		v = new Vector<String>();
		list = new JList<String>(v);
		JScrollPane sc = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(sc);
		
		
		
		setVisible(true);
		
		
	}
	
	private void setMenu() {
		mb = new JMenuBar();
		con = new JMenu("메뉴");
		sub = new JMenuItem("서브프레임");
		sub.addActionListener(this);
		
		con.add(sub);
		mb.add(con);
		setJMenuBar(mb);
		
		
	}

	public static void main(String[] args) {
		new Main("메인 프레임", 300, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			sf = new Sub("서브프레임", 250, 180,this);
			sf.setLocation(1100, 390);
	}

	public Vector<String> getV() {
		return v;
	}

	public JList<String> getList() {
		return list;
	}

}
