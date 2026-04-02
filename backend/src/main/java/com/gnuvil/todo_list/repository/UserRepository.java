package com.gnuvil.todo_list.repository;

import com.gnuvil.todo_list.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    //추가할 내용 : 회원 가입, 회원 ID값으로 조회, 회원 이메일로 조회, 전체 조회//
    public void save(User user) {
        em.persist(user);
    }

    public User findById(Long id) {
        User findUser = em.find(User.class, id);
        return findUser;
    }

    public Optional<User> findByEmail(String email) {
        List<User> result =  em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return result.stream().findAny();
    }
    public List<User> findAll(){
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }







}
