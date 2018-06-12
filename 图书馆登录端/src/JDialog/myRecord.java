package JDialog;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataExchange.lookrecord;
import LIbrarys.Record;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class myRecord extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private String n;
    private String bk;
	public myRecord(String name) {
		n=name;
		setTitle("\u6211\u7684\u5DF2\u501F\u56FE\u4E66");
		setBounds(100, 100, 639, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//借阅情况
		JLabel lblNewLabel = new JLabel("\u501F\u9605\u60C5\u51B5");
		lblNewLabel.setBounds(264, 41, 69, 18);
		contentPanel.add(lblNewLabel);
		//书名
		JLabel label = new JLabel("\u4E66\u540D");
		label.setBounds(94, 73, 72, 18);
		contentPanel.add(label);
		//借阅时间
		JLabel label_1 = new JLabel("\u501F\u9605\u65F6\u95F4");
		label_1.setBounds(215, 73, 72, 18);
		contentPanel.add(label_1);
		//归还事件
		JLabel lblNewLabel_1 = new JLabel("\u5F52\u8FD8\u65F6\u95F4");
		lblNewLabel_1.setBounds(334, 73, 72, 18);
		contentPanel.add(lblNewLabel_1);

		List<Record>list=new lookrecord().findallRecord(name);
		
		
		for(Record s:list)
		{
		int x=0;
		JTextField textField = new JTextField(s.getRb_name());
		textField.setBounds(78, 104+x, 86, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField(s.getLendDate());
		textField_1.setBounds(201, 104+x, 86, 24);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		//背景
		JLabel label2= new JLabel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("/BackImg/8.jpg"));
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(639,432,Image.SCALE_DEFAULT));
		label2.setIcon(img);
		label2.setBounds(0, 0, 639, 432);
		label2.setOpaque(false);
		contentPanel.add(label2);
	
		
		
		
		String sd="";
		if(s.getSendDate()!=null)
		{
			sd=s.getSendDate();
		}
		JTextField textField_2 = new JTextField(sd);
		textField_2.setBounds(334, 104+x, 86, 24);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		 
		 bk=s.getRb_name();
		 
		JButton btnNewButton = new JButton("还书");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new lookrecord().sendbook(n,bk);
			}
		});
		btnNewButton.setBounds(458, 103+x, 113, 27);
		contentPanel.add(btnNewButton);
		x=x+10;
	}
		

		
		
	}
}
