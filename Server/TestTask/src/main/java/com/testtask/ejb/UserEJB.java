package com.testtask.ejb;

import com.testtask.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.registry.infomodel.User;
import java.util.List;

@Stateless
public class UserEJB {

    @PersistenceContext(unitName = "myPU")
    EntityManager entityManager;

    public void addUser(UserEntity user) {
        entityManager.persist(user);
    }

    public List<UserEntity> getAllUsers() {
        Query query = entityManager.createQuery("SELECT user FROM UserEntity user");
        return query.getResultList();
    }

    public void updateUser(UserEntity user) {
        entityManager.merge(user);
    }

    public UserEntity getUserById(long id) {
        Query query = entityManager.createQuery("SELECT user FROM UserEntity user WHERE user.id = :id");
        UserEntity user = (UserEntity) query.setParameter("id", id).getSingleResult();
        return user;
    }

    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }
}
