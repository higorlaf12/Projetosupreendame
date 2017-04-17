package com.surprise.neppo.repository;

import com.surprise.neppo.model.SavingModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import java.util.List;

@Repository
public class SavingRepository {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    @Transactional
    public void savee(SavingModel savingModel){
        manager.merge(savingModel);
    }

    @Transactional
    public void changee(SavingModel savingModel){

        manager.merge(savingModel);
    }

    public SavingModel consultarPorId(int id){

        return manager.find(SavingModel.class, id);
    }
    @Transactional
    public  void remuve(int id){
        manager.remove(this.consultarPorId(id));
    }

    public List<SavingModel> consultarTodos(){
        return manager.createQuery("SELECT savingModel from SavingModel savingModel ORDER BY savingModel.id",
                SavingModel.class).getResultList();
    }
}
