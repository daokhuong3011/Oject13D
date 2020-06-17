package Main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

	JPanel coordinates = new Coordinates();
	JLabel label1 = new JLabel();
	JButton bt0 = new JButton();
	JButton bt1 = new JButton();

	// ham khoi tao
	public MainFrame() {
		// ham khoi tao cac gia tri do hoa
		initUI();
	}

	public void initUI() {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setSize(screenSize.width, screenSize.height);
		this.setSize(924, 740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Computer Graphics");

		// o trong nhap so lieu

//		tf1.setBounds(140, 200, 100, 40);
//		tf1.setFocusable(true);
//		tf1.setText("");
//		tf1.setEditable(true);

		label1.setBounds(300, 600, 300, 40);
		label1.setEnabled(false);
		label1.setText("Toa do diem ve");
		label1.setFont(new Font("", Font.BOLD, 15));

		// nut thu nhat
		bt0.setText("2D Graphics");
		bt0.setBounds(70, 140, 150, 40);
		bt0.setBorder(BorderFactory.createBevelBorder(1));
		bt0.setFocusable(false);
		bt0.setFont(new Font("", Font.CENTER_BASELINE, 16));

		bt1.setText("3D Graphics");
		bt1.setBounds(70, 240, 150, 40);
		bt1.setBorder(BorderFactory.createBevelBorder(1));
		bt1.setFocusable(false);
		bt1.setFont(new Font("", Font.CENTER_BASELINE, 16));

		// label
		this.add(label1);

		// button
		this.add(bt0);
		bt0.addActionListener(this);
		this.add(bt1);

		// panel
		this.add(coordinates);
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
//			sf.index = 0;
//			xuLy();
			break;
		}
	}

//	public void xuLy() {
//		try {
//			int r1 = Integer.parseInt(tf2.getText());
//			int r2 = Integer.parseInt(tf1.getText());
//			if (r2 <= 200 && r1 <= 200) {
//				sf.R2 = r2;
//				sf.R1 = r1;
//				System.out.print(sf.R1);
//				System.out.print(sf.R2);
//				sf.repaint();
//			} else {
//				String message = "Vui long nhap dung dinh dang! ";
//				JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
//			}
//		} catch (Exception q) {
//			String message = "Vui long nhap dung dinh dang! ";
//			JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
//		}
//	}

	public void actionPerformed(ActionEvent e) {
		if ("DRAW!".equals(e.getActionCommand())) {
//			sf.index = 0;
//			xuLy();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainFrame mainframe = new MainFrame();
				mainframe.setVisible(true);
			}
		});
	}
}
