package main.java.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionStreamExample {
    public static void main(String[] args) {
        // List 컬렉션 생성
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Product product = new Product(i, "상품" + i, "멋진 회사", (int) (10_000 * Math.random()));
            list.add(product);
        }

        // 객체 스트림 얻기
        Stream<Product> stream = list.stream();
        stream.forEach(product -> System.out.println(product));
    }

    static class Product {
        private int pno;
        private String name;
        private String company;
        private int price;

        public Product(int pno, String name, String company, int price) {
            this.pno = pno;
            this.name = name;
            this.company = company;
            this.price = price;
        }

        public int getPno() {
            return pno;
        }

        public String getName() {
            return name;
        }

        public String getCompany() {
            return company;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append("{")
                    .append("pno:" + pno + ", ")
                    .append("name:" + name + ", ")
                    .append("company:" + company + ", ")
                    .append("price:" + price)
                    .append("}")
                    .toString();
        }
    }
}
