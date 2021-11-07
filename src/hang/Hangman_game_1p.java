package hang;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import hang.Hangman_result_1p.BackPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class Hangman_game_1p extends JFrame {

   private JPanel contentPane;

   JLabel lbl_First;
   static public String choose;
   static JLabel lbl_1;
   static JLabel lbl_2;
   static JLabel lbl_3;
   static JLabel lbl_4;
   static JLabel lbl_5;
   static JLabel lbl_6;
   static JLabel lbl_7;
   static JLabel lbl_8;
   static JLabel lbl_9;
   static String name2="";   //³»°¡ Á¤´äÀ» Á¦ÃâÇÒ °ø°£
   static int cnt =0;      //   Æ²¸®¸é ¿Ã¶ó°¨
   static JTextArea text_First;
   static String name="";
   static boolean cntCheck =false;      //¸ÂÃß¸é true·Î ¹Ù²ñ
   static int fileCnt;
   static String strTemp="";		//¾²·¹±â°ª ³Ö¾îµÑ Àå¼Ò
   Hangman_btnSound btnSound = new Hangman_btnSound();
   Hangman_coinSound coinSound = new Hangman_coinSound();
   Timer timer = new Timer();
   
   
   
   /**
    * Launch the application.
    */
   
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Hangman_game_1p frame = new Hangman_game_1p();
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
   //=================================
   public void game(char str) {
      btnSound.abc();   // ¹öÆ° ¼Ò¸® ¸Þ¼Òµå
      Hangman_main.cnt2++;
      StringBuffer sb = new StringBuffer();
      sb.append(name2);
      //ÀÔ·ÂÇÑ ¹®ÀÚ¶û ¸ÂÃç¾ßÇÏ´Â¹®ÀÚÁß °°Àº ¹®ÀÚ°¡ ÀÖÀ¸¸é
      for(int i=0;i<name.length();i++) {
         if(str == name.charAt(i) ) {
            sb.replace(i, i+1, Character.toString(str));
            cntCheck=true;
         }
      }
      
      //¹®ÀÚ°¡ Æ²·È´Ù¸é
      
         
         if(!cntCheck) {
            cnt++;
//         System.out.println(cnt);         //µð¹ö±ë¿ë
         } else {
//            System.out.println(cnt);      //µð¹ö±ë¿ë
         }

      
      name2=sb.toString();
      
      
      //µð¹ö±ë¿ë
//      System.out.println(name2);   
      lbl_First.setText(name2);
   
      		strTemp=name;
      
      
      
            
         if (cnt ==1) {
            lbl_1.setVisible(false); 
            lbl_2.setVisible(true);
            lbl_3.setVisible(true);
            lbl_4.setVisible(true);
            lbl_5.setVisible(true);
            lbl_6.setVisible(true);
            lbl_8.setVisible(true);
            lbl_9.setVisible(false);
//            name=strTemp;
         }
         if (cnt ==2) {
            lbl_1.setVisible(false); 
            lbl_2.setVisible(false);
            lbl_3.setVisible(true);
            lbl_4.setVisible(true);
            lbl_5.setVisible(true);
            lbl_6.setVisible(true);
            lbl_9.setVisible(false);
            lbl_8.setVisible(true);
//            name=strTemp;
         }
         if (cnt ==3) {
            lbl_1.setVisible(false); 
            lbl_2.setVisible(false);
            lbl_3.setVisible(false);
            lbl_4.setVisible(true);
            lbl_5.setVisible(true);
            lbl_6.setVisible(true);
            lbl_9.setVisible(false);
            lbl_8.setVisible(true);
//            name=strTemp;
         }
         if (cnt ==4) {
            lbl_1.setVisible(false); 
            lbl_2.setVisible(false);
            lbl_3.setVisible(false);
            lbl_4.setVisible(false);
            lbl_5.setVisible(true);
            lbl_6.setVisible(true);
            lbl_9.setVisible(false);
            lbl_8.setVisible(true);
//            name=strTemp;
         }   
         if (cnt ==5) {
            lbl_1.setVisible(false); 
            lbl_2.setVisible(false);
            lbl_3.setVisible(false);
            lbl_4.setVisible(false);
            lbl_5.setVisible(false);
            lbl_6.setVisible(true);
            lbl_9.setVisible(false);
            lbl_8.setVisible(true);
//            name=strTemp;
         }
         if (cnt ==6) {
            lbl_1.setVisible(false); 
            lbl_2.setVisible(false);
            lbl_3.setVisible(false);
            lbl_4.setVisible(false);
            lbl_5.setVisible(false);
            lbl_6.setVisible(false);
            lbl_9.setVisible(true);
            lbl_8.setVisible(false);
            
            
         }
      


         if(!cntCheck) {
            
            if(cnt>5) {
               text_First.setText("6¹ø Æ²·Á¼­»ç¸Á\n");
               name="#####";
            }
            else {
            	text_First.setText(text_First.getText()+cnt+"¹ø ½ÃµµÁß"+"\n");
            
            }
            
         }

         if(name.equals(name2)) {
            text_First.setText("¸ÂÃß¼Ì½À´Ï´Ù! Å¬¸®¾î\n");
            Hangman_main.cntStr=Hangman_main.cnt2;
            Hangman_result_1p.back1X=0;
            Hangman_result_1p.back2X=985;
            Hangman_result_1p.mbackk=true;
            TimerTask m_task = new TimerTask() {
               @Override
               public void run() {
                  cntCheck=false;
                  dispose();
                  setVisible(false);
                  new Hangman_result_1p().setVisible(true);
                  
               }
            };
            timer.schedule(m_task, 3000);

            
         }
         
         cntCheck=false;
         
         

      
         
      
         

//            
      }
      
   
   //===================================
   public Hangman_game_1p() throws IOException {
      setTitle("FirstPlayer");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 985, 722);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(0, 100, 0));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      

      
//      FileManager fileLoad = new FileManager();
      fileCnt   =Hangman_FileManager.fileLineCount();      //ÅØ½ºÆ® ÆÄÀÏÀÇ ÁÙ ¼ö
      name=Hangman_FileManager.fileRandomLine(fileCnt).toUpperCase();
      
      
      
//      µð¹ö±ë¿ë
      System.out.println(name);      
      

      

      
      int nameLen=name.length();
      for(int i=0;i<nameLen;i++) {
         
         name2+="_";
//         name2+="\t";
         
      }
      
      
       JButton btn_A = new JButton("");
         btn_A.setBorderPainted(false);
         btn_A.setContentAreaFilled(false);
         btn_A.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/A.png")));
         btn_A.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('A');
            
            }
         });
         btn_A.setBackground(new Color(255, 255, 255));
         btn_A.setForeground(Color.BLACK);
         btn_A.setFocusPainted(false);
         btn_A.setBorderPainted(false);
         btn_A.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_A.setBounds(41, 507, 62, 59);
         contentPane.add(btn_A);

      
         JButton btn_B = new JButton("");
         btn_B.setBorderPainted(false);
         btn_B.setFocusPainted(false);
         btn_B.setContentAreaFilled(false);
         btn_B.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/B.png")));
         btn_B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('B');
            }
         });
         btn_B.setBackground(Color.WHITE);
         btn_B.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_B.setBounds(578, 585, 62, 59);
         contentPane.add(btn_B);
         
         JButton btn_C = new JButton("");
         btn_C.setBorderPainted(false);
         btn_C.setFocusPainted(false);
         btn_C.setContentAreaFilled(false);
         btn_C.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/C.png")));
         btn_C.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('C');
            }
         });
         btn_C.setBackground(Color.WHITE);
         btn_C.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_C.setBounds(322, 585, 62, 59);
         contentPane.add(btn_C);
         
         JButton btn_D = new JButton("");
         btn_D.setBorderPainted(false);
         btn_D.setFocusPainted(false);
         btn_D.setContentAreaFilled(false);
         btn_D.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/D.png")));
         btn_D.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('D');
            }
         });
         btn_D.setBackground(Color.WHITE);
         btn_D.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_D.setBounds(247, 507, 62, 59);
         contentPane.add(btn_D);
         
         JButton btn_E = new JButton("");
         btn_E.setBorderPainted(false);
         btn_E.setFocusPainted(false);
         btn_E.setContentAreaFilled(false);
         btn_E.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/E.png")));
         btn_E.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('E');
            }
         });
         btn_E.setBackground(Color.WHITE);
         btn_E.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_E.setBounds(225, 423, 62, 59);
         contentPane.add(btn_E);
         
         JButton btn_F = new JButton("");
         btn_F.setBorderPainted(false);
         btn_F.setFocusPainted(false);
         btn_F.setContentAreaFilled(false);
         btn_F.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/F.png")));
         btn_F.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('F');
            }
         });
         btn_F.setBackground(Color.WHITE);
         btn_F.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_F.setBounds(350, 507, 62, 59);
         contentPane.add(btn_F);
         
         JButton btn_G = new JButton("");
         btn_G.setBorderPainted(false);
         btn_G.setFocusPainted(false);
         btn_G.setContentAreaFilled(false);
         btn_G.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/G.png")));
         btn_G.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('G');
            }
         });
         btn_G.setBackground(Color.WHITE);
         btn_G.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_G.setBounds(453, 507, 62, 59);
         contentPane.add(btn_G);
         
         JButton btn_H = new JButton("");
         btn_H.setBorderPainted(false);
         btn_H.setFocusPainted(false);
         btn_H.setContentAreaFilled(false);
         btn_H.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/H.png")));
         btn_H.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('H');
            }
         });
         btn_H.setBackground(Color.WHITE);
         btn_H.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_H.setBounds(556, 507, 62, 59);
         contentPane.add(btn_H);
         
         JButton btn_I = new JButton("");
         btn_I.setBorderPainted(false);
         btn_I.setFocusPainted(false);
         btn_I.setContentAreaFilled(false);
         btn_I.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/I.png")));
         btn_I.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('I');
            }
         });
         btn_I.setBackground(Color.WHITE);
         btn_I.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_I.setBounds(690, 423, 62, 59);
         contentPane.add(btn_I);
         
         JButton btn_J = new JButton("");
         btn_J.setBorderPainted(false);
         btn_J.setFocusPainted(false);
         btn_J.setContentAreaFilled(false);
         btn_J.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/J.png")));
         btn_J.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('J');
            }
         });
         btn_J.setBackground(Color.WHITE);
         btn_J.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_J.setBounds(659, 507, 62, 59);
         contentPane.add(btn_J);
         
         JButton btn_K = new JButton("");
         btn_K.setBorderPainted(false);
         btn_K.setFocusPainted(false);
         btn_K.setContentAreaFilled(false);
         btn_K.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/K.png")));
         btn_K.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('K');
            }
         });
         btn_K.setBackground(Color.WHITE);
         btn_K.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_K.setBounds(762, 507, 62, 59);
         contentPane.add(btn_K);
         
         JButton btn_L = new JButton("");
         btn_L.setBorderPainted(false);
         btn_L.setFocusPainted(false);
         btn_L.setContentAreaFilled(false);
         btn_L.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/L.png")));
         btn_L.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('L');
            }
         });
         btn_L.setBackground(Color.WHITE);
         btn_L.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_L.setBounds(865, 507, 62, 59);
         contentPane.add(btn_L);
         
         JButton btn_M = new JButton("");
         btn_M.setBorderPainted(false);
         btn_M.setFocusPainted(false);
         btn_M.setContentAreaFilled(false);
         btn_M.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/M.png")));
         btn_M.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('M');
            }
         });
         btn_M.setBackground(Color.WHITE);
         btn_M.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_M.setBounds(827, 585, 62, 59);
         contentPane.add(btn_M);
         
         JButton btn_N = new JButton("");
         btn_N.setBorderPainted(false);
         btn_N.setFocusPainted(false);
         btn_N.setContentAreaFilled(false);
         btn_N.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/N.png")));
         btn_N.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('N');
            }
         });
         btn_N.setBackground(Color.WHITE);
         btn_N.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_N.setBounds(702, 585, 62, 59);
         contentPane.add(btn_N);
         
         JButton btn_O = new JButton("");
         btn_O.setBorderPainted(false);
         btn_O.setFocusPainted(false);
         btn_O.setContentAreaFilled(false);
         btn_O.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/O.png")));
         btn_O.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('O');
            }
         });
         btn_O.setBackground(Color.WHITE);
         btn_O.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_O.setBounds(783, 423, 62, 59);
         contentPane.add(btn_O);
         
         JButton btn_P = new JButton("");
         btn_P.setBorderPainted(false);
         btn_P.setFocusPainted(false);
         btn_P.setContentAreaFilled(false);
         btn_P.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/P.png")));
         btn_P.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('P');
            }
         });
         btn_P.setBackground(Color.WHITE);
         btn_P.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_P.setBounds(876, 423, 62, 59);
         contentPane.add(btn_P);
         
         JButton btn_Q = new JButton("");
         btn_Q.setBorderPainted(false);
         btn_Q.setFocusPainted(false);
         btn_Q.setContentAreaFilled(false);
         btn_Q.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/Q.png")));
         btn_Q.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('Q');
            }
         });
         btn_Q.setBackground(Color.WHITE);
         btn_Q.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_Q.setBounds(31, 423, 62, 59);
         contentPane.add(btn_Q);
         
         JButton btn_R = new JButton("");
         btn_R.setBorderPainted(false);
         btn_R.setFocusPainted(false);
         btn_R.setContentAreaFilled(false);
         btn_R.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/R.png")));
         btn_R.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('R');
            }
         });
         btn_R.setBackground(Color.WHITE);
         btn_R.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_R.setBounds(318, 423, 62, 59);
         contentPane.add(btn_R);
         
         JButton btn_S = new JButton("");
         btn_S.setBorderPainted(false);
         btn_S.setFocusPainted(false);
         btn_S.setContentAreaFilled(false);
         btn_S.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/S.png")));
         btn_S.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('S');
            }
         });
         btn_S.setBackground(new Color(255, 255, 255));
         btn_S.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_S.setBounds(144, 507, 62, 59);
         contentPane.add(btn_S);
         
         JButton btn_T = new JButton("");
         btn_T.setBorderPainted(false);
         btn_T.setFocusPainted(false);
         btn_T.setContentAreaFilled(false);
         btn_T.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/T.png")));
         btn_T.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('T');
            }
         });
         btn_T.setBackground(Color.WHITE);
         btn_T.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_T.setBounds(411, 423, 62, 59);
         contentPane.add(btn_T);
         
         JButton btn_U = new JButton("");
         btn_U.setBorderPainted(false);
         btn_U.setFocusPainted(false);
         btn_U.setContentAreaFilled(false);
         btn_U.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/U.png")));
         btn_U.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('U');
            }
         });
         btn_U.setBackground(Color.WHITE);
         btn_U.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_U.setBounds(597, 423, 62, 59);
         contentPane.add(btn_U);
         
         JButton btn_V = new JButton("");
         btn_V.setBorderPainted(false);
         btn_V.setFocusPainted(false);
         btn_V.setContentAreaFilled(false);
         btn_V.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/V.png")));
         btn_V.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('V');
            }
         });
         btn_V.setBackground(Color.WHITE);
         btn_V.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_V.setBounds(450, 585, 62, 59);
         contentPane.add(btn_V);
         
         JButton btn_W = new JButton("");
         btn_W.setBorderPainted(false);
         btn_W.setFocusPainted(false);
         btn_W.setContentAreaFilled(false);
         btn_W.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/W.png")));
         btn_W.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('W');
            }
         });
         btn_W.setBackground(Color.WHITE);
         btn_W.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_W.setBounds(124, 423, 62, 59);
         contentPane.add(btn_W);
         
         JButton btn_X = new JButton("");
         btn_X.setBorderPainted(false);
         btn_X.setFocusPainted(false);
         btn_X.setContentAreaFilled(false);
         btn_X.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/X.png")));
         btn_X.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('X');
            }
         });
         btn_X.setBackground(Color.WHITE);
         btn_X.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_X.setBounds(198, 585, 62, 59);
         contentPane.add(btn_X);
         
         JButton btn_Y = new JButton("");
         btn_Y.setBorderPainted(false);
         btn_Y.setFocusPainted(false);
         btn_Y.setContentAreaFilled(false);
         btn_Y.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/Y.png")));
         btn_Y.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('Y');
            }
         });
         btn_Y.setBackground(Color.WHITE);
         btn_Y.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_Y.setBounds(504, 423, 62, 59);
         contentPane.add(btn_Y);
         
         JButton btn_Z = new JButton("");
         btn_Z.setBorderPainted(false);
         btn_Z.setFocusPainted(false);
         btn_Z.setContentAreaFilled(false);
         btn_Z.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/Z.png")));
         btn_Z.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               game('Z');
            }
         });
         btn_Z.setBackground(Color.WHITE);
         btn_Z.setFont(new Font("µ¸¿ò", Font.BOLD, 30));
         btn_Z.setBounds(78, 585, 62, 59);
         contentPane.add(btn_Z);

      lbl_6 = new JLabel("");
      lbl_6.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uBA38\uB9AC.PNG")));
      lbl_6.setBounds(223, 110, 82, 82);
      contentPane.add(lbl_6);
      
      lbl_4 = new JLabel("");
      lbl_4.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uC624\uB978\uD314.PNG")));
      lbl_4.setBounds(277, 198, 49, 65);
      contentPane.add(lbl_4);
      
      lbl_3 = new JLabel("");
      lbl_3.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uC67C\uD314.PNG")));
      lbl_3.setBounds(205, 198, 55, 59);
      contentPane.add(lbl_3);
      
      lbl_5 = new JLabel("");
      lbl_5.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uBAB8\uD1B5.PNG")));
      lbl_5.setBounds(251, 190, 20, 96);
      contentPane.add(lbl_5);
      
      lbl_2 = new JLabel("");
      lbl_2.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uC67C\uB2E4\uB9AC.PNG")));
      lbl_2.setBounds(205, 285, 62, 59);
      contentPane.add(lbl_2);
      
      lbl_1 = new JLabel("");
      lbl_1.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uC624\uB978\uB2E4\uB9AC.PNG")));
      lbl_1.setBounds(264, 278, 62, 66);
      contentPane.add(lbl_1);
      
      lbl_8 = new JLabel("");
      lbl_8.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uB2E8\uB450\uB3002.PNG")));
      lbl_8.setBounds(57, 89, 394, 305);
      contentPane.add(lbl_8);
      
      lbl_9 = new JLabel("");
      lbl_9.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/\uC8FD\uC5C7\uC744\uB54C.png")));
      lbl_9.setBounds(177, 129, 245, 239);
      contentPane.add(lbl_9);
      
      
   
      
      lbl_First = new JLabel(name2);
      lbl_First.setForeground(Color.WHITE);
      lbl_First.setFont(new Font("±¼¸²", Font.BOLD, 50));
      lbl_First.setBounds(185, 0, 521, 74);
      contentPane.add(lbl_First);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(508, 89, 252, 290);
      contentPane.add(scrollPane);
      
      
      
      text_First = new JTextArea();
      text_First.setForeground(new Color(255, 255, 255));
      
      text_First.setBackground(new Color(0,100,0));
      
      text_First.setFont(new Font("Monospaced", Font.BOLD, 20));
      scrollPane.setViewportView(text_First);
      
      JButton btn_return = new JButton("");
      btn_return.setBorderPainted(false);
      btn_return.setForeground(new Color(0, 100, 0));
      btn_return.setBackground(new Color(0, 100, 0));
      btn_return.setFocusPainted(false);
      
      btn_return.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/iconmonstr-door-5-72 (1).png")));
      btn_return.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            dispose();   //Áö±ÝÃ¢ ´ÝÀ½
            setVisible(false);   //Áö±Ý Ã¢ ¾Èº¸ÀÌ°Ô
            name2="";
            name="";
            fileCnt=0;
            cnt=0;
            Hangman_main.cnt2=0;
            Hangman_main.check1p=false;
            
            new Hangman_main().setVisible(true);
            
            
         }
      });
      btn_return.setBounds(857, 23, 70, 72);
      contentPane.add(btn_return);
      
      JButton btn_coin = new JButton("");
      btn_coin.setBorderPainted(false);
      btn_coin.setBackground(new Color(0, 100, 0));
      btn_coin.setForeground(new Color(0, 100, 0));
      btn_coin.setFocusPainted(false);
      
      btn_coin.setIcon(new ImageIcon(Hangman_game_1p.class.getResource("/image/iconmonstr-coin-2-72 (1).png")));
      btn_coin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      btn_coin.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
        	coinSound.abc();
            text_First.setText(text_First.getText()+"µ¿Àü ÅõÀÔ!!!\n");
            cnt--;
            
            if (cnt ==0) {
               lbl_1.setVisible(true); 
               lbl_2.setVisible(true);
               lbl_3.setVisible(true);
               lbl_4.setVisible(true);
               lbl_5.setVisible(true);
               lbl_6.setVisible(true);
               lbl_8.setVisible(true);
               lbl_9.setVisible(false);
               name=strTemp;
            }
            
            
            if (cnt ==1) {
               lbl_1.setVisible(false); 
               lbl_2.setVisible(true);
               lbl_3.setVisible(true);
               lbl_4.setVisible(true);
               lbl_5.setVisible(true);
               lbl_6.setVisible(true);
               lbl_8.setVisible(true);
               lbl_9.setVisible(false);
               name=strTemp;
            }
            if (cnt ==2) {
               lbl_1.setVisible(false); 
               lbl_2.setVisible(false);
               lbl_3.setVisible(true);
               lbl_4.setVisible(true);
               lbl_5.setVisible(true);
               lbl_6.setVisible(true);
               lbl_9.setVisible(false);
               lbl_8.setVisible(true);
               name=strTemp;
            }
            if (cnt ==3) {
               lbl_1.setVisible(false); 
               lbl_2.setVisible(false);
               lbl_3.setVisible(false);
               lbl_4.setVisible(true);
               lbl_5.setVisible(true);
               lbl_6.setVisible(true);
               lbl_9.setVisible(false);
               lbl_8.setVisible(true);
               name=strTemp;
            }
            if (cnt ==4) {
               lbl_1.setVisible(false); 
               lbl_2.setVisible(false);
               lbl_3.setVisible(false);
               lbl_4.setVisible(false);
               lbl_5.setVisible(true);
               lbl_6.setVisible(true);
               lbl_9.setVisible(false);
               lbl_8.setVisible(true);
               name=strTemp;
            }   
            if (cnt ==5) {
               lbl_1.setVisible(false); 
               lbl_2.setVisible(false);
               lbl_3.setVisible(false);
               lbl_4.setVisible(false);
               lbl_5.setVisible(false);
               lbl_6.setVisible(true);
               lbl_9.setVisible(false);
               lbl_8.setVisible(true);
               name=strTemp;
            }
            if (cnt ==6) {
               lbl_1.setVisible(false); 
               lbl_2.setVisible(false);
               lbl_3.setVisible(false);
               lbl_4.setVisible(false);
               lbl_5.setVisible(false);
               lbl_6.setVisible(false);
               lbl_9.setVisible(true);
               lbl_8.setVisible(false);
               
               
            }
            
            if(cnt <0)
               cnt=0;
            
         }
      });
      btn_coin.setBounds(857, 110, 80, 82);
      contentPane.add(btn_coin);
      
      
      
      
   }
}