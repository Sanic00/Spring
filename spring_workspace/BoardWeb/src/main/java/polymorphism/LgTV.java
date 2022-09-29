package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//  <bean id="tv" class="polymorphism.SamsungTV">
@Component("tv")
public class LgTV implements TV {

	
	@Autowired
//	@Qualifier("sony") : 아이디로 지정
//	@Resource(name = "apple")
	private Speaker speaker;
	
	
	public LgTV() {
		System.out.println("=====> LgTV 객체 생성.");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV ---- 전원 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV ---- 전원 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
	   speaker.volumeDown();
	}

}
