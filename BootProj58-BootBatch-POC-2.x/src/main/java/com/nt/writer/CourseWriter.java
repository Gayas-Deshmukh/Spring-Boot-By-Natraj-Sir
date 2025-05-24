package com.nt.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("courseWriter")
public class CourseWriter implements ItemWriter<String>
{
	@Override
	public void write(List<? extends String> items) throws Exception 
	{
		System.out.println("CourseWriter.write()");
		
		items.forEach(System.out :: println);
	}
}
