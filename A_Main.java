package a;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class A_Main extends JFrame implements ActionListener {

	private JTextArea ta;
	private JMenuBar mb;
	private JMenu menuMenu;
	private JMenuItem menuItemOpen;

	public A_Main(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 창 크기 변경 제한
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		// 메뉴 추가
		makeMenu();
		
		this.setJMenuBar(mb);
		
		// 텍스트 아리아 추가
		ta = new JTextArea();
		ta.setLineWrap(true);	// 공간이 부족하면 밑으로 줄을 바꿔줌
		
		JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// 붙이기
		add(sp);
		
		// 보이기
		setVisible(true);
	}
	
	// 메뉴 만들기 메소드
	private void makeMenu() {

		mb = new JMenuBar();
		
		menuMenu = new JMenu("문제");

		menuItemOpen  = new JMenuItem("간단 계산기");
		menuItemOpen.addActionListener(this);
		menuMenu.add(menuItemOpen);
		
		mb.add(menuMenu);	
		
	}

	public static void main(String[] args) {
		new A_Main("202045053 지수빈", 350, 350);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		
		if (obj == menuItemOpen) {
			new A_Calculator("간단한 계산기", 350, 150, this);
		}
		
	}

	public JTextArea getTa() {
		return ta;
	}

	
	
}
