//Top-K Best Sellers

import java.util.*;

class Product {
    String id;
    int sales;

    Product(String id, int sales) {
        this.id = id;
        this.sales = sales;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Product> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.sales != b.sales)
                    return a.sales - b.sales; // smaller sales first

                return b.id.compareTo(a.id); // reverse id order for min heap
            }
        );

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            int sales = sc.nextInt();

            products[i] = new Product(id, sales);
        }

        int k = sc.nextInt();

        for (Product p : products) {

            if (pq.size() < k) {
                pq.add(p);
            }
            else {
                Product smallest = pq.peek();

                if (p.sales > smallest.sales ||
                   (p.sales == smallest.sales &&
                    p.id.compareTo(smallest.id) < 0)) {

                    pq.poll();
                    pq.add(p);
                }
            }
        }

        List<Product> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        result.sort((a, b) -> {
            if (a.sales != b.sales)
                return b.sales - a.sales; // descending sales

            return a.id.compareTo(b.id); // ascending id
        });

        for (Product p : result) {
            System.out.println(p.id + " " + p.sales);
        }
    }
}
