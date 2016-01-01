package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public abstract class ope extends cmd {
    abstract int operate(int left,int right);
    @Override
    public void func() {
        if(!is_reg(operand_2)) {
            reg.set(operand_1, operate(reg.get(operand_1), str_to_int(operand_2)));
        }
        else {
            reg.set(operand_1, operate(reg.get(operand_1), reg.get(operand_2)));
        }
    }
    public ope(String o1, String o2)
    {
        operand_1 = o1;
        operand_2 = o2;
    }
    public ope()
    {
        operand_1 = "";
        operand_2 = "";
    }
}
