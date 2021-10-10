package com.rjr.myfinances.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.convert.Jsr310Converters;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="registry", schema="finance")
@Data
@Builder
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
	@Enumerated(value=EnumType.STRING)
	private TypeOfRegistry type;
 
	@Column(name = "status")
	@Enumerated(value=EnumType.STRING)
	private StatusOfRegistry status;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name = "insert_date")
	@Convert(converter = Jsr310Converters.LocalDateToDateConverter.class)
	private LocalDate insertDate;
}
