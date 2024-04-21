package com.greatlearning.rbawiththymeleaf.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_INCREMENT
	private int dno;
	private String dname;
	private String hod;

}
