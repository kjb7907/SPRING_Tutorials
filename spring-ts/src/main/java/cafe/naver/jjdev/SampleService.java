package cafe.naver.jjdev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SampleService {
	private static final Logger logger =LoggerFactory.getLogger(SampleService.class);
	@Autowired
	private SampleDao sampleDao;
	
	public int addSample(Sample sample){
        int row = sampleDao.insertSample(sample);
       
        //예외발생시켜 롤백되는지 테스트
        boolean flag = true;
        if(flag) {
            throw new RuntimeException();
        }    

		return row;
	}
}
