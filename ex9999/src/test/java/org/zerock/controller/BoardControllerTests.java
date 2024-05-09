package org.zerock.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class BoardControllerTests {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

	}
	
	@Test
	public void testList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testList2() throws Exception{
		MockHttpServletRequestBuilder a = MockMvcRequestBuilders.get("/board/list");
		ResultActions b = mockMvc.perform(a);
		MvcResult c = b.andReturn();
		ModelAndView d = c.getModelAndView();
		ModelMap e = d.getModelMap();
		List<BoardVO> f = (List<BoardVO>) e.get("list");
		
		for (int i = 0 ; i<f.size(); i++) {
			BoardVO vo = f.get(i);
			log.info(vo);
		}
		log.info("@@@@@@@@@@@:" + e);
		log.info("$$$$$$$$$$$: " + f);
	
	}
	
	@Test
	public void testRegister() throws Exception{
		String resultPage =
				mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트 새글 제목")
				.param("content", "테스트 새글 내용")
				.param("writer","user00")
				)
				.andReturn()
				.getModelAndView()
				.getViewName();
		
		log.info(resultPage);
	}
	
	@Test
	public void testRegister2() throws Exception{
		MockHttpServletRequestBuilder a = MockMvcRequestBuilders.post("/board/register");
		a.param("title","테스트 새글 제목2");
		a.param("content", "테스트 새글 내용 2");
		a.param("writer","user002");
		ResultActions b = mockMvc.perform(a);
		MvcResult c = b.andReturn();
		ModelAndView d = c.getModelAndView();
		String e = d.getViewName();
		
		log.info("@@@@@@@@@@@@@@@@@@@" +e );
	}
	@Test
	public void testGet() throws Exception{
		log.info(mockMvc.perform(
				MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView().getModelMap());
		
	}
	
	@Test
	public void testModify() throws Exception{
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno", "1")
						.param("title", "수정된 테스트 새글 제목")
						.param("content", "수정된 테스트 새글 내용")
						.param("writer","user00"))
				.andReturn().getModelAndView().getViewName();
		
	}
	
	@Test
	public void testRemove() throws Exception{
		//삭제 전 게시물 번호 존재 여부 확인
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno","11")
				).andReturn().getModelAndView().getViewName();
	}
	
	@Test
	public void testListPaging() throws Exception{
		
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());
	}
}
