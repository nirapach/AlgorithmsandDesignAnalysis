/**
 * Created by Niranjan on 10/30/2015.
 */
import java.util.*;

abstract class HuffmanTree implements Comparable<HuffmanTree>
{
    public final int weight;
    public HuffmanTree(int freq)
    {
        weight = freq;
    }

    // compares on the weight.
    public int compareTo(HuffmanTree tree)
    {
        return weight - tree.weight;
    }
}

class HuffmanLeaf extends HuffmanTree
{
    // the character of the leaf.
    public final char value;

    public HuffmanLeaf(int freq, char val)
    {
        super(freq);
        value = val;
    }
}

class HuffmanNode extends HuffmanTree
{
    public final HuffmanTree left, right; // subtrees

    public HuffmanNode(HuffmanTree l, HuffmanTree r)
    {
        super(l.weight + r.weight);
        left = l;
        right = r;
    }
}

public class HuffmanCode
{
    public static HuffmanTree buildTree(int[] charFreqs)
    {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // one for each character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));

        //assert trees.size() > 0;
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // Create the same values as a new node.
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf)
        {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.weight + "\t" + prefix);

        }
        else if (tree instanceof HuffmanNode)
        {
            HuffmanNode node = (HuffmanNode)tree;

            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void main(String[] args)
    {

        // Highest ASCII value of alphabets.
        int[] charFreqs = new int[127];
        while(true)
        {
            System.out.println("Enter the character, Type exit to proceed");
            Scanner scan = new Scanner(System.in);
            String inpString = scan.nextLine();
            if(inpString.contentEquals("exit"))
                break;
            char c = inpString.charAt(0);
            System.out.println("Enter the frequency");
            charFreqs[c] = scan.nextInt();
        }


        // build tree
        HuffmanTree tree = buildTree(charFreqs);

        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }
}
