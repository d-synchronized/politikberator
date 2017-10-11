package com.incedo.politikberator.user.db.service.controller;

import static com.incedo.politikberator.common.api.constant.ApiConstant.API_BASE_URI;
import static com.incedo.politikberator.common.api.constant.ApiConstant.API_VERSION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.politikberator.user.db.service.facade.UserManagementFacade;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(API_BASE_URI + API_VERSION + "/user")
@Api(value = "User Resource Endpoints")
public class UserManagementController {

	@Autowired
	private UserManagementFacade userManagementFacade;

}
