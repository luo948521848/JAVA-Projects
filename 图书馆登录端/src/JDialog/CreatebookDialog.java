package JDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataExchange.CreateBook;
import DataExchange.QCode;
import LIbrarys.book;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class CreatebookDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
    private book b=null;

	public CreatebookDialog() {
		setBounds(100, 100, 563, 496);
		getContentPane().setLayout(null);
		
		//取消
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(111, 398, 113, 27);
		getContentPane().add(btnNewButton);
		
		//确定
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b=new book();
				b.setB_name(textField.getText());
				b.setB_writer(textField_1.getText());
				Integer n=Integer.parseInt(textField_2.getText());
				b.setB_num(n);
				b.setB_publish(textField_3.getText());
				b.setBr_date(textField_4.getText());
				System.out.println(b);
				new CreateBook(b);
				
				
				//创建二维码
				
				new QCode(b);
				
				JOptionPane.showMessageDialog(null, "新建成功", "提示", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		btnNewButton_1.setBounds(304, 398, 113, 27);
		getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("\u4E66\u540D");
		label.setBounds(71, 49, 72, 18);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005");
		lblNewLabel.setBounds(71, 99, 72, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6570\u91CF");
		lblNewLabel_1.setBounds(71, 154, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u7248\u793E");
		lblNewLabel_2.setBounds(71, 211, 72, 18);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u51FA\u7248\u65E5\u671F");
		lblNewLabel_3.setBounds(71, 282, 72, 18);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(219, 46, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 96, 86, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 151, 86, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(219, 208, 86, 24);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(219, 279, 86, 24);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		//上传图片
		JButton btnNewButton_2 = new JButton("\u4E0A\u4F20\u56FE\u7247");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    
			        try {
						// TODO Auto-generated method stub  
						JFileChooser jfc=new JFileChooser();  
						jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
						jfc.showDialog(new JLabel(), "选择");  
						File file=jfc.getSelectedFile();  
						if(file.isDirectory()){  
						    System.out.println("文件夹:"+file.getAbsolutePath()); 
						    
						}else if(file.isFile()){  
						    System.out.println("文件:"+file.getAbsolutePath());
						    
						} 
						//要有写入和读取的过程
						
						File f=new File("C://Users/Administrator/Desktop/mylibrary/book/"+textField.getText()+".jpg");
						if(f.isFile() && f.exists())
						{
							JOptionPane.showMessageDialog(null, "图书已存在", "提示", JOptionPane.ERROR_MESSAGE);
						}
						else
						{ 
							//不存在则写入 
							//来源
							try {
								InputStream input=new FileInputStream(file);
								//出口
								OutputStream output=new FileOutputStream(f);
								
								//创建缓冲区
								byte[] buff=new byte[input.available()];
								input.read(buff);//客人进
								output.write(buff);//客人出
								input.close();
								output.close();
							} catch (FileNotFoundException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							
						}	
						
						
						

						
					} catch (HeadlessException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						
					}
			        
			          
			        
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(363, 150, 113, 27);
		getContentPane().add(btnNewButton_2);
		
		//背景图片
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(this.getClass().getResource("/BackImg/5.jpg")));
		lblNewLabel_4.setBounds(0, 0, 545, 449);
		getContentPane().add(lblNewLabel_4);
	}
}
