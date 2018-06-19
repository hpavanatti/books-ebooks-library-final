package com.henriquejoaquim.booksEbooksLibrary.model;

import java.util.Objects;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COLECOES_ITENS")
@SequenceGenerator(name = "COLECOES_ITENS_SEQ", sequenceName = "COLECOES_ITENS_SEQ", allocationSize = 1)
public class ColecaoItem implements Entidade {
    
    @Id
    @Column(name = "ID_COLECAO_ITEM")
    @GeneratedValue(generator = "COLECOES_ITENS_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_LIVRO")
    private Livro livro;
    
    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @NotNull(message = "{ColecaoItem.quantidade.NotNull}")
    @Digits(integer = 10, fraction = 0)
    @Column(name = "QUANTIDADE", precision = 10, scale = 0)
    private Integer quantidade;
    
    @NotNull(message = "{ColecaoItem.estado.NotNull}")
    @Column(name = "ESTADO", length = 30)
    @Size(min = 2, max = 30, message = "{ColecaoItem.estado.Size}")
    private String estado;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.livro);
        hash = 89 * hash + Objects.hashCode(this.genero);
        hash = 89 * hash + Objects.hashCode(this.quantidade);
        hash = 89 * hash + Objects.hashCode(this.estado);
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
        final ColecaoItem other = (ColecaoItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ColecaoItem{" + "id=" + id + ", livro=" + livro + ", genero=" + genero + ", quantidade=" + quantidade + ", estado=" + estado + '}';
    }
}
