package com.geekster.H2fun.repository;

import com.geekster.H2fun.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<Users,Integer> {
    public Users findByName(String name);

    //get above certain age
    public List<Users> findByAgeGreaterThan(Integer age);




    //Make your own query
    @Query(value = "select * from users order by user_age asc",nativeQuery = true)
    List<Users> findUsersOrderedByAgeASC();

    @Query(value = "select * from Users where user_age = :age" , nativeQuery = true)
    public List<Users> findUserAccordingToAge(Integer age);



}
