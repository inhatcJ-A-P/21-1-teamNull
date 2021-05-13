package swing.midterm.b;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sub2 extends JFrame implements ActionListener {
	
	

	private JPanel p1;
	private JPanel p2;
	private JLabel l1;
	private JTextField tx1;
	private JButton b1;
	private JLabel[] star;
	private int temp;
	private int x;
	private int y;
	private int test = 0;
	
	
	//JFrame을 상속 받아 만드는 방법 << 이걸 더 선호함.
	public Sub2(String title, int width, int height) {

		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		
		p1 = new JPanel();
		p1.setBackground(Color.pink);
		l1 = new JLabel("별의 갯수 : ");
		tx1 = new JTextField("0",5);
		tx1.setHorizontalAlignment(JTextField.RIGHT);
		b1 = new JButton("그리기");
		b1.addActionListener(this);
		p1.add(l1);
		p1.add(tx1);
		p1.add(b1);
		
		p2 = new JPanel();
		p2.setLayout(null);
		
		add(p1,BorderLayout.NORTH);
		add(p2);
		
		
		setVisible(true);
	}
	public JTextField getTx1() {
		return tx1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == b1) {
			temp = Integer.parseInt(tx1.getText());
			star = new JLabel[temp];
			
			if(test == 0) {
				for (int i = 0; i < star.length; i++) {
					star[i] = new JLabel("*");
					x = (int) (Math.random()*280);
					y = (int) (Math.random()*215);
					star[i].setBounds(x,y, 20, 20);	
					p2.add(star[i]);
				}
				test = 1;
			}
			else {
				p2.removeAll();
				for (int i = 0; i < star.length; i++) {
					star[i] = new JLabel("*");
					x = (int) (Math.random()*280);
					y = (int) (Math.random()*215);
					star[i].setBounds(x,y, 20, 20);	
					p2.add(star[i]);
				}
			}
			p2.revalidate();		// 자바 스윙에서 컨트롤을 동적 변화 시켯을때 아래 명령어를 써줘야함 업데이트 느낌?
			p2.repaint();
		}
		
	}
	
	
}
