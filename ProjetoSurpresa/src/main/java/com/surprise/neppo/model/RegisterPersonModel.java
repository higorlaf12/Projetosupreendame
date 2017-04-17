package com.surprise.neppo.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personTable")
public class RegisterPersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id_Identificador")
    private int id;

    @NotEmpty
    @Column(name ="nomeLogin")
    private String login;

    @NotEmpty
    @Column(name = "nomePassword")
    private String senha;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
