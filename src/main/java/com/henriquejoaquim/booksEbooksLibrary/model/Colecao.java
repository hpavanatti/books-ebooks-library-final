package com.henriquejoaquim.booksEbooksLibrary.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COLECOES")
@SequenceGenerator(name = "COLECOES_SEQ", sequenceName = "COLECOES_SEQ", allocationSize = 1)
public class Colecao implements Entidade {
    
    @Id
    @Column(name = "ID_COLECAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLECOES_SEQ")
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_AUTOR")
    private Autor autor;
    
    @NotNull(message = "{Colecao.titulo.NotNull}")
    @Column(name = "TITULO", length = 100)
    @Size(min = 2, max = 100, message = "{Colecao.titulo.Size}")
    private String titulo;
    
    @Column(name = "CRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;
    
    @JoinColumn(name = "ID_COLECAO")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ColecaoItem> itens;

    @NotNull(message = "{Colecao.categoria.NotNull}")
    @Column(name = "CATEGORIA", length = 50, unique = true)
    @Size(min = 2, max = 50, message = "{Colecao.categoria.Size}")
    private String categoria;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public List<ColecaoItem> getItens() {
        return itens;
    }

    public void setItens(List<ColecaoItem> itens) {
        this.itens = itens;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.autor);
        hash = 67 * hash + Objects.hashCode(this.titulo);
        hash = 67 * hash + Objects.hashCode(this.criacao);
        hash = 67 * hash + Objects.hashCode(this.itens);
        return 67 * hash + Objects.hashCode(this.categoria);
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
        final Colecao other = (Colecao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.criacao, other.criacao)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return Objects.equals(this.categoria, other.categoria);
    }

    @Override
    public String toString() {
        return "Colecao{" + "id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", criacao=" + criacao + ", itens=" + itens + ", categoria=" + categoria + '}';
    }
}
