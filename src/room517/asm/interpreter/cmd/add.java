package room517.asm.interpreter.cmd;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class add extends ope {
    @Override
    int operate(int left, int right) {
        return left + right;
    }

    public add(String o1, String o2)
    {
        super(o1, o2);
    }
    public add()
    {
        super();
    }

}
