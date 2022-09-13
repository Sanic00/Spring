package polymorphism;

import org.springframework.aop.*;


public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
	System.out.println("===>애플 스피커로 객체생성");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker --- 소리 올린다.");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker --- 소리 내린다.");

	}

}
