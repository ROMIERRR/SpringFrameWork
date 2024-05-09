package org.zerock.service;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void restRegister() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("Title 1 Key");
		boardVO.setContent("Content 1 Key");
		boardVO.setWriter("User01");
		
		service.register(boardVO);
		
		log.info("생성된 게시물 번호: " + boardVO.getBno());
		//mapper.insertSelectKey(boardVO);

	}
	
	@Test
	public void testGetList() {
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet() {
		

		log.info(service.get(10000L));
		
	}	

	@Test
	public void testDelete() {
		

		log.info("REMOVE RESULT: " + service.remove(1L));
		
	}	
	
	@Test
	public void testUpdate() {
		
		BoardVO boardVO = service.get(10000L);
		
		if (boardVO ==null) {
			return;
		}
		
		boardVO.setTitle("제목을 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(boardVO));
		
	}	
	

}
