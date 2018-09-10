package 二叉堆;

import java.util.Arrays;

public class HeapSort {
	public static void downAdjust(int[] array, int parentIndex, int length) {

		//保持父节点的值用于最后的赋值
		int temp=array[parentIndex];
		int childIndex=2*parentIndex+1;
		
		while(childIndex<length) //存在子节点
		{
			//存在右孩子 并且右孩子的值小于左孩子  定位到右孩子
			if(childIndex+1 <length&&array[childIndex-1]<array[childIndex])
			{
				childIndex++;
			}
	    //如果temp 小于任何一个结点的值直接跳出
			
			if(temp <array[childIndex])
			
			{
				break;
			}
			
			
			//无需进行真正交换
			array[parentIndex]=array[childIndex];
			parentIndex=childIndex;
			childIndex=2*childIndex+1;   //变大了
			
		}
		array[parentIndex]=temp;
	}
	
	public static void heapSort(int [] array)
	{
		//进行下沉操作
		for(int i=0;i<=(array.length-2)/2;i++)
		{
			downAdjust(array, i, array.length);
		}
		System.out.println(Arrays.toString(array));
		
		//循环删除堆顶元素
		
		for(int i=array.length-1;i>0;i--)
		{
			//最后一个元素与第一个元素交换
			int temp=array[i];
			array[i]=array[0];
			array[0]=temp;
			//下沉调整最大堆
			downAdjust(array, 0, i);
			
		}
		
	}
	

	public static void main(String[] args) {
		
	
		int[] arr=new int[]{1,3,2,6,5,7,8,9,10,0};
		//先变成最小堆
		//再通过删除栈顶变成了 最大堆
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
