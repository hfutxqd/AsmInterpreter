package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class mul16 extends Operation {

    @Override
    long operate(long left, long right) {
        long al = Register.get("al");
        left = left & 0x000000000000FFFFL;
        Register.setFlags(left, al, Register.OpeType.mul16);
        left = left * al;
        Register.set("ax", left);
        return left;
    }

    public mul16(String o1)
    {
        operStr1 = o1;
        operStr2 = "";
    }
}
