package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class jmp extends cmd {
    node ptr;
    public jmp(String o1, node p)
    {
        operand_1 = o1;
        ptr = p;
    }
    public jmp()
    {
        operand_1 = "";
        ptr = null;
    }

    @Override
    public void func() {
        jump(operand_1);
    }

    public void jump(String site)
    {
        cmd_buffer p;
        p = label_buf;
        while (p != null)
        {
            if (site.equals(p.label_name))
            {
                ptr.convert(p.label_site);
                return;
            }
            p = p.next_label;
        }
    }
}
