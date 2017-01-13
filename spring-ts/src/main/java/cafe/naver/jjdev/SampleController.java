package cafe.naver.jjdev;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SampleController {
	
	private static final Logger logger =LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/add")
	public String addSample(){
		
		Sample sample = new Sample();
		
		int y = (int) Math.floor(Math.random()*10); //0~9
		logger.debug("y : "+y);
		
		sample.setY(y);
		sampleService.addSample(sample);
		return "redirect:";
	}
}
