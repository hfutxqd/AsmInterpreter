package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class cmp extends ope{

    public cmp(String o1, String o2) {
        operand_1 = o1;
        operand_2 = o2;
    }

    @Override
    long operate(long left, long right) {
        Register.setCmp(left, right);
        return left;
    }
}
