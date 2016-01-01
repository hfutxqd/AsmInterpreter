package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class jz extends jmp {
    public jz(String o1, node p)
    {
        super(o1, p);
    }
    public jz()
    {
        super();
    }

    @Override
    public void func() {
        if (reg.get("bh") == 0)
        {
            jump(operand_1);
        }
        else
        {
            ptr.convert(null);
        }
    }
}
