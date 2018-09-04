package 组合模式;

import java.util.ArrayList;
import java.util.List;

//目录结点
public class Noder extends Node{

	//内部节点列表（包括文件和下级目录）
	List<Node> nodeList = new ArrayList<Node>();
	public Noder(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	//新增节点
	public void addNode(Node node) throws Exception{
		nodeList.add(node);
	}

	//删除节点
	public void removeNode(Node node)throws Exception
	{
		nodeList.remove(node);
	}

    //向下递归打印名称
	@Override
	void display() {
		System.out.println(name);
		for(Node node:nodeList){
			node.display();
		}
	}
}
