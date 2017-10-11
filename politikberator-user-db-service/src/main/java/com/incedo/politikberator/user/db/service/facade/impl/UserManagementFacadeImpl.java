package com.incedo.politikberator.user.db.service.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incedo.politikberator.user.db.service.data.repository.UserManagementRepository;
import com.incedo.politikberator.user.db.service.facade.UserManagementFacade;

@Service
public class UserManagementFacadeImpl implements UserManagementFacade {

	@Autowired
	private UserManagementRepository userManagementRepository;

}
