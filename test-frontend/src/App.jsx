import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NhanVienList from "./components/NhanVienList";
import NhanVienDetail from "./components/NhanVienDetail";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<NhanVienList />} />
        <Route path="/nhan-vien/:id" element={<NhanVienDetail />} />
      </Routes>
    </Router>
  );
}

export default App;
