package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service("service")
public class LocaleServiceImpl implements ILocaleService {

	@Override
	public List<String> getAllCountry() {
		List<String> list = null;
		Locale locale[] = null;
		
		list = new ArrayList<>();
		locale= Locale.getAvailableLocales();
		for(Locale l : locale) {
			if(!l.getDisplayCountry().equals("")) {
				list.add(l.getDisplayCountry());
			}
			
		}
		
		
		return list;
	}

}
