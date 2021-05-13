package swing.midterm.a;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame implements ActionListener {
	
	
	private JMenuBar mb;
	private JMenu me;
	private JMenuItem sub;
	private JTextArea tx;
	private Sub sf;
	

	
	

	//JFrame을 상속 받아 만드는 방법 << 이걸 더 선호함.
	public Main(String title, int width, int height) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		
		setMenu();
		
		tx = new JTextArea();
		tx.setLineWrap(true);
		JScrollPane sp = new JScrollPane(tx,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp);
		setVisible(true);
		
		
	}
	
	private void setMenu() {
		mb =  new JMenuBar();
		me = new JMenu("문제");
		sub = new JMenuItem("간단한 계산기");
		sub.addActionListener(this);
		
		me.add(sub);
		mb.add(me);
		
		setJMenuBar(mb);
		
	}

	public static void main(String[] args) {
		   new Main("학번 이름", 500, 400);
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == sub) {
			  sf = new Sub("간단한 계산기", 300, 150, this);
			  sf.setLocation(1200, 340);
		}
	}

	public JTextArea getTx() {
		return tx;
	}

	

}
