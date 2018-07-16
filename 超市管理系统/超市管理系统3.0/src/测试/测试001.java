package 测试;



//这里是关于日志文件的测试
//连锁超市  可以根据发送日志到服务器端 进行商品销售分析
import com.lc.shopmarket.DataExchage.ClassLog4j;
import org.apache.log4j.Logger;


public class 测试001 {
	
	
	private static Logger logger=ClassLog4j.getLogger();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
     
		logger.info("hahahah");
		
	}

}
