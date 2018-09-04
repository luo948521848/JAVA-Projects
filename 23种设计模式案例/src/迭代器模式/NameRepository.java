package 迭代器模式;

public class NameRepository implements Container {
	public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	//姓名迭代器
	private class NameIterator implements Iterator {

		//int默认值为0 Integer的默认值为null
		int index;

		//判断是否还元素
		@Override
		public boolean hasNext() {
			if(index < names.length){
				return true;
			}
			return false;
		}

		//获取下一个坐标下的元素
		@Override
		public Object next() {
			if(this.hasNext()){
				return names[index++];
			}
			return null;
		}     
	}
}