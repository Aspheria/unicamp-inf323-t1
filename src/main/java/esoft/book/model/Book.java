// package esoft.book.model;
// import esoft.com.util.Validator;


// public class Book <String> {

//     // Regex to match ISBN (either ISBN-10 or ISBN-13)
//     private static final String ISBN_REGEX = "(^\\d{9}[\\dX]$)|(^\\\\d{13}$)";
//     // Regex to match strings with letters, including accented characters, spaces, and ,.&'-
//     private static final String GENERAL_STRING_REGEX = "^[\\p{L} ,.&'-]+$";
//     // Define the maximum length for various fields
//     private static final int PUBLISHER_MAX_LENGTH = 100;
//     private static final int DESC_MAX_LENGTH = 1000;
//     private static final int THUMBNAIL_MAX_LENGTH = 200;
//     private static final int IMAGE_MAX_LENGTH = 200;
//     private static final int DIMENSIONS_MAX_LENGTH = 50;


//     public Book(String name) {
//         if (name == null)
//         throw new RuntimeException();
//         this.name = name;
//     }


// }

package esoft.book.model;

import esoft.com.exception.NullValueException;
import esoft.com.util.Validator;

public class Book {
    private String name;
    private String pubDate;
    private String avail;
    private String subject;
    private String backing;
    private String author;
    private String publisher;
    private String desc;
    private String thumbnail;
    private String image;
    // private String dimensions;
    private String isbn;
    private double srp;
    private int page;
    
    private static final String GENERAL_STRING_REGEX = "^[\\p{L} ,.&'-]+$";
    private static final int PUBLISHER_MAX_LENGTH = 100;
    private static final int DESC_MAX_LENGTH = 1000;
    private static final int THUMBNAIL_MAX_LENGTH = 200;
    private static final int IMAGE_MAX_LENGTH = 200;
    // private static final int DIMENSIONS_MAX_LENGTH = 50;



    public static void validateNotNull(Object value, String message) {
    if (value == null) {
        throw new NullValueException(message); // Sem necessidade de adicionar "cannot be null" novamente
    }
}

    // Atributos e construtor...

    public Book(String name, String pubDate, 
                String avail, String subject, 
                String backing, String author,
                String publisher, String desc, 
                String thumbnail, String image, 
                String isbn,
                double srp, int page) {

        
        Validator.validateNotNull(name, "Name cannot be null");

           
        Validator.validateNotNull(pubDate, "Publication Date cannot be null");
        Validator.validateNotNull(avail, "Availability cannot be null");
        Validator.validateNotNull(subject, "Subject cannot be null");
        Validator.validateNotNull(backing, "Backing cannot be null");
        Validator.validateNotNull(author, "Author cannot be null");

        Validator.validateString(publisher, "Publisher", GENERAL_STRING_REGEX);
        Validator.validateStringMaxLength(publisher, "Publisher exceeds max length", PUBLISHER_MAX_LENGTH);

        Validator.validateString(desc, "Description", GENERAL_STRING_REGEX);
        Validator.validateStringMaxLength(desc, "Description exceeds max length", DESC_MAX_LENGTH);

        Validator.validateString(thumbnail, "Thumbnail", GENERAL_STRING_REGEX);
        Validator.validateStringMaxLength(thumbnail, "Thumbnail exceeds max length", THUMBNAIL_MAX_LENGTH);

        Validator.validateString(image, "Image", GENERAL_STRING_REGEX);
        Validator.validateStringMaxLength(image, "Image exceeds max length", IMAGE_MAX_LENGTH);

        // Validator.validateString(dimensions, "Dimensions", GENERAL_STRING_REGEX);
        // Validator.validateStringMaxLength(dimensions, "Dimensions exceed max length", DIMENSIONS_MAX_LENGTH);

        Validator.validateString(isbn, "ISBN", "(^\\d{9}[\\dX]$)|(^\\d{13}$)");

        Validator.validatePositive(srp, "SRP must be positive");
        Validator.validatePositive(page, "Page count must be positive");
        

        // Inicialização dos atributos...
        this.name = name;
        this.pubDate = pubDate;
        this.avail = avail;
        this.subject = subject;
        this.backing = backing;
        this.author = author;
        this.publisher = publisher;
        this.desc = desc;
        this.thumbnail = thumbnail;
        this.image = image;
        this.isbn = isbn;
        this.srp = srp;
        this.page = page;
    }
    
    @SuppressWarnings("unused")
    private void validatePositive(double value, String errorMessage) {
        if (value <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    @SuppressWarnings("unused")
    private void validatePositive(int value, String errorMessage) {
        if (value <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    // Getters e outros métodos...
    public String getName() {
        return this.name;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public double getSrp() {
        return this.srp;
    }

    public int getPage() {
        return this.page;
    }
    public String getAuthor() {
        return this.author;
    }

    public Object getName(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

}



