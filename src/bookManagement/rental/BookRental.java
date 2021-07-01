package bookManagement.rental;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bookManagement.BookMain;
import jdbc.DB;

public class BookRental extends JFrame implements ActionListener {
	
	//민주 수정
	private JPanel jpBInf,jpInfo,jpSearch,jpAll,jpWhy,jpButton,p6,p7;
	private JButton btnSearch,btnBandR,btnClear,btnRenew,btnBack;
	private JLabel lblBName,lblBNum,lblAuthor,lblPay,lblBNAme,lblPublisher,lblRental;
	private JTextField tfBName,tfBNum,tfAuthor,tfPay,tfBtitle,tfPublisher,tfRental;
	private JTable table;
	private DefaultTableModel model;
	private PreparedStatement ps;
	private JScrollPane scroll;
	private BookRandB bookRandB;
	private String header[] = {"도서번호","제목","저자","출판사","가격","대출여부"};
	private ResultSet rs;
	private Statement st;
	private BookMain bookMain;
	public DefaultTableModel getModel() {
		return model;
	}
	
	public JTextField getTfBName() {
		return tfBName;
	}

	public JTextField getTfBNum() {
		return tfBNum;
	}

	public BookRental(String Title, int width, int height) {
		setTitle(Title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//전체 패널
		jpAll = new JPanel();
		jpAll.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		
		//검색 패널
		jpSearch = new JPanel();
		lblBName = new JLabel("도서명");
		tfBName = new JTextField(14);
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		jpSearch.setPreferredSize(new Dimension(680, 40));


		jpSearch.add(lblBName);
		jpSearch.add(tfBName);
		jpSearch.add(btnSearch);

		
		jpWhy = new JPanel();
		jpWhy.setPreferredSize(new Dimension(180, 85));

		//정보입력 패널1
		jpBInf = new JPanel();
		jpBInf.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
		lblBNum = new JLabel("도서번호");
		tfBNum = new JTextField(10);
		lblAuthor = new JLabel("저   자");
		tfAuthor = new JTextField(10);
		lblPay = new JLabel("가  격");
		tfPay = new JTextField(10);
		btnBandR = new JButton("대여/반납");
		btnBandR.addActionListener(this);
		btnClear = new JButton("초기화");
		btnClear.addActionListener(this);
		btnRenew = new JButton("새로고침");
		btnRenew.addActionListener(this);
		btnBack = new JButton("돌아가기");
		btnBack.addActionListener(this);
		jpBInf.setPreferredSize(new Dimension(180, 100));


		jpBInf.add(lblBNum);
		jpBInf.add(tfBNum);
		jpBInf.add(lblAuthor);
		jpBInf.add(tfAuthor);
		jpBInf.add(lblPay);
		jpBInf.add(tfPay);


		//정보입력 패널2
		jpInfo = new JPanel();
		jpInfo.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
		lblBNAme = new JLabel("제    목");
		tfBtitle = new JTextField(10);
		lblPublisher = new JLabel("출 판 사");
		tfPublisher = new JTextField(10);
		lblRental = new JLabel("대출여부");
		tfRental = new JTextField(10);
		jpInfo.setPreferredSize(new Dimension(180, 120));


		jpInfo.add(lblBNAme);
		jpInfo.add(tfBtitle);
		jpInfo.add(lblPublisher);
		jpInfo.add(tfPublisher);
		jpInfo.add(lblRental);
		jpInfo.add(tfRental);

		
		//버튼 패널
		jpButton = new JPanel();
		jpButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpButton.setPreferredSize(new Dimension(680, 100));
		jpButton.add(btnBandR);
		jpButton.add(btnClear);
		jpButton.add(btnRenew);
		jpButton.add(btnBack);


		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(680, 500));
		createTable(model);


		jpAll.add(jpSearch);
		jpAll.add(jpBInf);
		jpAll.add(jpWhy);
		jpAll.add(jpInfo);
		jpAll.add(jpButton);
		jpAll.add(scroll);


		add(jpAll);
		setVisible(true);
	}

	public JTextField getTfRental() {
		return tfRental;
	}

	public JTextField getTfBtitle() {
		return tfBtitle;
	}

	private void createTable(DefaultTableModel model) {
		
		String sql = "select * from lib";
		
		try {
			rs = DB.getResultSet(sql);
			for(int i = 0; i<model.getRowCount();) {
				model.removeRow(0);
			}
			
			while(rs.next()) {
				String data[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
				model.addRow(data);
			}
			
		} catch (Exception e) {
			//작성된 sql문 확인
			System.out.println(sql);
			e.printStackTrace();
		}
		
	}
	
	private void getSearch(String sql) {
		try {
			rs = DB.getResultSet(sql);
			
			while (rs.next()) {
				tfBNum.setText(rs.getString(1));
				tfBtitle.setText(rs.getString(2));
				tfAuthor.setText(rs.getString(3));
				tfPublisher.setText(rs.getString(4));
				tfPay.setText(rs.getString(5));
				tfRental.setText(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

	public static void main(String[] args) {
		try {
			DB.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BookRental("도서대여/반납",700,700);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		//돌아가기
		if (obj == btnBack) {
			this.dispose();
			bookMain = new BookMain("도서 관리 프로그램", 1008, 652);
		}
		//대여/반납창
		else if (obj == btnBandR) {
				bookRandB = new BookRandB("대여 정보",500,600,this);
				//JOptionPane.showMessageDialog(null, "대여중인 도서입니다.", "메시지", JOptionPane.ERROR_MESSAGE);
			
		}
		//검색
		else if(obj == btnSearch) {
			String bName = tfBName.getText();
			String sql = "select * from lib where lib_name ='" + bName.trim()+ "'";
			getSearch(sql);
			
		}
		//초기화
		else if(obj == btnClear) {
			tfBName.setText("");
			tfBNum.setText("");
			tfBtitle.setText("");
			tfAuthor.setText("");
			tfPublisher.setText("");
			tfPay.setText("");
			tfRental.setText("");
		}
		//새로고침
		else if(obj == btnRenew) {
			createTable(model);
		}
	}

	



}