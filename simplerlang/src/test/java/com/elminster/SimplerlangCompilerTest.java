package com.elminster;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class SimplerlangCompilerTest {

    private static final String TEST_PROGRAM_DIR = "test/programs";
    private static final String SIMPLERLANG_PROGRAM_EXTENSION = ".slg";

    @Test
    public void testCompile() throws IOException {
        File dir = new File(this.getClass().getClassLoader().getResource(TEST_PROGRAM_DIR).getFile());
        compileFile(dir);
    }

    private void compileFile(File file) throws IOException {
        if (file.isFile()) {
            if (isProgramFile(file)) {
                SimplerlangCompiler compiler = new SimplerlangCompiler();
                compiler.compileProgram(file.getAbsolutePath());
            }
        } else if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File child : children) {
                compileFile(child);
            }
        }
    }

    private boolean isProgramFile(File file) {
        if (file.getName().endsWith(SIMPLERLANG_PROGRAM_EXTENSION)) {
            return true;
        }
        return false;
    }
}
