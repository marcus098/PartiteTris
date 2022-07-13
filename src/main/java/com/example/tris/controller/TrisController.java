package com.example.tris.controller;

import com.example.tris.model.ReturnElement;
import com.example.tris.model.Tris;
import com.example.tris.service.TrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class TrisController {

    @Autowired
    TrisService trisService;

    @GetMapping("/new")
    public String newGame() {
        return trisService.addNew();
    }

    @GetMapping("/reset/{matchId}")
    public String resetGame(@PathVariable("matchId") int matchId) {
        return trisService.resetGame(matchId);
    }

    //Fare una mossa (/move/{X/O}/{pos_i}/{pos_j})
    //Fare una mossa (/move/{pos_i}/{pos_j})
    //@GetMapping("/move/{matchId}/{x}/{pos_i}/{pos_j}")
    @GetMapping("/move/{matchId}/{pos_i}/{pos_j}")
    public ReturnElement move(@PathVariable("pos_i") int posI, @PathVariable("pos_j") int posJ, @PathVariable("matchId") int id) {
        //return trisService.move(c, posI, posJ, id);
        return trisService.move(posI, posJ, id);
    }

    @GetMapping("/back/{matchId}")
    public String goBack(@PathVariable("matchId") int id) {
        return trisService.goBack(id);
    }

    @GetMapping("/print/{matchId}")
    public Tris print(@PathVariable("matchId") int id){
        return trisService.print(id);
    }
}
