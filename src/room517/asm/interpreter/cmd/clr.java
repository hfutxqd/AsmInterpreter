package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class clr extends Command {

    public clr(String o1)
    {
        operStr1 = o1;
        operStr2 = "";
    }
    public void func()
    {
        Register.set(operStr1, 0);
    }
}
