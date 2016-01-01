package room517.asm.interpreter.interpreter;

import room517.asm.interpreter.cmd.node;
import room517.asm.interpreter.register.Register;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class Interpreter {

    public void translate(String str) throws IOException {
        long time1 = System.currentTimeMillis();
        node.fin = new Scanner(new File(str));
        node begin = new node();
        begin.read_asm();
        node.fin.close();
        begin.run_asm();
        long time2 = System.currentTimeMillis();
        System.out.println("\nExecuted in "+(time2 - time1) +" ms.");
        System.out.println("Register status:");
        System.out.println("ax:"+ Register.get("ax"));
        System.out.println("bx:"+ Register.get("bx"));
        System.out.println("cx:"+ Register.get("cx"));
        System.out.println("dx:"+ Register.get("dx"));
    }
}
