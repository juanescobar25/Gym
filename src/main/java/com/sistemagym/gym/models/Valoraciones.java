package com.sistemagym.gym.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Valoraciones")
public class Valoraciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valoracion")
    private Integer id;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "masa_muscular")
    private Double masaMuscular;

    @Column(name = "porcentaje_grasa")
    private Double porcentajeGrasa;

    @Column(name = "Brazo")
    private Double brazo;

    @Column(name = "Pierna")
    private Double pierna;

    @Column(name = "abdomenBajo")
    private Double abdomenBajo;

    @Column(name = "abdomenAlto")
    private Double abdomenAlto;

    @Column(name = "cintura")
    private Double cintura;

    @Column(name = "fecha")
    private Date fecha;

	@ManyToOne
	@JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
	@JsonBackReference(value = "valoraciones-usuario")
	private Usuario usuario;


	public Valoraciones() {
	}


	public Valoraciones(Integer id, Double peso, Double altura, Double masaMuscular, Double porcentajeGrasa,
			Double brazo, Double pierna, Double abdomenBajo, Double abdomenAlto, Double cintura, Date fecha) {
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.masaMuscular = masaMuscular;
		this.porcentajeGrasa = porcentajeGrasa;
		this.brazo = brazo;
		this.pierna = pierna;
		this.abdomenBajo = abdomenBajo;
		this.abdomenAlto = abdomenAlto;
		this.cintura = cintura;
		this.fecha = fecha;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public Double getMasaMuscular() {
		return masaMuscular;
	}


	public void setMasaMuscular(Double masaMuscular) {
		this.masaMuscular = masaMuscular;
	}


	public Double getPorcentajeGrasa() {
		return porcentajeGrasa;
	}


	public void setPorcentajeGrasa(Double porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}


	public Double getBrazo() {
		return brazo;
	}


	public void setBrazo(Double brazo) {
		this.brazo = brazo;
	}


	public Double getPierna() {
		return pierna;
	}


	public void setPierna(Double pierna) {
		this.pierna = pierna;
	}


	public Double getAbdomenBajo() {
		return abdomenBajo;
	}


	public void setAbdomenBajo(Double abdomenBajo) {
		this.abdomenBajo = abdomenBajo;
	}


	public Double getAbdomenAlto() {
		return abdomenAlto;
	}


	public void setAbdomenAlto(Double abdomenAlto) {
		this.abdomenAlto = abdomenAlto;
	}


	public Double getCintura() {
		return cintura;
	}


	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

    

	
    

    

}
