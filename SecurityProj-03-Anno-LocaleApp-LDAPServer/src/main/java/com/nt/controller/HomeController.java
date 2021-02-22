package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ILocaleService;

@Controller
public class HomeController {
	
	@Autowired
	private ILocaleService service;

	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}
	
	
	 /*@RequestMapping(value="/country", method=RequestMethod.GET) 
	  * public ModelAndView fetchCountry() { List<String> list= null;
	  
	  list=service.getAllCountry(); System.out.println(list.get(5));
	  
	 return new ModelAndView("show_result","infoList",list); }
	 */
	
	/*@RequestMapping(value="/country", method=RequestMethod.GET)
	public ModelAndView fetchCountry() {
		List<String> list= null;
		
		list=service.getAllCountry();
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("infoList", list);
		mav.addObject("opration", "country");
		mav.setViewName("show_result");
		return mav;
	}*/
	
	/*@RequestMapping(value="/country", method=RequestMethod.GET)
	public String fetchCountry(Map<String, Object> map) {
		List<String> list= null;
		
		list=service.getAllCountry();
		
		map.put("infoList", list);
		map.put("opration", "country");
		return "show_result";
		
	}*/
	
	@RequestMapping(value="/country", method=RequestMethod.GET)
	public String fetchCountry(ModelMap map) {
		List<String> list= null;
		
		list=service.getAllCountry();
		
		map.put("infoList", list);
		map.put("opration", "country");
		map.put("count", list.size());
		return "show_result";
	}
		
	


}
