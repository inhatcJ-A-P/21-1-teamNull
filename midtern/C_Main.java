package c;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import a.A_Calculator;

public class C_Main extends JFrame implements ActionListener {
	
	private String[] result = {};

	private JMenuBar mb;
	private JMenu menuMenu;
	private JMenuItem menuItemOpen;

	private JList lstResult;

	private DefaultListModel listModel;

	public C_Main(String title, int width, int height) {
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
		
		listModel = new DefaultListModel();
		
		lstResult = new JList<>(listModel);
		
		JScrollPane sp = new JScrollPane(lstResult, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(sp);	// lstResult 말고 sp를 붙여야 스크롤 생김
		
		setVisible(true);
	}
	
	private void makeMenu() {

		mb = new JMenuBar();
		
		menuMenu = new JMenu("문제");

		menuItemOpen  = new JMenuItem("간단 계산기");
		menuItemOpen.addActionListener(this);
		menuMenu.add(menuItemOpen);
		
		mb.add(menuMenu);	
		
	}

	public static void main(String[] args) {
		new C_Main("My 프레임", 300, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		Object obj = e.getSource();
		
		if (obj == menuItemOpen) {
			new C_Calculator("202045053 지수빈", 350, 200, this);
		}
		
	}

	public JList getLstResult() {
		return lstResult;
	}

	public void setLstResult(JList lstResult) {
		this.lstResult = lstResult;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}
	
}
