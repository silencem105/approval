package test;

import org.junit.Test;

import com.cn.majj.Child;

public class ChildTest {
	
	@Test
	public void testEducateChild(){
		Child c = new Child();
		String result = c.educateChild();
		if("好好学习".equals(result)){
			System.out.println("对了");
		}else{
			System.out.println("错了");
		}
	}
	
	@Test
	public void test2(){
		Child c = new Child();
		String result = c.educateChild();
		if("好好学习".equals(result)){
			System.out.println("对了");
		}else{
			System.out.println("错了");
		}
	}
	
	@Test
	public void test3(){
		Child c = new Child();
		String result = c.educateChild();
		if("好好学习".equals(result)){
			System.out.println("对了");
		}else{
			System.out.println("错了");
		}
	}

}
