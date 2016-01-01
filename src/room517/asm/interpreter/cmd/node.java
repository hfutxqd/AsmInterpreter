package room517.asm.interpreter.cmd;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class node {
    Command substance = null;
    static cmdBuffer first_label = null;
    node ptr_next = null;
    node ptr_jump = null;
    void save(Vector<String> words)
    {
        String command = (words.size() > 0 ? words.get(0) : "");
        if (command.equals("xchg"))
        {
            substance = new xchg(words.get(1), words.get(2));
        }
        else if (command.equals("clr"))
        {
            substance = new clr(words.get(1));
        }
        else if (command.equals("and"))
        {
            substance = new and(words.get(1), words.get(2));
        }else if (command.equals("or"))
        {
            substance = new or(words.get(1), words.get(2));
        }else if (command.equals("not"))
        {
            substance = new not(words.get(1));
        }else if (command.equals("neg"))
        {
            substance = new neg(words.get(1));
        }else if (command.equals("xor"))
        {
            substance = new xor(words.get(1), words.get(2));
        }else if (command.equals("test"))
        {
            substance = new test(words.get(1), words.get(2));
        }else if (command.equals("mov"))
        {
            substance = new mov(words.get(1), words.get(2));
        }
        else if (command.equals("loop"))
        {
            substance = new loop(words.get(1), this);
        }else if (command.equals("cmp"))
        {
            substance = new cmp(words.get(1), words.get(2));
        }else if (command.equals("jmp"))
        {
            substance = new jmp(words.get(1), this);
        }else if (command.equals("jcxz"))
        {
            substance = new jcxz(words.get(1), this);
        }else if (command.equals("jg"))
        {
            substance = new jg(words.get(1), this);
        }
        else if (command.equals("jl"))
        {
            substance = new jl(words.get(1), this);
        }
        else if (command.equals("je"))
        {
            substance = new je(words.get(1), this);
        }
        else if (command.equals("jne"))
        {
            substance = new jne(words.get(1), this);
        }
        else if (command.equals("jz"))
        {
            substance = new jz(words.get(1), this);
        }
        else if (command.equals("jnz"))
        {
            substance = new jnz(words.get(1), this);
        }
        else if (command.equals("inc"))
        {
            substance = new inc(words.get(1));
        }
        else if (command.equals("dec"))
        {
            substance = new dec(words.get(1));
        }
        else if (command.equals("add"))
        {
            substance = new add(words.get(1), words.get(2));
        }
        else if (command.equals("sub"))
        {
            substance = new sub(words.get(1), words.get(2));
        }
        else if (command.equals("mul16"))
        {
            substance = new mul16(words.get(1));
        }
        else if (command.equals("mul32"))
        {
            substance = new mul32(words.get(1));
        }
        else if (command.equals("div16"))
        {
            substance = new div16(words.get(1));
        }
        else if (command.equals("div32"))
        {
            substance = new div32(words.get(1));
        }
        else if (command.equals("int"))
        {
            substance = new int_(words.get(1));
        }
        else if (words.get(0).charAt(words.get(0).length() - 1) == ':' ||
                (words.size() > 1 && words.get(1).equals(":")))
        {
            if (words.get(0).charAt(words.get(0).length() - 1) == ':')
            {
                command = "";
                for (int i = 0; i < words.get(0).length() - 1; i++)
                {
                    command += words.get(0).charAt(i);
                }
            }
            cmdBuffer p = first_label;
            while (p.next_label != null) {
                p = p.next_label;
            }
            p.label_site = this;
            p.label_name = command;
            p.next_label = new cmdBuffer();
            substance = new label();
        }
    }

    public static Scanner fin = null;
    public node()
    {
        if (first_label == null)

            first_label = new cmdBuffer();

        Command.set_buffer(first_label);
    }

    public void convert(node p)
    {
        ptr_jump = p;
    }

    public void read_asm()
    {
        String sentence;
        Vector<String> words;
        do {
            if (fin == null) {
                return;
            }
            else{
                if(fin != null && fin.hasNextLine())
                {
                    sentence = fin.nextLine();
                }else {
                    return;
                }
            }
            words = separateWord(sentence);
        }while (words.size() == 0);
        save(words);
        ptr_next = new node();
        ptr_next.read_asm();
    }

    public void run_asm()
    {
        if (substance != null)
        {
            substance.func();
        }
        if (ptr_jump != null)
        {
            ptr_jump.run_asm();
        }
        else if (ptr_next != null)
        {
            ptr_next.run_asm();
        }
    }

    Vector<String> separateWord(String sen)
    {
        String temp = "";
        Vector<String> word = new Vector<>();
        for (int i = 0; i != sen.length(); i ++)
        {
            if (sen.charAt(i) == ';')
                break;
            if (sen.charAt(i) == ' ' || sen.charAt(i) == '	' || sen.charAt(i) == ',')
            {
                if (!temp.equals(""))
                {
                    word.add(temp);
                    temp = "";
                }
                continue;
            }
            temp += sen.charAt(i);
        }
        if (!temp.equals(""))
        {
            word.add(temp);
        }
        return word;
    }
}
