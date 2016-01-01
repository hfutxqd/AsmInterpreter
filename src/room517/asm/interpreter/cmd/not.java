package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class not extends Command {
    @Override
    public void func() {
        long tmp = Register.get(operStr1);
        Register.setFlags(tmp, 0, Register.OpeType.not);
        Register.set(operStr1, ~tmp);
    }

    public not(String o1)
    {
        operStr1 = o1;
        operStr2 = "";
    }
}
