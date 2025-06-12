package com.sistemagym.gym.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
	@JsonBackReference(value = "ventas-usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "fk_productos", referencedColumnName = "id_producto")
	@JsonBackReference(value = "ventas-producto")
	private Productos productos;


	public Ventas() {
	}

	public Ventas(Integer id, Date fecha, Integer cantidad) {
		this.id = id;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

    
    
}
