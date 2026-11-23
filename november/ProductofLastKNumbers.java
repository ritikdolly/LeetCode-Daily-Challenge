import java.util.ArrayList;
import java.util.List;

public class ProductofLastKNumbers {
    /**
     * Your ProductOfNumbers object will be instantiated and called as such:
     * ProductOfNumbers obj = new ProductOfNumbers();
     * obj.add(num);
     * int param_2 = obj.getProduct(k);
     */

    // Approach 1: Using a list to store the numbers and calculating the product of
    // the last k numbers when requested.
    class ProductOfNumbers {
        List<Integer> arr;

        public ProductOfNumbers() {
            arr = new ArrayList<>();
        }

        public void add(int num) {
            arr.add(num);
        }

        public int getProduct(int k) {
            if (k > arr.size()) {
                return 0;
            }
            int product = 1;
            int left = arr.size() - k;
            int right = arr.size() - 1;
            int total = Math.abs(right - left);
            while (left < right) {
                product *= arr.get(left++) * arr.get(right--);
            }
            if (total % 2 == 0) {
                product *= arr.get(right);
            }
            return product;
        }
    }

    // Approach 2: Using a list to store the prefix products and calculating the
    // product of the last k numbers when requested.
    class ProductOfNumbers {
        List<Integer> prefixProducts;

        public ProductOfNumbers() {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                prefixProducts.clear();
                prefixProducts.add(1);
            } else {
                prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            int n = prefixProducts.size();
            if (k >= n) {
                return 0;
            }
            return prefixProducts.get(n - 1) / prefixProducts.get(n - k - 1);
        }
    }

    public static void main(String[] args) {
        ProductofLastKNumbers productOfNumbers = new ProductofLastKNumbers();
        ProductOfNumbers obj = productOfNumbers.new ProductOfNumbers();
        obj.add(3);
        obj.add(0);
        obj.add(2);
        obj.add(5);
        obj.add(4);
        System.out.println(obj.getProduct(2)); // Output: 20
        System.out.println(obj.getProduct(3)); // Output: 40
        System.out.println(obj.getProduct(4)); // Output: 0
        obj.add(8);
        System.out.println(obj.getProduct(2)); // Output: 32
    }
}