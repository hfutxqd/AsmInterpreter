package room517.asm.interpreter.test;

import room517.asm.interpreter.interpreter.Interpreter;

import java.io.IOException;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class Main {
    public static void main(String ... args) throws IOException {
        Interpreter translator = new Interpreter();
        translator.translate("1.asm");
    }
}
