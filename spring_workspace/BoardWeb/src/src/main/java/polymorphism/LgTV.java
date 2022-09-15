package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")	
public class LgTV implements TV {

//	<bean id="tv" class="polymorphism.SamsungTV">
	@Autowired
//	@Qualifier("sony") : id�� ����
//	@Resource(name = "apple")
	
	private Speaker speaker;
	
	public LgTV() {
	System.out.println("(1)LGTV ��ü ����");
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("LGTV ---�����Ҵ�");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV ---��������");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		
	}

	@Override
	public void volumeDown(){
		speaker.volumeDown();
		
	}
	
	

		
}
