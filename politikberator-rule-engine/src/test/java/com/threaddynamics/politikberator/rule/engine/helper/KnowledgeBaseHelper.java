package com.threaddynamics.politikberator.rule.engine.helper;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

public class KnowledgeBaseHelper {
	
	
	public static InternalKnowledgeBase producesKnowledgeBase(final String ruleFileLocation){
		final KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory.newClassPathResource(ruleFileLocation), ResourceType.DRL);
		
		if(knowledgeBuilder.hasErrors()){
			throw new RuntimeException("Error occurred while initializing the rule engine." + knowledgeBuilder.getErrors().toString());
		}
		
		final InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addPackages(knowledgeBuilder.getKnowledgePackages());
		return knowledgeBase;
	}

}
