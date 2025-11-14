import { useEffect, useState } from "react";
import { getBooks } from "../services/BookService"; // <-- import your service

function BookList() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    getBooks()
      .then((data) => setBooks(data))
      .catch((err) => console.error("Error loading books:", err));
  }, []);

  return (
    <div>
      <h2>Book List</h2>

      {books.length === 0 ? (
        <p>No books available.</p>
      ) : (
        <ul>
          {books.map((book) => (
            <li key={book.id}>
              <strong>{book.title}</strong> — {book.author} ({book.publishedYear})
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default BookList;
