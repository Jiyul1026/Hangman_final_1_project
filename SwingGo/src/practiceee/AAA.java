package practiceee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AAA extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AAA frame = new AAA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AAA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(45, 135, 57, 15);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("pw");
		lblPw.setBounds(45, 175, 57, 15);
		contentPane.add(lblPw);
		
		txtID = new JTextField();
		txtID.setBounds(126, 132, 116, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtPW = new JTextField();
		txtPW.setBounds(126, 172, 116, 21);
		contentPane.add(txtPW);
		txtPW.setColumns(10);
		
		JButton button = new JButton("\uC778\uC790\uAC16\uACE0\uAC00\uC790");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();		//지금창 해제 프레임 닫기
				setVisible(false);	//지금의 창이 안보이게
				String id = txtID.getText();
				String pw = txtPW.getText();
				new FFF2(id,pw).setVisible(true);
			}
		});
		button.setBounds(126, 85, 116, 23);
		contentPane.add(button);
	}

}
