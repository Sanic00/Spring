package polymorphism;

import org.springframework.aop.*;


public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
	System.out.println("===>���� ����Ŀ�� ��ü����");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker --- �Ҹ� �ø���.");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker --- �Ҹ� ������.");

	}

}
