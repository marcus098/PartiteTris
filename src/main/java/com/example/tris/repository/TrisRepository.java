package com.example.tris.repository;

import com.example.tris.model.ReturnElement;
import com.example.tris.model.Tris;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrisRepository {
    private int id = -1;
    private List<Tris> list = new ArrayList<>();

    public String addMatch() {
        id = incrementAndGetId();
        if (findById(id))
            return "failed";
        list.add(new Tris(id));
        return "success";
    }

    public String reset(int id) {
        if (findById(id))
            return list.stream().filter(tris -> tris.getId() == id).findFirst().get().reset();
        return "failed";
    }

    public ReturnElement move(int posI, int posJ, int matchId) {
        if (!findById(matchId))
            return null;
        Tris t = list.stream().filter(tris -> tris.getId() == id).findFirst().get();
        // t.setMove(posI,posJ);
        return new ReturnElement(t, t.setMove(posI, posJ));
    }

    public String back(int matchId) {
        if (!findById(matchId))
            return "Match non trovato";
        return list.stream().filter(tris -> tris.getId() == id).findFirst().get().goBack();
    }

    public Tris print(int id) {
        if (!findById(id))
            return null;
        return list.stream().filter(tris -> tris.getId() == id).findFirst().get();
    }

    private int incrementAndGetId() {
        id++;
        return id;
    }

    private boolean findById(int id) {
        if (list.stream().filter(tris -> tris.getId() == id).count() == 0) {
            //list.add(new Tris(id));
            return false;
        }
        return true;
    }


}
