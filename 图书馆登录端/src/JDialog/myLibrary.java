package JDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataExchange.Login;
import DataExchange.Look_book;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Label;

public class myLibrary extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private List<String>list=null;
    private String name=null;
	public myLibrary(String nm) {
		this.name=nm;
		setBounds(100, 100, 661, 445);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.GREEN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u9986");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(276, 0, 92, 81);
		contentPanel.add(label);

		
		list=new Look_book().lookbooks();
		int	n=0,x=0,y=0;
		for(String bookname:list){

		
			
		JLabel label_1= new JLabel();
		ImageIcon img=new ImageIcon("C://Users/Administrator/Desktop/mylibrary/book/"+bookname+".jpg");
		//设置照片大小
		img.setImage(img.getImage().getScaledInstance(77,125,Image.SCALE_DEFAULT));
		label_1.setIcon(img);
		label_1.setBounds(101+x, 89+y, 77, 125);
	
		contentPanel.add(label_1);
		
		label_1.addMouseListener(new MouseAdp(name,bookname));
		 n++;
		 if(n%3==0){
			 y=y+183;
			 x=x-460;	 
		 }
		 else{
			 x=x+180;
			 
		 }
		 
		 /*
			//背景
			JLabel label2= new JLabel();
			ImageIcon img1=new ImageIcon(this.getClass().getResource("/BackImg/8.jpg"));
			//设置照片大小
			img1.setImage(img1.getImage().getScaledInstance(661,445,Image.SCALE_DEFAULT));
			label2.setIcon(img1);
			label2.setBounds(0, 0, 661, 445);
			label2.setOpaque(true);
			this.add(label2);
		 
		 */
		 }
		

		
		
	}
}
