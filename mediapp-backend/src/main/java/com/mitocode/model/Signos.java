package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información de signos vitáles del paciente")
@Entity
@Table(name = "signos")
public class Signos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Schema(description = "Fecha donde se registro los signos vitáles")
	@Column(name = "fecha",  nullable = false)
	private LocalDateTime fecha;
	
	@NotNull
	@Schema(description = "Temperatura del paciente")
	@Column(name = "temperatura",  nullable = false)
	private Double temperatura;	
	
	@NotNull
	@Schema(description = "Pulsos del paciente por minuto")
	@Column(name = "pulso",  nullable = false)
	private Integer pulso;

	@NotNull
	@Schema(description = "Ritmo respiratorio del paciente por minuto")
	@Column(name = "ritmo_respiratorio",  nullable = false)
	private Integer ritmoRespiratorio;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_paciente"))
	private Paciente paciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Integer getPulso() {
		return pulso;
	}

	public void setPulso(Integer pulso) {
		this.pulso = pulso;
	}

	public Integer getRitmoRespiratorio() {
		return ritmoRespiratorio;
	}

	public void setRitmoRespiratorio(Integer ritmoRespiratorio) {
		this.ritmoRespiratorio = ritmoRespiratorio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}		
	
}
