package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class jz extends jmp {
    public jz(String o1, node p)
    {
        super(o1, p);
    }
    @Override
    public void func() {
        long[] nums = Register.getFlagsFrom();
        if (nums[0] == 0)
        {
            jump(operStr1);
        }
        else
        {
            ptr.convert(null);
        }
    }
}
