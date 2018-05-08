package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Critaria;
import org.zerock.domain.PageMaker;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.Setter;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Setter(onMethod_ = { @Autowired })
	private ReplyService service;
	
	@PostMapping("/new")
	public ResponseEntity<String> insert(@RequestBody ReplyVO vo){
		
		ResponseEntity<String> entity = null;
		
		try {
			
			service.create(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		}catch(Exception e) {
			
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
		
	}
	
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> delete(@PathVariable("rno") Integer rno){
		
		ResponseEntity<String> entity = null;
		
		try {
			
			service.remove(rno);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		}catch(Exception e) {
			
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
		
	}
	
	@PutMapping("/{rno}")
	public ResponseEntity<String> update(@RequestBody ReplyVO vo, @PathVariable("rno") Integer rno){
		
		ResponseEntity<String> entity = null;
		
		try {
			vo.setRno(rno);
			service.modify(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
		}catch(Exception e) {
			
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
		
	}
	
	@GetMapping("/{rno}")
	public ResponseEntity<ReplyVO> read(@PathVariable("rno") Integer rno){
		
		ResponseEntity<ReplyVO> entity = null;
		
		try {
	
			entity = new ResponseEntity<ReplyVO>(service.getView(rno), HttpStatus.OK);
			
		}catch(Exception e) {
			
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
		
	}
	
	@GetMapping("/{bno}/{page}")
	public ResponseEntity<Map<String, Object>> read(@PathVariable("bno") Integer bno, Critaria cri){
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		Map<String, Object> map = new HashMap<>();
		PageMaker pm = new PageMaker(cri, service.getTotal(bno));
		
		map.put("list", service.getList(cri, bno));
		map.put("pm", pm);
		
		try {
	
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			
		}catch(Exception e) {
			
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
		
	}

}
