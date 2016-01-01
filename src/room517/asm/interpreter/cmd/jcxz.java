package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2016/1/1.
 *
 */
public class jcxz extends jmp{
    public jcxz(String o1, node p)
    {
        super(o1, p);
    }

    @Override
    public void func() {
        if(Register.get("cx") == 0)
        {
            jump(operStr1);
        }
    }
}
