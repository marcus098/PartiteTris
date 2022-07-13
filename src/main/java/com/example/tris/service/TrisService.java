package com.example.tris.service;

import com.example.tris.model.ReturnElement;
import com.example.tris.model.Tris;
import com.example.tris.repository.TrisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrisService {

    @Autowired
    private TrisRepository trisRepository;

    public String addNew() {
        return trisRepository.addMatch();
    }

    public String resetGame(int id) {
        return trisRepository.reset(id);
    }

    public ReturnElement move(/*char c, */int p1, int p2, int id) {
        return trisRepository.move(p1, p2, id);
    }

    public String goBack(int id){
        return trisRepository.back(id);
    }

    public Tris print(int id){
        return trisRepository.print(id);
    }
}
