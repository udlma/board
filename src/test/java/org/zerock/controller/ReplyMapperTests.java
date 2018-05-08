package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Critaria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {
	
	@Setter(onMethod_={@Autowired})
	ReplyMapper mapper;
	
	@Test
	public void testList() {
		
		mapper.list(new Critaria(1), 50);
		
	}
	
	@Test
	public void testRead() {
		
		mapper.read(42);
		
	}
	
	@Test
	public void testInsert() {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(116);
		vo.setReplytext("test");
		vo.setReplyer("user00");
		mapper.insert(vo);
		
	}
	
	@Test
	public void testDelete() {
		
		mapper.read(42);
		
	}
	
	@Test
	public void testUpdate() {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(38);
		vo.setReplytext("test");
		vo.setReplyer("user00");
		mapper.insert(vo);
		
	}

}
