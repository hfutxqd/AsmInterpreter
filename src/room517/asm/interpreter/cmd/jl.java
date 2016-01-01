package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class jl extends jmp{
    public jl(String o1, node p)
    {
        super(o1, p);
    }
    public jl()
    {
        super();
    }

    @Override
    public void func() {
        if (reg.get("bh") < reg.get("dh"))
        {
            jump(operand_1);
        }
        else{
            ptr.convert(null);
        }
    }
}
