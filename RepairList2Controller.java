package com.springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RepairList2Controller {
@RequestMapping(value="/RepairList2", method=RequestMethod.GET)
	public ModelAndView do_loadListRepair(){
	ModelAndView mav = new ModelAndView("RepairList2");
	RepairListManager rm = new RepairListManager();
	mav.addObject("Repairlist2", rm.getListRepair());
	return mav;
	}

}