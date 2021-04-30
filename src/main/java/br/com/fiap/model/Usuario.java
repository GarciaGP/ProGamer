package br.com.fiap.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_USUARIO_PROGAMER")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_TB_USUARIO_PROGAMER", allocationSize = 1)
public class Usuario {
	
	@Id
	@Column(name = "CD_USUARIO")
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_USUARIO")
	private String name;
	
	@Column(name = "EMAIL_USUARIO")
	private String email;
	
	@Column(name = "DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "PW_USUARIO")
	private String password;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
