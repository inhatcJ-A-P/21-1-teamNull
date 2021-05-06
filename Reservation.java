package train.ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reservation extends JFrame implements MouseListener, ActionListener {
	
	private String[] str0 = {"전체", "KTX", "새마을호", "무궁화호"};	
	private String[] str1 = {"서울역", "대전역", "대구역", "광주역", "부산역"};
	private JComboBox<String> cbKinds;
	private JPanel panBottom;
	private JLabel[] str2 = {new JLabel("Seoul") , new JLabel("Daejun"), new JLabel("Daegu"), new JLabel("Kwangju"), new JLabel("Busan")};
//	private JList<String> Station;
	private JLabel lblStartB;
	private JLabel lblStopB;
	private JButton btnSelect;
	 
	public Reservation(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		setLayout(new BorderLayout());	
		
		PanCenTer();
		
		setVisible(true);
	}


	private void PanCenTer() {
		panBottom = new JPanel();
		
		panBottom.setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/TrainMap.jpg");
		JLabel img = new JLabel(icon);
		img.setBounds(10, 10, 265, 270);
		
		str2[0] = new JLabel(str1[0]);
		str2[0].addMouseListener(this);
		str2[0].setBounds(85, 50, 50, 50);
		
		str2[1] = new JLabel(str1[1]);
		str2[1].addMouseListener(this);
		str2[1].setBounds(110, 120, 50, 50);
		
		str2[2] = new JLabel(str1[2]);
		str2[2].addMouseListener(this);
		str2[2].setBounds(180, 155, 50, 50);
		
		str2[3] = new JLabel(str1[3]);
		str2[3].addMouseListener(this);
		str2[3].setBounds(70, 190, 50, 50);
		
		str2[4] = new JLabel(str1[4]);
		str2[4].addMouseListener(this);
		str2[4].setBounds(215, 195, 50, 50);
		
		JLabel lblStartA = new JLabel("출발역:");
		lblStartA.setBounds(15, 280, 40, 40);
		lblStartB = new JLabel("");
		lblStartB.setBounds(140, 280, 40, 40);
		JLabel lblStopA = new JLabel("도착역:");
		lblStopA.setBounds(15, 310, 40, 40);
		lblStopB = new JLabel("");
		lblStopB.setBounds(140, 310, 40, 40);
		JLabel lblKinds = new JLabel("열차종류:");
		lblKinds.setBounds(15, 340, 70, 40);
		cbKinds = new JComboBox<String>(str0);
		cbKinds.setBounds(140, 350, 90, 20);
//		
//		Station = new JList<String>(str2);
//		Station.setBounds(500, 500, 50, 50);
		
		panBottom.add(lblStartA);
		panBottom.add(lblStartB);
		panBottom.add(lblStopA);
		panBottom.add(lblStopB);
		panBottom.add(lblKinds);
		panBottom.add(cbKinds);
		panBottom.add(str2[0]);
		panBottom.add(str2[1]);
		panBottom.add(str2[2]);
		panBottom.add(str2[3]);
		panBottom.add(str2[4]);
		panBottom.add(img);
		//panBottom.add(Station);
		
		
		btnSelect = new JButton("열차조회");
		btnSelect.setBounds(105, 385, 90, 25);
		btnSelect.addActionListener(this);
		panBottom.add(btnSelect);
			
		add(panBottom);
	}

	public static void main(String[] args) {
		new Reservation("승차권예매", 300, 460);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel obj = (JLabel)e.getSource();
		
		if(e.isMetaDown())	{
		for(int i = 0; i < 5; i++) {
			if(obj.getText().equals(str1[i])) {
				lblStopB.setText(str1[i]);
				str2[i].setForeground(Color.BLUE);
			} else {
				str2[i].setForeground(Color.BLACK);
			}
		}
		
		
	} else  {
		for(int i = 0; i < 5; i++) {
			if(obj.getText().equals(str1[i])) {
				lblStartB.setText(str1[i]);
				str2[i].setForeground(Color.RED);
			} else {
				str2[i].setForeground(Color.BLACK);
			}
		}
	}
}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnSelect) {
			new Result("조회결과", 600, 550);
		}
	}
}
