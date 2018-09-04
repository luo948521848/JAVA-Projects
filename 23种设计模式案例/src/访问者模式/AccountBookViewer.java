package 访问者模式;

public interface AccountBookViewer {
	 //查看消费的单子
    void view(ConsumeBill bill);

    //查看收入的单子
    void view(IncomeBill bill);

}
