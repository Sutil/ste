package br.com.ste.app.image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageSwitchBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<String> images;  
	  
    public ImageSwitchBean() {  
        images = new ArrayList<String>();  
        images.add("/ste/spring/javax.faces.resource/java.png?ln=images");  
        images.add("/ste/spring/javax.faces.resource/android.png?ln=images");  
        images.add("/ste/spring/javax.faces.resource/primefaces.png?ln=images");  
        images.add("/ste/spring/javax.faces.resource/SpringSource.png?ln=images"); 
    }  
  
    public List<String> getImages() {  
        return images;  
    }

}
