package club.motour.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import club.motour.dao.ImageDAO;
import club.motour.model.Image;

@Controller
@Scope("prototype")
public class GalleryController extends BaseController {

	@Autowired
	ImageDAO dao;
	
	
	@RequestMapping(value="gallery")
	public String gallery(ModelMap model) {
		List<Image> list = dao.findAll();
		model.addAttribute("list", list);
		return "gallery";
	}
	
	@RequestMapping(value="/video")
	public String video(ModelMap model) {
		return "video";
	}
}
