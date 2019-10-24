package com.springmvc.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Building;
import com.springmvc.model.ListUser;
import com.springmvc.model.Repairlist;
import com.springmvc.model.Room;
@Controller
public class InsertRepairController {
	@RequestMapping(value="/InsertRepair",method=RequestMethod.GET)
	public String DetailRepair(){
		return "insertRepair";
	}
	@RequestMapping(value="/InsertRepair2", method=RequestMethod.POST)
	public ModelAndView doinsertrepair(HttpServletRequest request){
	String message = "";
	ModelAndView mav = new ModelAndView("insertRepair2");
	if (ServletFileUpload.isMultipartContent(request)) {
	try {
		List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			String userID = data.get(0).getString();
			String Fullname = data.get(1).getString();
			String BuildingNo = data.get(2).getString();
			String RoomID = data.get(3).getString();
			String Type = data.get(4).getString();
			String Damage = data.get(5).getString();
			String imagefile = new File(data.get(6).getName()).getName();
			String filetype =imagefile.substring(imagefile.lastIndexOf(".") + 1);
		insertManager im = new insertManager();
		ListUser insertUserID = im.userlist(userID);
		Building insertBuildingNo = im.buildinglist(BuildingNo);
		Room insertRoomID =im.roomlist(RoomID);
		Repairlist insertRepairlist = new Repairlist(Fullname,Type,Damage,imagefile,insertBuildingNo,insertUserID,insertRoomID);
		insertManager rm = new insertManager();
			message = rm.doHibernateInsertRepair(insertRepairlist);
		String path = request.getSession().getServletContext().getRealPath("/") +"//WEB-INF//images//";
		data.get(6).write(new File(path + File.separator +imagefile + "." + filetype));
	}catch(Exception e) {
		e.printStackTrace();
		message = "Please try again....";
		}
	}
	mav.addObject("message", message);
		return mav;
	}
}
