package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.entity.MarriageSeeker;
import com.nt.service.IMarrigeSeekerService;


@Component
public class MarrigeSeekerTestRunner implements CommandLineRunner 
{
	@Autowired
	private IMarrigeSeekerService service;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Scanner scan = new Scanner(System.in);
		
		/*
		System.out.println("Enter person name");
		String name = scan.nextLine();
		
		System.out.println("Enter person address");
		String address = scan.nextLine();
		
		System.out.println("Enter person photo file path");
		String photoPath = scan.nextLine();
		
		System.out.println("Enter person biodata file path");
		String biodataPath = scan.nextLine();
		
		System.out.println("Is the person india?");
		boolean isIndian = scan.nextBoolean();
		
		scan.close();
		
		// prepare byte[] representing photo file content 
		InputStream is = new FileInputStream(photoPath);
		
		byte [] photoData = new byte[is.available()];
		
		photoData = is.readAllBytes();
		
		// prepare char[] representing photo file content 
		File file  = new File (biodataPath);
		
		Reader reader = new FileReader(file);
		
		char [] biodataContent = new char[(int) file.length()];
		
		reader.read(biodataContent);
		
		// Prepare entity class object
		MarriageSeeker seeker = MarriageSeeker.builder()
				                             .name(name)
				                             .adds(address)
				                             .dob(LocalDateTime.of(1997, 5, 12, 01, 14))
				                             .photo(photoData)
				                             .biodata(biodataContent)
				                             .isIndian(isIndian)
				                             .build();
		
		System.out.println(service.registerMarriageSeeker(seeker));
		*/
		
		System.out.println("================================================================");
		
		Optional<MarriageSeeker> marriageSeeeker = service.searchSeekerById(52);
		
		if (marriageSeeeker.isPresent())
		{
			MarriageSeeker ms = marriageSeeeker.get();
			
			System.out.println(ms.getId() + " " + ms.getName() +  " " + ms.getAdds() +  " " + ms.getDob() +  " " + ms.isIndian());
			
			// Get Photo
			OutputStream os = new FileOutputStream("Car.jpg");	
			os.write(ms.getPhoto());
			os.flush();
			
			// Get biodata
			Writer wr = new FileWriter("01_DDD.pdf");
			wr.write(ms.getBiodata());
			wr.flush();
			
			os.close();
			wr.close();
			
		}
		else
		{
			System.out.println("Record not found");
		}
	}
}
