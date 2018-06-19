package com.henriquejoaquim.booksEbooksLibrary.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AUTORES")
@SequenceGenerator(name = "AUTORES_SEQ", sequenceName = "AUTORES_SEQ", allocationSize = 1)
public class Autor implements Entidade {
    
    @Id
    @Column(name = "ID_AUTOR")
    @GeneratedValue(generator = "AUTORES_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "PSEUDONIMO", length = 50, unique = true)
    @NotNull(message = "{Autor.pseudonimo.NotNull}")
    @Size(min = 3, max = 50, message = "{Autor.pseudonimo.Size}")
    private String pseudonimo;
    
    @Column(name = "NOME", length = 80)
    @NotNull(message = "{Autor.nome.NotNull}")
    @Size(min = 5, max = 80, message = "{Autor.nome.Size}")
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "ID_SOCIAL")
    private Social social;
   
    @Column(name = "LINK", length = 300)
    @NotNull(message = "{Autor.link.NotNull}")
    @Size(max = 300, message = "{Autor.link.Size}")
    private String link;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.pseudonimo);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.social);
        hash = 83 * hash + Objects.hashCode(this.link);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.pseudonimo, other.pseudonimo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.social, other.social)) {
            return false;
        }
        if (!Objects.equals(this.link, other.link)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", pseudonimo=" + pseudonimo + ", nome=" + nome + ", social=" + social + ", link=" + link + '}';
    }
}
