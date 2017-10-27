package com.threaddynamics.politikberator.rule.engine;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.kie.api.runtime.KieContainer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import com.threaddynamics.politikberator.rule.engine.helper.KnowledgeBaseHelper;
import com.threaddynamics.politlberator.rule.engine.RuleEngineServiceImpl;
import com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumDetail;
import com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumResponse;
import com.threaddynamics.politlberator.rule.engine.exception.RuleEngineException;
import com.threaddynamics.politlberator.rule.engine.util.AgeCalculator;

@RunWith(Parameterized.class)
public class RuleEngineServiceTest {
	
	@Rule 
	public MockitoRule rule = MockitoJUnit.rule();
	
	@InjectMocks
	private RuleEngineServiceImpl ruleEngineService;

	@Mock
	private Mapper mapper;
	
	@Mock
	private KieContainer kieContainer;
	
	private static final String RULE_FILE_LOCATION = "rules/policy-rules.drl";
	
	@Parameter(0)
	public Date dateOfBirth;
	
	@Parameter(1)
	public boolean smoker;
	
	@Parameter(2)
	public boolean expectation;
	
	@BeforeClass
	public static void prepareTestEnvironment() {
	}
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {AgeCalculator.fetchDate(2000, 07, 13, null), false, false},
                {AgeCalculator.fetchDate(2000, 07, 13, null), true, false},
                {AgeCalculator.fetchDate(1991, 07, 13, null), false, true},
                {AgeCalculator.fetchDate(1991, 07, 13, null), true, true},
                {AgeCalculator.fetchDate(1955, 07, 13, null), false, true},
                {AgeCalculator.fetchDate(1955, 07, 13, null), true, false}
        });
    }
	
	
	@Test
	public void testFetchPolicyDetails() throws RuleEngineException{
		when(kieContainer.newKieSession("politikberator-rule-session"))
		     .thenReturn(KnowledgeBaseHelper.producesKnowledgeBase(RULE_FILE_LOCATION).newKieSession());
		
		when(mapper.map(any(PolicyPremiumDetail.class), eq(PolicyPremiumResponse.class))).thenAnswer(new Answer<PolicyPremiumResponse>() {

			@Override
			public PolicyPremiumResponse answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				if (arguments != null && arguments.length > 0 && arguments[0] != null){
					PolicyPremiumDetail policyPremiumDetail = (PolicyPremiumDetail) arguments[0];
					final Mapper mapper = new DozerBeanMapper();
					return mapper.map(policyPremiumDetail, PolicyPremiumResponse.class);
                }
				return null;
			}
		});
		
		final PolicyPremiumResponse policyPremiumResponse = ruleEngineService.obtainPolicyDetails(dateOfBirth, smoker);
		Assert.assertEquals(policyPremiumResponse.isEligibleForPolicy(), expectation);
	}
	
}