package com.erp.core.model;

public class Department {
	private Long id;
	private Employee head;
	private Title deptTitle;

	Department(Employee head, Title deptTitle) {
		super();
		this.head = head;
		this.deptTitle = deptTitle;
	}

	public Employee getHead() {
		return head;
	}

	public void setHead(Employee head) {
		this.head = head;
	}

	public Title getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(Title deptTitle) {
		this.deptTitle = deptTitle;
	}

	public Long getId() {
		return id;
	}

	public enum Title {
		FINANCE, IT, HR, SALES
	}
}
