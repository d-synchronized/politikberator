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
import com.threaddynamics.politlberator.rule.engine.dto.PolicyPremiumRequest;
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
	
	
	protected ExecutionResults execute(Collection<?> objects,final String ruleName,final String filterOut){
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
					if(object instanceof PolicyPremiumRequest){
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
		when(AgeCalculator.fetchDate(2000, 07, 13, null)).thenReturn(Date.from(LocalDate.of(2000, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final PolicyPremiumRequest policyPremiumRequest = new PolicyPremiumRequest();
		final Date dob = AgeCalculator.fetchDate(2000, 07, 13, null);
		policyPremiumRequest.setDateOfBirth(dob);
		policyPremiumRequest.setSmoker(true);
		
		final ExecutionResults executionResults = execute(Arrays.asList(policyPremiumRequest), "ageBelow18" , "policyPremiumRequest");
		final List<PolicyPremiumRequest> policyPremiumRequests = (List<PolicyPremiumRequest>)executionResults.getValue("policyPremiumRequest");
		if(policyPremiumRequests.size() == 0 || policyPremiumRequests.size() > 1){
			Assert.fail("testRuleForAgeLessThen18Years failed. Invalid number of output from rule file, size - " + policyPremiumRequests.size());
		}
		Assert.assertFalse("testRuleForAgeLessThen18Years has been successfully validated", policyPremiumRequests.get(0).isEligibleForPolicy());
	}
	
	
	@Test
	public void testRuleForAgeLessThen18YearsAndSmoker(){
		
	}

}
