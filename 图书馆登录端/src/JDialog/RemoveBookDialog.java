package JDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataExchange.RemoveBook;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public RemoveBookDialog() {
		setBounds(100, 100, 650, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u60A8\u60F3\u4E0B\u67B6\u7684\u56FE\u4E66\u540D");
		label.setBounds(108, 140, 150, 18);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(326, 137, 174, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			dispose();
				
				
			}
		});
		btnNewButton.setBounds(173, 303, 113, 27);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new RemoveBook(textField.getText());
				
				
			}
		});
		btnNewButton_1.setBounds(375, 303, 113, 27);
		contentPanel.add(btnNewButton_1);
		
		
		//背景图
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/BackImg/5.jpg"));
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(632,397,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(0, 0, 632, 397);
		contentPanel.add(lblNewLabel);
	}
}
