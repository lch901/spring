package com.lch.board;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.lch.board.model.BoardVo;

@Controller// 
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String test(Model model) {
		//List<BoardVo> list = service.getBoardList();
		model.addAttribute("list", service.getBoardList());
		return "board/list";
	}
	@GetMapping("/writeForm")
	public String writeForm(Model model) {
		model.addAttribute("boardVo",new BoardVo());
		return returnFilePath("writeForm");
	}
	
	
	
	@PostMapping("/write")
	public RedirectView write(@ModelAttribute BoardVo boardVo) {
		System.out.println("title : "+boardVo.getTitle());
		service.insertBoard((boardVo));
		return new RedirectView("list");
	}
	
	
	@GetMapping("/detail/{i}")
	public String detail(@PathVariable("i")int i,Model model) {
		System.out.println("i ="+i);
		BoardVo vo = new BoardVo();
		vo.setI(i);
		model.addAttribute("data",service.getBoard(vo));
		
		return returnFilePath("detail");
	}
	@GetMapping("/modForm")
		public String modForm(@RequestParam int i,Model model) {
			BoardVo param = new BoardVo();
			param.setI(i);
			model.addAttribute("boardVo",service.getBoard(param));
			System.out.println("i ="+i);
			return returnFilePath("modForm");
	}
	
	@PutMapping("/mod")
	public RedirectView mod(@ModelAttribute BoardVo boardVo) {
		System.out.println("i : "+boardVo.getI());
		System.out.println("title : "+boardVo.getTitle());
		System.out.println("content : "+boardVo.getContent());
		service.modBoard(boardVo);
		return new RedirectView("list");
	}
	
	@PostMapping("/delete")
	public RedirectView delete(@ModelAttribute BoardVo boardVo) {
		
		System.out.println("여기는 delete");
		return new RedirectView("list");
	}
	
	
	public String returnFilePath(String fileNm) {
		return "board/" + fileNm;
	}
	
}

