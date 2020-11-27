package com.ja.jademo.controller;

import com.ja.jademo.model.Info;
import com.ja.jademo.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoRepository infoRepository;

    @GetMapping("/info_list")
    public String list(Model model) {
        List<Info> infos = infoRepository.findAll();
        model.addAttribute("infos", infos);
        return "info/info_list";
    }
}
