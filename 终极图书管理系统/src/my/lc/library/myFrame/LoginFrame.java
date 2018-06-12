package my.lc.library.myFrame;

import java.awt.BorderLayout;



import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import my.lc.library.dataExchange.UserService;
import my.lc.library.interfaces.UserInterface;
import my.lc.library.librarys.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8068421322318377574L;
	private JTextField textField;
	private JPasswordField passwordField;
    public Integer wid=584;
    public Integer hig=376;

	public static void main(String[] args) {
		
					LoginFrame frame = new LoginFrame();
				    frame.setVisible(true);
	
	}

	
	
	public LoginFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(584,376);
		this.setLayout(null);
		this.setResizable(false);
		//窗口标签以及窗口居中
		//让窗口居中
		 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
		//窗口图标  要设置img包  放入图片
		                 String path="/BackImg/1.png/";

				try{
					
					Image img =ImageIO.read(this.getClass().getResourceAsStream(path));
					this.setIconImage(img);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		
		
		
		
		
		//输入部分
		JLabel lblNewLabel = new JLabel("用户");
		lblNewLabel.setBounds(132, 113, 72, 23);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(132, 162, 72, 18);
		this.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(206, 112, 179, 24);
		this.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 159, 179, 24);
		this.add(passwordField);
		
		//取消按钮
		JButton btnNewButton = new JButton("取消");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton.setBounds(132, 265, 113, 27);
		this.add(btnNewButton);
		
		//确认按钮
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//获取账号和密码
				String name=textField.getText();
				char[]m=passwordField.getPassword();
				String password=new String(m);

				//对账号进行进行验证
				//从Spring bean容器获取服务层
				
				ApplicationContext app= new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
				UserService userService=app.getBean("userService",UserService.class);
				User user=userService.ImpLogin(name, password);
				if(user!=null)
				{
					
					//登录成功  将用户信息同步存储在Session中
					/*
					 * 这里没有产生request 
					HttpServletRequest request = ServletActionContext.getRequest();
					HttpSession session = request.getSession(); 
					session.setAttribute("name", name);
					*/
					
					//调整返回值类型，来获取用户类型
					UserFrame userFrame=new UserFrame(user);
					userFrame.setVisible(true);
				}
				else
				{
					//登录失败
					JOptionPane.showMessageDialog(null, "输入的账号有误", "警告", JOptionPane.ERROR_MESSAGE);
					
				}
				dispose();
				
			}

			
		});
		
		btnNewButton_1.setBounds(313, 265, 113, 27);
		this.add(btnNewButton_1);
		
		//背景
		JLabel label= new JLabel("");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/BackImg/1.jpg"));
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(566,329,Image.SCALE_DEFAULT));
		label.setIcon(img);
		label.setBounds(0, 0, 566, 329);
		this.add(label);	
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
