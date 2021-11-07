package hang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Hangman_result_2p extends JFrame {

	private JPanel contentPane;
	private static Image backk=new ImageIcon(Hangman_result_2p.class.getResource("../image/mback.png")).getImage();
	ImageIcon ii = new ImageIcon(this.getClass().getResource("../image/runningman.gif"));
	static int back1X2;
	static int back2X2;
	static boolean mbackk2;

	class BackPanel extends JPanel{
		public BackPanel() {
			
			setFocusable(true);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (mbackk2) {
						back1X2--;
						back2X2--;
						if(back1X2 < -(backk.getWidth(null))) {
							back1X2 = backk.getWidth(null);
							back2X2=back2X2+1;
						}
						
						if(back2X2 < -(backk.getWidth(null))) {
							back2X2 = backk.getWidth(null);
							back1X2=back1X2+1;
						}
						
							
						
						repaint();
						try {
							Thread.sleep(5);
							//System.out.println("실행중"+back1X); //디버깅
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(backk, back1X2, 0, this);
			g.drawImage(backk, back2X2, 0, this);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hangman_result_1p frame = new Hangman_result_1p();
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
	
	public Hangman_result_2p() {
		setTitle("Result_2p");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label_result = new JLabel("");
		label_result.setFont(new Font("돋움", Font.BOLD, 25));
		label_result.setForeground(new Color(255, 255, 255));
		label_result.setBounds(357, 400, 343, 52);
		contentPane.add(label_result);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
		});
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Hangman_result_1p.class.getResource("/image/\uAC8C\uC784\uC885\uB8CC.PNG")));
		btnNewButton_1.setBackground(new Color(238, 130, 238));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(410, 550, 152, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Hangman_result_1p.class.getResource("/image/\uC7AC\uB3C4\uC804.PNG")));
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								
				dispose();	//지금창 닫음
				setVisible(false);	//지금 창 안보이게
				mbackk2=false;
				Hangman_main.check2p=false;
				new Hangman_main().setVisible(true);
			
			}
		});
		btnNewButton.setBounds(414, 480, 142, 53);
		contentPane.add(btnNewButton);
		
		JLabel imagebtn= new JLabel();
		/*imageLabel.setFocusPainted(false);
		imageLabel.setBorderPainted(false);*/
		imagebtn.setIcon(new ImageIcon(Hangman_result_1p.class.getResource("../image/runningman.gif")));
		imagebtn.setBackground(new Color(0, 100, 0));
		imagebtn.setBounds(60, 450, 200, 200);
		contentPane.add(imagebtn);

        label_result.setText("총"+Hangman_main.cntStr2+"번 만에 맞추셨습니다");
        Hangman_main.cnt3=0;
        
		JPanel panel = new BackPanel();
		panel.add(label_result);
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		panel.add(imagebtn);
		//panel.add(imageLabel);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
	}
}
