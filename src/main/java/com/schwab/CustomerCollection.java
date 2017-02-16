package com.schwab;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBObject;

@RestController
@RequestMapping("/cust")
public class CustomerCollection {
	private CustomerService service=new CustomerService();
	@RequestMapping("/findall")
	public List<Customer> findAll(){
		return service.findAll();
		
		
	}
	@RequestMapping("/age/{id}")
	public DBObject findObjectId(@PathVariable String id){
		return service.findObjectId(id);
		
		
	}
	/*@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Customer saveCustomer(@RequestBody Customer cust){
		return service.saveCustomer(cust);
		
		
	}*/
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
}
