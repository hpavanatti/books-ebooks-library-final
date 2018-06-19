package com.henriquejoaquim.booksEbooksLibrary.model;

import java.util.Objects;
import javax.persistence.Id;
import java.math.BigInteger;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LIVROS")
@SequenceGenerator(name = "LIVROS_SEQ", sequenceName = "LIVROS_SEQ", allocationSize = 1)
public class Livro implements Entidade {
    
    @Id
    @Column(name = "ID_LIVRO")
    @GeneratedValue(generator = "LIVROS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "{Livro.titulo.NotNull}")
    @Column(name = "TITULO", length = 100)
    @Size(min = 2, max = 100, message = "{Livro.titulo.Size}")
    private String titulo;
    
    @Column(name = "RESUMO", length = 400)
    @Size(max = 400, message = "{Livro.resumo.Size}")
    private String resumo;
    
    @NotNull(message = "{Livro.pagina.NotNull}")
    @Column(name = "PAGINA", precision = 10, scale = 0)
    @Digits(integer = 10, fraction = 0, message = "{Livro.pagina.Digits}")
    private BigInteger pagina;
    
    @NotNull(message = "{Livro.edicao.NotNull}")
    @Column(name = "EDICAO", precision = 15, scale = 5)
    @Size(min = 2, max = 100, message = "{Livro.edicao.Size}")
    private String edicao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public BigInteger getPagina() {
        return pagina;
    }

    public void setPagina(BigInteger pagina) {
        this.pagina = pagina;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.titulo);
        hash = 23 * hash + Objects.hashCode(this.resumo);
        hash = 23 * hash + Objects.hashCode(this.pagina);
        hash = 23 * hash + Objects.hashCode(this.edicao);
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.resumo, other.resumo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pagina, other.pagina)) {
            return false;
        }
        if (!Objects.equals(this.edicao, other.edicao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", pagina=" + pagina + ", edicao=" + edicao + '}';
    }
    
}
