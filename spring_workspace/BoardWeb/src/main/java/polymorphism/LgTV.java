package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")	
public class LgTV implements TV {

//	<bean id="tv" class="polymorphism.SamsungTV">
	@Autowired
//	@Qualifier("sony") : id로 지정
//	@Resource(name = "apple")
	
	private Speaker speaker;
	
	public LgTV() {
	System.out.println("(1)LGTV 객체 생성");
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("LGTV ---전원켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV ---전원끊다");
		
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
