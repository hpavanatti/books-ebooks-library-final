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
@Table(name = "SOCIAIS")
@SequenceGenerator(name = "SOCIAIS_SEQ", sequenceName = "SOCIAIS_SEQ", allocationSize = 1)
public class Social implements Entidade {
    
    @Id
    @Column(name = "ID_SOCIAL")
    @GeneratedValue(generator = "SOCIAIS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "NOME", length = 30)
    @NotNull(message = "{Social.nome.NotNull}")
    @Size(min = 3, max = 30, message = "{Social.nome.Size}")
    private String nome;
   
    @Column(name = "LINK", length = 300)
    @Size(max = 300, message = "{Social.link.Size}")
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.link);
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
        final Social other = (Social) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.link, other.link)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Social{" + "id=" + id + ", nome=" + nome + ", link=" + link + '}';
    }
}