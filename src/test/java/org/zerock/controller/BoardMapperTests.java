package org.zerock.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Critaria;
import org.zerock.mapper.BoardMapper;
import lombok.Setter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class BoardMapperTests {
	
	@Setter(onMethod_={@Autowired})	
	private BoardMapper mapper;
	
	@Test
	public void testList() {
		
		mapper.list(new Critaria(1));
		
	}
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("±×¶ó»þ");
		vo.setContent("ddfd");
		vo.setWriter("user00");
		
		mapper.insert(vo);
		
	}
	
	@Test
	public void testDelete() {
		
		mapper.delete(118);
		
	}
	
	@Test
	public void testUpdate() {
		
		
		BoardVO vo = new BoardVO();
		vo.setTitle("¾Æ±¸¸ó");
		vo.setContent("ddfd");
		vo.setWriter("user00");
		vo.setBno(116);
		
		mapper.update(vo);
		
	}
	
	@Test
	public void testRead() {
		
		mapper.read(116);
		
	}
	
	@Test
	public void testSearchList() {
		
		Critaria cri = new Critaria(1);
		cri.setType("t");
		cri.setKeyword("±×¶ó»þ");
		mapper.searchList(cri);
		
	}

}
