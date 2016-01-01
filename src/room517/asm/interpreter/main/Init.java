package room517.asm.interpreter.main;

import room517.asm.interpreter.interpreter.Interpreter;

import java.io.IOException;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class Init {
    public static void main(String ... args){
        if(args.length == 1)
        {
            Interpreter translator = new Interpreter();
            try {
                translator.translate(args[0]);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }else {
            System.out.println("请查看使用说明.");
        }
    }
}
