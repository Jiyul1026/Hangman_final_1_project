package practiceee;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class PaintSwing extends JFrame {

	private JPanel contentPane;
	private int witchiX=0,witchiY=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintSwing frame = new PaintSwing();
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
	public PaintSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Graphics g =getGraphics();
				g.setColor(Color.red);
				Graphics2D g2d = (Graphics2D)g;
				g2d.setStroke(new BasicStroke(10)) ;
				
				int badaX=e.getX();
				int badaY=e.getY();
				
				g.drawLine(witchiX, witchiY, badaX, badaX);
				witchiX=badaX;
				witchiY=badaY;
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			//마우스 누를때
			public void mousePressed(MouseEvent e) {
				witchiX=e.getX();
				witchiY=e.getY();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
