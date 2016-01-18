package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class div16 extends Operation {
    @Override
    long operate(long left, long right) {
        long ax = Register.get("ax");
        left = left & 0x000000000000FFFFL;
        Register.setFlags(left, ax, Register.OpeType.div16);
        long al = ax / left;
        long ah = ax % left;
        Register.set("al", al);
        Register.set("ah", ah);
        return left;
    }

    public div16(String o1) {
        operStr1 = o1;
        operStr2 = "";
    }
}
