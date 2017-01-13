package cafe.naver.jjdev;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final Logger logger =LoggerFactory.getLogger(SampleDao.class);
	public int insertSample(Sample sample){
		logger.debug(""+sample.getY());
		return sqlSession.insert("cafe.naver.jjdev.SampleMapper.sampleInsert", sample);
	}
}

