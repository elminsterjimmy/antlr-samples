package com.elminster.sandlang;

import com.elminster.antlr.SandLexer;
import com.elminster.antlr.SandParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.InputStream;

public class SandLangParser {

  public SandParser.SandFileContext parse(InputStream is) throws IOException {
    SandLexer lexer = new SandLexer(CharStreams.fromStream(is));
    lexer.addErrorListener(new SandLangErrorListener());
    SandParser parser = new SandParser(new CommonTokenStream(lexer));
    parser.addErrorListener(new SandLangErrorListener());
    return parser.sandFile();
  }
}
