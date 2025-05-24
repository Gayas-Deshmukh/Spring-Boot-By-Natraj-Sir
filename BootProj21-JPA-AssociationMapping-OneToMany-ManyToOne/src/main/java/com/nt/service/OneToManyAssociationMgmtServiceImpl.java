package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNuberRepositoy;

@Service
public class OneToManyAssociationMgmtServiceImpl implements OneToManyAssociationMgmtService
{
	@Autowired
	private IPersonRepository personRepo;
	
	@Autowired
	private IPhoneNuberRepositoy phoneNumberRepo;

	@Override
	public void saveDataUsingParent() 
	{
		//create parent object
		Person person = new Person();
		person.setPname("Rahul");
		person.setPaddrs("Pune");
		
		// create child obj1
		PhoneNumber number1 = new PhoneNumber();
		number1.setNumber(19996663l);
		number1.setProvider("Idea");
		// add parent to child
		number1.setPersonInfo(person);
		
		// create child obj2
		PhoneNumber number2 = new PhoneNumber();
		number2.setNumber(85214785l);
		number2.setProvider("Jio");
		// add parent to child
		number2.setPersonInfo(person);
		
		// add childs to parent
       Set<PhoneNumber> phoneNumbers = new HashSet<>();
       phoneNumbers.add(number1);
       phoneNumbers.add(number2);
       person.setNumbers(phoneNumbers);
		
       // save parent object
       personRepo.save(person);
	
       System.out.println("Person and it's associated phonenumbers are saved (Parent to Child)");
	}

	@Override
	public void saveDataUsingChild() 
	{
		//create parent object
		Person person = new Person();
		person.setPname("Nitin");
		person.setPaddrs("Mumbai");

		// create child obj1
		PhoneNumber number1 = new PhoneNumber();
		number1.setNumber(8588888l);
		number1.setProvider("BSNL");
		// add parent to child
		number1.setPersonInfo(person);

		// create child obj2
		PhoneNumber number2 = new PhoneNumber();
		number2.setNumber(77444444l);
		number2.setProvider("DOCOMO");
		// add parent to child
		number2.setPersonInfo(person);

		// add childs to parent
		Set<PhoneNumber> phoneNumbers = new HashSet<>();
		phoneNumbers.add(number1);
		phoneNumbers.add(number2);
		person.setNumbers(phoneNumbers);

		// save child object
		phoneNumberRepo.save(number1);
		phoneNumberRepo.save(number2);
		
		System.out.println("Person and it's associated phonenumbers are saved (Child to Parent)");
	}

	@Override
	public void loadDataUsingParent() 
	{
		List<Person> persons = personRepo.findAll();
		
		persons.forEach(person ->{
			System.out.println(person);
		});
	}

	@Override
	public void loadDataUsingChild() 
	{
		List<PhoneNumber> phoneNumbers = phoneNumberRepo.findAll();
		
		phoneNumbers.forEach(num -> {
			System.out.println(num);
			System.out.println(num.getPersonInfo());
			System.out.println("==================================================");
		});
	}

	@Override
	public void deleteDataUsingParent(int id) 
	{
		Optional<Person> personObj = personRepo.findById(id);
		
		if (personObj.isPresent())
		{
			personRepo.delete(personObj.get());
			
			System.out.println("Person & it's phone numbers are deleted");
		}
		else
		{
			System.out.println("Person with id " + id + " not found");
		}
	}

	@Override
	public void deleteDataUsingChild(int id) 
	{
		Optional<PhoneNumber> phObj = phoneNumberRepo.findById(id);
		
		if (phObj.isPresent())
		{
			phoneNumberRepo.delete(phObj.get());
			
			System.out.println("Childs and it's associated parents are deleted");
		}
		else
		{
			System.out.println("Phone number with id " + id + " not found");
		}
	}

	@Override
	public void deleteAllPhoneNumbersOfPerson(int pid)
	{
		Optional<Person> personObj = personRepo.findById(pid);
		
		if (personObj.isPresent())
		{
			Set<PhoneNumber> numbers = personObj.get().getNumbers();
			
			numbers.forEach(num -> {
				num.setPersonInfo(null);
			});
			
			phoneNumberRepo.deleteAll(numbers);
			
			System.out.println("Deleted " + numbers.size() + " Ph numbers of person with id " + pid);
		}
		else
		{
			System.out.println("Person with id " + pid + " not found");
		}
	}

	@Override
	public void addNewChildToExistingParent(int pid) 
	{
		// Load Parent Obj
		Optional<Person> personObj = personRepo.findById(pid);
		
		if (personObj.isPresent())
		{
			Person per = personObj.get();
			
			// Get Child Of Parent
			Set<PhoneNumber> numbers = per.getNumbers();
			
			// create new child
			PhoneNumber number = new PhoneNumber();
			number.setNumber(997774444l);
			number.setProvider("TATA");
			
			// link child to parent
			number.setPersonInfo(per);
			
			numbers.add(number);
						
			// save parent
			personRepo.save(per);
			
			System.out.println("Per " + per.getNumbers().getClass().hashCode()); 
			System.out.println("Set " + numbers.getClass().hashCode());
			/**
			 * 	Per 2133955451
				Set 2133955451
			 */
			
			System.out.println("New child is added to existing childs of person with id " + pid);
		}
		else
		{
			System.out.println("Person with id " + pid + " not found");
		}	
	}
}
