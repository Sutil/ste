package br.com.ste.app.home.web;

import org.springframework.stereotype.Controller;

import br.com.ste.app.image.ImageSwitchBean;

@Controller
public class HomeController {
	
	public ImageSwitchBean newImageBean(){
		return new ImageSwitchBean();
	}
	
}
