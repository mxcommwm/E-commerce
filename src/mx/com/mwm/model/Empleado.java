package mx.com.mwm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado implements Serializable{
	/**
	 * Version de serealizable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Cod_Empl")
	private Long codigo;
	
	@Column(name="Apellidos")
	private String apellidos;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Fecha_Nac")
	private Date fechaNacimiento;
	
	public Empleado() {
		
	}

	public Empleado(Long codigo, String apellidos, String nombre, Date fechaNacimiento) {
		
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", apellidos=" + apellidos + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	

}
