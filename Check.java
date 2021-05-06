package train;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.sun.jdi.connect.spi.Connection;
import com.sun.net.httpserver.Authenticator.Result;

public class Check extends JFrame implements ActionListener{
		
	JTable tb;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	
	public Check(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		nPanel();
		cPanel();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		setLayout(new FlowLayout());
		
		setVisible(true);
	}//end of ListEx

	

	private void cPanel() {
		JPanel cp = new JPanel();
		String header[] = {"열차", "출발역", "도착역", "좌석현황","가격"," "};
		Object content[][] = {
				{"KTX", "서울역","부산역"," 45석남음", "40,200",jb1},
				{"새마을호", "서울역","부산역"," 45석남음", "35,200",(JButton)jb2},
				{"무궁화호", "서울역","부산역"," 45석남음", "30,200",(JButton)jb3},
				};
		DefaultTableModel dtm = new DefaultTableModel(content,header);
		tb = new JTable(dtm);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		
		JScrollPane sp = new JScrollPane(tb);
		tb.getTableHeader().setBackground(Color.DARK_GRAY);
		tb.getTableHeader().setForeground(Color.white);
		tb.setShowHorizontalLines(false);
		tb.setShowVerticalLines(false);
		tb.setBackground(Color.white);
		jb1 = new JButton("예매하기");
		jb1.setOpaque(true);
		jb2 = new JButton("예매하기");
		jb2.setOpaque(true);
		jb3 = new JButton("예매하기");
		jb3.setOpaque(true);
		
//        tb.getColumn("jb1").setCellRenderer(tcr);
//        tb.getColumn("jb2").setCellRenderer(tcr);
    
		
//		table.getColumn("").setCellRenderer(new ButtonRedm);
//		tb.getColumn("jb1").setCellEditor((TableCellEditor)jb1);
//		tb.getColumn("jb2").setCellEditor((TableCellEditor)jb2);
//		tb.getColumn("jb3").setCellEditor((TableCellEditor)jb3);

		cp.add(sp);
		add(cp);
		}

	private void nPanel() {
		JPanel np = new JPanel();
		np.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		
		JLabel l1 = new JLabel("열차");
		l1.setBackground(Color.DARK_GRAY);
		l1.setOpaque(true);
		l1.setForeground(Color.white);
		l1.setPreferredSize(new Dimension(70,25));
		l1.setHorizontalAlignment(JLabel.CENTER);
		np.add(l1);
		
		JLabel l2 = new JLabel("출발역");
		l2.setBackground(Color.DARK_GRAY);
		l2.setOpaque(true);
		l2.setForeground(Color.white);
		l2.setPreferredSize(new Dimension(70,25));
		l2.setHorizontalAlignment(JLabel.CENTER);
		np.add(l2);
		
		JLabel l3 = new JLabel("도착역");
		l3.setBackground(Color.DARK_GRAY);
		l3.setOpaque(true);
		l3.setForeground(Color.white);
		l3.setPreferredSize(new Dimension(70,25));
		l3.setHorizontalAlignment(JLabel.CENTER);
		np.add(l3);
		
		JLabel l4 = new JLabel("좌석현황");
		l4.setBackground(Color.DARK_GRAY);
		l4.setOpaque(true);
		l4.setForeground(Color.white);
		l4.setPreferredSize(new Dimension(70,25));
		l4.setHorizontalAlignment(JLabel.CENTER);
		np.add(l4);
		
		JLabel l5 = new JLabel("가격");
		l5.setBackground(Color.DARK_GRAY);
		l5.setOpaque(true);
		l5.setForeground(Color.white);	
		l5.setPreferredSize(new Dimension(70,25));
		l5.setHorizontalAlignment(JLabel.CENTER);
		np.add(l5);
		
		add(np);
	}

	public static void main(String[] args) {
		new Check("조회결과",600,400);

	}//end of main

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
	}

}//end of class
