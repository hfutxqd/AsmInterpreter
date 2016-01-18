package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class mul32 extends Operation {
    @Override
    long operate(long left, long right) {
        long ax = Register.get("ax");
        left = left & 0x00000000FFFFFFFFL;
        Register.setFlags(left, ax, Register.OpeType.mul32);
        long result = left * ax;
        long dx = result & 0xFFFFFFFF00000000L;
        dx = dx >> 32;
        ax = result & 0x00000000FFFFFFFFL;
        Register.set("dx", dx);
        Register.set("ax", ax);
        return left;
    }

    public mul32(String o1)
    {
        operStr1 = o1;
        operStr2 = "";
    }
}
