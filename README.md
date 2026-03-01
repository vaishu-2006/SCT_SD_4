# SCT_SD_4
SkillCraft Technology Internship - Task 04 : E-commerce product scraper in Java using JSoup to extract product details and store them in CSV format.


# SCT_SD_4 - E-commerce Product Scraper

## SkillCraft Technology Internship - Task 04

### Description
This project is a Java-based web scraping program that extracts product information from an e-commerce website.

The program collects:
- Product Name
- Price
- Rating

The extracted data is saved into a CSV file named `products.csv`.

### Output File
After running the program, a file called:

products.csv

will be generated in the project directory.  
This file contains all scraped product details in structured CSV format.

### Technologies Used
- Java
- JSoup Library
- File Handling

### How to Run
1. Download the JSoup library from: https://jsoup.org
2. Place the jsoup JAR file in the same directory as the Java file.
3. Compile:
   javac -cp ".;jsoup-1.22.1.jar" EcommerceScraper.java
4. Run:
   java -cp ".;jsoup-1.22.1.jar" EcommerceScraper
