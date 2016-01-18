package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class sub extends Operation {

    @Override
    long operate(long left, long right) {
        Register.setFlags(left, right, Register.OpeType.sub);
        return left - right;
    }

    public sub(String o1, String o2)
    {
        super(o1, o2);
    }
}
