import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import { Welcome } from "./pages/Welcome";
import { MainPage } from "./pages/MainPage";
import { SecondPage } from "./pages/SecondPage";
import { HomePage } from "./pages/HomePage";  // named export
import { MapPage } from "./pages/MapPage";    // named export

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Welcome />} />
        <Route path="/main" element={<MainPage />} />
        <Route path="/second" element={<SecondPage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/map" element={<MapPage />} />
        <Route path="*" element={<Welcome />} />
      </Routes>
    </Router>
  );
}

export default App;
