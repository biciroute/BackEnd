package edu.eci.BiciRoute.Repositories;

import edu.eci.BiciRoute.Models.*;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@NoRepositoryBean
public interface IUserRepositoryU {
    User updateUser(String email , User user);
}
