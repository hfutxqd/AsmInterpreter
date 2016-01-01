package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class or extends operation {
    @Override
    long operate(long left, long right) {
        Register.setFlags(left, right, Register.OpeType.or);
        return left | right;
    }

    public or(String o1, String o2)
    {
        super(o1, o2);
    }
}
