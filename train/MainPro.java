package Train;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//민주
public class MainPro extends JFrame{

	private String mt[]  = {"열차","출발시간","도착역","도착시간"};
	private String contents[][]  = {
			{"새마을호", "10:41", "대전역", "12:31"},
			{"무궁화호", "15:48", "대전역", "16:11"},
			{"KTX", "15:48", "부산역", "19:08"},
			{"새마을호", "17:34", "부산역", "20:24"},
			{"무궁화호", "17:54", "부산역", "20:24"},
			{"새마을호", "20:20", "대구역", "22:20"},
	};
	private String []  station = {"서울역","대전역","대구역","부산역","광주역"};
	private JPanel jp1;
	private JPanel jp2;
	private JComboBox<String> cb;
	private JLabel lbl;
	private JTable table;
	private JScrollPane sp;
	private JPanel jp3;
	private JButton btn2;
	private JButton btn3;
	private JButton btn1;


	public MainPro(String title, int width, int height, RogIn rogIn ) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(1, 200, 0));
		
		cb = new JComboBox<String>(station);
		jp1.add(cb);
		
		lbl = new JLabel("현재시각 : 12:22", JLabel.RIGHT);
		jp1.add(lbl);
		
		jp2 = new JPanel();
		table = new JTable(contents, mt);
		table.setSize(500, 400);
		jp2.add(table);
		sp = new JScrollPane(table);
		jp2.add(sp);
	
		jp3 = new JPanel();
		jp3.setPreferredSize(new Dimension(180, 120));
		btn1 = new JButton("승차권예매");
		btn1.setPreferredSize(new Dimension(150, 35));
		btn1.setBounds(30, 30, 30, 30);
		jp3.add(btn1);
		
		btn2 = new JButton("승차권확인");
		btn2.setPreferredSize(new Dimension(150, 35));
		btn2.setBounds(30, 30, 30, 30);
		jp3.add(btn2);	
		
			
		btn3 = new JButton("로그아웃");
		btn3.setBounds(30, 30, 30, 30);
		btn3.setPreferredSize(new Dimension(150, 35));
		jp3.add(btn3);
		
		
		
		
		
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		setVisible(true);
		
	}




}
