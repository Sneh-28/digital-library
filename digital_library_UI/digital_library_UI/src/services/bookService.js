import axios from "axios";

const API_URL = "http://localhost:8080/book"; // <-- change to your backend endpoint

export const getBooks = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};
