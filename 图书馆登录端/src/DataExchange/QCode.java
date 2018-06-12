package DataExchange;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import LIbrarys.book;

public class QCode {

	private book b1=null;
public QCode(book b2)
{
	b1=b2;
	int width=300;
	int height =300;
	String nums=b1.getB_num().toString();
	String format="png";//生成二维码的格式
	String content="书名："+b1.getB_name()
			+ "作者："+b1.getB_writer()
			+ "数量:"+nums
			+ "出版社："+b1.getB_publish()
			+ "出版日期："+b1.getBr_date();
               ;
			
	// 来定义二维码的参数
	HashMap img=new HashMap();
	img.put(EncodeHintType.CHARACTER_SET,"utf-8");//设置编译的字节集
	img.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
	img.put(EncodeHintType.MARGIN, 2);//设置边距
	
	
	try{
		BitMatrix b=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,img);//1.是内容 2.是二维码类型  5是二维码
		
		Path file=new File("C://Users/Administrator/Desktop/mylibrary/Code/"+b1.getB_name()+".png").toPath();
	
		MatrixToImageWriter.writeToPath(b, format, file);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
}


}
