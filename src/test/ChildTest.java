package test;

import org.junit.Test;

import com.cn.majj.Child;

public class ChildTest {
	
	@Test
	public void testEducateChild(){
		Child c = new Child();
		String result = c.educateChild();
		if("�ú�ѧϰ".equals(result)){
			System.out.println("����");
		}else{
			System.out.println("����");
		}
	}
	
	@Test
	public void test2(){
		Child c = new Child();
		String result = c.educateChild();
		if("�ú�ѧϰ".equals(result)){
			System.out.println("����");
		}else{
			System.out.println("����");
		}
	}
	
	@Test
	public void test3(){
		Child c = new Child();
		String result = c.educateChild();
		if("�ú�ѧϰ".equals(result)){
			System.out.println("����");
		}else{
			System.out.println("����");
		}
	}

}
