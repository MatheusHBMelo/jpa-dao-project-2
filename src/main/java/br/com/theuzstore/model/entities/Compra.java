package br.com.theuzstore.model.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer id;

    @Column(name = "valor")
    private Double valor;

    @Column
    private LocalDateTime data;

    @Column(name = "observacao", length = 250)
    private String observacao;

    @ManyToOne
    private Cliente cliente;

    public Compra() {
    }

    public Compra(Integer id, Double valor, LocalDateTime data, String observacao, Cliente cliente) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
                " - Cliente: " + cliente.getNome();
    }
}
