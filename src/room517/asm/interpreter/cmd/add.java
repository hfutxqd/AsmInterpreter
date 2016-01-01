package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class add extends ope {
    @Override
    long operate(long left, long right) {

        return left + right;
    }

    public add(String o1, String o2)
    {
        super(o1, o2);
    }

}
