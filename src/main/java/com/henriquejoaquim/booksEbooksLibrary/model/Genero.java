package com.henriquejoaquim.booksEbooksLibrary.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "GENEROS")
@SequenceGenerator(name = "GENEROS_SEQ", sequenceName = "GENEROS_SEQ", allocationSize = 1)
public class Genero implements Entidade {
    
    @Id
    @Column(name = "ID_GENERO")
    @GeneratedValue(generator = "GENEROS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "NOME", length = 50)
    @NotNull(message = "{Genero.nome.NotNull}")
    @Size(min = 2, max = 50, message = "{Genero.nome.Size}")
    private String nome;
   
    @Column(name = "DESCRICAO", length = 300)
    @Size(max = 300, message = "{Genero.descricao.Size}")
    private String descricao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genero other = (Genero) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Genero{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
}