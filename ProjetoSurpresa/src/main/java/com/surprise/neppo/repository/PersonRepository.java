package com.surprise.neppo.repository;

import com.surprise.neppo.model.RegisterPersonModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class PersonRepository {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    @Transactional
    public void save(RegisterPersonModel registerPersonModel){
        manager.persist(registerPersonModel);
    }

    @Transactional
    public void change(RegisterPersonModel registerPersonModel){
        manager.persist(registerPersonModel);
    }
    public RegisterPersonModel consultPerId(int id){

        return  manager.find(RegisterPersonModel.class,id);
    }
    @Transactional
    public  void remuve(int id){
        manager.remove(this.consultPerId(id));
    }

    public List<RegisterPersonModel>consultAll(){
        return manager.createQuery("SELECT registerPersonModel from RegisterPersonModel registerPersonModel ORDER BY registerPersonModel.id",
                RegisterPersonModel.class).getResultList();
    }
    public RegisterPersonModel logar(String login){

        return manager.createQuery("select nomelogin from RegisterPersonModel nomelogin where nomelogin.login = :login",RegisterPersonModel.class).setParameter("login",login).getSingleResult();
    }
}
