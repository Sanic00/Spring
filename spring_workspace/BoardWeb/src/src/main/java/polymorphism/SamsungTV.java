package polymorphism;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@Repository
@Controller
public class SamsungTV implements TV{

	private Speaker speaker; // �Ｚtv�� sony�� injection��
	private int price; 
	
	public void initMethod() {
		// ��ü�� �ʱ�ȭ �۾� �޼ҵ�
		System.out.println("��ü �ʱ�ȭ �۾��� ó����");
	}
	public void destroyMethod() {
		// ��ü�� �ʱ�ȭ �۾� �޼ҵ�
		System.out.println("��ü ���� ���� ó���� ����");
	}
	
	public SamsungTV() {
		System.out.println("====> SamsungTV(1) ��ü ����...");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("====> SamsungTV(2) ��ü ����...");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("====> SamsungTV(3) ��ü ����...");
		this.speaker = speaker;
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV ----- ���� �Ҵ�.(����Ŀ ����:"+price+"��)");
		// System.out.println("SamsungTV ----- ���� �Ҵ�.");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV ----- ���� ������.");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() ȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice() ȣ��");
		this.price = price;
	}
}
	
	

