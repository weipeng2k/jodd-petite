package com.murdock.tools.petite.beans.pojo;

import jodd.petite.meta.PetiteInject;

public class Worker {
	@PetiteInject
	private Staff staff;

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
