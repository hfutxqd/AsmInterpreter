package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class je extends  jmp {
    public je(String o1, node p)
    {
        super(o1, p);
    }
    public je()
    {
        super();
    }

    @Override
    public void func() {
        if (reg.get("bh") == reg.get("dh"))
        {
            jump(operand_1);
        }else{
            ptr.convert(null);
        }
    }
}
