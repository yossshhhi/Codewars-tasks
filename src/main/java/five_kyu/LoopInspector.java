package five_kyu;

import five_kyu_test.Node;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoopInspector {
    public int loopSize(Node node) {
        Map<Node, Integer> hashNode = new LinkedHashMap<>();
        Node temp = node;
        int count = 0;
        while (true) {
            if (!hashNode.containsKey(temp)) {
                hashNode.put(temp, count++);
                temp = temp.getNext();
            } else {
                return hashNode.size() - hashNode.get(temp);
            }
        }
    }
}

