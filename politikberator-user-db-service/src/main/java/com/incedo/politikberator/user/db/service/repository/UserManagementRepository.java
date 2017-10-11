package com.incedo.politikberator.user.db.service.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.incedo.politikberator.orm.user.entity.User;

public interface UserManagementRepository extends CrudRepository<User, Serializable> {

}
