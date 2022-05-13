package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/register")
	public void register() {}

	@GetMapping("/list")
	public void list(Criteria criteria, Model model) {
		log.info("list");
		model.addAttribute("list", service.getList(criteria));
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes attributes) {
		log.info("register : " + board);
		service.register(board);
		attributes.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}

	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam("bno") Long bno, Model model) {
		log.info("/modify");
		model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes attributes) {
		log.info("modify : " + board);
		if (service.modify(board)) {
			attributes.addFlashAttribute("result", "success");
		}

		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes attributes) {
		log.info("remove : " + bno);
		if (service.remove(bno)) {
			attributes.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
