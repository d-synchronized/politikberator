package com.threaddynamics.politlberator.rule.engine.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class AgeCalculator {
	
	public static int calculateAge(final Date dateOfBirth){
		final LocalDate localDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		final LocalDate now = LocalDate.now();
		
		final Period period = Period.between(localDate, now);
		return period.getYears();
	}
	
	
	public static Date fetchDate(final int year,final int month,final int day,final String zoneId){
		final LocalDate localDate = LocalDate.of(year, month, day);
		final Date date = Date.from(localDate.atStartOfDay(zoneId == null || zoneId == "" ? ZoneId.systemDefault() : ZoneId.of(zoneId)).toInstant());
		return date;
	}

}