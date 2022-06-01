package train;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

public class SelectSeat extends JFrame implements ActionListener, MouseListener {
	
	// 클래스 작성자 : 지수빈
	// 안 되는 거 : 좌석 버튼이 파란색일 때 선택하면 이미 예약된 좌석이라고 띄우기, 좌석 선택하고 '선택완료' 버튼 눌렀을 때 정보 담은 창 띄우기
	// 버튼 하나씩 만들지 않고 배열로 만드는 것까지 하고 리스너 고치는 중(코드는 안고쳐놓음)
	
	private JPanel panSelectNum, panSelectSeat, panBtn;
	private SpinnerNumberModel numberModel;
	private JSpinner spinner;
	private SpinnerListModel listModel;
	private JButton btn1A;
	private JButton btn2A;
	private JButton btn3A;
	private JButton btn4A;
	private JButton btn5A;
	private JButton btn6A;
	private JButton btnSelect;
	private String[] SeatNum;
	private JButton btnSeat;
	
	int i = 0;
	int cnt;

	public SelectSeat(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		// n호차 선택 패널
		panSelectNum = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		String[] CarNum = new String[] {"1호차", "2호차", "3호차", "4호차", "5호차", "6호차", "7호차", "8호차"};
		listModel = new SpinnerListModel(CarNum);
		spinner = new JSpinner(listModel);
		
		panSelectNum.add(spinner);
		
		// 좌석 선택 패널
		panSelectSeat = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		int i = 0;
		
		JButton[] btnSeat = {btn1A, btn2A, btn3A, btn4A, btn5A, btn6A};
		
		btn1A = new JButton("1A");
		btn2A = new JButton("2A");
		btn3A = new JButton("3A");
		btn4A = new JButton("4A");
		btn5A = new JButton("5A");
		btn6A = new JButton("6A");
		
		btn1A.setPreferredSize(new Dimension(110, 110));
		btn2A.setPreferredSize(new Dimension(110, 110));
		btn3A.setPreferredSize(new Dimension(110, 110));
		btn4A.setPreferredSize(new Dimension(110, 110));
		btn5A.setPreferredSize(new Dimension(110, 110));
		btn6A.setPreferredSize(new Dimension(110, 110));

		btn1A.setBackground(Color.WHITE);	// 버튼 색 설정
		btn2A.setBackground(Color.WHITE);
		btn3A.setBackground(Color.WHITE);
		btn4A.setBackground(Color.WHITE);
		btn5A.setBackground(Color.WHITE);
		btn6A.setBackground(Color.WHITE);
		
		btn1A.setOpaque(false);		// 버튼 투명하게 설정
		btn2A.setOpaque(false);
		btn3A.setOpaque(false);
		btn4A.setOpaque(false);
		btn5A.setOpaque(false);
		btn6A.setOpaque(false);
		
		btn1A.setBorder(new LineBorder(Color.BLACK, 2));	// 버튼 테두리 설정
		btn2A.setBorder(new LineBorder(Color.BLACK, 2));
		btn3A.setBorder(new LineBorder(Color.BLACK, 2));
		btn4A.setBorder(new LineBorder(Color.BLACK, 2));
		btn5A.setBorder(new LineBorder(Color.BLACK, 2));
		btn6A.setBorder(new LineBorder(Color.BLACK, 2));
		
		panSelectSeat.add(btn1A);
		panSelectSeat.add(btn2A);
		panSelectSeat.add(btn3A);
		panSelectSeat.add(btn4A);
		panSelectSeat.add(btn5A);
		panSelectSeat.add(btn6A);
		
		btn1A.addMouseListener(this);
		btn2A.addMouseListener(this);
		btn3A.addMouseListener(this);
		btn4A.addMouseListener(this);
		btn5A.addMouseListener(this);
		btn6A.addMouseListener(this);
		
		// 버튼 패널
		panBtn = new JPanel();
		
		btnSelect = new JButton("선택완료");
		btnSelect.addActionListener(this);
		
		panBtn.add(btnSelect);
		
		
		// 붙이기
		add(panSelectNum, BorderLayout.NORTH);
		add(panSelectSeat, BorderLayout.CENTER);
		add(panBtn, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SelectSeat("좌석선택", 300, 550);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		
		if(obj == btnSelect && cnt == 0) {
			JOptionPane.showMessageDialog(null, "좌석을 선택해주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(obj == btnSelect && cnt != 0) {
			JOptionPane.showMessageDialog(null, "이미 예약된 좌석입니다", "메시지", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object obj =  e.getSource();
		
		if(obj == btn1A) {
			btn1A.setOpaque(true);
			btn2A.setOpaque(false);
			btn3A.setOpaque(false);
			btn4A.setOpaque(false);
			btn5A.setOpaque(false);
			btn6A.setOpaque(false);
			
			btn1A.setBackground(Color.PINK);
			btn2A.setBackground(Color.WHITE);
			btn3A.setBackground(Color.WHITE);
			btn4A.setBackground(Color.WHITE);
			btn5A.setBackground(Color.WHITE);
			btn6A.setBackground(Color.WHITE);
			
			cnt++;
		} else if (obj == btn2A){
			btn1A.setOpaque(false);
			btn2A.setOpaque(true);
			btn3A.setOpaque(false);
			btn4A.setOpaque(false);
			btn5A.setOpaque(false);
			btn6A.setOpaque(false);
			
			btn1A.setBackground(Color.WHITE);
			btn2A.setBackground(Color.PINK);
			btn3A.setBackground(Color.WHITE);
			btn4A.setBackground(Color.WHITE);
			btn5A.setBackground(Color.WHITE);
			btn6A.setBackground(Color.WHITE);
			
			cnt++;
		} else if (obj == btn3A) {
			btn1A.setOpaque(false);
			btn2A.setOpaque(false);
			btn3A.setOpaque(true);
			btn4A.setOpaque(false);
			btn5A.setOpaque(false);
			btn6A.setOpaque(false);
			
			btn1A.setBackground(Color.WHITE);
			btn2A.setBackground(Color.WHITE);
			btn3A.setBackground(Color.PINK);
			btn4A.setBackground(Color.WHITE);
			btn5A.setBackground(Color.WHITE);
			btn6A.setBackground(Color.WHITE);
			
			cnt++;
		} else if (obj == btn4A) {
			btn1A.setOpaque(false);
			btn2A.setOpaque(false);
			btn3A.setOpaque(false);
			btn4A.setOpaque(true);
			btn5A.setOpaque(false);
			btn6A.setOpaque(false);
			
			btn1A.setBackground(Color.WHITE);
			btn2A.setBackground(Color.WHITE);
			btn3A.setBackground(Color.WHITE);
			btn4A.setBackground(Color.PINK);
			btn5A.setBackground(Color.WHITE);
			btn6A.setBackground(Color.WHITE);
			
			cnt++;
		} else if (obj == btn5A) {
			btn1A.setOpaque(false);
			btn2A.setOpaque(false);
			btn3A.setOpaque(false);
			btn4A.setOpaque(false);
			btn5A.setOpaque(true);
			btn6A.setOpaque(false);
			
			btn1A.setBackground(Color.WHITE);
			btn2A.setBackground(Color.WHITE);
			btn3A.setBackground(Color.WHITE);
			btn4A.setBackground(Color.WHITE);
			btn5A.setBackground(Color.PINK);
			btn6A.setBackground(Color.WHITE);
			
			cnt++;
		} else if (obj == btn6A) {
			btn1A.setOpaque(false);
			btn2A.setOpaque(false);
			btn3A.setOpaque(false);
			btn4A.setOpaque(false);
			btn5A.setOpaque(false);
			btn6A.setOpaque(true);
			
			btn1A.setBackground(Color.WHITE);
			btn2A.setBackground(Color.WHITE);
			btn3A.setBackground(Color.WHITE);
			btn4A.setBackground(Color.WHITE);
			btn5A.setBackground(Color.WHITE);
			btn6A.setBackground(Color.PINK);
			
			cnt++;
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

}
