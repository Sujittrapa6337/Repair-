package com.springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RepairListController {
@RequestMapping(value="/RepairList", method=RequestMethod.GET)
	public ModelAndView do_loadListRepair(){
	ModelAndView mav = new ModelAndView("RepairList");
	RepairListManager rm = new RepairListManager();
	mav.addObject("Repairlist", rm.getListRepair());
	return mav;
	}

}