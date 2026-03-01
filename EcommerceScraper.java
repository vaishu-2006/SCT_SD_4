import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class EcommerceScraper {

    public static void main(String[] args) {

        // URL of e-commerce site (Example: Books from BooksToScrape)
        String url = "https://books.toscrape.com/";

        try {
            // Connect to the website
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            // Select product containers
            Elements products = doc.select("article.product_pod");

            // Create CSV file
            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Product Name,Price,Rating\n");

            // Loop through each product
            for (Element product : products) {

                // Extract Name
                String name = product.select("h3 a").attr("title");

                // Extract Price
                String price = product.select(".price_color").text();

                // Extract Rating
                String ratingClass = product.select(".star-rating").attr("class");
                String rating = ratingClass.replace("star-rating ", "");

                // Write to CSV
                csvWriter.append(name).append(",")
                        .append(price).append(",")
                        .append(rating).append("\n");

                // Print to console
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                System.out.println("Rating: " + rating);
                System.out.println("---------------------------");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Data successfully saved to products.csv");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}