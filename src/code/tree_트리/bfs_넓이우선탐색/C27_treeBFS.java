package code.tree_트리.bfs_넓이우선탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** 성공, 템플릿 저장 , 레퍼런스 참조 */
public class C27_treeBFS {
    public static void main(String[] args) {
        C27_Solution.tree root = new C27_Solution.tree("1");
        C27_Solution.tree rootChild1 = root.addChildNode(new C27_Solution.tree("2"));
        C27_Solution.tree rootChild2 = root.addChildNode(new C27_Solution.tree("3"));
        C27_Solution.tree leaf1 = rootChild1.addChildNode(new C27_Solution.tree("4"));
        C27_Solution.tree leaf2 = rootChild1.addChildNode(new C27_Solution.tree("5"));
        ArrayList<String> output = C27_Solution.bfs(root);
        System.out.println(output); // --> ["1", "2", "3", "4", "5"]

        leaf1.addChildNode(new C27_Solution.tree("6"));
        rootChild2.addChildNode(new C27_Solution.tree("7"));
        output = C27_Solution.bfs(root);
        System.out.println(output); // --> ["1", "2", "3", "4", "5", "7", "6"]
    }
}

class C27_Solution {
    public static ArrayList<String> bfs(tree node) {
        // TODO:
        Queue<tree> queue = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            tree t = queue.poll();
            result.add(t.value);

            if(t.getChildrenNode() != null)
            {
                queue.addAll(t.getChildrenNode());
            }
        }

        return result;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.\
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}