import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResearchInstitute {

    Node[][] roomList;
    int x;
    int y;

    public void main(String[] args) {
        int[][] arrays = inputValue();
        x = arrays[0][1];
        y = arrays[0][0];
        createNode(arrays);
//        System.out.println(result);
    }

    private void createNode(int[][] arrays) {
        Node node;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 1 || j == 0) {
                    node = new Node(arrays[i][j]);
                    roomList[i - 1][j] = node;
                }
            }
        }
        mappingNode();
    }

    private void mappingNode() {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < y; j++) {
                if (i - 1 > -1) {
                    roomList[i][j].setUp(roomList[i-1][j]);
                }
                if (i + 1 < y) {
                    roomList[i][j].setDown(roomList[i+1][j]);
                }
                if (j - 1 > -1) {
                    roomList[i][j].setDown(roomList[i][j-1]);
                }
                if (j + 1 > x) {
                    roomList[i][j].setDown(roomList[i][j+1]);
                }
            }
        }
    }

    class Node {
        Node up;
        Node right;
        Node down;
        Node left;
        int value;

        public void setUp(Node up) {
            this.up = up;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setDown(Node down) {
            this.down = down;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        int initValue;
        boolean check = false;

        public Node(int value) {
            this.initValue = value;
            this.value = value;
        }

        public void init() {
            this.value = initValue;
            boolean check = false;
        }

        public boolean checkInfection() {
            if (value == 1) {
                return false;
            }
            if (value == 2) {
                return true;
            }
            if (value == 0) {
                if ((up != null && up.checkInfection()) ||
                    (right != null && right.checkInfection()) ||
                    (down != null && down.checkInfection()) ||
                    (left != null && left.checkInfection())) {
                    value = 2;
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    private static int[][] inputValue() {
        int[][] results = new int[9][8];
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            String line;
            int count = 0;
            while ((line = buffer.readLine()) != null && !line.equals(""))
            {
                String[] stringLine = line.split("\\s");
                for (int i = 0; i < stringLine.length; i++) {
                    results[count][i] = Integer.parseInt(stringLine[i]);
                }
                count++;
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
