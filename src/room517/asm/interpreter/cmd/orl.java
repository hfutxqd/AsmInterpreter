package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class orl extends ope {
    @Override
    int operate(int left, int right) {
        return left | right;
    }

    public orl(String o1, String o2)
    {
        super(o1, o2);
    }
}
