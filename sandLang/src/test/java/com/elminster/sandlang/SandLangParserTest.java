package com.elminster.sandlang;

import com.elminster.antlr.SandParser;
import org.junit.Test;

import java.io.IOException;

public class SandLangParserTest {

  private static final String[] SCRIPT_NAMES = {
      "simplest_var_decl.sand",
      "addition_assignment.sand",
      "parenthesis.sand",
      "precedence_expression.sand",
      "references.sand"
  };

  @Test
  public void testLineWalker() throws IOException {
    SandLangParser sandLangParser = new SandLangParser();
    LineWalker lineWalker = new LineWalker();
    for (String scriptName : SCRIPT_NAMES) {
      SandParser.SandFileContext ctx = sandLangParser.parse(this.getClass().getClassLoader().getResourceAsStream(scriptName));
      lineWalker.walk(ctx);
      System.out.println("---");
    }
  }
}
