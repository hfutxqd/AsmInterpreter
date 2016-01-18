package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class div32 extends Operation {
    @Override
    long operate(long left, long right) {
        long ax = Register.get("ax");
        long dx = Register.get("dx");
        dx = dx << 32;
        Register.setFlags(left, dx|ax, Register.OpeType.div32);
        left = left & 0x00000000FFFFFFFFL;
        long divide = Long.divideUnsigned(dx|ax, left);
        long remainder = Long.remainderUnsigned(dx|ax, left);
        Register.set("ax", divide);
        Register.set("dx", remainder);
        return left;
    }

    public div32(String o1) {
        operStr1 = o1;
        operStr2 = "";
    }
}
