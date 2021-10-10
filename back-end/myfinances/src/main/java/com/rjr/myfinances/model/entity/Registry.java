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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public TypeOfRegistry getType() {
		return type;
	}

	public void setType(TypeOfRegistry type) {
		this.type = type;
	}

	public StatusOfRegistry getStatus() {
		return status;
	}

	public void setStatus(StatusOfRegistry status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(LocalDate insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, insertDate, month, status, type, user, value, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registry other = (Registry) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(insertDate, other.insertDate) && Objects.equals(month, other.month)
				&& status == other.status && type == other.type && Objects.equals(user, other.user)
				&& Objects.equals(value, other.value) && Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "Registry [id=" + id + ", description=" + description + ", month=" + month + ", year=" + year
				+ ", value=" + value + ", type=" + type + ", status=" + status + ", user=" + user + ", insertDate="
				+ insertDate + "]";
	}

	
}
