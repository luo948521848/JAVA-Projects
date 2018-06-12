package client;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private JTextArea textArea;
    private Thread thread;
    private int i=1;
    private boolean iswhile=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel 聊天室 = new JLabel("\u804A\u5929\u5BA4");
		聊天室.setForeground(Color.RED);
		聊天室.setFont(new Font("宋体", Font.BOLD, 15));
		聊天室.setBounds(289, 37, 81, 18);
		contentPane.add(聊天室);
		
		textArea = new JTextArea();
		textArea.setBounds(62, 91, 571, 210);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("\u60A8\u60F3\u8BF4\u7684\u8BDD\uFF1A");
		lblNewLabel.setBounds(39, 337, 126, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 334, 310, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//发送
		JButton btnNewButton = new JButton("\u53D1\u9001");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String word=textField.getText();
				
				if(i==1)
				{
			    thread.start();
			    i=i-1;
			    System.out.println("start");
				}
				else
				{
					System.out.println("重启");
					iswhile=false;
					synchronized (thread){
					thread.notify();
					}
				}
		        try {
					Getconnection g=new Getconnection("127.0.0.1", word);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		        
		       
		        
		       textField.setText("");
		        iswhile=true;
		       
				
			}
		});
		btnNewButton.setBounds(508, 333, 113, 27);
		contentPane.add(btnNewButton);
		
		//背景
		JLabel label= new JLabel("");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/img/timg.jpg"));
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(677,389,Image.SCALE_DEFAULT));
		label.setIcon(img);
		label.setBounds(0, 0, 677, 389);
		contentPane.add(label);
		
		thread=new Thread(new Runnable() {
			
			private ServerSocket server;

			@Override
			public void run() {
				
				try {
					this.server=new ServerSocket(9913);
					 while(true)
					 {
						 
						synchronized (thread) {
							
						while(iswhile)
							{
								thread.wait();
							}
						}
						Socket socket = server.accept();
						//获取输入流
						InputStream is=socket.getInputStream();
						InputStreamReader isr =new InputStreamReader(is);				
						//转化成字符流
						BufferedReader rd=new BufferedReader(isr);
						String str="客户端:"+rd.readLine();
						textArea.append("\r\n"+str);
						System.out.print(str);
					
						
					 }
				
				} catch (IOException | InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				finally
				{
					try {
						server.close();
						
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}
			}
		});
		
	
	
			
		
		

		
	}
}
