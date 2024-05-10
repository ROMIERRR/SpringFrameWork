package org.zerock.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ReplyMapperTests {

	private Long[] bnoArr = { 16438L, 16437L, 16434L, 16432L };
	
	@Autowired
	private ReplyMapper mapper;

	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
//	@Test //책에 있는 원래의 테스트 내용
//	public void testCreate() {
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO vo = new ReplyVO();
//
//			vo.setBno(bnoArr[1 % 5]);
//			vo.setReply("댓글 테스트" + i);
//			vo.setReplyer("replyer" + i);
//
//			mapper.insert(vo);
//		});
//	}
	
	@Test //선생님 버전
	public void testCreate2() {
		for(int i =0; i<bnoArr.length; i++) {
			
			ReplyVO vo = new ReplyVO();

			vo.setBno(bnoArr[1 % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer" + i);

			mapper.insert(vo);
		}
	}
	
	
	@Test
	public void testRead()	{
		Long targetRno =5L;
		ReplyVO vo =mapper.read(targetRno);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		Long targetRno =1L;
		mapper.delete(targetRno);
	}
	
	@Test
	public void testUpdate() {
		Long targetRno =10L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT:" +count);
	}
	
	@Test
	public void testList() {
		Criteria cri =new Criteria();
		List<ReplyVO> replies= mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
}