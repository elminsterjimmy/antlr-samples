package com.elminster.sandlang;

import com.elminster.antlr.SandParser;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;

public class LineWalker {

  public void walk(SandParser.SandFileContext rootCtx) {
    for (SandParser.LineContext lineContext : rootCtx.line()) {
      walkThruTree(lineContext);
    }
  }

  private void walkThruTree(ParseTree tree) {
    int childCount = tree.getChildCount();
    if (0 == childCount) { // always be TerminalNodeImpl
      CommonToken payload = (CommonToken) tree.getPayload();
      System.out.println(payload);
      System.out.println(SandParser.VOCABULARY.getSymbolicName(payload.getType()) + "[" + payload.getStartIndex() + "-" + payload.getStopIndex() + "]");
    } else {
      for (int i = 0; i < childCount; i++) {
        ParseTree child = tree.getChild(i);
        walkThruTree(child);
      }
    }
  }
}
