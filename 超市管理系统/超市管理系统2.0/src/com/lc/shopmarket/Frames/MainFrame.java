package com.lc.shopmarket.Frames;



import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lc.shopmarket.DataExchage.InventoryDao;
import com.lc.shopmarket.DataExchage.SaleDao;
import com.lc.shopmarket.Dialog.AddUserDialog;
import com.lc.shopmarket.Dialog.MidInventoryDialog;
import com.lc.shopmarket.Dialog.MidMerchandiseDialog;
import com.lc.shopmarket.Dialog.MidUserDialog;
import com.lc.shopmarket.Dialog.PutInventoryDialog;
import com.lc.shopmarket.Dialog.PutawayDialog;
import com.lc.shopmarket.JavaBean.Sale;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.awt.event.ActionEvent;


import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
*该类的功能以及特点描述：超市管理系统的管理员主界面


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
*1.动态显示数据信息
*2.通过定时器实时展示销售信息
*
*
*最后更改日期：
*/
public class MainFrame extends JFrame implements Serializable{

	/**
	 * 
	 */ 
	private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";  
	private String time;  
	private int ONE_SECOND = 1000;
	private int ONE_minute =60000;
	private static final long serialVersionUID = -4784343392062508158L;
	private JPanel contentPane;
	private JTextField textField;
	private String name;

	   //表格所需的变量
    private Vector<String>colunmNames;
    private Vector<Vector<String>>tableValue;
    private JTable table;
	public MainFrame(String n) {
		this.name=n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 468);
		setTitle("欢迎使用超市管理系统");
		this.setResizable(false);
		//窗口标签以及窗口居中
		//让窗口居中
		 Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight=dem.height;
		int sWidth=dem.width;
		int fHeight=this.getHeight();
		int fWidth=this.getWidth();
		this.setLocation((sWidth-fWidth)/2, (sHeight-fHeight)/2);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4ED3\u5E93");
		menuBar.add(menu);
		
		//商品入库
		JMenuItem menuItem_3 = new JMenuItem("\u5546\u54C1\u5165\u5E93");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new PutInventoryDialog(name).setVisible(true);
			}
		});
		menu.add(menuItem_3);
		
		//查看库存
		JMenuItem menuItem_8 = new JMenuItem("\u67E5\u770B\u5E93\u5B58");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MidInventoryDialog("查看库存").setVisible(true);
				
			}
		});
		menu.add(menuItem_8);
		
		JMenu menu_6 = new JMenu("\u8D27\u67B6");
		menuBar.add(menu_6);
		
		//商品上架
		JMenuItem menuItem_4 = new JMenuItem("\u5546\u54C1\u4E0A\u67B6");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    //打开上架对话框进行进货操作
				
				new PutawayDialog().setVisible(true);
			}
		});
		menu_6.add(menuItem_4);
		
		
		//商品下架
		JMenuItem menuItem_14 = new JMenuItem("\u5546\u54C1\u4E0B\u67B6");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MidMerchandiseDialog("撤销").setVisible(true);
				
			}
		});
		
		//修改货架商品信息
		JMenuItem menuItem_7 = new JMenuItem("\u8D27\u67B6\u5546\u54C1\u4FEE\u6539");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MidMerchandiseDialog("修改").setVisible(true);
				
				
			}
		});
		menu_6.add(menuItem_7);
		menu_6.add(menuItem_14);
		
		JMenu menu_1 = new JMenu("\u7528\u6237\u67E5\u8BE2");
		menuBar.add(menu_1);
		
		//用户信息（可以进行修改）
		JMenuItem mntmVip = new JMenuItem("VIP\u4FE1\u606F");
		mntmVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//打开查询对话框
				new MidUserDialog().setVisible(true);
			}
		});
		menu_1.add(mntmVip);
		
		//注册新用户
		JMenuItem mntmvip = new JMenuItem("\u6CE8\u518CVIP");
		mntmvip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddUserDialog addUserDialog=new AddUserDialog();
			
				addUserDialog.setVisible(true);
				
				
				
			}
		});
		menu_1.add(mntmvip);
		
		//注册收银员 
		//这个菜单栏 在是Root时才被添加
		JMenuItem menuItem_2 = new JMenuItem("\u6CE8\u518C\u6536\u94F6\u5458");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("\u660E\u7EC6\u67E5\u8BE2");
		menuBar.add(menu_2);
		
		
		//查询收银员的收银金额
		JMenuItem menuItem_10 = new JMenuItem("\u67E5\u770B\u9500\u552E\u6392\u884C");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_2.add(menuItem_10);
		
		//根据销售Id查询销售记录
		JMenuItem menuItem_9 = new JMenuItem("\u67E5\u770B\u9500\u552E\u4FE1\u606F\u8868");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_2.add(menuItem_9);
		
		JMenu menu_3 = new JMenu("\u67E5\u8BE2\u5546\u54C1\u4FE1\u606F");
		menuBar.add(menu_3);
		
		
		//查看商品信息
		JMenuItem menuItem_11 = new JMenuItem("\u67E5\u770B\u5546\u54C1\u4FE1\u606F");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//输入商品编号查询商品
				new MidMerchandiseDialog("查询").setVisible(true);
				
				
			}
		});
		menu_3.add(menuItem_11);
		
		JMenu menu_5 = new JMenu("\u6309\u5546\u54C1\u7C7B\u522B\u67E5\u8BE2");
		menuBar.add(menu_5);
		
		
		//查看一类产品的销售情况
		JMenuItem menuItem_12 = new JMenuItem("\u5206\u7C7B\u67E5\u8BE2\u9500\u552E\u60C5\u51B5");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		menu_5.add(menuItem_12);
		
		JMenuItem menuItem_1 = new JMenuItem("");
		menu_5.add(menuItem_1);
		
		JMenu menu_4 = new JMenu("\u7CFB\u7EDF");
		menuBar.add(menu_4);
		
		//退出系统的菜单
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//关闭程序
				System.exit(0);
				
				
			}
		});
		menu_4.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 41, 701, 326);
		
		
		//在这里添加实时展示销售信息
		
	    table=new JTable();
		

		//用model给jtable填充数据，vector给model填充数据，vector给vector填充数据   
		//因为第一参数接收的是二维的参数，所以产生了vector给vector填充数据 
		colunmNames=new Vector<String>();
		colunmNames.add("销售ID");
		colunmNames.add("商品ID");
		colunmNames.add("销售日期");
		colunmNames.add("数量");
		colunmNames.add("价格");
		colunmNames.add("折扣");
		colunmNames.add("VIP号");
		colunmNames.add("商品名称");
		colunmNames.add("收银员");

		//定义二维部分
		tableValue =new Vector<Vector<String>>();//定义表格数据向量
		SetTable();
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
         //水平滚动条根据需要才显示
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
		//垂直滚动条根据需要才显示
		tabbedPane.add(scrollPane);

	

		contentPane.add(tabbedPane);
		
		JLabel label = new JLabel("\u5B9E\u65F6\u9500\u552E\u60C5\u51B5");
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(268, 13, 119, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5F53\u524D\u65F6\u95F4");
		label_1.setFont(new Font("黑体", Font.PLAIN, 15));
		label_1.setBounds(438, 377, 72, 18);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(524, 374, 152, 24);
		contentPane.add(textField);
		textField.setColumns(10);
	}
    public void configTimeArea() {  
        Timer tmr = new Timer();  
        tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_SECOND);  
    }  
    /** 
     * Timer task 更新时间显示区 
     *  
     */  
    protected class JLabelTimerTask extends TimerTask {  
        SimpleDateFormat dateFormatter = new SimpleDateFormat(  
                DEFAULT_TIME_FORMAT);  
  
        @Override  
        public void run() {  
            time = dateFormatter.format(Calendar.getInstance().getTime());  
            textField.setText(time);  
        }  
    } 
    
    
    
    
    public void configTimeArea01() { 
    	
        Timer tmr = new Timer();  
        tmr.scheduleAtFixedRate(new JLabelTimerTask(), new Date(), ONE_minute);  
    }  
    /** 
     * Timer task 更新时间显示区 
     *  
     */  
    protected class JLabelTimerTask01 extends TimerTask {  
  
    	//每隔一分钟的行为
        @Override  
        public void run() {  
        	SetTable();
         
        }  
        
    }
        
        public void SetTable()
        {
        	
       	//查询数据库  最后十条数据（最新产生的10条）
        	
        	List<Sale>list=new SaleDao().looklast();
        	//数据靠后的排在前面
        
        	for(int i=list.size()-1;i>=0;i--)
        	{
        		Sale sale=list.get(i);
				 //加入到表格中
				 Vector<String>row=new Vector<String>();
				 row.add(sale.getSaleId());
				 row.add(sale.getProductId());
				 row.add(sale.getSaleDate());
				 row.add(sale.getNumber().toString());
				 row.add(sale.getPrice().toString());
				 row.add(sale.getDiscount());
				 row.add(sale.getVipId());
				 row.add(sale.getProductName());
				 row.add(sale.getCashier());
				 tableValue.add(row);
		
        	}
        	
        	
			 //加入到表格中
			 DefaultTableModel model = new DefaultTableModel(tableValue,colunmNames);
			 table.setModel(model);
        }
    
    
    
    
    
    
    
    
    
    
    
}
