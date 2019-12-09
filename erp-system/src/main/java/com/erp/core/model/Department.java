package com.erp.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "head_id_fk", referencedColumnName = "empId", nullable = true)
	// @MapsId("empId")
	// private Employee head;
	private Title deptTitle;

	public Department(/* Employee head, */ Title deptTitle) {
		super();
		// this.head = head;
		this.deptTitle = deptTitle;
	}

	/*
	 * public Employee getHead() { return head; }
	 * 
	 * public void setHead(Employee head) { this.head = head; }
	 */
	public Title getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(Title deptTitle) {
		this.deptTitle = deptTitle;
	}

	public Long getId() {
		return deptId;
	}

	public enum Title {
		FINANCE, IT, HR, SALES, BOARD
	}
}
