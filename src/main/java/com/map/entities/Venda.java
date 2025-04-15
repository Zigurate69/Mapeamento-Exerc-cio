package com.map.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera automaticamente os getters e setters
@NoArgsConstructor // Não possui nenhum argumento construtor
@AllArgsConstructor // Todos argumentos construtores
@Entity // Informa que é uma entidade
@Table(name = "venda") // Cria uma tabela com o nome venda
public class Venda {
	
	@Id // Classifica como id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera um valor automático para o id
	private Long id; // Cria um id
	
	private Date data_venda; // Cria um date
	
	@ManyToOne // Aqui ele informa a cardinalidade (conexão) que ele vai ter com o cliente
	@JoinColumn(name = "cliente_id", nullable = false) // Aqui ele cria uma coluna com o nome de cliente_id e diz que não pode ser inserido nenhum valor nulo
	private Cliente cliente; // Aqui ele diz que os dados de Cliente são os mesmos de cliente
}