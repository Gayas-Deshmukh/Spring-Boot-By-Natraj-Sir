package com.nt.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("courseWriter")
public class CourseWriter implements ItemWriter<String>
{
	@Override
	public void write(Chunk<? extends String> items) throws Exception 
	{
		System.out.println("CourseWriter.write()");
		
		items.forEach(System.out :: println);
	}
}
