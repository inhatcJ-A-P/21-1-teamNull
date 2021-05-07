package train;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;

public class TicketCheck extends JFrame implements ActionListener, MouseListener {
		// 김종하
		// 해결 못한부분 Jtable 셀에 버튼 삽입
	private JTable table;
	private JScrollPane scroll;
	private JPanel p1;
	private JPanel Last;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private int result;
	private DefaultTableModel model;
	private DefaultTableModel m;
	public TicketCheck(String title, int width, int height) {
		this.setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this); 	//화면 가운데 찍음
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫을수 있는 특정 상수값을 주었기 때문에 프레임 종료버튼이 클릭될때 프로그램도 같이 사라짐 
		
		String [] header = {"예매일", "열차", "출발역", "출발시간", "도착역", "도착시간", "좌석번호", "가격"};
		String [][] content = {{"2016-04-27", "KTX", "광주역", "2016-06-24 14:57", "대구역", "2016-06-24 16:57", "6E", "31,800"},
				{"2016-06-24", "KTX", "서울역", "2016-06-24 15:48", "부산역", "2016-06-24 19:08", "1A", "40,200"},
				{"2016-05-14", "무궁화호", "부산역", "2016-06-24 16:13", "서울역", "2016-06-24 19:03", "2F", "30,200"},
				{"2016-05-08", "KTX", "부산역", "2016-06-24 17:08", "서울역", "2016-06-24 19:28", "6E", "40,200"}
		};
		setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		
		// 테이블 생성 -> 테이블 생성시 Default 모델 사용하는 이유는 테이블 내에 데이터를 삽입,수정,삭제 하기위해서
		model = new DefaultTableModel(content, header);
		table = new JTable(model);
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		m = (DefaultTableModel)table.getModel();
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
		
		//테이블 셀 크기 조절
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(30);
		
		// 머리글(컬럼헤더) 클릭시 필드를 기준으로 오름차순, 내림차순
		table.setAutoCreateRowSorter(true);
		TableRowSorter tablesorter = new TableRowSorter(table.getModel());
		table.setRowSorter(tablesorter);
		
		
		b1 = new JButton("예매변경");
		b1.addActionListener(this);
		b2 = new JButton("예매취소");
		b2.addActionListener(this);
		b3 = new JButton("닫기");
		b3.addActionListener(this);
		add(scroll);
		add(b1);
		add(b2);
		add(b3);
		
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new TicketCheck("승차권확인", 720, 700);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1) {
			int rowindex = table.getSelectedRow();
			System.out.println(rowindex);
			if(rowindex != -1) {		// JTable 선택하고 버튼 클릭시
				result = JOptionPane.showConfirmDialog(null,"예매를 변경하시겠습니까?","",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					new Reservation("승차권예매", 600, 550);
				}
			}
			else {	// JTable 선택하지 않고 버튼 클릭시
				JOptionPane.showMessageDialog(null,"승차권을 선택해주세요.","메시지",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(obj == b2) {
			int rowindex = table.getSelectedRow();
			if(rowindex != -1) {	// JTable 선택하고 버튼 클릭시
				result = JOptionPane.showConfirmDialog(null,"예매를 취소하시겠습니까?","",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {	// YES 버튼 누르면 JTable 리스트 삭제함  
					m.removeRow(rowindex);
					JOptionPane.showMessageDialog(null,"예매가 취소되었습니다.","메시지",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"승차권을 선택해주세요.","메시지",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(obj == b3) {
			dispose();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

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

}

