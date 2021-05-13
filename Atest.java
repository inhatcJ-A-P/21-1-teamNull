package swing.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Atest extends JFrame implements ActionListener{		
		private JMenuBar mb;
		private JTextArea ta;
	public Atest(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(650, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		makeMenu();
		setJMenuBar(mb);
			
		setVisible(true);
	}

	private void makeMenu() {
		mb = new JMenuBar();
		
		JMenu menu = new JMenu("문제");
		mb.add(menu);
		
		JMenuItem item = new JMenuItem("간단한 계산기");
		item.addActionListener(this);
		menu.add(item);
		
		ta = new JTextArea();
		JScrollPane js = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(js);
		
	}

	public static void main(String[] args) {
		new Atest("201845089 이성호", 300, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Asubtest("간단한 계산기", 300, 150, this);
	}

	public JTextArea getTa() {
		return ta;
	}

}
