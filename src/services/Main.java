package services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UI userInter = context.getBean("UI", UI.class);
		context.getBean("foodOrderHandler");
		userInter.chicCafe();
		context.close();
	}

}
