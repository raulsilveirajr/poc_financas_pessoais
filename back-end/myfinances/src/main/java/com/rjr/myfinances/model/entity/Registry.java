package com.rjr.myfinances.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.convert.Jsr310Converters;

@Entity
@Table(name="registry", schema="finance")
public class Registry {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "year")
	private String year;

	@Column(name = "value")
	private BigDecimal value;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name = "insert_date")
	@Convert(converter = Jsr310Converters.LocalDateToDateConverter.class)
	private LocalDate insertDate;

}
