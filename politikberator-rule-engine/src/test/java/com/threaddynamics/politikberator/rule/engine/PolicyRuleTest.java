package com.threaddynamics.politikberator.rule.engine;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.GetObjectsCommand;
import org.drools.core.impl.InternalKnowledgeBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.threaddynamics.politikberator.rule.engine.helper.KnowledgeBaseHelper;
import com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumDetail;
import com.threaddynamics.politlberator.rule.engine.util.AgeCalculator;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AgeCalculator.class)
public class PolicyRuleTest {
	
	private StatelessKieSession statelessKieSession;
	
	private static final String RULE_FILE_LOCATION = "rules/policy-rules.drl";
	
	@Before
	public void beforeStartup(){
		final InternalKnowledgeBase internalKnowledgeBase = KnowledgeBaseHelper.producesKnowledgeBase(RULE_FILE_LOCATION);
		statelessKieSession = internalKnowledgeBase.newStatelessKieSession();
	}
	
	
	private ExecutionResults execute(Collection<?> objects,final String ruleName,final String filterOut){
		final List<Command<?>> commands = new ArrayList<>();
//		commands.add(CommandFactory.newSetGlobal("ageCalculator", ageCalculator));
		commands.add(CommandFactory.newInsertElements(objects));
		final RuleNameEqualsAgendaFilter ruleNameEqualsAgendaFilter = new RuleNameEqualsAgendaFilter(ruleName);
		final FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand(ruleNameEqualsAgendaFilter);
		commands.add(fireAllRulesCommand);
		
		if(filterOut != null){
			final GetObjectsCommand getObjectsCommand = new GetObjectsCommand(new ObjectFilter() {
				
				@Override
				public boolean accept(Object object) {
					if(object instanceof PolicyPremiumDetail){
						return true;
					}
					return false;
				}
			});
			getObjectsCommand.setOutIdentifier(filterOut);
			commands.add(getObjectsCommand);
		}
		return statelessKieSession.execute(CommandFactory.newBatchExecution(commands));
	}
	
	
	@Test
	@SuppressWarnings("unchecked")
	public void testRuleForAgeLessThen18Years(){
		PowerMockito.mockStatic(AgeCalculator.class);
		when(AgeCalculator.fetchDate(2000, 07, 13, null))
		   .thenReturn(Date.from(LocalDate.of(2000, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		when(AgeCalculator.calculateAge(AgeCalculator.fetchDate(2000, 07, 13, null)))
		   .thenReturn(17);
		
		final PolicyPremiumDetail policyPremiumRequest = new PolicyPremiumDetail();
		final Date dob = AgeCalculator.fetchDate(2000, 07, 13, null);
		policyPremiumRequest.setDateOfBirth(dob);
		policyPremiumRequest.setSmoker(false);
		
		final ExecutionResults executionResults = execute(Arrays.asList(policyPremiumRequest), "ageBelow18" , "policyPremiumRequest");
		final List<PolicyPremiumDetail> policyPremiumRequests = (List<PolicyPremiumDetail>)executionResults.getValue("policyPremiumRequest");
		if(policyPremiumRequests.size() == 0 || policyPremiumRequests.size() > 1){
			Assert.fail("testRuleForAgeLessThen18Years failed. Invalid number of output from rule file, size - " + policyPremiumRequests.size());
		}
		Assert.assertFalse("testRuleForAgeLessThen18Years has been successfully validated", policyPremiumRequests.get(0).isEligibleForPolicy());
	}
	
	
	@Test
	public void testRuleForAgeLessThen18YearsAndSmoker(){
		PowerMockito.mockStatic(AgeCalculator.class);
		when(AgeCalculator.fetchDate(2000, 07, 13, null))
		     .thenReturn(Date.from(LocalDate.of(2000, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		when(AgeCalculator.calculateAge(AgeCalculator.fetchDate(2000, 07, 13, null)))
		   .thenReturn(17);
		
		final PolicyPremiumDetail policyPremiumRequest = new PolicyPremiumDetail();
		final Date dob = AgeCalculator.fetchDate(2000, 07, 13, null);
		policyPremiumRequest.setDateOfBirth(dob);
		policyPremiumRequest.setSmoker(true);
		
		final ExecutionResults executionResults = execute(Arrays.asList(policyPremiumRequest), "ageBelow18IsSmoker" , "policyPremiumRequest");
		@SuppressWarnings("unchecked")
		final List<PolicyPremiumDetail> policyPremiumRequests = (List<PolicyPremiumDetail>)executionResults.getValue("policyPremiumRequest");
		if(policyPremiumRequests.size() == 0 || policyPremiumRequests.size() > 1){
			Assert.fail("testRuleForAgeLessThen18YearsAndSmoker failed. Invalid number of output from rule file, size - " + policyPremiumRequests.size());
		}
		Assert.assertFalse("testRuleForAgeLessThen18YearsAndSmoker has been successfully validated", policyPremiumRequests.get(0).isEligibleForPolicy());

	}
	
	@Test
	public void testRuleForAgeBetween18And40Years(){
		PowerMockito.mockStatic(AgeCalculator.class);
		when(AgeCalculator.fetchDate(1991, 07, 13, null))
		    .thenReturn(Date.from(LocalDate.of(1991, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		when(AgeCalculator.calculateAge(AgeCalculator.fetchDate(1991, 07, 13, null)))
		   .thenReturn(27);
		
		final PolicyPremiumDetail policyPremiumRequest = new PolicyPremiumDetail();
		final Date dob = AgeCalculator.fetchDate(1991, 07, 13, null);
		policyPremiumRequest.setDateOfBirth(dob);
		policyPremiumRequest.setSmoker(true);
		
		final ExecutionResults executionResults = execute(Arrays.asList(policyPremiumRequest), "ageBetween18And40" , "policyPremiumRequest");
		@SuppressWarnings("unchecked")
		final List<PolicyPremiumDetail> policyPremiumRequests = (List<PolicyPremiumDetail>)executionResults.getValue("policyPremiumRequest");
		if(policyPremiumRequests.size() == 0 || policyPremiumRequests.size() > 1){
			Assert.fail("testRuleForAgeBetween18And40Years failed. Invalid number of output from rule file, size - " + policyPremiumRequests.size());
		}
		Assert.assertTrue("testRuleForAgeBetween18And40Years has been successfully validated", policyPremiumRequests.get(0).isEligibleForPolicy());

	}
	
	@Test
	public void testRuleForAgeBetween18And40YearsAndSmoker(){
		PowerMockito.mockStatic(AgeCalculator.class);
		when(AgeCalculator.fetchDate(1991, 07, 13, null))
		   .thenReturn(Date.from(LocalDate.of(1991, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		when(AgeCalculator.calculateAge(AgeCalculator.fetchDate(1991, 07, 13, null)))
		   .thenReturn(27);
		
		final PolicyPremiumDetail policyPremiumRequest = new PolicyPremiumDetail();
		final Date dob = AgeCalculator.fetchDate(1991, 07, 13, null);
		policyPremiumRequest.setDateOfBirth(dob);
		policyPremiumRequest.setSmoker(true);
		
		final ExecutionResults executionResults = execute(Arrays.asList(policyPremiumRequest), "ageBetween18And40IsSmoker" , "policyPremiumRequest");
		@SuppressWarnings("unchecked")
		final List<PolicyPremiumDetail> policyPremiumRequests = (List<PolicyPremiumDetail>)executionResults.getValue("policyPremiumRequest");
		if(policyPremiumRequests.size() == 0 || policyPremiumRequests.size() > 1){
			Assert.fail("testRuleForAgeBetween18And40YearsAndSmoker failed. Invalid number of output from rule file, size - " + policyPremiumRequests.size());
		}
		Assert.assertTrue("testRuleForAgeBetween18And40YearsAndSmoker has been successfully validated", policyPremiumRequests.get(0).isEligibleForPolicy());

	}
	
	@Test
	public void testRuleForAgeAbove60Years(){
		PowerMockito.mockStatic(AgeCalculator.class);
		when(AgeCalculator.fetchDate(1940, 07, 13, null))
		    .thenReturn(Date.from(LocalDate.of(1940, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		when(AgeCalculator.calculateAge(AgeCalculator.fetchDate(1940, 07, 13, null)))
		   .thenReturn(61);
		
		final PolicyPremiumDetail policyPremiumRequest = new PolicyPremiumDetail();
		final Date dob = AgeCalculator.fetchDate(1940, 07, 13, null);
		policyPremiumRequest.setDateOfBirth(dob);
		policyPremiumRequest.setSmoker(true);
		
		final ExecutionResults executionResults = execute(Arrays.asList(policyPremiumRequest), "ageAbove60" , "policyPremiumRequest");
		@SuppressWarnings("unchecked")
		final List<PolicyPremiumDetail> policyPremiumRequests = (List<PolicyPremiumDetail>)executionResults.getValue("policyPremiumRequest");
		if(policyPremiumRequests.size() == 0 || policyPremiumRequests.size() > 1){
			Assert.fail("testRuleForAgeAbove60Years failed. Invalid number of output from rule file, size - " + policyPremiumRequests.size());
		}
		Assert.assertTrue("testRuleForAgeAbove60Years has been successfully validated", policyPremiumRequests.get(0).isEligibleForPolicy());

	}
	
	@Test
	public void testRuleForAgeAbove60AndSmoker(){
		PowerMockito.mockStatic(AgeCalculator.class);
		when(AgeCalculator.fetchDate(1940, 07, 13, null))
		   .thenReturn(Date.from(LocalDate.of(1991, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		when(AgeCalculator.calculateAge(AgeCalculator.fetchDate(1940, 07, 13, null)))
		   .thenReturn(61);
		
		final PolicyPremiumDetail policyPremiumRequest = new PolicyPremiumDetail();
		final Date dob = AgeCalculator.fetchDate(1940, 07, 13, null);
		policyPremiumRequest.setDateOfBirth(dob);
		policyPremiumRequest.setSmoker(true);
		
		final ExecutionResults executionResults = execute(Arrays.asList(policyPremiumRequest), "ageAbove60IsSmoker" , "policyPremiumRequest");
		@SuppressWarnings("unchecked")
		final List<PolicyPremiumDetail> policyPremiumRequests = (List<PolicyPremiumDetail>)executionResults.getValue("policyPremiumRequest");
		if(policyPremiumRequests.size() == 0 || policyPremiumRequests.size() > 1){
			Assert.fail("testRuleForAgeAbove60AndSmoker failed. Invalid number of output from rule file, size - " + policyPremiumRequests.size());
		}
		Assert.assertFalse("testRuleForAgeAbove60AndSmoker has been successfully validated", policyPremiumRequests.get(0).isEligibleForPolicy());

	}

}
