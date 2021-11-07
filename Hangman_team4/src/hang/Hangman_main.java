package hang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Hangman_main extends JFrame {

	private JPanel contentPane;
	private Image background=new ImageIcon(Hangman_main.class.getResource("../image/background.png")).getImage();
	public static int cnt2=0;		//hangman_game_1p�� �� Ŭ�� Ƚ��
	public static int cnt3=0;		//hangman_game_2p�� �� Ŭ�� Ƚ��222
	Hangman_btnSound btnSound = new Hangman_btnSound();
	Hangman_bgmSound bgmSound = new Hangman_bgmSound();
	Hangman_coinSound coinSound = new Hangman_coinSound();
	
	public static int cntStr;
	public static int cntStr2;
	JButton btn_duo;

	public static Image backk=new ImageIcon(Hangman_result_1p.class.getResource("../image/mback.png")).getImage();
	public static int back1X;
	
	public static boolean check1p = false;
	public static boolean check2p = false;

	
	class background extends JPanel{
		public background() {
		}
			@Override
			protected void paintComponent(Graphics g) {//�׸��� �Լ�
				super.paintComponent(g);
				g.drawImage(background, 0, 0, null);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hangman_main frame = new Hangman_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//�ܾ��߰� �޼ҵ�
	public void fileAdd(String fileAdd) throws IOException {
		File file2 = new File("word.txt");		//�ؽ�Ʈ������ ����

		
		//���� �ڿ� true�� ���� �߰������尡 �Ǿ ���� ������ ����������
		FileOutputStream outFr = new FileOutputStream(file2,true);
		OutputStreamWriter writer = new OutputStreamWriter(outFr,"UTF-8");
		BufferedWriter out = new BufferedWriter(writer);
		
		//file read - ȭ�����(write)  byte�ΰ��� readInt

		out.write("\r"+fileAdd);	//�ؽ�Ʈ������ ������� ������
		
		out.close();
		
	}
	
	/**
	 * Create the frame.
	 */
	public Hangman_main() {
		setTitle("Hangman");
		
		Hangman_game_1p.name="";
		Hangman_game_1p.name2="";
		Hangman_game_1p.cnt=0;
		
		Hangman_game_2p.name="";
		Hangman_game_2p.name2="";
		Hangman_game_2p.cnt=0;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 722);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		JButton btn_add = new JButton("");
		btn_add.setBackground(new Color(0, 100, 0));
		btn_add.setFocusPainted(false);
		btn_add.setBorderPainted(false);
		btn_add.setIcon(new ImageIcon(Hangman_main.class.getResource("/image/\uB2E8\uC5B4\uCD94\uAC00.PNG")));
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSound.abc();	// ��ư �Ҹ� �޼ҵ�
				
				
				  String add=JOptionPane.showInputDialog("�߰��� �ܾ �Է��ϼ���");
		            try {
		               if(add !=null)
		               fileAdd(add);
		            } catch (IOException e1) {
		               // TODO Auto-generated catch block
		               e1.printStackTrace();
		            }
			}
		});
		
		JButton btn_single = new JButton("");
		btn_single.setFocusPainted(false);
		btn_single.setBorderPainted(false);
		btn_single.setIcon(new ImageIcon(Hangman_main.class.getResource("/image/\uD63C\uC790\uD558\uAE30.PNG")));
		btn_single.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSound.abc();    // ��ư �Ҹ� �޼ҵ�
                dispose();    //����â ����
                setVisible(false);    //���� â �Ⱥ��̰�

                if(!check1p) {
                    try {
                        new Hangman_game_1p().setVisible(true);
                        check1p=true;//�ι�° â ���
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }else if(!check2p) {
                	try {
						new Hangman_game_2p().setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }

               
			}
		});
		btn_single.setBounds(395, 334, 165, 62);
		contentPane.add(btn_single);
		
		btn_duo = new JButton("");
		btn_duo.setFocusPainted(false);
		btn_duo.setBorderPainted(false);
		btn_duo.setIcon(new ImageIcon(Hangman_main.class.getResource("/image/\uB458\uC774\uD558\uAE30.PNG")));
		btn_duo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSound.abc();	// ��ư �Ҹ� �޼ҵ�
				dispose();	//����â ����
				setVisible(false);	//���� â �Ⱥ��̰�
				if(!check1p) {
				try {
					new Hangman_game_1p().setVisible(true);
					check1p=true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//�ι�° â ���
				}
				
				if(!check2p) {
				try {
					new Hangman_game_2p().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//�ι�° â ���
				}
				check2p=true;
			}
		});
		btn_duo.setBounds(395, 430, 172, 62);
		contentPane.add(btn_duo);
		btn_add.setBounds(395, 250, 157, 62);
		contentPane.add(btn_add);
		
		JButton btn_exit = new JButton("");
		btn_exit.setFocusPainted(false);
		btn_exit.setBorderPainted(false);
		btn_exit.setIcon(new ImageIcon(Hangman_main.class.getResource("/image/\uB098\uAC00\uAE30.PNG")));
		//btn_exit.setBorderPainted(false);
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSound.abc();	// ��ư �Ҹ� �޼ҵ�
				System.exit(0);
			}
		});
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btn_Music = new JButton("");
		btn_Music.setBackground(new Color(0, 100, 0));
		btn_Music.setFocusPainted(false);
		btn_Music.setBorderPainted(false);
		btn_Music.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bgmSound.abc();	//BGM �޼ҵ� ȣ��
			}
		});
		btn_Music.setIcon(new ImageIcon(Hangman_main.class.getResource("/image/pbtn.png")));
		btn_Music.setBounds(750, 150, 100, 100);
		contentPane.add(btn_Music);
		btn_exit.setBounds(395, 510, 165, 62);
		contentPane.add(btn_exit);
			//BGM �޼ҵ� ȣ��
		
		
		
		JPanel panel = new background();
		panel.add(btn_add);
		panel.add(btn_single);
		panel.add(btn_exit);
		panel.add(btn_Music);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
