package com.xworkz.ArrayCrudApplications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.ArrayCrudApplications.Dao.ArrayCrudDao;
import com.xworkz.ArrayCrudApplications.Dto.RegisterDto;

@RestController
public class CRUDController {

	@Autowired
	ArrayCrudDao arrayCRUDDAO;

	@GetMapping("get")
	public String getName() {
		return "Ravi";
	}

	@PostMapping("save")
	public RegisterDto registerDetails(@RequestBody RegisterDto data) {
		System.out.println(data.getName());
		System.out.println(data.getContact());
		arrayCRUDDAO.save(data);
		return data;
	}
	
	
	@PostMapping("displays")
	public String displayRecords() {
		System.out.println("wait a second display method is calling");
		arrayCRUDDAO.display();
		return "check in the localsystem";
		
	}
	
	@GetMapping("update")
	public String updatePassByMail(	@RequestParam String email, @RequestParam String pass) {
		return "email is : " + email + "\t" + "password is : " + pass;
	}
	
//	display by id method
	@PostMapping("getById")
	public String getByName(@RequestParam int id) {
		arrayCRUDDAO.displayById(id);
		return "check in console output";
		
	}

	

	//display by name
	@PostMapping("getByName")
	public String getByName(@RequestParam String name) {
		arrayCRUDDAO.displayByName(name);
		return "check in console output";
		
	}
		
	
	//display by contact
	@PostMapping("getByContact")
	public String getByContact(@RequestParam long contact) {
		arrayCRUDDAO.displayByContact(contact);
		return "check in console output";
		
	}


	//display by email
	@PostMapping("getByEmail")
	public String getByEmail(@RequestParam String email) {
		arrayCRUDDAO.displayByEmail(email);
		return "check in console output";
		
	}
			
	//update by id
		@PostMapping("updateById")
		public String updateByid(	@RequestParam int id, @RequestParam long contact) {
			arrayCRUDDAO.updateById(id,contact);
			return "check in console output";
			
		}
		
		
		
//delete by name
	@PostMapping("deleteByName")
	public String deleteByName(@RequestParam String name) {
		arrayCRUDDAO.deleteByName(name);
		return "check in console output";
		
	}
		
}
