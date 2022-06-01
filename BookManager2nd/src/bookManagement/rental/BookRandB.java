package bookManagement.rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jdbc.DB;

public class BookRandB extends JFrame implements ActionListener {
	
	private JPanel jpID, jpBook, jpTable, jpAll;
	private JTextField tfID, tfBNumSub, tfBNameSub;
	private JButton btnRental, btnReturn, btnCancel;
	private JLabel lblID, lblBNum, lblBName;
	private String today;
	
	//테이블
	private JTable tbList;
	private JScrollPane jsList;
	private DefaultTableModel model;
	private String[] header = {"대여번호","회원이름","회원전화","도서이름","도서번호","날짜"};
	private ResultSet rs;
	private Statement st;
	private BookRental bookRental;
	private String name = "";
	private String phone = "";
	private int count;

	public BookRandB(String title, int width, int height, BookRental bookRental) {  
		this.setTitle(title);
		setSize(width,height);
		//크기 변경 막음
		setResizable(false); 
		setLocationRelativeTo(this);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.bookRental = bookRental;
		
		//전체 패널
		jpAll = new JPanel();
		
		//주민번호 패널
		jpID = new JPanel();
		
		lblID = new JLabel("회원주민번호");
		tfID = new JTextField(10);
		
		btnRental = new JButton("대여");
		btnRental.addActionListener(this);
		
		btnReturn = new JButton("반납");
		btnReturn.addActionListener(this);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		
		jpID.add(lblID);
		jpID.add(tfID);
		jpID.add(btnRental);
		jpID.add(btnReturn);
		jpID.add(btnCancel);
		
		
		//도서번호 패널
		jpBook = new JPanel();
		
		lblBNum = new JLabel("도서번호");
		tfBNumSub = new JTextField(10);
		lblBName = new JLabel("제 목");
		tfBNameSub = new JTextField(10);
		
		jpBook.add(lblBNum);
		jpBook.add(tfBNumSub);
		jpBook.add(lblBName);
		jpBook.add(tfBNameSub);
		
		//테이블 패널
		jpTable = new JPanel();
		model = new DefaultTableModel(header,0);
		tbList = new JTable(model);
		jsList = new JScrollPane(tbList);
		jpTable.add(jsList);
		createTable(model);
		
		
		
		
		//전체 패널에 붙이기
		jpAll.add(jpID);
		jpAll.add(jpBook);
		jpAll.add(jpTable);
		
		add(jpAll);
		setVisible(true); 
	}
	
	private void createTable(DefaultTableModel model) {
		
		String sql = "select * from rent";
		
		try {
			rs = DB.getResultSet(sql);
			for(int i =0; i<model.getRowCount();) {
				model.removeRow(0);
			}
			while(rs.next()) {
				String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4),rs.getString(6)};
				model.addRow(data);
			}
		} catch (Exception e) {
			System.out.println(sql);
			e.printStackTrace();
		}
		
	}
	
	public void todaydate () {
		Date t = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		today = sdf.format(t);
	}


	public void setTable(String sql) {
		try {
			ResultSet rs = DB.getResultSet(sql);

			while (rs.next()) {
				name = rs.getString(1);
				phone = rs.getString(3);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void query(String sql) {
		try {
			DB.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	 Object obj = e.getSource();
		
		if(obj == btnCancel) {
			//취소 버튼 눌렀을 때
			this.dispose();
		}
		else if(obj == btnRental) {
				
				if(tfID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "주민번호를 입력해주세요.", "메시지", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(bookRental.getTfRental().getText().equals("Y")) {
						count = model.getRowCount();
						todaydate();
						String memsql = "select * from member where mb_num = '" + tfID.getText() + "' ";
						setTable(memsql);
						tfBNumSub.setText(bookRental.getTfBNum().getText());
						tfBNameSub.setText(bookRental.getTfBtitle().getText());
						++count;
						String rentsql = "insert into rent values ('"+ count + "', '" + name + "', '" + phone + "', '" + tfBNumSub.getText() + "', '" + tfBNameSub.getText() + "', '"+ today + "')";
						System.out.println(rentsql);
						query(rentsql);
						createTable(model);
						String updatesql = "update lib set lib_state = 'N' where lib_code = '"+ tfBNumSub.getText() + "'";
						query(updatesql);
						bookRental.getTfRental().setText("N");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "대여중인 도서입니다.", "메시지", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			
		}
		else if(obj == btnReturn) {
			
			if(tfID.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "주민번호를 입력해주세요.", "메시지", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String memsql = "select * from member where mb_num = '" + tfID.getText() + "' ";
				setTable(memsql);
				tfBNumSub.setText(bookRental.getTfBNum().getText());
				tfBNameSub.setText(bookRental.getTfBtitle().getText());
				
				
				String sql = "delete from rent where mem_name = '" + name +"'";
				query(sql);
				createTable(model);
				String updatesql = "update lib set lib_state = 'Y' where lib_code = '"+ bookRental.getTfBNum().getText() + "'";
				query(updatesql);
				bookRental.getTfRental().setText("Y");
				
				tfBNumSub.setText("");
				tfBNameSub.setText("");
				tfID.setText("");
				
			}
			
		}
		
	}

}
