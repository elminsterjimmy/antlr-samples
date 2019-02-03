package com.elminster;

import java.util.HashMap;
import java.util.Map;

import com.elminster.antlr.SimplerlangBaseListener;
import com.elminster.antlr.SimplerlangParser.LetContext;
import com.elminster.antlr.SimplerlangParser.ShowContext;

class SimplerlangCustomListener extends SimplerlangBaseListener {
    
    Map<String, Integer> variableMap = new HashMap<>();

    @Override
    public void exitShow(ShowContext ctx) {
        if (null != ctx.INT()) {
            System.out.println(ctx.INT().getText());
        } else if (null != ctx.VAR()) {
            System.out.println(this.variableMap.get(ctx.VAR().getText()));
        }
    }

    @Override
    public void exitLet(LetContext ctx) {
        this.variableMap.put(ctx.VAR().getText(), Integer.parseInt(ctx.INT().getText()));
    }
    
}