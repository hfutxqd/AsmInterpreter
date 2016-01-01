package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class xchg extends Command {
    public xchg(String o1, String o2)
    {
        operStr1 = o1; operStr2 = o2;
    }
    public void func()
    {
        long temp = Register.get(operStr1);
        Register.set(operStr1, Register.get(operStr2));
        Register.set(operStr2, temp);
    }
}
