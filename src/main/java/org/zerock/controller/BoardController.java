package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Critaria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	@GetMapping("/list")
	public void list(Critaria cri, Model model) {

		List<BoardVO> list = new ArrayList<>();
		PageMaker pm = null;
		
		if(cri.getType() != null) {
			list = service.getSearchList(cri);
			pm = new PageMaker(cri, service.getSearchTotal(cri));
		}else {
			list = service.getList(cri);
			pm = new PageMaker(cri, service.getTotal());
		}

		model.addAttribute("list", list);
		model.addAttribute("pm", pm);

	}

	@GetMapping("/register")
	public void register() {

		log.info("register get");

	}

	@PostMapping("/register")
	public String registerPost(BoardVO vo, RedirectAttributes reattr) {

		log.info("register post");
		service.create(vo);

		reattr.addFlashAttribute("value", "rsuccess");

		return "redirect:/board/list";

	}

	@GetMapping("/delete")
	public String delete(Integer bno, int page, RedirectAttributes reattr) {
		
		log.info("delete get");

		service.remove(bno);

		reattr.addFlashAttribute("value", "dsuccess");

		return "redirect:/board/list?page="+page;

	}

	@GetMapping("/update")
	public void update(Integer bno, Model model) {

		log.info("update get");

		BoardVO vo = service.getView(bno);

		model.addAttribute("vo", vo);

	}

	@PostMapping("/update")
	public String updatePost(BoardVO vo, int page, int bno, String type, String keyword, RedirectAttributes reattr) {

		log.info("update post");
		service.modify(vo);

		reattr.addFlashAttribute("value", "usuccess");
		
		if(type != null) {
			return "redirect:/board/view?page=" + page +"&bno="+bno+"&type="+type+"&keyword="+keyword;
		}

		return "redirect:/board/view?page=" + page +"&bno="+bno;

	}

	@GetMapping("/view")
	public void view(Integer bno, Model model) {

		log.info("view get");

		BoardVO vo = service.getView(bno);

		model.addAttribute("vo", vo);

	}



}
