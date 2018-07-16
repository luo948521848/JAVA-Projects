package com.lc.shopmarket.Frames;



import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lc.shopmarket.DataExchage.StaffDao;

import com.lc.shopmarket.JavaBean.Staff;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
/*
*该类的功能以及特点描述：超市管理系统的登录界面


*该类是否被编译测试：否
*@see(与之相关联的类)：   来源：
*                     中间：
*                     去处：
*开发公司或单位：成007个人
*版权：成007

*@author(作者)：成007
*@since（该文件使用的jdk）：JDK1.8
*@version（版本）：1.0
*@数据库查询方式：mysql+Hibernate
*@date(开发日期)：2018/5/22
*改进：
*互斥复选框
*最后更改日期：
*/
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2611708944906142187L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private  Checkbox checkbox ;
	private Checkbox checkbox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		this.setTitle("超市管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		//窗口标签以及窗口居中
		//让窗口居中
		 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
	
		
		
		
		//账号输入框
		textField = new JTextField();
		textField.setBounds(348, 162, 137, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(103, 165, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setForeground(Color.RED);
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(103, 222, 72, 18);
		contentPane.add(label);
		
		
		//密码输入框
		passwordField = new JPasswordField();
		passwordField.setBounds(348, 219, 137, 24);
		contentPane.add(passwordField);
		
		
		
		//普通用户（收银员）  默认被选中
		checkbox = new Checkbox("普通用户",true);
		checkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//实现复选框相斥
				if(checkbox.getState())
				{
					checkbox_1.setState(false);
					
				}
				
				
				
			}
		});
		checkbox.setBounds(103, 91, 118, 25);
		contentPane.add(checkbox);
		
		
		//管理员用户
		 checkbox_1 = new Checkbox("管理员");
		checkbox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//实现复选框相斥
				if(checkbox_1.getState())
				{
					checkbox.setState(false);
					
				}
				
				
			}
		});
		checkbox_1.setBounds(360, 91, 118, 25);
		contentPane.add(checkbox_1);
		
		
		
		
		
		
		
		//取消按键
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//讲输入类容清空
				
				textField.setText("");
				passwordField.setText("");
				
			}
		});
		btnNewButton.setBounds(137, 297, 113, 27);
		contentPane.add(btnNewButton);
		
		//确认按键
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				String name=textField.getText().trim();
				//passwordField是二进制形式 所以要进行转换
				
				char[]m=passwordField.getPassword();
				String password=new String(m);
				
				//获取用户类型   root管理员   common普通用户
				String usertype;
				//因这2个复选框是互斥的，所以只要监听一个就
				if(checkbox.getState())
				{
					usertype="common";
					
				}
				else
				{
					usertype="root";
					
				}
				

				//进行用户登录和查询
				
				if(name.equals("")||password.equals(""))
				{
					//输入框为空
					JOptionPane.showMessageDialog(null, "账号与密码不得为空", "警告", JOptionPane.ERROR_MESSAGE);
					
					
					
				}
				else
				{
				
					Staff staff=StaffDao.getStaffDao().Login(name,password,usertype);
				
				
				if(staff!=null)
				{
					//登录成功
					
				     if(usertype.equals("root"))
				     {
				    	 //进入管理者界面
				    	 MainFrame mainFrame=new MainFrame(staff.getName());
				    
				    	 mainFrame.configTimeArea();
				    	 mainFrame.configTimeArea01();
				    	 mainFrame.setVisible(true);
				    	 dispose();
				     }
				     else
				     {
				    	//收银终端
				    	 CheckstandFrame check1= new CheckstandFrame();
				    	 check1.configTimeArea();
				    	 check1.setVisible(true);
				    	 dispose();
				    	 
				     }
					
					
					
					
				}
				else
				{
					//登录失败  尝试重新登录
					JOptionPane.showMessageDialog(null, "账号或者密码错误", "警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}
				
				
				
				
				
				
				
				
				}
			}
		});
		btnNewButton_1.setBounds(371, 297, 113, 27);
		contentPane.add(btnNewButton_1);
		
		
		
		//背景
		JLabel label1= new JLabel("\u7BA1\u7406\u5458");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/images/1.jpg"));
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(592,417,Image.SCALE_DEFAULT));
		label1.setIcon(img);
		label1.setBounds(0, 0, 592, 417);
		getContentPane().add(label1);
		

		
		
		
		
		
		//pack();
		//键盘监听事件 进行焦点切换
	    this.addKeyListener(new KeyAdapter()//键盘监听按钮
	    		   {
	    		        public void keyPressed(KeyEvent e)
	    		        {
	    		            if(e.getKeyCode()==KeyEvent.VK_TAB)
	    		            {
	    		            	passwordField.addFocusListener(new FocusListener() {
									
									@Override
									public void focusLost(FocusEvent arg0) {
										// TODO 自动生成的方法存根
										
									}
									
									@Override
									public void focusGained(FocusEvent arg0) {
										// TODO 自动生成的方法存根
										
									}
								});
	    		            	{}
	    		            	
	    		            }

	    		        }
	    		        
	    		    });
		
	}
}
