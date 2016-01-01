package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class loop extends cmd {
    node ptr;
    public loop(String o1, node p)
    {
        operand_1 = o1;
        ptr = p;
    }
    public loop()
    {
        operand_1 = "";
        ptr = null;
    }

    @Override
    public void func() {
        reg.set("cx", reg.get("cx") - 1);
        if (reg.get("cx") > 0)
        {
            cmd_buffer p;
            p = label_buf;
            while (p != null)
            {
                if (operand_1.equals(p.label_name))
                {
                    ptr.convert(p.label_site);
                    return;
                }
                p = p.next_label;
            }
        }
        else
        {
            ptr.convert(null);
        }
    }
}
