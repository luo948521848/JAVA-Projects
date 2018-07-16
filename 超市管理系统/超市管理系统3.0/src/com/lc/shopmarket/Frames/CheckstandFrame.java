package com.lc.shopmarket.Frames;



import java.awt.Dimension;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/*
*该类的功能以及特点描述：超市管理系统的收银终端


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
*@date(开发日期)：2018/5/20
*改进：
*表格数据展示
*最后更改日期：
*/
public class CheckstandFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2788061383851054361L;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
    private String DEFAULT_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";  
    private String time;  
    private int ONE_SECOND = 1000;
 
    private double sum=1.8;//测试所用
    
    
    
    
    
    
    
    
    
    //表格所需的变量
    private Vector<String>colunmNames;
    private Vector<Vector<String>>tableValue;
    private JTable table;

    private DecimalFormat df = new DecimalFormat( "0.0 "); 
	/**
	 * Create the frame.
	 */
	public CheckstandFrame() {
		setTitle("\u8D85\u5E02\u6536\u94F6\u7EC8\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 594);
		contentPane = new JPanel();
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 38, 650, 310);
		
         
		/*
		String[] colunmNames1={"商品编号","名称","规格","单位","数量","售价","折扣","金额"};
		String [][]row={};
		*/
		
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
		//定义一行的数据类容
		Vector<String>row1=new Vector<String>();
		row1.add("001");
		row1.add("乐视薯条");
		row1.add("300g");
		row1.add("包");
		row1.add("1");
		row1.add("90");
		row1.add("1");
		row1.add("5.9");
		tableValue.add(row1);
		
		Vector<String>row2=new Vector<String>();
		row2.add("001");
		row2.add("乐视薯条");
		row2.add("300g");
		row2.add("包");
		row2.add("1");
		row2.add("90");
		row2.add("1");
		row2.add("5.9");
		tableValue.add(row2);
		
		
		
        //修改table(增加)即可
		//根据扫码添加商品
		
		DefaultTableModel model = new DefaultTableModel(tableValue,colunmNames);
		table.setModel(model);
		
	
		//监听table的行数的变化
		
		table.getModel().addTableModelListener(new TableModelListener()  
        {  
            @Override  
            public void tableChanged(TableModelEvent e)  
            {  
                  
            	System.out.print("表格发生了变化");
            	
            	//4价格  5折扣
            	DefaultTableModel model = (DefaultTableModel)table.getModel();//获取defaulttablemodel
            	
            	int size = table.getRowCount(); 
            	//因为是遍历全表
            	sum=0.0;
            	for(int i=0;i<size;i++)
            	{
            		String price=model.getValueAt(i,4).toString();
            		double price001=new Double(price);
            		String discount=model.getValueAt(i,5).toString();
            		double discount001=new Double(discount);
            		
            		sum=sum+price001*(discount001/100);
  	
            	}
                
            	
            	textField_6.setText(String.valueOf(df.format(sum)));
 
  
            }  
        }); 
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        //水平滚动条根据需要才显示
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
		//垂直滚动条根据需要才显示
		tabbedPane.add(scrollPane);
		
		contentPane.add(tabbedPane);
		
		JLabel label_1 = new JLabel("\u4F1A\u5458\u5361\u53F7");
		label_1.setBounds(14, 398, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_5 = new JLabel("\u5F53\u524D\u65F6\u95F4");
		label_5.setBounds(393, 361, 72, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5E94\u6536\u8D26\u6B3E");
		label_6.setFont(new Font("黑体", Font.PLAIN, 18));
		label_6.setBounds(14, 451, 72, 18);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u9884\u4ED8\u6B3E");
		label_7.setFont(new Font("黑体", Font.PLAIN, 18));
		label_7.setBounds(217, 451, 72, 18);
		contentPane.add(label_7);
		
		JLabel lblNewLabel = new JLabel("\u627E\u96F6\u91D1\u989D");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setBounds(393, 451, 72, 18);
		contentPane.add(lblNewLabel);
		
		//会员卡号
		textField_2 = new JTextField();
		textField_2.setBounds(98, 377, 86, 42);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		//当前时间
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setBounds(354, 395, 151, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		//应收账款
		textField_6 = new JTextField();
		textField_6.setText(String.valueOf(df.format(sum)));
		textField_6.setEditable(false);
		textField_6.setBounds(98, 441, 86, 42);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		//预付金额
		textField_7 = new JTextField();
		
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				

				String text=textField_7.getText().trim();
				
				if(text.equals(""))
				{
					textField_8.setText("");
				}
				else
				{
				double mon=new Double(text);
				
				if(mon>=sum)
				{
					double r=mon-sum;
					textField_8.setText(new String(df.format(r)));
				}
				else
				{
					textField_8.setText("");
				}
				}
				
				
				
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(277, 441, 86, 42);
		contentPane.add(textField_7);
		//找零金额
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(489, 441, 86, 42);
		contentPane.add(textField_8);
		
		
		
		//撤销商品
		JButton btnNewButton = new JButton("\u64A4\u9500\u5546\u54C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//难点如何确定选定的表中的商品
				
				
				int[] selection = table.getSelectedRows();
				DefaultTableModel model = (DefaultTableModel)table.getModel();//获取defaulttablemodel
				
				
				
				for(int i:selection)
				{
					
            		String price=model.getValueAt(i,4).toString();
            		double price001=new Double(price);
            		String discount=model.getValueAt(i,5).toString();
            		double discount001=new Double(discount);
            		
            		sum=sum-price001*(discount001/100);
					model.removeRow(i);//删除某行
				}
				table.setModel(model);
				
			}
		});
		btnNewButton.setBounds(61, 507, 113, 27);
		contentPane.add(btnNewButton);
		//交易取消
		JButton btnNewButton_1 = new JButton("\u4EA4\u6613\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//清空getModel
				 //加入到表格中
				 tableValue=null;
				 DefaultTableModel model = new DefaultTableModel(tableValue,colunmNames);
				 table.setModel(model);
				 sum=0.0;
				
				
			}
		});
		btnNewButton_1.setBounds(287, 507, 113, 27);
		contentPane.add(btnNewButton_1);
		//注销登录
		JButton btnNewButton_2 = new JButton("\u6CE8\u9500\u767B\u5F55");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new LoginFrame().setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(507, 507, 113, 27);
		contentPane.add(btnNewButton_2);
	}
	
    /** 
     * 这个方法创建 a timer task 每秒更新一次 the time 
     * 参数三 单位是1000毫秒  即设置的刷新间隔
     */  
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
            textField_5.setText(time);  
        }  
    } 
}
