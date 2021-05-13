package swing.midterm.b;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {
	
	private JButton b1;
	private JButton b2;
	private JPanel p1;
	private Sub sf1;
	private Sub2 sf2;


	//JFrame을 상속 받아 만드는 방법 << 이걸 더 선호함.
	public Main(String title, int width, int height) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		p1 = new JPanel();
		b1 = new JButton("프레임 열기");
		b1.addActionListener(this);
		b2 = new JButton("종료");
		b2.addActionListener(this);
		p1.setLayout(new GridLayout(2, 1,10,10));
		p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p1.add(b1);
		p1.add(b2);
		
		add(p1);
		
		
		setVisible(true);
		
		
	}
	public Sub2 getSf2() {
		return sf2;
	}
	public static void main(String[] args) {
		new Main("메인", 180, 200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
				if(obj == b1) {
					sf1 = new Sub("간단한 계산기", 300, 150,this);
					sf1.setLocation(1050, 440);
					sf2 = new Sub2("결과", 300, 300);
					sf2.setLocation(1350, 440);
				}
				else if(obj == b2) {
					System.exit(0);
				}
	}
	
	
	

}
