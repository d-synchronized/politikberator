package com.incedo.politikberator.common.api.constant;

public interface ApiConstant {

	public static final String API_BASE_URI = "/api";

	public static final String API_VERSION = "/v1";
	
	public static final String RULE_ENGINE_CONTROLLER_BASE_PATH = API_BASE_URI + API_VERSION +  "/process";
	
	public static final String POLICY_SERVICE_CONTROLLER_BASE_PATH = API_BASE_URI + API_VERSION + "/policy";
	
	public static final String POLICY_DB_SERVICE_CONTROLLER_BASE_PATH = API_BASE_URI + API_VERSION + "/policy";
	
	public static final String USER_MANAGEMENT_CONTROLLER_BASE_PATH = API_BASE_URI + API_VERSION + "/user";
	
	public static final String API_GATEWAY_BASE_URI = "http://localhost:8079";
	
	public static final String POLICY_SERVICE_BASE_URI = API_GATEWAY_BASE_URI + "/policy-service" + POLICY_SERVICE_CONTROLLER_BASE_PATH;
	
	public static final String POLICY_DB_SERVICE_BASE_URI = API_GATEWAY_BASE_URI + "/policy-db-service" + POLICY_DB_SERVICE_CONTROLLER_BASE_PATH;
	
	public static final String ADVISOR_SERVICE_BASE_URI = API_GATEWAY_BASE_URI + "/advisory";//NEED TO BE FIXED
	
	public static final String ADVISOR_DB_SERVICE_BASE_URI = API_GATEWAY_BASE_URI + "/advisory-persistence";//NEED TO BE FIXED
	
	public static final String RULE_ENGINE_SERVICE_BASE_URI = API_GATEWAY_BASE_URI + "/rule-engine" + RULE_ENGINE_CONTROLLER_BASE_PATH;
	
	public static final String USER_DB_SERVICE_BASE_URI = API_GATEWAY_BASE_URI + "/user-db-service" + USER_MANAGEMENT_CONTROLLER_BASE_PATH;

}
