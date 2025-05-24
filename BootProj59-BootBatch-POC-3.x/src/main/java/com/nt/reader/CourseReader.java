package com.nt.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("courseReader")
public class CourseReader implements ItemReader<String>
{
	String courses	[]	=	new String [] {"JAVA", "JEE", "SQL", "SPRING"};
	int count 			=	0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException 
	{
		System.out.println("CourseDetailsReader.read()");
		
		if (count < courses.length)
		{
			return courses[count++];
		}
		
		return null;
	}
}
