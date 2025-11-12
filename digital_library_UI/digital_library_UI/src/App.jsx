import { Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <div>
      <nav style={{ padding: "1rem", background: "#f0f0f0" }}>
        <Link to="/">Home</Link> |{" "}
        <Link to="/books">Books</Link> |{" "}
        <Link to="/add">Add Book</Link>
      </nav>

      <Routes>
        <Route path="/" element={<h2>Welcome to Digital Library</h2>} />
        <Route path="/books" element={<h2>Book List</h2>} />
        <Route path="/add" element={<h2>Add New Book</h2>} />
      </Routes>
    </div>
  );
}

export default App;
