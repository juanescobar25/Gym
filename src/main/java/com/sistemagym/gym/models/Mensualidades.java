package com.sistemagym.gym.models;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Mensualidades")
public class Mensualidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensualidad")
    private Integer id;

    @Column(name = "precio")
    private Double precio;
    
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_final")
    private Date fechaFinal;

	@ManyToOne
	@JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
	@JsonBackReference(value = "mensualidades-usuario")
	private Usuario usuario;

	public Mensualidades() {
	}

	public Mensualidades(Integer id, Double precio, Date fechaInicio, Date fechaFinal) {
		this.id = id;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

    
}
