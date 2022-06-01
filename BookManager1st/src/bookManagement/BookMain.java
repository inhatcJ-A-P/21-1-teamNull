package bookManagement;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bookManagement.book.BookManage;
import bookManagement.member.MemberList;
import bookManagement.rental.BookAllRental;
import bookManagement.rental.BookRental;
import jdbc.DB;

public class BookMain extends JFrame implements ActionListener {

	private JButton btnUser, btnBook, btnBorrow, btnAllInfo, btnExit;
	private ImageIcon img;
	private JLabel lblImg;
	private MemberList ml;
	private BookManage bm;
	private BookRental br;
	private BookAllRental bar;

	public BookMain(String title, int width, int height) {

		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		// 레이아웃
		setLayout(new BorderLayout());

		// 버튼 생성
		JPanel PanBtn = new JPanel();

		btnUser = new JButton("회원 등록/삭제");
		btnUser.addActionListener(this);
		PanBtn.add(btnUser);
		
		btnBook = new JButton("도서 등록/삭제");
		btnBook.addActionListener(this);
		PanBtn.add(btnBook);
		
		btnBorrow = new JButton("도서 대여/반납");
		btnBorrow.addActionListener(this);
		PanBtn.add(btnBorrow);
		
		btnAllInfo = new JButton("모든 대여 정보");
		btnAllInfo.addActionListener(this);
		PanBtn.add(btnAllInfo);
		
		btnExit = new JButton("종료");
		btnExit.addActionListener(this);
		PanBtn.add(btnExit);

		// 사진
		img = new ImageIcon("images/Welcome.jpg");
		lblImg = new JLabel(img);

		add(PanBtn,BorderLayout.NORTH);
		add(lblImg,BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			DB.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BookMain("도서 관리 프로그램", 1008, 652);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnUser) {
			ml = new MemberList("회원목록",500,600);
			this.dispose();
		}else if (obj == btnBook) {
			bm = new BookManage("도서관리",500,550);
			this.dispose();
		}else if (obj == btnBorrow) {
			br = new BookRental("도서대여/반납",700,700);
			this.dispose();
		}else if (obj == btnAllInfo) {
			bar = new BookAllRental("대여 정보",500,600);
			this.dispose();
		}else if (obj == btnExit) {
			System.exit(0);
		}
	}

} 