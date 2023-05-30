package br.com.theuzstore.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Compra implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Double valor;
    private LocalDateTime data;
    private String observacao;

    private Cliente responsavel;

    public Compra() {
    }

    public Compra(Integer id, Double valor, LocalDateTime data, String observacao, Cliente responsavel) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.responsavel = responsavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Cliente responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " - Valor: " + valor +
                " - Data: " + data +
                " - Observação: " + observacao +
                " - Responsavel: " + responsavel.getNome();
    }
}
