package 中介模式;

import org.junit.Test;
public class CustomService {

	
	private Custom custom;
	private Artisan artisan;
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	public Artisan getArtisan() {
		return artisan;
	}
	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}
	
	
	public void organize()
	{
		if(custom!=null&&artisan!=null)
		{
			artisan.solution(custom);
		}
		
	}
	
	@Test
	public void test()
	{
		
		CustomService customService=new CustomService();
		customService.setArtisan(new Artisan());
		customService.setCustom(new Custom());
		System.out.println("组织技术人员与顾客见面");
		customService.organize();
	}
	
}
