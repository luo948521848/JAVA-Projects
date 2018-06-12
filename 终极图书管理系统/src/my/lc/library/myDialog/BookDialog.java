package my.lc.library.myDialog;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import my.lc.library.librarys.book;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
    private book Book;
	private String name2=null;
	public BookDialog(book b,final String name) {
		this.name2=name;
		this.Book=b;
		this.setBounds(100, 100, 604, 474);
		this.setTitle(Book.getBookname()+"的基本信息");
        getContentPane().setLayout(null);
	
    	//窗口标签以及窗口居中
		//让窗口居中
		 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
		
		
		//书的图片
		JLabel lblNewLabel = new JLabel("bookimg");
		lblNewLabel.setBounds(94, 39, 110, 146);
		ImageIcon img=new ImageIcon("/BookImg/"+b.getBookname()+".jpg");
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(110,146,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(img);	
		getContentPane().add(lblNewLabel);
		
		//二维码
		JLabel lblNewLabel_1 = new JLabel("Qcode");
		lblNewLabel_1.setBounds(94, 231, 92, 92);
		ImageIcon img2=new ImageIcon("/Code/"+b.getBookname()+".png");
		//设置照片大小
		img2.setImage(img2.getImage().getScaledInstance(92,92,Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(img2);
		getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel label = new JLabel("书名");
		label.setBounds(290, 39, 72, 18);
		getContentPane().add(label);
		
		JLabel label1 = new JLabel("\u4F5C\u8005");
		label1.setBounds(290, 103, 72, 18);
		getContentPane().add(label1);
		
		JLabel label_2 = new JLabel("\u6570\u91CF");
		label_2.setBounds(290, 167, 72, 18);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u51FA\u7248\u793E");
		label_3.setBounds(290, 238, 72, 18);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u51FA\u7248\u65E5\u671F");
		label_4.setBounds(290, 300, 72, 18);
		getContentPane().add(label_4);
		

		
		System.out.println(b);
		
		
		//书名
		textField = new JTextField(Book.getBookname());
		textField.setBounds(376, 39, 110, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		//作者
		textField_1 = new JTextField(Book.getWriter());
		textField_1.setColumns(10);
		textField_1.setBounds(376, 100, 110, 24);
		getContentPane().add(textField_1);
		
		//数量
		int num=Book.getNum();
		String nums=Integer.toString(num);
		textField_2 = new JTextField(nums);
		textField_2.setColumns(10);
		textField_2.setBounds(376, 164, 110, 24);
		getContentPane().add(textField_2);
		
		//出版社
		textField_3 = new JTextField(Book.getPublish());
		textField_3.setColumns(10);
		textField_3.setBounds(376, 235, 110, 24);
		getContentPane().add(textField_3);
		
		//日期
		textField_4 = new JTextField(Book.getWritedate());
		textField_4.setColumns(10);
		textField_4.setBounds(376, 297, 110, 24);
		getContentPane().add(textField_4);
		
		

		
		JButton button = new JButton("取消");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(74, 367, 113, 27);
		getContentPane().add(button);
		
		
		JButton btnNewButton = new JButton("借阅");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//生成借阅记录
               
				
				
			JOptionPane.showMessageDialog(null, "借阅成功！", "提示", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		btnNewButton.setBounds(416, 367, 113, 27);
		getContentPane().add(btnNewButton);
		
		
		JButton button_1 = new JButton("归还");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//查询并修改阅读记录
                
				
				
				
			
			}
		});
		
		button_1.setBounds(257, 367, 113, 27);
		getContentPane().add(button_1);
		JLabel label2= new JLabel();
		ImageIcon img3=new ImageIcon(this.getClass().getResource("/BackImg/10.jpg"));
		//设置照片大小
		img3.setImage(img3.getImage().getScaledInstance(639,432,Image.SCALE_DEFAULT));
		label2.setIcon(img3);
		label2.setBounds(0, 0, 639, 432);
		label2.setOpaque(false);
		this.add(label2);
		
	}
}
