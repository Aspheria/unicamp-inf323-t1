package esoft.book.model;
import esoft.com.exception.InvalidValueException;
import esoft.com.exception.NullValueException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BookTest {

    @Test
    public void testBookCreationWithValidData() {
        Book book = new Book("Effective Java", "2020-01-01", "Available", "Programming", "Hardcover",
                             "Joshua Bloch", "Pearson", "A comprehensive guide to Java",
                             "thumbnail.jpg", "image.jpg", "9780134685991", 45.99, 416);
        
        assertEquals("Effective Java", book.getName());
        assertEquals("9780134685991", book.getIsbn());
        assertEquals(45.99, book.getSrp(), 0.01); 
        assertEquals(416, book.getPage());
    }

    @Test
    public void testBookCreationWithInvalidISBN() {
        InvalidValueException exception = assertThrows(InvalidValueException.class, () -> {
            new Book("Effective Java", "2020-01-01", "Available", "Programming", "Hardcover",
                     "Joshua Bloch", "Pearson", "A comprehensive guide to Java",
                     "thumbnail.jpg", "image.jpg", "978-0-123456-47-2", 45.99, 416); // Assuming this ISBN is incorrect
        });
        assertTrue(exception.getMessage().contains("ISBN"));
    }


    @Test
    public void testBookAuthorCannotBeNull() {
        assertThrows(NullValueException.class, () -> {

        new Book("The Lord of the Rings", "1954-07-29", "Available", "Fantasy", "Hardcover", 
        null, "Allen & Unwin", 
        "An epic high-fantasy novel", 
        "thumbnail.jpg", "image.jpg", 
        "9780261102385", 49.99, 1216);
    });
    }


    @Test
    public void testBookCreationWithNegativeSRP() {
        IllegalArgumentException srpException = assertThrows(IllegalArgumentException.class, () -> {
            new Book("The Hobbit", "1937-09-21", "Available", "Fantasy", "Hardcover",
                     "J.R.R. Tolkien", "George Allen & Unwin", "A children's fantasy novel",
                     "thumbnail.jpg", "image.jpg", "9780261102217", -19.99, 310);  // Negative SRP
        });
        assertEquals("SRP must be positive must be a positive number.", srpException.getMessage());
    }

    public void testBookCreationWithNegativePageCount() {
        IllegalArgumentException pageCountException = assertThrows(IllegalArgumentException.class, () -> {
            new Book("The Hobbit", "1937-09-21", "Available", "Fantasy", "Hardcover",
                     "J.R.R. Tolkien", "George Allen & Unwin", "A children's fantasy novel",
                     "thumbnail.jpg", "image.jpg", "9780261102217", 19.99, -310);  // Negative page count
        });
        assertEquals("Page count must be positive must be a positive number.", pageCountException.getMessage());
    }

    @Test
    public void testBookCreationWithInvalidPublisherFormat() {
        InvalidValueException exception = assertThrows(InvalidValueException.class, () -> {
            new Book("The Hobbit", "1937-09-21", "Available", "Fantasy", "Hardcover",
                     "J.R.R. Tolkien", "George Allen & Unwin123", // Invalid characters
                     "A children's fantasy novel",
                     "thumbnail.jpg", "image.jpg", "20x30", 19.99, 310);
        });
        assertEquals("Publisher contains invalid characters. The value \"George Allen & Unwin123\" does not match the pattern \"^[\\p{L} ,.&'-]+$\".", exception.getMessage());
    }

 @Test
    public void testBookCreationWithInvalidDescriptionFormat() {
        InvalidValueException exception = assertThrows(InvalidValueException.class, () -> {
            new Book("The Hobbit", "1937-09-21", "Available", "Fantasy", "Hardcover",
                     "J.R.R. Tolkien", "George Allen & Unwin",
                     "A children's fantasy novel@#", // Invalid characters
                     "thumbnail.jpg", "image.jpg", "9780261102217", 19.99, 310);
        });
        assertEquals("Description contains invalid characters. The value \"A children's fantasy novel@#\" does not match the pattern \"^[\\p{L} ,.&'-]+$\".", exception.getMessage());
    }

    @Test
    public void testBookCreationWithExcessivePublisherLength() {
        String longPublisher = "George Allen & Unwin".repeat(10); // Exceeds the max length
        InvalidValueException exception = assertThrows(InvalidValueException.class, () -> {
            new Book("The Hobbit", "1937-09-21", "Available", "Fantasy", "Hardcover",
                     "J.R.R. Tolkien", longPublisher,
                     "A children's fantasy novel",
                     "thumbnail.jpg", "image.jpg", "9780261102217", 19.99, 310);
        });
        assertEquals("Publisher exceeds max length cannot be longer than 100 characters", exception.getMessage());
    }

    public void testBookCreationWithNegativeSRPThrowsException() {
        double negativeSrp = -19.99;
        int validPageCount = 310;
    
        String expectedMessage = "SRP must be positive must be a positive number.";
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("The Hobbit", "1937-09-21", "Available", "Fantasy", "Hardcover",
                     "J.R.R. Tolkien", "George Allen & Unwin", "A children's fantasy novel",
                     "thumbnail.jpg", "image.jpg", "9780261102217", negativeSrp, validPageCount);
        });
    
        assertEquals(expectedMessage, exception.getMessage());
    }
}
