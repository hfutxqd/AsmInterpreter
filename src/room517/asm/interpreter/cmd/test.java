package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class test extends operation{
    @Override
    long operate(long left, long right) {
        Register.setFlags(left, right, Register.OpeType.and);
        return left;
    }
    public test(String o1, String o2) {
        super(o1, o2);
    }
}
