package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class cmp extends Operation {

    public cmp(String o1, String o2) {
        operStr1 = o1;
        operStr2 = o2;
    }

    @Override
    long operate(long left, long right) {
        Register.setFlags(left, right, Register.OpeType.sub);
        return left;
    }
}
