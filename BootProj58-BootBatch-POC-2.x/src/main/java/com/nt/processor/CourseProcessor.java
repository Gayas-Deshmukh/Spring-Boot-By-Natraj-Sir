package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("bookProcessor")
public class CourseProcessor implements ItemProcessor<String, String>
{
	@Override
	public String process(String item) throws Exception 
	{
		System.out.println("CourseProcessor.process()");
		
		if (item.equals("JAVA")) {
			return item += " : 2000";
		}
		else if (item.equals("JEE")) {
			return item += " : 3000";
		}
		else if (item.equals("SQL")) {
			return item += " : 1000";
		}
		else if (item.equals("SPRING")) {
			return item += " : 5000";
		}
		
		return item;
	}
	
}
