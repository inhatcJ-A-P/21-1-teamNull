package swing.test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Btest extends JFrame implements ActionListener{

	private JButton btnOpen, btnExit;
	private Bsubtest b1;
	private Bsubsubtest b2;

	public Bsubtest getB1() {
		return b1;
	}

	public Bsubsubtest getB2() {
		return b2;
	}

	public Btest(int width, int height) {
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(650, 350);
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2, 1, 10, 10));
		pan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnOpen = new JButton("프레임 열기");
		btnOpen.addActionListener(this);
		pan.add(btnOpen);
		
		btnExit = new JButton("종료");
		btnExit.addActionListener(this);
		pan.add(btnExit);
		add(pan);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Btest(150 ,200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnOpen) {
		b1 = new Bsubtest("간단한 계산기", 300, 150, this);
		b2 = new Bsubsubtest("결과", 300, 300);
		} else if(obj == btnExit) {
			System.exit(0);
		}
	}

}
