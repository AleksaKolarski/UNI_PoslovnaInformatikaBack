package com.projekat.poslovna.dto;

import java.util.ArrayList;
import java.util.List;

import com.projekat.poslovna.entity.Company;
import com.projekat.poslovna.entity.Employee;
import com.projekat.poslovna.entity.Warehouse;

public class EmployeeDTO {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Boolean isAdmin;
	private Integer companyId;
	private Integer warehouseId;
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(Employee employee) {
		this.id = employee.getId();
		this.firstname = employee.getFirstName();
		this.lastname = employee.getLastName();
		this.email = employee.getEmail();
		this.isAdmin = employee.getIsAdmin();
		
		Company company = employee.getCompany();
		if(company != null) {
			this.companyId = company.getId();
		}
		
		Warehouse warehouse = employee.getWarehouse();
		if(warehouse != null) {
			this.warehouseId = warehouse.getId();
		}
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	
	public static List<EmployeeDTO> parseList(List<Employee> list){
		List<EmployeeDTO> listDTO = new ArrayList<>();
		for(Employee employee: list) {
			listDTO.add(new EmployeeDTO(employee));
		}
		return listDTO;
	}
}
