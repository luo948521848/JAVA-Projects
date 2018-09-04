package 组合模式;

import java.io.File;
public class Clienter {
	   public static void createTree(Node node) throws Exception{
		            File file = new File(node.name);
		            File[] f = file.listFiles();
		           for(File fi : f){
		        	   //判断结点是不是文件
		               if(fi.isFile()){  
		            	    //利用绝对路径给结点命名
		                    Filer filer = new Filer(fi.getAbsolutePath());
		                    node.addNode(filer);
		               }
		               //判断结点是不是目录
		               if(fi.isDirectory()){
		            	 //利用绝对路径给结点命名
		                   Noder noder = new Noder(fi.getAbsolutePath());
		                   node.addNode(noder);
		                   createTree(noder);//使用递归生成树结构
		               }
		           }
		       }
		       public static void main(String[] args) {
		           Node noder = new Noder("G://WeGame");
		          try {
		               createTree(noder);
		          } catch (Exception e) {
		              e.printStackTrace();
		          }
		           noder.display();
		       }
}
