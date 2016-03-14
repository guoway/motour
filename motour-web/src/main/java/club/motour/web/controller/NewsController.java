package club.motour.web.controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
public class NewsController {

	Logger log = Logger.getLogger(NewsController.class) ;
	
	@RequestMapping(value="/news", method={RequestMethod.GET})
	public String newList(){
		return "news/news" ;
	}
}
