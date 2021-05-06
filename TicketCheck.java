package train;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class TicketCheck extends JFrame {
	
	private JTable table;
	private JScrollPane scroll;
	private JPanel p1;
	private JPanel Last;
	private JButton b1;
	private JButton b2;
	private JButton b3;

	//JFrame을 상속 받아 만드는 방법 << 이걸 더 선호함.
	public TicketCheck(String title, int width, int height) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		
		String [] header = {"예매일", "열차", "출발역", "출발시간", "도착역", "도착시간", "좌석번호", "가격"};
		String [][] content = {{"2016-04-27", "KTX", "광주역", "2016-06-24 14:57", "대구역", "2016-06-24 16:57", "6E", "31,800"},
				{"2016-06-24", "KTX", "서울역", "2016-06-24 15:48", "부산역", "2016-06-24 19:08", "1A", "40,200"},
				{"2016-05-14", "무궁화호", "부산역", "2016-06-24 16:13", "서울역", "2016-06-24 19:03", "2F", "30,200"},
				{"2016-05-08", "KTX", "부산역", "2016-06-24 17:08", "서울역", "2016-06-24 19:28", "6E", "40,200"}
		};
		setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		table = new JTable(content,header);
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(700, 630));
		
		
		// DefaultCellHeaderRender 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tbCellRender = new DefaultTableCellRenderer();
		// DefaultTableCellHeaderRender의 정렬을 가운데 정렬로 지정
		tbCellRender.setHorizontalAlignment(SwingConstants.CENTER);
		// 정렬한 테이블의 ColumnModel을 가져옴
		TableColumnModel tbColModel = table.getColumnModel();
		
		
		
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tbColModel.getColumnCount(); i++) {
			tbColModel.getColumn(i).setCellRenderer(tbCellRender);
		}
		
		table.getColumn("예매일").setPreferredWidth(10);
		table.getColumn("열차").setPreferredWidth(10);
		table.getColumn("출발역").setPreferredWidth(10);
		table.getColumn("도착역").setPreferredWidth(10);
		table.getColumn("좌석번호").setPreferredWidth(10);
		table.getColumn("가격").setPreferredWidth(10);
		
		
		b1 = new JButton("예매변경");
		b2 = new JButton("예매취소");
		b3 = new JButton("닫기");
		add(scroll);
		add(b1);
		add(b2);
		add(b3);
		
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new TicketCheck("승차권확인", 720, 700);
	}

}
