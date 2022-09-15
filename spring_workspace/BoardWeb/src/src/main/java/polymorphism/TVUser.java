package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 * GenericXmlApplicationContext
 * - ���� �ý����̳� Ŭ������ ��ο� �ִ� xml ���������� �ε��Ͽ� �����ϴ� ������ �����̳ʴ�.
 * XmlWebApplicationContext
 * - ������� ������ ���ø����̼��� ������ �� ����ϴ� ������ �����̳ʴ�.
 */



public class TVUser {

	public static void main(String[] args) {
		/* ����� id�� �̿�(��ü��)
		// 1. spring �����̳�(���⼭�� applicationContext.xml)�� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 2. spring �����̳ʷκ��� �ʿ��� ��ü�� ��û�Ѵ�.
		TV tv = (TV)factory.getBean("tv"); // xml���� ���� id�� �˻�
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		// 3. spring �����̳ʸ� �����Ѵ�.
		factory.close();
		*/ 
		
		// ����� Ŭ������ �̿�
		// 1. spring �����̳�(���⼭�� applicationContext.xml)�� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 2. spring �����̳ʷκ��� �ʿ��� ��ü�� ��û�Ѵ�.
		TV tv1 = (TV)factory.getBean("tv");
		// TV tv2 = tv1;
		// TV tv3 = tv2; �䷡�ϸ� ��ü ���� �ϳ��� ���°���
		
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
		// 3. spring �����̳ʸ� �����Ѵ�.
		factory.close();

	}
}