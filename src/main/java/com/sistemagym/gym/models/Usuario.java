package com.sistemagym.gym.models;

import com.sistemagym.gym.Helpers.enums.UsuarioEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre", length= 100, unique = true, nullable = false)
    private String nombre;

    @Column(name = "correo", length = 260, unique = true, nullable = false)
    private String correo;

    @Column(name = "contrasena", length = 260, nullable = false)
    private String contrasena;

    @Column(name = "telefono", length = 260, nullable = true)
    private String telefono;

    @Column(name = "tipo_usuario", nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioEnum tipoUsuario;

	public Usuario() {
    }

	public Usuario(Integer id, String nombre, String correo, String contrasena, String telefono,
			UsuarioEnum tipoUsuario) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public UsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

    
    

    

    

    
}
