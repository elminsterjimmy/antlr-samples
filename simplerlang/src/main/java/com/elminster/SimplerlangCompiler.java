package com.elminster;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.elminster.antlr.SimplerlangLexer;
import com.elminster.antlr.SimplerlangParser;

public class SimplerlangCompiler {
    
    public void compileProgram(String programFile) throws IOException {
        CharStream input = CharStreams.fromFileName(programFile);
        SimplerlangLexer lexer = new SimplerlangLexer(input);
        SimplerlangParser parser = new SimplerlangParser(new CommonTokenStream(lexer));
        parser.addParseListener(new SimplerlangCustomListener());
        parser.program();
    }
}
