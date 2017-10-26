package com.incedo.politikberator.user.db.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.common.api.constant.ApiConstant;
import com.incedo.politikberator.user.db.service.facade.UserManagementFacade;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(ApiConstant.USER_MANAGEMENT_CONTROLLER_BASE_PATH)
@Api(value = "User Resource Endpoints")
public class UserManagementController {

	@Autowired
	private UserManagementFacade userManagementFacade;

}
