package br.com.tinnova.cars.tinnovatestcars.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cars")
public class Car implements Serializable{
    private static final long serialVersionUID = 386204037136386676L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "model", nullable = false)
	private String model;

	@Column(name = "brand", nullable = false)
	private String brand;

	@Column(name = "year", nullable = false)
	private int year;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "isSolded", nullable = false)
	private boolean isSolded;

	@Column(name = "createdAt", nullable = false)
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false)
	private Date updatedAt;
}
