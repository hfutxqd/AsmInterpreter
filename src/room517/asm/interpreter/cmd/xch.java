package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class xch extends cmd {
    public xch(String o1, String o2)
    {
        operand_1 = o1; operand_2 = o2;
    }
    public void func()
    {
        int temp = reg.get(operand_1);
        reg.set(operand_1, reg.get(operand_2));
        reg.set(operand_2, temp);
    }
}
