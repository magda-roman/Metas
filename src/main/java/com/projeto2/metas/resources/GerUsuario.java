package com.projeto2.metas.resources;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "GER_USUARIO")
public class GerUsuario implements Serializable {

    @Id
    @SequenceGenerator(name = "GEN_GER_USUARIO", sequenceName = "GEN_GER_USUARIO", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_GER_USUARIO")
    @Column(name = "USR_ID")
    private Integer codigo;
    @Column(name = "USR_NOME")
    private String nome;
    @Column(name = "USR_SENHA")
    private String senha;
    @Column(name = "USR_CPF")
    private String cpf;
    @Column(name = "USR_ADMIN")
    private boolean admin;

    public GerUsuario() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
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
        final GerUsuario other = (GerUsuario) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
}
