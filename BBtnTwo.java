package Test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BBtnTwo extends JFrame implements ActionListener{

	private JPanel jp1;
	private JButton btnopen;
	private JButton btnexit;
	private BbanTest bbanTest;
	private BResult bResult;
	
	
	
	public BBtnTwo(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2, 1,10,10));
		jp1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnopen = new JButton("프레임 열기");
		btnopen.addActionListener(this);
		
		btnexit = new JButton("종료");
		btnexit.addActionListener(this);
		
		jp1.add(btnopen);
		jp1.add(btnexit);
		
		add(jp1);
		setVisible(true);
		
	}


	public static void main(String[] args) {
		new BBtnTwo(" ", 100, 300);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnopen) {
			bbanTest = new BbanTest("간단한 계산기", 300, 150,this);
			bResult = new BResult("결과", 300, 300);
		}else if(obj == btnexit) {
			System.exit(0);
		}
		
	}


	public BResult getbResult() {
		return bResult;
	}


	


	

}
