package br.com.theuzstore.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    private List<Compra> compras;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String login, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " - Nome: " + nome +
                " - Login: " + login +
                " - Email: " + email +
                " - Senha: " + senha +
                " - Compras: " + compras.size();
    }
}
