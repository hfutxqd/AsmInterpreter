package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class jmp extends Command {
    node ptr;
    public jmp(String o1, node p)
    {
        operStr1 = o1;
        ptr = p;
    }

    @Override
    public void func() {
        jump(operStr1);
    }

    public void jump(String site)
    {
        CmdBuffer p;
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
