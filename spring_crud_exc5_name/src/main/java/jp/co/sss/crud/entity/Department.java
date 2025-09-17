package jp.co.sss.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name ="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator= "seq_department_gen")
	@SequenceGenerator(name = "seq_department_gen", sequenceName = "seq_department",allocationSize = 1)
	private Integer deptId;
	
	@Column
	private String deptName;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}


