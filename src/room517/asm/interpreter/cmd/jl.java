package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class jl extends jmp{
    public jl(String o1, node p)
    {
        super(o1, p);
    }

    @Override
    public void func() {
        if (Register.get("bh") < Register.get("dh"))
        {
            jump(operand_1);
        }
        else{
            ptr.convert(null);
        }
    }
}
