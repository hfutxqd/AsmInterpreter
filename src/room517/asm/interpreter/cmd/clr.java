package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class clr extends cmd {

    public clr(String o1)
    {
        operand_1 = o1;
        operand_2 = "";
    }
    public void func()
    {
        reg.set(operand_1, 0);
    }
}
