package com.map.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera getter e setters
@NoArgsConstructor // Não possui nenhum argumento construtor
@AllArgsConstructor // Possui todos argumentos construtores
@Entity // Informa que é uma entidade
@Table(name = "cliente") //Cria uma table a e informa o nome dela
public class Cliente {
	
	@Id // Classifica como um id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Ele gera um valor automático para o id
	private Long id; // Aqui é a criação do id
	
	private String email; // Aqui criamos o email
	
	private String nome; // Aqui criamos o nome
	
	private String telefone; // Aqui criamos o telefone
}