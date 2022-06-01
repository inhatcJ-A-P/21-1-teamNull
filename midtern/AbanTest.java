package Test;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AbanTest extends JFrame implements ActionListener{

	private JMenuBar jm;
	private JMenuItem Calc;
	private JMenu pro;
	private JTextArea ta;
	private JPanel jp;
	private JScrollPane scroll;
	private Asubframe as;


	public AbanTest(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(500, 300);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		makeMenu();
		
		
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		ta = new JTextArea(7,15);
		ta.setEditable(false);
		scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp.add(scroll);
		
		add(jm, BorderLayout.NORTH);
		add(jp, BorderLayout.CENTER);
		setVisible(true);
		
	}


	private void makeMenu() {
		jm = new JMenuBar();
		
		pro = new JMenu("문제");
		
		Calc = new JMenuItem("간단계산기");
		Calc.addActionListener(this);
		pro.add(Calc);
		
		jm.add(pro);
		
	}


	public static void main(String[] args) {
		new AbanTest("202045101 김민주", 300, 300);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 Object obj = e.getSource();
		 
		 if(obj == Calc) {
			 as = new Asubframe("202045101 김민주", 300, 150, this);
		 }
	}


	public JTextArea getTa() {
		return ta;
	}


	public void setTa(JTextArea ta) {
		this.ta = ta;
	}
	
}
