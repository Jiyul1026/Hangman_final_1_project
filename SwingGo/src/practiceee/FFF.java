package practiceee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;

public class FFF extends JFrame {

        private JPanel contentPane;
        private JTextField textField;///////////

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        FFF frame = new FFF();
                                        frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        /**
         * Create the frame.
         * @param pw 
         * @param id 
         */
        public FFF(String id, String pw) {//인자 있는 생성자 
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 450, 300);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
                contentPane.setLayout(null);
                
                textField = new JTextField();
                textField.setBackground(Color.YELLOW);
                textField.setBounds(38, 44, 174, 43);
                contentPane.add(textField);
                textField.setColumns(10);
                //-------------------------
                textField.setText(id+","+pw);//babo,ondal 
                //-------------------------
        }
        public FFF() {//디폴트생성자 
                getContentPane().setLayout(null);
                
                JLabel lblNewLabel = new JLabel("New label");
                lblNewLabel.setBounds(102, 66, 57, 15);
                getContentPane().add(lblNewLabel);} //디폴트도 내가 만들어야 함 
}
