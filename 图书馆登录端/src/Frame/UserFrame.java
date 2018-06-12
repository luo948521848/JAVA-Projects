package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataExchange.Look_book;
import JDialog.CreatebookDialog;
import JDialog.RemoveBookDialog;
import JDialog.myLibrary;
import JDialog.myRecord;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private String usertype=null;
    private String name=null;
	public UserFrame(String s,String n) {
		name=n;
		this.usertype=s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//窗口标签以及窗口居中
		//让窗口居中
		 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
		//窗口图标  要设置img包  放入图片
		                 String path="/BackImg/book.jpg/";

				try{
					
					Image img =ImageIO.read(this.getClass().getResourceAsStream(path));
					this.setIconImage(img);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}		
		
		
		//菜单栏
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("\u7528\u6237\u7BA1\u7406");
		menuBar.setBounds(0, 0, 742, 26);
		contentPane.add(menuBar);
		
		//图书管理
		JMenu mnNewMenu = new JMenu("用户管理");
		menuBar.add(mnNewMenu);
		

		
		JMenuItem menuItem = new JMenuItem("图书管理");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new myRecord(name).setVisible(true);
				
				
			}
		});
		mnNewMenu.add(menuItem);
		
		
		//书籍管理
		JMenu menu = new JMenu("书籍管理");
		
		if(usertype.equals("root"))
		{
			menuBar.add(menu);
		}
		
			
		
		
		JMenuItem menuItem_1 = new JMenuItem("图书上架");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//打开新建图书对话框
				new CreatebookDialog().setVisible(true);
				
				
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("图书下架");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new RemoveBookDialog().setVisible(true);
				
			}
		});
		menu.add(menuItem_2);
		
		
		
		
		
		//电子书籍
		JMenu mnNewMenu_1 = new JMenu("\u7535\u5B50\u56FE\u4E66\u9986");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u5206\u7C7B");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new myLibrary(name).setVisible(true);
				
			}
		});
		mnNewMenu_1.add(menuItem_3);
		
		//页面端
		JMenu menu_1 = new JMenu("页面端");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8FDB\u5165\u9875\u9762\u7AEF");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//用JAVA EE来做
				
				
				
			}
		});
		menu_1.add(menuItem_4);
		
		//帮助
		JMenu mnf = new JMenu("帮助");
		menuBar.add(mnf);
		
		JMenuItem menuItem_5 = new JMenuItem("\u8FDB\u5165\u5E2E\u52A9");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//打开一网页
				Runtime rt = Runtime.getRuntime();
				try  
				{
				rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://www.baidu.com");
				 } 
				catch (IOException e1) 
				{
				}
				
				
			}
		});
		mnf.add(menuItem_5);
		
		textField = new JTextField();
		textField.setBounds(163, 152, 307, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索一下");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//通过书名进行查询
				
				String b_name=textField.getText();
				textField.setText("");
				new Look_book(b_name,name);
				
				
				
			}
		});
		btnNewButton.setBounds(471, 152, 113, 37);
		contentPane.add(btnNewButton);
		

		//背景
		JLabel label= new JLabel("");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/BackImg/2.jpg"));
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(760,485,Image.SCALE_DEFAULT));
		label.setIcon(img);
		label.setBounds(0, 0, 742, 438);
		contentPane.add(label);
	}
}
