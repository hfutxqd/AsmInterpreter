package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class inc extends cmd{
    @Override
    public void func() {
        reg.set(operand_1, reg.get(operand_1) + 1);
    }

    public inc(String o1)
    {
        operand_1 = o1;
        operand_2 = "";
    }
}
